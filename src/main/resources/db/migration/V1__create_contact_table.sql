CREATE
EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE contact
(
    id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    first_name  VARCHAR(100),
    middle_name VARCHAR(100),
    last_name   VARCHAR(100),
    nickname    VARCHAR(100),
    birthday    DATE,
    gender      VARCHAR(50),
    is_active   BOOLEAN NOT NULL,
    company_id  BIGINT
);