package org.serje3.BotBackend.discord.youtube;

import com.serje3.generated.jooq.tables.records.YoutubeSearchResponseCacheRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.serje3.BotBackend.discord.youtube.data.Track;
import org.serje3.BotBackend.discord.youtube.data.Tracks;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.serje3.generated.jooq.Tables.YOUTUBE_SEARCH_QUERY_CACHE;
import static com.serje3.generated.jooq.Tables.YOUTUBE_SEARCH_RESPONSE_CACHE;


@Repository
@RequiredArgsConstructor
public class YoutubeRepository {
    private final DSLContext dsl;

    public List<Track.Ref> getQueryCache(String query) {
        return dsl.select(
                        YOUTUBE_SEARCH_QUERY_CACHE.ID,
                        YOUTUBE_SEARCH_QUERY_CACHE.QUERY,
                        YOUTUBE_SEARCH_QUERY_CACHE.EXECUTED_AT,
                        YOUTUBE_SEARCH_RESPONSE_CACHE.ETAG,
                        YOUTUBE_SEARCH_RESPONSE_CACHE.TITLE,
                        YOUTUBE_SEARCH_RESPONSE_CACHE.CHANNEL_ID,
                        YOUTUBE_SEARCH_RESPONSE_CACHE.CHANNEL_TITLE,
                        YOUTUBE_SEARCH_RESPONSE_CACHE.VIDEO_ID,
                        YOUTUBE_SEARCH_RESPONSE_CACHE.THUMBNAIL_URL,
                        YOUTUBE_SEARCH_RESPONSE_CACHE.PUBLISH_TIME
                        )
                .from(YOUTUBE_SEARCH_QUERY_CACHE)
                .leftJoin(YOUTUBE_SEARCH_RESPONSE_CACHE).on(YOUTUBE_SEARCH_RESPONSE_CACHE.QUERY_ID.eq(YOUTUBE_SEARCH_QUERY_CACHE.ID))
                .where(YOUTUBE_SEARCH_QUERY_CACHE.QUERY.eq(query))
                .orderBy(YOUTUBE_SEARCH_RESPONSE_CACHE.ID)
                .fetchInto(Track.Ref.class);
    }


    @Transactional
    public void cacheQuery(String query, Tracks tracks) {
        dsl.insertInto(YOUTUBE_SEARCH_QUERY_CACHE)
                .set(YOUTUBE_SEARCH_QUERY_CACHE.QUERY, query)
                .execute();

        Integer queryId = dsl.select(YOUTUBE_SEARCH_QUERY_CACHE.ID)
                .from(YOUTUBE_SEARCH_QUERY_CACHE)
                .where(YOUTUBE_SEARCH_QUERY_CACHE.QUERY.eq(query))
                .fetchOneInto(Integer.class);

        List<YoutubeSearchResponseCacheRecord> records = new ArrayList<>();

        for (Track track :tracks.getItems()){
            records.add(
                    new YoutubeSearchResponseCacheRecord()
                            .setTitle(track.getTitle())
                            .setQueryId(queryId)
                            .setEtag(track.getEtag())
                            .setPublishTime(track.getPublishTime())
                            .setVideoId(track.getVideoId())
                            .setThumbnailUrl(track.getThumbnailUrl())
                            .setChannelId(track.getChannelId())
                            .setChannelTitle(track.getChannelTitle())
            );
        }

        dsl.batchInsert(records).execute();
    }
}
