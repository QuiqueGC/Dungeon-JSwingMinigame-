drop database if exists dungeon;

create database dungeon;

use dungeon;

create table ranking (
id int auto_increment primary key,
nombre varchar (50) not null,
clase varchar (50) not null,
oro int not null,
vidas int not null,
tiempo int not null,
victoria boolean not null,
fecha datetime not null);


drop user if exists dungeonMaster@localhost;

create user dungeonMaster@localhost
identified by "1234";

grant insert
on dungeon.*
to dungeonMaster@localhost;

grant select
on dungeon.*
to dungeonMaster@localhost;

grant update
on dungeon.*
to dungeonMaster@localhost;

grant delete
on dungeon.*
to dungeonMaster@localhost;