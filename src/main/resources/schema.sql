DROP TABLE USERS;
DROP TABLE TASKS;

create table USERS(
      ID BIGINT unique not null,
      NAME varchar(100) not null,
      EMAIL varchar(100) not null,
      EMAILVERIFIED varchar(100) not null,
      PASSWORD varchar(100) not null,
      AUTHPROVIDER varchar(100) not null,
      PRIMARY KEY ( ID )
);

create table TASKS(
      ID BIGINT unique not null,
      TEXT varchar(500) not null,
      DONE bool not null,
      PRIMARY KEY ( ID )
);
