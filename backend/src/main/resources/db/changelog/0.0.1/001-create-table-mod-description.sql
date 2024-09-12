create table if not exists mod_description(
    id bigserial primary key,
    mod_id bigint not null unique,
    description varchar not null,
    foreign key (mod_id) references mod(id)
)