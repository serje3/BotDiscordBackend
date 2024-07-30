package org.serje3.BotBackend.discord.music;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.discord.music.data.RecentTrack;
import org.serje3.BotBackend.discord.music.data.SaveRecentTrack;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;

    public void saveRecentTrack(SaveRecentTrack track) {
        musicRepository.saveTrackToRecent(track);
    }

    public List<RecentTrack> getRecentTracks(Long guildId) {
        return musicRepository.getRecentTracks(guildId);
    }
}
