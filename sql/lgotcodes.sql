--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

-- Started on 2017-12-05 12:40:12

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 216 (class 1259 OID 17575)
-- Name: lgotcodes; Type: TABLE; Schema: public; Owner: userpp
--

CREATE TABLE lgotcodes (
    old_code character varying(50) NOT NULL,
    new_code character varying(50) NOT NULL,
    field character varying(20) NOT NULL
);


ALTER TABLE lgotcodes OWNER TO userpp;

--
-- TOC entry 2211 (class 0 OID 17575)
-- Dependencies: 216
-- Data for Name: lgotcodes; Type: TABLE DATA; Schema: public; Owner: userpp
--

INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('﻿ЗП12А', '27-1', 'cwcext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП12Б', '27-2', 'cwcext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП12В', '27-3', 'cwcext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП12Г', '27-4', 'cwcext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП12Д', '27-5', 'cwcext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП12Е', '27-6', 'cwcext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП12Ж', '27-7', 'cwcext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП12З', '27-8', 'cwcext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП12И', '27-9', 'cwcext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП12К', '27-10', 'cwcext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП12М', '27-ОС', 'cwcext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('28-ОС', '27-ОС', 'cwcext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('28-ПЖ', '27-ПЖ', 'cwcext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('28-СП', '27-СП', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('28-ПД', '27-ПД', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('28-ПДРК', '27-ПДРК', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('28-ГД', '27-ГД', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('28-ГДХР', '27-ГДХР', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('28-СМ', '27-СМ', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('28-СМХР', '27-СМХР', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('СЕВ26', '28-СЕВ', 'cwcext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП78ГР', '27-11ГР', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП78ВП', '27-11ВП', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП78ФЛ', '27-12', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП78СС', '27-СП', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП80ПД', '27-ПД', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП80РК', '27-ПДРК', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП81ГД', '27-ГД', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП81СМ', '27-СМ', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ХИРУРГД', '27-ГДХР', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ХИРУРСМ', '27-СМХР', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('УВД', '27-14', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ИТС', '27-15', 'cspext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('ЗП12О', '27-ПЖ', 'cwcext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('МКСР', 'МКС', 'cggext');
INSERT INTO lgotcodes (old_code, new_code, field) VALUES ('РКСМ', 'РКС', 'cggext');


--
-- TOC entry 2089 (class 2606 OID 17579)
-- Name: lgotcodes lgotcodes_pkey; Type: CONSTRAINT; Schema: public; Owner: userpp
--

ALTER TABLE ONLY lgotcodes
    ADD CONSTRAINT lgotcodes_pkey PRIMARY KEY (old_code);


-- Completed on 2017-12-05 12:40:14

--
-- PostgreSQL database dump complete
--
