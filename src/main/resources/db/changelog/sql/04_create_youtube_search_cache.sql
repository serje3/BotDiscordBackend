CREATE TABLE youtube_search_query_cache
(
    id          SERIAL PRIMARY KEY,
    query       VARCHAR(255) NOT NULL,
    executed_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE youtube_search_response_cache
(
    id            SERIAL PRIMARY KEY,
    query_id      INTEGER NOT NULL REFERENCES youtube_search_query_cache (id),
    etag          VARCHAR(255),
    video_id      VARCHAR(50),
    title         VARCHAR(100),
    channel_title VARCHAR(255),
    channel_id    VARCHAR(50),
    publish_time  TIMESTAMP,
    thumbnail_url VARCHAR(255)
);

create unique index youtube_search_query_cache_unique
    on youtube_search_query_cache
        (query,
         extract(month from executed_at),
         extract(year from executed_at));