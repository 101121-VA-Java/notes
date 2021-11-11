drop table if exists employees;
create table if not exists employees(
	e_id serial primary key,
	e_name varchar(50) not null,
	e_username varchar(50) unique,
	e_password varchar(50) not null,
	e_role varchar(50),
	man_e_id integer references employees(e_id)
);

insert into employees (e_name, e_username, e_password, e_role) values ('test name', 'test username', 'test password', 'test role');
