--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

-- Started on 2017-11-24 16:11:31

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 2184 (class 0 OID 17359)
-- Dependencies: 207
-- Data for Name: k_raions; Type: TABLE DATA; Schema: public; Owner: userpp
-- Table: public.k_raions

-- DROP TABLE public.k_raions;

CREATE TABLE public.k_raions
(
    kodr integer NOT NULL,
    koef real NOT NULL,
    rgn character varying(30) COLLATE pg_catalog."default",
    dst character varying(60) COLLATE pg_catalog."default"
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.k_raions
    OWNER to userpp;

INSERT INTO k_raions VALUES (3002, 1.3, 'Республика Бурятия', 'Баунтовский');
INSERT INTO k_raions VALUES (3013, 1.3, 'Республика Бурятия', 'Муйский');
INSERT INTO k_raions VALUES (3017, 1.3, 'Республика Бурятия', 'Северо-Байкальский');
INSERT INTO k_raions VALUES (9011, 1.3, 'Республика Карелия', 'Медвежьегорский');
INSERT INTO k_raions VALUES (9006, 1.3, 'Республика Карелия', 'Муезерский');
INSERT INTO k_raions VALUES (9004, 1.3, 'Республика Карелия', 'Пудожский');
INSERT INTO k_raions VALUES (9014, 1.3, 'Республика Карелия', ' г. Сегежа');
INSERT INTO k_raions VALUES (7018, 1.3, 'Республика Коми', 'Ижемский');
INSERT INTO k_raions VALUES (7006, 1.3, 'Республика Коми', 'Печорский, Печора');
INSERT INTO k_raions VALUES (7014, 1.3, 'Республика Коми', 'Троицко-Печорский');
INSERT INTO k_raions VALUES (7019, 1.3, 'Республика Коми', 'Усть-Цилемский');
INSERT INTO k_raions VALUES (7016, 1.3, 'Республика Коми', 'Удорский');
INSERT INTO k_raions VALUES (7020, 1.3, 'Республика Коми', 'Вуктыл');
INSERT INTO k_raions VALUES (7022, 1.3, 'Республика Коми', 'Сосногорск');
INSERT INTO k_raions VALUES (7007, 1.3, 'Республика Коми', 'Ухта');
INSERT INTO k_raions VALUES (7021, 1.3, 'Республика Коми', 'Усинск');
INSERT INTO k_raions VALUES (34028, 1.3, 'Красноярский край', 'Богучанский');
INSERT INTO k_raions VALUES (34013, 1.3, 'Красноярский край', 'Енисейский');
INSERT INTO k_raions VALUES (34039, 1.3, 'Красноярский край', 'Кежемский');
INSERT INTO k_raions VALUES (34044, 1.3, 'Красноярский край', 'Мотыгинский');
INSERT INTO k_raions VALUES (34051, 1.3, 'Красноярский край', 'Северо-Енисейский');
INSERT INTO k_raions VALUES (34053, 1.3, 'Красноярский край', 'Туруханский (южнее рек Нижняя Тунгуска и Турухан) районы');
INSERT INTO k_raions VALUES (34061, 1.3, 'Красноярский край', 'Лесосибирск');
INSERT INTO k_raions VALUES (48008, 1.3, 'Иркутская область', 'Бодайбинский');
INSERT INTO k_raions VALUES (48009, 1.3, 'Иркутская область', 'Братский');
INSERT INTO k_raions VALUES (48015, 1.3, 'Иркутская область', 'Казачинско-Ленский');
INSERT INTO k_raions VALUES (48016, 1.3, 'Иркутская область', 'Катангский');
INSERT INTO k_raions VALUES (48034, 1.3, 'Иркутская область', 'Киренский');
INSERT INTO k_raions VALUES (48019, 1.3, 'Иркутская область', ' Мамско-Чуйский');
INSERT INTO k_raions VALUES (48021, 1.3, 'Иркутская область', 'Нижнеилимский');
INSERT INTO k_raions VALUES (48028, 1.3, 'Иркутская область', 'Усть-Кутский');
INSERT INTO k_raions VALUES (48027, 1.3, 'Иркутская область', 'Усть-Илимск');


-- Completed on 2017-11-24 16:11:33

--
-- PostgreSQL database dump complete
--
