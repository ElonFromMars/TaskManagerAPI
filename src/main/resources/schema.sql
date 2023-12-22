DROP TABLE USERS;
DROP TABLE TASKS;

create table USERS(
      ID BIGINT GENERATED ALWAYS AS IDENTITY,
      NAME varchar(100) not null,
      EMAIL varchar(100) not null,
      EMAIL_VERIFIED bool not null,
      PASSWORD varchar(100),
      PROVIDER varchar(100),
      PROVIDER_ID varchar(100),
      PRIMARY KEY ( ID )
);

create table TASKS(
      ID BIGINT unique not null,
      TEXT varchar(500) not null,
      DONE bool not null,
      PRIMARY KEY ( ID )
);
