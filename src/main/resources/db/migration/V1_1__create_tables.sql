CREATE TABLE attributes
(
    ean varchar(64) PRIMARY KEY,
    qauntity int,
    reason_code varchar(255)
);

CREATE TABLE items
(
    id varchar (64) PRIMARY KEY,
    type varchar(64),
    attributes varchar(64),
    CONSTRAINT fk_attributes FOREIGN KEY (attributes)
        REFERENCES attributes (ean) MATCH SIMPLE
        ON UPDATE  NO ACTION
        ON DELETE  NO ACTION
);
