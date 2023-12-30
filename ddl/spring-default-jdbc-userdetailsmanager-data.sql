insert into users (username, password, enabled) values ('default-user1', '123456', true);
insert into users (username, password, enabled) values ('default-user2', '1234567', true);

insert into authorities (username, authority) values ('default-user1', 'admin');
insert into authorities (username, authority) values ('default-user2', 'dev-user');