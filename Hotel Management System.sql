CREATE DATABASE projecthms

create table login
(
userid int identity(1,1) primary key,
username varchar(30) not null,
password varchar(30) not null
);

create table employee
(
employee_id int identity(1,1) primary key,
name varchar(30) not null,
age int not null,
gender varchar(15) not null,
job varchar(30) not null,
salary int not null,
phone varchar(15) not null,
nid varchar(25) not null,
email varchar(30) not null
);


create table room
(
room_number int identity(101,1) primary key,
available varchar(20) not null,
status varchar(20) not null,
price int not null,
bed_type varchar(20) not null
);


select * from room;



create table driver
(
driver_id int identity(1,1) primary key,
name varchar(30) not null,
age int check (age >= 18),
gender varchar(15) not null,
model varchar(20) not null,
available varchar(20) not null,
location varchar(40) not null
);


