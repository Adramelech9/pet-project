CREATE TABLE client (
    id          bigint PRIMARY KEY,
    uuid        VARCHAR(50) UNIQUE NOT NULL,
    email       VARCHAR(50)        NOT NULL,
    password    VARCHAR(50)        NOT NULL,
    birth_date  DATE               NOT NULL,
    first_name  VARCHAR(50)        NOT NULL,
    last_name   VARCHAR(50)        NOT NULL,
    created_at  TIMESTAMP          NOT NULL,
    updated_at  TIMESTAMP          NOT NULL
);

CREATE TABLE vehicle (
    id                  bigint PRIMARY KEY,
    uuid                VARCHAR(50) UNIQUE NOT NULL,
    color               VARCHAR(50)        NOT NULL,
    engine_capacity     INT                NOT NULL,
    year_of_manufacture INT                NOT NULL,
    weight_kg           INT                NOT NULL,
    created_at          TIMESTAMP          NOT NULL,
    updated_at          TIMESTAMP          NOT NULL,
    client_id           bigint,
    contract_id         bigint,
    constraint vehicle_client_id_fk foreign key (client_id) references client (id)
);

CREATE TABLE insurance_kit (
    id                   bigint PRIMARY KEY,
    uuid                 VARCHAR(50) UNIQUE NOT NULL,
    duration             TIMESTAMP          NOT NULL,
    compensation_percent INT                NOT NULL,
    damage_level         VARCHAR(50)        NOT NULL,
    covered_part         VARCHAR(50)        NOT NULL,
    created_at           TIMESTAMP          NOT NULL,
    updated_at           TIMESTAMP          NOT NULL
);

CREATE TABLE insurance_contract (
    id         bigint PRIMARY KEY,
    uuid       VARCHAR(50) UNIQUE NOT NULL,
    created_at TIMESTAMP          NOT NULL,
    updated_at TIMESTAMP          NOT NULL,
    client_id  bigint             NOT NULL,
    constraint insurance_contract_client_id_fk foreign key (client_id) references client (id)
);

alter table vehicle
    add foreign key (contract_id) references insurance_contract;

CREATE TABLE contract_kit (
    contract_id bigint not null,
    kit_id bigint not null,
    primary key (contract_id, kit_id),
    constraint contract_kit_contract_id_insurance_contract_fk foreign key (contract_id) references insurance_contract (id),
    constraint contract_kit_kit_id_insurance_kit_fk foreign key (kit_id) references insurance_kit (id)
);