create table mod_description(
    id serial primary key,
    mod_id int not null unique,
    description varchar not null,
    foreign key (mod_id) references mod(mod_id)
);