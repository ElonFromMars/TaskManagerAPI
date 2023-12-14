DROP TABLE USERS;

create table USERS(
      ID int unique not null,
      NAME varchar(100) not null,
      EMAIL varchar(100) not null,
      PRIMARY KEY ( ID )
);

INSERT INTO USERS(ID, NAME, EMAIL) VALUES (0, 'Ivan', 'ivan@gmail.com');
INSERT INTO USERS(ID, NAME, EMAIL) VALUES (1, 'Prokofij', 'prokofij228@gmail.com');
INSERT INTO USERS(ID, NAME, EMAIL) VALUES (2, 'Marusia', 'marusia322_223@gmail.com');