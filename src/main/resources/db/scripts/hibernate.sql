create table accident (
                          id int4 not null,
                          address varchar(255),
                          created timestamp,
                          name varchar(255),
                          text text,
                          time timestamp,
                          officer_docserial int4,
                          primary key (id)
);


create table officer (
                         docserial int4 not null,
                         login varchar(255),
                         of_first_name varchar(255),
                         of_rang varchar(255),
                         of_second_name varchar(255),
                         password varchar(255),
                         role_id varchar(255),
                         primary key (docserial)
);


create table participant (
                             first_name varchar(255) not null,
                             passport int4 not null,
                             second_name varchar(255) not null,
                             description varchar(255),
                             primary key (first_name, passport, second_name)
);


create table participant_accidents (
                                       membo_first_name varchar(255) not null,
                                       membo_passport int4 not null,
                                       membo_second_name varchar(255) not null,
                                       accidents_id int4 not null,
                                       primary key (membo_first_name, membo_passport, membo_second_name, accidents_id)
);


create table photo (
                       id int4 not null,
                       photo bytea not null,
                       accident_id int4,
                       primary key (id)
);


create table role (
                      id varchar(255) not null,
                      primary key (id)
);


alter table if exists officer
    add constraint UK_gc0g53qn8d40y2ntoefsa073h unique (login);


alter table if exists accident
    add constraint FKnvntfc6y6grxmsca21phw80sj
        foreign key (officer_docserial)
            references officer;


alter table if exists officer
    add constraint FKo8fps1uyygedttwnw0aya5xwl
        foreign key (role_id)
            references role;


alter table if exists participant_accidents
    add constraint FK37bqtaqb4oqy01e7c5hq65v2f
        foreign key (accidents_id)
            references accident;


alter table if exists participant_accidents
    add constraint FKdu7d6vp90lrmdfaytptrb5i1b
        foreign key (membo_first_name, membo_passport, membo_second_name)
            references participant;


alter table if exists photo
    add constraint FKrlxp497mkinw1ln6fbnqqgpih
        foreign key (accident_id)
            references accident;