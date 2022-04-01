create table if not exists protocol(
    id int serial primary key,
    name varchar(100),
    date datetime,
    number_of_voters_in_list int,
    ballots_recieved_by_Commission int,
    ballots_issued_to_early int,
    ballots_issued_in_room int,
    ballots_issued_outside_room int,
    cancelled_ballots int,
    ballots_in_portable_boxes int,
    ballots_in_stationary_boxes int,
    invalid_ballots int,
    valid_ballots int,
    lost_ballots int,
    not_taken_ballots int
);

create table if not exists precinct(
    id int serial primary key,
    name varchar(100),
    protocol_id int references protocol(id)
);

create table if not exists candidate(
    id int serial primary key,
    name varchar(100),
    surname varchar(100),
    middle_name varchar(100),
    voters int,
    percent float,
    precinct_id int references precinct(id)
);

insert into precinct (name) values ('Коми');
insert into candidate (name, surname, middle_name, precinct_id)
values ('Виктор','Бетехтин','Васильевич',1),
       ('Андрей','Никитин','Андреевич',1),
       ('Сергей','Пономарев','Викторович',1),
       ('Владимир','Уйба','Викторович',1);