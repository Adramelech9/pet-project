CREATE TABLE client (
    id          int PRIMARY KEY,
    uuid        VARCHAR(50) UNIQUE NOT NULL,
    email       VARCHAR(50)        NOT NULL,
    password    VARCHAR(50)        NOT NULL,
    birth_date  TIMESTAMP          NOT NULL,
    first_name  VARCHAR(50)        NOT NULL,
    last_name   VARCHAR(50)        NOT NULL,
    created_at  TIMESTAMP          NOT NULL,
    updated_at  TIMESTAMP          NOT NULL
);

CREATE TABLE vehicle (
    id                  int PRIMARY KEY,
    uuid                VARCHAR(50) UNIQUE NOT NULL,
    color               VARCHAR(50)        NOT NULL,
    engine_capacity     INT                NOT NULL,
    year_of_manufacture VARCHAR(50)        NOT NULL,
    weight_kg           INT                NOT NULL,
    created_at          TIMESTAMP          NOT NULL,
    updated_at          TIMESTAMP          NOT NULL,
    constraint fk_client foreign key (id) references client (id)
);

CREATE TABLE insurance_kit (
    id                   int PRIMARY KEY,
    uuid                 VARCHAR(50) UNIQUE NOT NULL,
    duration             TIMESTAMP          NOT NULL,
    compensation_percent INT                NOT NULL,
    damage_level         VARCHAR(50)        NOT NULL,
    covered_part         VARCHAR(50)        NOT NULL,
    created_at           TIMESTAMP          NOT NULL,
    updated_at           TIMESTAMP          NOT NULL
);

CREATE TABLE insurance_contract (
    id         int PRIMARY KEY,
    uuid       VARCHAR(50) UNIQUE NOT NULL,
    created_at TIMESTAMP          NOT NULL,
    updated_at TIMESTAMP          NOT NULL,
    constraint fk_client foreign key (id) references client (id)
);

alter table if exists vehicle
    add constraint fk_insurance_kit
    foreign key (id) references insurance_kit;

CREATE TABLE catalog_contracts (
    id_contract int not null,
    id_kit int not null,
    primary key (id_contract, id_kit),
    constraint id_contract foreign key (id_contract) references insurance_contract (id),
    constraint id_kit foreign key (id_kit) references insurance_kit (id)
);
alter table if exists vehicle
    add constraint fk_contract
    foreign key (id) references insurance_kit;

alter table if exists client
    add constraint fk_contract
    foreign key (id) references insurance_contract;