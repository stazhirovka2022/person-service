create table if not exists person_data
(
    id              bigserial     not null primary key,
    last_name       varchar(255)  not null,
    first_name      varchar(255)  not null,
    birth_dt        date          not null,
    age             smallint,
    sex             char(1)       not null,
    contact_id      bigint        not null,
    medical_card_id bigint unique not null,
    parent_id       bigint check ( parent_id <> id )
);

alter table person_data
    add constraint person_parent_fk foreign key (parent_id) references person_data (id);

create table if not exists medical_card
(
    id            bigserial not null primary key,
    client_status char(1)            default 'N',
    med_status    char(1),
    registry_dt   date      not null default now(),
    comment       text
);

create table if not exists illness
(
    id              bigserial not null primary key,
    medical_card_id bigint    not null references medical_card (id),
    type_id         bigint,
    heaviness       char(1),
    appearance_dttm timestamp not null,
    recovery_dt     date
);

alter table person_data
    add constraint person_card_fk foreign key (medical_card_id) references medical_card (id);

create table if not exists contact
(
    id           bigserial   not null primary key,
    phone_number varchar(32) not null,
    email        varchar(128),
    profile_link text
);

alter table person_data
    add constraint person_contact_fk foreign key (contact_id) references contact (id);

create table if not exists address
(
    id         bigserial    not null primary key,
    contact_id bigint       not null references contact (id),
    country_id bigint       not null,
    city       varchar(255) not null,
    index      int,
    street     varchar(255) not null,
    building   varchar(32)  not null,
    flat       varchar(32)
);