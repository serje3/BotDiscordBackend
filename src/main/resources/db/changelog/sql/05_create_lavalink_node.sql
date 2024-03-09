CREATE TABLE lavalink_node
(
    id          SERIAL PRIMARY KEY,
    url         VARCHAR(256) NOT NULL UNIQUE,
    password    VARCHAR(256) NOT NULL,
    region      VARCHAR(50) NOT NULL
);
