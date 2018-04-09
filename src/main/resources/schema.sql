CREATE TABLE product (
	id int NOT NULL,
	name varchar(255) NOT NULL,
	description varchar(255) NOT NULL,
	retail_price decimal(20,2) NULL,
	wholesale_price decimal(20,2) NULL
);

CREATE TABLE inventory(
   id int NOT NULL,
   number_available int NOT NULL
 );