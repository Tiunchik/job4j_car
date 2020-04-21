create table if not exists accidents
(
    acc_nubmer  serial4 primary key,
    acc_name    varchar(100),
    acc_text    varchar(255),
    acc_address varchar(255)
);