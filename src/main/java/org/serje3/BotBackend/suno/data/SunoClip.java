package org.serje3.BotBackend.suno.data;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
@Getter
public class SunoClip {
    private final String id;
    @JsonAlias("video_url")
    private final String videoUrl;
    @JsonAlias("audio_url")
    private final String audioUrl;
    @JsonAlias("image_url")
    private final String imageUrl;
    @JsonAlias("image_large_url")
    private final String imageLargeUrl;
    @JsonAlias("is_video_pending")
    private final boolean isVideoPending;
    @JsonAlias("major_model_version")
    private final String majorModelVersion;
    @JsonAlias("model_name")
    private final String modelName;
    @JsonAlias("metadata")
    private final Map<String, Object> metadata;
    @JsonAlias("is_liked")
    private final boolean isLiked;
    @JsonAlias("user_id")
    private final String userId;
    @JsonAlias("display_name")
    private final String displayName;
    private final String handle;
    @JsonAlias("is_handle_updated")
    private final boolean isHandleUpdated;
    @JsonAlias("is_trashed")
    private final boolean isTrashed;
    private final Object reaction; // тип данных для reaction может варьироваться в зависимости от содержания
    @JsonAlias("created_at")
    private final String createdAt;
    private final String status;
    private final String title;
    @JsonAlias("play_count")
    private final int playCount;
    @JsonAlias("upvote_count")
    private final int upvoteCount;
    @JsonAlias("is_public")
    private final boolean isPublic;
}
