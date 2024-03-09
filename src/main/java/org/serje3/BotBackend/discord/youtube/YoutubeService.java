package org.serje3.BotBackend.discord.youtube;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.serje3.generated.jooq.tables.records.YoutubeSearchQueryCacheRecord;
import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.discord.youtube.data.Track;
import org.serje3.BotBackend.discord.youtube.data.Tracks;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class YoutubeService {
    private final YoutubeAPIService apiService;
    private final YoutubeRepository youtubeRepository;

    public Tracks search(String q) throws GeneralSecurityException, IOException {
        if (q.isBlank() || q.isEmpty()){
            return Tracks.empty();
        }
        List<Track.Ref> queryCache = youtubeRepository.getQueryCache(q);

        if (!queryCache.isEmpty()){
            return Tracks.fromRefList(queryCache);
        }

        Tracks tracks = Tracks.fromSearchListResponse(youtubeSearch(q));
        youtubeRepository.cacheQuery(q, tracks);
        return tracks;
    }

    public SearchListResponse youtubeSearch(String q) throws GeneralSecurityException, IOException {
        YouTube youTube;
        SearchListResponse response;
        youTube = apiService.get();
        response = youTube.search().list(List.of("id", "snippet"))
                .setQ(q)
                .setType(List.of("video"))
                .setMaxResults(50L)
                .execute();
        return response;
    }
}
