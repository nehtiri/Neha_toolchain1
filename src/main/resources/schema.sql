drop table user_details;

CREATE TABLE user_details
(

	userId SERIAL PRIMARY KEY,
    lastName varchar(100) NOT NULL,
    firstName varchar(100) NOT NULL ,
    phoneNumber varchar(100) NOT NULL,
    password varchar(100) NOT NULL,
    email varchar(100) DEFAULT NULL,
    category varchar(100) DEFAULT NULL ,
 	UNIQUE ( phoneNumber)
);

drop table requester_fulfiller;

CREATE TABLE requester_fulfiller
(
    id SERIAL PRIMARY KEY,
    pan_TAN varchar(100) ,
    aadhar_Card_no varchar(100) NOT NULL ,
    bank_AccountNo varchar(100) ,
    iFSC varchar(100) ,
    skills varchar(100),
    specification varchar(100),
    area  varchar(100),
    phoneNumber varchar(100) NOT NULL,
);

drop table orders;

create table orders
{

    order_id SERIAL PRIMARY KEY ,
	item varchar(100) NOT NULL ,
    quantity number(10),
    fulfiller_Id number(10),
    req_id number(10)
}
    
