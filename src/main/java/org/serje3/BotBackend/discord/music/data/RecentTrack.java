package org.serje3.BotBackend.discord.music.data;

import lombok.Data;

@Data
public class RecentTrack {
    private Long id;
    private String name;
    private String url;
}
