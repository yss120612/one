--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

-- Started on 2017-11-24 16:04:52

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
-- TOC entry 2186 (class 0 OID 17362)
-- Dependencies: 208
-- Data for Name: dojitye; Type: TABLE DATA; Schema: public; Owner: userpp
--
-- Table: public.dojitye

-- DROP TABLE public.dojitye;

CREATE TABLE public.dojitye
(
    year integer NOT NULL,
    period integer NOT NULL,
    period_min integer NOT NULL,
    period_lgot integer NOT NULL,
    CONSTRAINT dojitye_pkey PRIMARY KEY (year)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.dojitye
    OWNER to userpp;
    


INSERT INTO dojitye VALUES (2002, 144, 120, 144);
INSERT INTO dojitye VALUES (2003, 150, 120, 150);
INSERT INTO dojitye VALUES (2004, 156, 120, 156);
INSERT INTO dojitye VALUES (2005, 162, 120, 162);
INSERT INTO dojitye VALUES (2006, 168, 120, 168);
INSERT INTO dojitye VALUES (2007, 174, 120, 174);
INSERT INTO dojitye VALUES (2008, 180, 120, 180);
INSERT INTO dojitye VALUES (2009, 186, 126, 186);
INSERT INTO dojitye VALUES (2010, 192, 132, 192);
INSERT INTO dojitye VALUES (2011, 204, 138, 204);
INSERT INTO dojitye VALUES (2012, 216, 144, 216);
INSERT INTO dojitye VALUES (2013, 228, 150, 228);
INSERT INTO dojitye VALUES (2014, 228, 156, 240);
INSERT INTO dojitye VALUES (2015, 228, 162, 252);
INSERT INTO dojitye VALUES (2016, 228, 168, 252);


-- Completed on 2017-11-24 16:04:54

--
-- PostgreSQL database dump complete
--
 