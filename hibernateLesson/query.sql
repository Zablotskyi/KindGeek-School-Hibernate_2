drop database hibernateLesson;
create database hibernateLesson;
use hibernateLesson;
set charset utf8;

create table person(
id bigint auto_increment primary key,
firstName varchar(255)
) engine = MyISAM;

create table car(
id bigint auto_increment primary key,
nameCar varchar(255),
powerCar int,
person_id bigint
) engine = MyISAM;

alter table car add constraint foreign key(person_id) references person(id);