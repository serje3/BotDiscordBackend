create table suno_login
(
    user_id    bigserial primary key,
    cookie     text   not null,
    session_id varchar(128)
);