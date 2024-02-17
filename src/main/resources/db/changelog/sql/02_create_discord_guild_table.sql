create table guild
(
    id        SERIAL PRIMARY KEY,
    owner_id  BIGINT       NOT NULL,
    guild_id  BIGINT       NOT NULL UNIQUE,
    name      VARCHAR(255) NOT NULL,
    icon_url  TEXT,
    join_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);