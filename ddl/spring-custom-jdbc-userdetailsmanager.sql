create table customer (
    id int not null primary key,
    email varchar(1000) not null,
    pwd varchar(500) not null,
    role varchar(50) not null
);