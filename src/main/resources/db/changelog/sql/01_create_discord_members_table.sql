CREATE TABLE members
(
    id                 SERIAL PRIMARY KEY,
    user_id            INT          NOT NULL,
    guild_id           INT          NOT NULL,
    effective_username VARCHAR(255) NOT NULL,
    is_admin           BOOLEAN   DEFAULT FALSE,
    join_date          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT unique_user_guild_pair UNIQUE (user_id, guild_id)
);
