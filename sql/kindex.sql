--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

-- Started on 2017-11-28 17:32:28

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
-- TOC entry 213 (class 1259 OID 17396)
-- Name: kindex; Type: TABLE; Schema: public; Owner: userpp
--

CREATE TABLE kindex (
    year integer NOT NULL,
    koeff real NOT NULL,
    osnov character varying(100)
);


ALTER TABLE kindex OWNER TO userpp;

--
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 213
-- Name: TABLE kindex; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON TABLE kindex IS 'Коэффициенты индексации';


--
-- TOC entry 2201 (class 0 OID 17396)
-- Dependencies: 213
-- Data for Name: kindex; Type: TABLE DATA; Schema: public; Owner: userpp
--

INSERT INTO kindex (year, koeff, osnov) VALUES (2002, 1.177, 'ПП РФ от 15.03.2004 г. N 141');
INSERT INTO kindex (year, koeff, osnov) VALUES (2003, 1.114, 'ПП РФ от 11.07.2005 г. N 417');
INSERT INTO kindex (year, koeff, osnov) VALUES (2004, 1.127, 'ПП РФ от 24.03.2006 г. N 166');
INSERT INTO kindex (year, koeff, osnov) VALUES (2005, 1.16, 'ПП РФ от 27.03.2007 г. N 183');
INSERT INTO kindex (year, koeff, osnov) VALUES (2006, 1.204, 'ПП РФ от 25.03.2008 г. N 205');
INSERT INTO kindex (year, koeff, osnov) VALUES (2007, 1.269, 'ПП РФ от 21.03.2009 г. N 248');
INSERT INTO kindex (year, koeff, osnov) VALUES (2008, 1.1427, 'ПП РФ от 18.03.2010 г. N 168');
INSERT INTO kindex (year, koeff, osnov) VALUES (2009, 1.088, 'ПП РФ от 7.04.2011 г. N 255');
INSERT INTO kindex (year, koeff, osnov) VALUES (2010, 1.1065, 'ПП РФ от 27.03.2012 г. N 238');
INSERT INTO kindex (year, koeff, osnov) VALUES (2011, 1.101, 'ПП РФ от 27.03.2013 г. N 263');
INSERT INTO kindex (year, koeff, osnov) VALUES (2012, 1.083, 'ПП РФ от 28.03.2014 г. N 240');
INSERT INTO kindex (year, koeff, osnov) VALUES (2013, 1, NULL);
INSERT INTO kindex (year, koeff, osnov) VALUES (2014, 1, '-');


--
-- TOC entry 2079 (class 2606 OID 17400)
-- Name: kindex kindex_pkey; Type: CONSTRAINT; Schema: public; Owner: userpp
--

ALTER TABLE ONLY kindex
    ADD CONSTRAINT kindex_pkey PRIMARY KEY (year);


-- Completed on 2017-11-28 17:32:31

--
-- PostgreSQL database dump complete
--
