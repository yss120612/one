--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

-- Started on 2017-11-30 18:15:21

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
-- TOC entry 214 (class 1259 OID 17408)
-- Name: spripk; Type: TABLE; Schema: public; Owner: userpp
--

CREATE TABLE spripk (
    year integer NOT NULL,
    ipks real NOT NULL,
    ipkn real NOT NULL
);


ALTER TABLE spripk OWNER TO userpp;

--
-- TOC entry 2209 (class 0 OID 0)
-- Dependencies: 214
-- Name: TABLE spripk; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON TABLE spripk IS 'Справочник коэффициентов ИПК';


--
-- TOC entry 2204 (class 0 OID 17408)
-- Dependencies: 214
-- Data for Name: spripk; Type: TABLE DATA; Schema: public; Owner: userpp
--

INSERT INTO spripk (year, ipks, ipkn) VALUES (2015, 7.39, 4.62);
INSERT INTO spripk (year, ipks, ipkn) VALUES (2016, 7.83, 4.89);
INSERT INTO spripk (year, ipks, ipkn) VALUES (2017, 8.26, 5.16);
INSERT INTO spripk (year, ipks, ipkn) VALUES (2018, 8.7, 5.43);
INSERT INTO spripk (year, ipks, ipkn) VALUES (2019, 9.13, 5.71);
INSERT INTO spripk (year, ipks, ipkn) VALUES (2020, 9.57, 5.98);
INSERT INTO spripk (year, ipks, ipkn) VALUES (2021, 10, 6.25);


--
-- TOC entry 2082 (class 2606 OID 17412)
-- Name: spripk spripk_pkey; Type: CONSTRAINT; Schema: public; Owner: userpp
--

ALTER TABLE ONLY spripk
    ADD CONSTRAINT spripk_pkey PRIMARY KEY (year);


-- Completed on 2017-11-30 18:16:00

--
-- PostgreSQL database dump complete
--
