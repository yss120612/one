--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

-- Started on 2017-12-01 11:51:39

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
-- TOC entry 215 (class 1259 OID 17413)
-- Name: sprspk; Type: TABLE; Schema: public; Owner: userpp
--

CREATE TABLE sprspk (
    date date NOT NULL,
    spk real NOT NULL,
    fv real
);


ALTER TABLE sprspk OWNER TO userpp;

--
-- TOC entry 2212 (class 0 OID 0)
-- Dependencies: 215
-- Name: TABLE sprspk; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON TABLE sprspk IS 'Стоимость пенсионного балла по датам и фиксированная выплата  ';


--
-- TOC entry 2207 (class 0 OID 17413)
-- Dependencies: 215
-- Data for Name: sprspk; Type: TABLE DATA; Schema: public; Owner: userpp
--

INSERT INTO sprspk (date, spk, fv) VALUES ('2002-01-01', 0, 522.38);
INSERT INTO sprspk (date, spk, fv) VALUES ('2003-01-01', 0, 598.02);
INSERT INTO sprspk (date, spk, fv) VALUES ('2004-01-01', 0, 660);
INSERT INTO sprspk (date, spk, fv) VALUES ('2005-01-01', 0, 954);
INSERT INTO sprspk (date, spk, fv) VALUES ('2006-01-01', 0, 1035.09);
INSERT INTO sprspk (date, spk, fv) VALUES ('2007-01-01', 0, 1560);
INSERT INTO sprspk (date, spk, fv) VALUES ('2008-01-01', 0, 1794);
INSERT INTO sprspk (date, spk, fv) VALUES ('2009-01-01', 0, 1950);
INSERT INTO sprspk (date, spk, fv) VALUES ('2010-01-01', 0, 2723.41);
INSERT INTO sprspk (date, spk, fv) VALUES ('2011-01-01', 0, 2963.07);
INSERT INTO sprspk (date, spk, fv) VALUES ('2012-01-01', 0, 3278.59);
INSERT INTO sprspk (date, spk, fv) VALUES ('2013-01-01', 0, 3610.31);
INSERT INTO sprspk (date, spk, fv) VALUES ('2014-01-01', 0, 3910.34);
INSERT INTO sprspk (date, spk, fv) VALUES ('2015-01-01', 64.1, 3935);
INSERT INTO sprspk (date, spk, fv) VALUES ('2015-02-01', 71.41, 4383.59);
INSERT INTO sprspk (date, spk, fv) VALUES ('2016-01-01', 74.27, 4558.93);
INSERT INTO sprspk (date, spk, fv) VALUES ('2017-01-01', 78.58, 4805.11);


--
-- TOC entry 2085 (class 2606 OID 17417)
-- Name: sprspk sprspk_pkey; Type: CONSTRAINT; Schema: public; Owner: userpp
--

ALTER TABLE ONLY sprspk
    ADD CONSTRAINT sprspk_pkey PRIMARY KEY (date);


-- Completed on 2017-12-01 11:51:40

--
-- PostgreSQL database dump complete
--
