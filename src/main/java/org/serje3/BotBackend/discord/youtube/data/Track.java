package org.serje3.BotBackend.discord.youtube.data;

import com.google.api.services.youtube.model.SearchResult;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Getter
public class Track {
    private final String etag;
    private final String title;
    private final String channelId;
    private final String channelTitle;
    private final String videoId;
    private final String thumbnailUrl;
    private final LocalDateTime publishTime;

    public static Track fromSearchResult(SearchResult item) {
        return new Track(
                item.getEtag(),
                item.getSnippet().getTitle(),
                item.getSnippet().getChannelId(),
                item.getSnippet().getChannelTitle(),
                item.getId().getVideoId(),
                item.getSnippet().getThumbnails().getDefault().getUrl(),
                LocalDateTime.parse(item.getSnippet().getPublishedAt().toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[.SSS]XXX"))
        );
    }

    @RequiredArgsConstructor
    @Getter
    public static class Ref {
        private final Integer id;
        private final String query;
        private final LocalDateTime executedAt;
        private final String etag;
        private final String title;
        private final String channelId;
        private final String channelTitle;
        private final String videoId;
        private final String thumbnailUrl;
        private final LocalDateTime publishTime;


        public Track toTrack(){
            return new Track(etag, title, channelId, channelTitle, videoId, thumbnailUrl, publishTime);
        }
    }
}
