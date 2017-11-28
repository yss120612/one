--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

-- Started on 2017-11-28 17:35:56

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
-- TOC entry 212 (class 1259 OID 17391)
-- Name: solidar; Type: TABLE; Schema: public; Owner: -
--

-- DROP TABLE public.solidar;

CREATE TABLE public.solidar
(
    period character varying(12) COLLATE pg_catalog."default" NOT NULL,
    sld66 real NOT NULL,
    sld67 real NOT NULL,
    CONSTRAINT solidar_pkey PRIMARY KEY (period)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.solidar
    OWNER to userpp;
COMMENT ON TABLE public.solidar
    IS 'Солидарная часть взносов по периодам';


--
-- TOC entry 2201 (class 0 OID 17391)
-- Dependencies: 212
-- Data for Name: solidar; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO solidar (period, sld66, sld67) VALUES ('2002', 0, 0);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2003', 0, 0);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2004', 0, 0);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2005', 0, 0);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2006', 0, 0);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2007', 0, 0);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2008', 0, 0);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2009', 0, 0);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2010-0', 4, 4);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2010-1', 0, 4);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2010-2', 4, 4);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2011-0', 10, 10);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2011-1', 10, 10);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2011-2', 10, 10);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2011-3', 10, 10);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2011-4', 10, 10);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2012-0', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2012-1', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2012-2', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2012-3', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2012-4', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2013-0', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2013-1', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2013-2', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2013-3', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2013-4', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2014-0', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2014-1', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2014-2', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2014-3', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2014-4', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2015-0', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2015-1', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2015-2', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2015-3', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2015-4', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2016-0', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2016-1', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2016-2', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2016-3', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2016-4', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2017-0', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2017-1', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2017-2', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2017-3', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2017-4', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2018-1', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2018-2', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2018-3', 6, 6);
INSERT INTO solidar (period, sld66, sld67) VALUES ('2018-4', 6, 6);


-- Completed on 2017-11-28 17:36:01

--
-- PostgreSQL database dump complete
--
