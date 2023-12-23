CREATE TABLE IF NOT EXISTS users(
      id bigint GENERATED ALWAYS AS IDENTITY,
      name varchar(100) not null,
      email varchar(100) not null,
      email_verified bool not null,
      password varchar(100),
      provider varchar(100),
      provider_id varchar(100),
      PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS workspaces(
      id bigint GENERATED ALWAYS AS IDENTITY,
      name varchar(100) not null,
      owner_user_id bigint not null,
      PRIMARY KEY (id)
);

ALTER TABLE workspaces DROP CONSTRAINT IF EXISTS workspaces_owner_user_id;
ALTER TABLE workspaces
    ADD CONSTRAINT workspaces_owner_user_id
        FOREIGN KEY (owner_user_id) REFERENCES users(id);

CREATE TABLE IF NOT EXISTS card_tables(
       id bigint GENERATED ALWAYS AS IDENTITY,
       name varchar(100) not null,
       workspace_id bigint not null,
       PRIMARY KEY (id)
);

ALTER TABLE card_tables DROP CONSTRAINT IF EXISTS tables_workspace_id;
ALTER TABLE card_tables
    ADD CONSTRAINT tables_workspace_id
        FOREIGN KEY (workspace_id) REFERENCES workspaces(id);

CREATE TABLE IF NOT EXISTS card_lists(
      id bigint GENERATED ALWAYS AS IDENTITY,
      name varchar(100) not null,
      card_table_id bigint not null,
      PRIMARY KEY (id)
);

ALTER TABLE card_lists DROP CONSTRAINT IF EXISTS card_lists_card_table_id;
ALTER TABLE card_lists
    ADD CONSTRAINT card_lists_card_table_id
        FOREIGN KEY (card_table_id) REFERENCES card_tables(id);

CREATE TABLE IF NOT EXISTS cards(
       id bigint GENERATED ALWAYS AS IDENTITY,
       name varchar(100) not null,
       text varchar(1000) not null,
       card_list_id bigint not null,
       PRIMARY KEY (id)
);

ALTER TABLE cards DROP CONSTRAINT IF EXISTS cards_card_list_id;
ALTER TABLE cards
    ADD CONSTRAINT cards_card_list_id
        FOREIGN KEY (card_list_id) REFERENCES card_lists(id);
