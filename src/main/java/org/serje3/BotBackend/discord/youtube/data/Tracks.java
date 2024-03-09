package org.serje3.BotBackend.discord.youtube.data;

import com.google.api.services.youtube.model.SearchListResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Tracks {
    private final List<Track> items;


    public static Tracks fromSearchListResponse(SearchListResponse response) {
        return new Tracks(response.getItems().stream().map(Track::fromSearchResult).toList());
    }


    public static Tracks fromRefList(List<Track.Ref> tracks) {
        return new Tracks(tracks.stream().map(Track.Ref::toTrack).toList());
    }

    public static Tracks empty() {
        return new Tracks(Collections.emptyList());
    }
}
