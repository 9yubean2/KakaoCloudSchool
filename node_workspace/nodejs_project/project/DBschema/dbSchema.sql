create table member
(
    
    memberid bigint not null primary key auto_increment,
    userid varchar(40) unique,
    password varchar(200),
    username varchar(40),
    email varchar(40),
    phone varchar(40),
    wdate datetime,
    delyn char(1) default 'N'

);

insert into member(userid, password, username, email, phone, wdate)
values ('test', '1234', '홍길동', 'hong@hanmail.net', '010-0000-0000',now());

create table board  
(  
		id bigint not null primary key auto_increment,
		title varchar(800),
		writer varchar(100),
		contents longtext,
		wdate datetime,
		hit int 
);