CREATE TABLE dane_do_pobrania (id INTEGER NULL, info CHAR(64) NULL);
INSERT INTO dane_do_pobrania VALUES (1, '111');
INSERT INTO dane_do_pobrania VALUES (2, '222');
INSERT INTO dane_do_pobrania VALUES(3, '333');
INSERT INTO dane_do_pobrania VALUES(4, '444');

CREATE TABLE ostatnie_pobranie (id INTEGER NULL, data_pobrania TIMESTAMP NULL);
INSERT INTO ostatnie_pobranie VALUES(1, '2001-01-01');
INSERT INTO ostatnie_pobranie VALUES(2, '2001-01-01');

CREATE TABLE historia_pobran (id INTEGER NULL, data_pobrania TIMESTAMP NULL);
INSERT INTO historia_pobran VALUES(1, '2001-01-01');
INSERT INTO historia_pobran VALUES(2, '2001-01-01');