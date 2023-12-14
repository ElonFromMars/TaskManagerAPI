DROP TABLE USERS;
DROP TABLE TASKS;

create table USERS(
      ID int unique not null,
      NAME varchar(100) not null,
      EMAIL varchar(100) not null,
      PRIMARY KEY ( ID )
);

create table TASKS(
      ID int unique not null,
      TEXT varchar(500) not null,
      DONE bool not null,
      PRIMARY KEY ( ID )
);