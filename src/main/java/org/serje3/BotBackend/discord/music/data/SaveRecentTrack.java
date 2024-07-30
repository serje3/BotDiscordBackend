package org.serje3.BotBackend.discord.music.data;

import lombok.Data;

@Data
public class SaveRecentTrack {
    private Long guildId;
    private String trackName;
    private String url;
}
