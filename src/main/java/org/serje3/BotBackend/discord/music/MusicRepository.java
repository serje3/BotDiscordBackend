package org.serje3.BotBackend.discord.music;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.serje3.BotBackend.discord.music.data.RecentTrack;
import org.serje3.BotBackend.discord.music.data.SaveRecentTrack;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.serje3.generated.jooq.Tables.RECENT_TRACKS;


@Repository
@RequiredArgsConstructor
public class MusicRepository {
    private final DSLContext dsl;
    private final Integer RECENT_TRACKS_LIMIT = 25;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void saveTrackToRecent(SaveRecentTrack track) {
        Integer count = dsl.selectCount()
                .from(RECENT_TRACKS)
                .fetchOne(0, int.class);

        // Delete if more or equal 25
        if (count >= RECENT_TRACKS_LIMIT) {
            List<RecentTrack> tracks = getRecentTracks(track.getGuildId());
            RecentTrack oldestTrack = tracks.get(tracks.size() - 1);
            Long oldestTrackId = oldestTrack.getId();
            dsl.deleteFrom(RECENT_TRACKS)
                    .where(RECENT_TRACKS.GUILD_ID.eq(track.getGuildId()),
                            RECENT_TRACKS.ID.lessOrEqual(oldestTrackId))
                    .execute();
        }

        String trackName = track.getTrackName().length() > 255 ? track.getTrackName().substring(0, 255) : track.getTrackName();

        dsl.insertInto(RECENT_TRACKS)
                .columns(RECENT_TRACKS.NAME, RECENT_TRACKS.GUILD_ID, RECENT_TRACKS.URL)
                .values(trackName, track.getGuildId(), track.getUrl())
                .execute();
    }

    public List<RecentTrack> getRecentTracks(Long guildId) {
        return dsl.selectFrom(RECENT_TRACKS)
                .where(RECENT_TRACKS.GUILD_ID.eq(guildId))
                .orderBy(RECENT_TRACKS.ID.desc())
                .limit(RECENT_TRACKS_LIMIT)
                .fetchInto(RecentTrack.class);
    }
}
