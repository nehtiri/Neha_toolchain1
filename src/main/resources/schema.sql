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