CREATE TABLE IF NOT EXISTS recent_tracks
(
    id       BIGSERIAL PRIMARY KEY,
    guild_id BIGINT NOT NULL REFERENCES guild(guild_id),
    name     VARCHAR(255) NOT NULL,
    url      VARCHAR(512) NOT NULL
);
