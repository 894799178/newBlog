create table user (
    id	int  not null AUTO_INCREMENT,
    name varchar(20) not null,
    age int,
		sex int ,  
	  phone varchar(15),
    ddate date,
    remarks varchar(50),
    primary key(id)
)