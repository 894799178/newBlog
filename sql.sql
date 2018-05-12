create table user (
    id	int  not null AUTO_INCREMENT,
    name varchar(20) not null,
    age int,
		sex int ,  
	  phone varchar(15),
    ddate date,
    remarks varchar(50),
    primary key(id)

);
create table contentTable(
    id int  not null AUTO_INCREMENT,
    user_id int not null,
    title varchar(30) not null,
    content text,
    monthday varchar(10),
    UNIQUE (title),
    primary key (id)
);
#ALTER TABLE contenttable ADD UNIQUE (title);
create table userloginTable(
    id int not null AUTO_INCREMENT,
    userName varchar(20) not null,
    password varchar(255) not null,
    primary key(id),
    UNIQUE (userName)
);
insert into user (id,name,age,sex,phone) values
(0,"王俊艺1",18,1,"13213465"),
(0,"小王",15,1,"1231243234"),
(0,"小李",23,0,"13213465");