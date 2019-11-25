DROP TABLE IF EXISTS attributes;
DROP TABLE IF EXISTS items;

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
    FOREIGN KEY (attributes) REFERENCES attributes (ean)
);

INSERT INTO attributes (ean, qauntity, reason_code) VALUES
('02939384', 10, 'In Stock'),
('029121321', 12, 'In Stock'),
('02932136565', 1, 'In Stock');

INSERT INTO items (id, type, attributes) VALUES
('02939384', 'stock', '02939384'),
('029121321', 'stock', '029121321'),
('02932136565', 'stock', '02932136565');