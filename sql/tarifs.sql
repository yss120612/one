-- Table: public.tarifs

-- DROP TABLE public.tarifs;

CREATE TABLE public.tarifs
(
    kod integer NOT NULL,
    kod_regr integer NOT NULL,
    year integer NOT NULL,
    strah1 real NOT NULL,
    nakop1 real NOT NULL,
    strah2 real NOT NULL,
    nakop2 real NOT NULL,
    strah3 real NOT NULL,
    nakop3 real NOT NULL,
    s_strah1 real NOT NULL,
    s_nakop1 real NOT NULL,
    s_strah2 real NOT NULL,
    s_nakop2 real NOT NULL,
    s_strah3 real NOT NULL,
    s_nakop3 real NOT NULL,
    gr_vznos real NOT NULL,
    solidar real NOT NULL,
    CONSTRAINT tarifs_pkey PRIMARY KEY (kod, year)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tarifs
    OWNER to userpp;
COMMENT ON TABLE public.tarifs
    IS 'Тарифы страховых взносов';
    
--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

-- Started on 2017-11-27 17:41:35

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

SET search_path = public, pg_catalog;

--
-- TOC entry 2195 (class 0 OID 17381)
-- Dependencies: 211
-- Data for Name: tarifs; Type: TABLE DATA; Schema: public; Owner: userpp
--

INSERT INTO tarifs VALUES (1, 58, 1996, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (1, 59, 1997, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (2, 51, 1996, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (2, 52, 1997, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (3, 48, 1996, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (3, 49, 1997, 0, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (3, 50, 1998, 0, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (4, 68, 1999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (4, 69, 2000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (5, 78, 2000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (6, 79, 2000, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (7, 95, 2000, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (8, 37, 1999, 42, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (8, 38, 2000, 42, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (9, 41, 1999, 36.4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (9, 42, 2000, 36.4, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (10, 39, 1999, 14, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (10, 40, 2000, 14, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (11, 53, 1996, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (11, 54, 1997, 0, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (11, 55, 1998, 0, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (11, 56, 1999, 0, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (11, 57, 2000, 0, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (12, 80, 1996, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (12, 81, 1997, 0, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (12, 82, 1998, 0, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (12, 83, 1999, 0, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (12, 84, 2000, 0, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (13, 70, 1996, 28, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (13, 71, 1997, 28, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (13, 72, 1998, 28, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (13, 73, 1999, 28, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (13, 74, 2000, 28, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (14, 96, 1996, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (14, 97, 1997, 0, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (14, 98, 1998, 0, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (14, 99, 1999, 0, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (14, 100, 2000, 0, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (15, 43, 1996, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (15, 44, 1997, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (15, 45, 1998, 20.4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (15, 46, 1999, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (15, 47, 2000, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (16, 90, 1996, 20.6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (16, 91, 1997, 20.6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (16, 92, 1998, 20.6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (16, 93, 1999, 20.6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (16, 94, 2000, 20.6, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (17, 60, 1996, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (17, 61, 1997, 0, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (17, 62, 1998, 0, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (17, 63, 1999, 0, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (17, 64, 2000, 0, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (18, 75, 1998, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (18, 76, 1999, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (18, 77, 2000, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (19, 65, 1998, 0, 3.67, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (19, 66, 1999, 0, 3.67, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (19, 67, 2000, 0, 3.67, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (20, 28, 2001, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (21, 35, 2001, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (22, 23, 2001, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (23, 32, 2001, 20.6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (24, 25, 2001, 19.2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (25, 29, 2001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (26, 26, 2001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (27, 22, 2001, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (28, 1, 2002, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (28, 2, 2003, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (28, 3, 2004, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (28, 4, 2005, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (28, 5, 2006, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (28, 6, 2007, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (28, 7, 2008, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (28, 108, 2009, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (29, 8, 2002, 14, 0, 12, 2, 11, 3, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (29, 9, 2003, 14, 0, 12, 2, 11, 3, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (29, 10, 2004, 14, 0, 12, 2, 10, 4, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (29, 11, 2005, 14, 0, 14, 0, 10, 4, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (29, 12, 2006, 14, 0, 14, 0, 10, 4, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (29, 13, 2007, 14, 0, 14, 0, 10, 4, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (29, 14, 2008, 14, 0, 14, 0, 8, 6, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (29, 109, 2009, 14, 0, 14, 0, 8, 6, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (30, 15, 2002, 10.3, 0, 8.3, 2, 7.3, 3, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (30, 16, 2003, 10.3, 0, 8.3, 2, 7.3, 3, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (30, 17, 2004, 10.3, 0, 8.3, 2, 6.3, 4, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (30, 18, 2005, 10.3, 0, 10.3, 0, 6.3, 4, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (30, 19, 2006, 10.3, 0, 10.3, 0, 6.3, 4, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (30, 20, 2007, 10.3, 0, 10.3, 0, 6.3, 4, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (30, 21, 2008, 10.3, 0, 10.3, 0, 4.3, 6, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (30, 111, 2009, 10.3, 0, 10.3, 0, 4.3, 6, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (31, 101, 2002, 0, 0, 0, 0, 0, 0, 1200, 0, 1200, 0, 1200, 600, 0, 0);
INSERT INTO tarifs VALUES (31, 102, 2003, 0, 0, 0, 0, 0, 0, 1200, 0, 1200, 0, 1200, 600, 0, 0);
INSERT INTO tarifs VALUES (31, 103, 2004, 0, 0, 0, 0, 0, 0, 1200, 0, 1200, 0, 1200, 600, 0, 0);
INSERT INTO tarifs VALUES (31, 104, 2005, 0, 0, 0, 0, 0, 0, 1200, 0, 1200, 0, 1200, 600, 0, 0);
INSERT INTO tarifs VALUES (31, 105, 2006, 0, 0, 0, 0, 0, 0, 1200, 0, 1200, 0, 1200, 600, 0, 0);
INSERT INTO tarifs VALUES (31, 106, 2007, 0, 0, 0, 0, 0, 0, 1232, 0, 1232, 0, 1232, 616, 0, 0);
INSERT INTO tarifs VALUES (31, 107, 2008, 0, 0, 0, 0, 0, 0, 2576, 0, 2576, 0, 2576, 1288, 0, 0);
INSERT INTO tarifs VALUES (31, 110, 2009, 0, 0, 0, 0, 0, 0, 2576, 0, 2576, 0, 2576, 1288, 0, 0);
INSERT INTO tarifs VALUES (34, 30, 2001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (35, 24, 2001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (36, 33, 2001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (37, 27, 2001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (39, 31, 2001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (40, 36, 2001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (41, 34, 2001, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (42, 85, 1996, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (42, 86, 1997, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (42, 87, 1998, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (42, 88, 1999, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (42, 89, 2000, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO tarifs VALUES (44, 112, 2010, 1.1, 2, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 415000, 0);
INSERT INTO tarifs VALUES (44, 147, 2011, 3.1, 2, 26, 0, 20, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (44, 209, 2012, 5.1, 0, 22, 0, 16, 6, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (44, 282, 2013, 5.1, 0, 22, 0, 16, 6, 0, 0, 0, 0, 0, 0, 568000, 10);
INSERT INTO tarifs VALUES (44, 340, 2014, 5.1, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 624000, 10);
INSERT INTO tarifs VALUES (44, 385, 2015, 5.1, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 711000, 10);
INSERT INTO tarifs VALUES (44, 438, 2016, 5.1, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 796000, 10);
INSERT INTO tarifs VALUES (45, 113, 2010, 1.1, 1.2, 15.8, 0, 9.8, 6, 0, 0, 0, 0, 0, 0, 415000, 0);
INSERT INTO tarifs VALUES (45, 151, 2011, 1.1, 1.2, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (46, 114, 2010, 0, 0, 14, 0, 8, 6, 0, 0, 0, 0, 0, 0, 415000, 0);
INSERT INTO tarifs VALUES (46, 155, 2011, 1.1, 1.2, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (46, 215, 2012, 2.3, 0, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (46, 289, 2013, 3.7, 0, 21, 0, 15, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (46, 341, 2014, 3.7, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (47, 115, 2010, 0, 0, 10.3, 0, 4.3, 6, 0, 0, 0, 0, 0, 0, 415000, 0);
INSERT INTO tarifs VALUES (47, 173, 2011, 1.1, 1.2, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (47, 216, 2012, 2.3, 0, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (47, 288, 2013, 3.7, 0, 21, 0, 15, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (47, 344, 2014, 3.7, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (48, 116, 2010, 0, 0, 14, 0, 8, 6, 0, 0, 0, 0, 0, 0, 415000, 0);
INSERT INTO tarifs VALUES (49, 117, 2010, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 415000, 0);
INSERT INTO tarifs VALUES (49, 123, 2011, 0, 0, 26, 0, 20, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (49, 124, 2012, 0, 0, 22, 0, 16, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (49, 125, 2013, 0, 0, 22, 0, 16, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (49, 126, 2014, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (49, 361, 2015, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (49, 429, 2016, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (50, 118, 2010, 0, 0, 15.8, 0, 9.8, 6, 0, 0, 0, 0, 0, 0, 415000, 0);
INSERT INTO tarifs VALUES (50, 127, 2011, 0, 0, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (50, 128, 2012, 0, 0, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (50, 129, 2013, 0, 0, 21, 0, 15, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (50, 130, 2014, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (51, 119, 2010, 0, 0, 14, 0, 8, 6, 0, 0, 0, 0, 0, 0, 415000, 0);
INSERT INTO tarifs VALUES (52, 121, 2010, 0, 0, 10.3, 0, 4.3, 6, 0, 0, 0, 0, 0, 0, 415000, 0);
INSERT INTO tarifs VALUES (52, 135, 2011, 0, 0, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (52, 136, 2012, 0, 0, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (52, 137, 2013, 0, 0, 21, 0, 15, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (52, 138, 2014, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (53, 120, 2010, 0, 0, 14, 0, 8, 6, 0, 0, 0, 0, 0, 0, 415000, 0);
INSERT INTO tarifs VALUES (55, 122, 2010, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 415000, 0);
INSERT INTO tarifs VALUES (55, 143, 2011, 0, 0, 26, 0, 20, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (55, 144, 2012, 0, 0, 26, 0, 20, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (55, 145, 2013, 0, 0, 26, 0, 20, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (55, 146, 2014, 0, 0, 26, 0, 26, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (55, 384, 2015, 0, 0, 26, 0, 26, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (55, 435, 2016, 0, 0, 26, 0, 26, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (57, 159, 2010, 0, 0, 14, 0, 8, 6, 0, 0, 0, 0, 0, 0, 415000, 0);
INSERT INTO tarifs VALUES (57, 174, 2011, 2, 2, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (57, 217, 2012, 4, 0, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (57, 292, 2013, 4, 0, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (57, 345, 2014, 4, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (57, 388, 2015, 4, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (57, 439, 2016, 4, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (58, 160, 2011, 0, 0, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (58, 181, 2012, 0, 0, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (58, 278, 2013, 0, 0, 21, 0, 15, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (58, 306, 2014, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (59, 161, 2011, 0, 0, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (59, 182, 2012, 0, 0, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (59, 274, 2013, 0, 0, 21, 0, 15, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (59, 309, 2014, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (60, 162, 2011, 0, 0, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (60, 183, 2012, 0, 0, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (60, 279, 2013, 0, 0, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (60, 321, 2014, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (60, 370, 2015, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (60, 436, 2016, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (61, 163, 2011, 0, 0, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (61, 184, 2012, 0, 0, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (61, 277, 2013, 0, 0, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (61, 336, 2014, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (61, 383, 2015, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (61, 433, 2016, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (62, 171, 2010, 0, 0, 14, 0, 8, 6, 0, 0, 0, 0, 0, 0, 415000, 0);
INSERT INTO tarifs VALUES (62, 165, 2011, 0, 0, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (62, 185, 2012, 0, 0, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (62, 273, 2013, 0, 0, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (62, 314, 2014, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (62, 364, 2015, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (62, 430, 2016, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (63, 167, 2011, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (63, 186, 2012, 0, 0, 20.8, 0, 14.8, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (63, 276, 2013, 0, 0, 21.6, 0, 15.6, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (63, 324, 2014, 0, 0, 23.2, 0, 23.2, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (64, 168, 2011, 0, 0, 18, 0, 12, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (64, 187, 2012, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (64, 275, 2013, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (64, 317, 2014, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (64, 367, 2015, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (64, 431, 2016, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (65, 172, 2010, 0, 0, 14, 0, 8, 6, 0, 0, 0, 0, 0, 0, 415000, 0);
INSERT INTO tarifs VALUES (65, 170, 2011, 0, 0, 14, 0, 8, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (65, 188, 2012, 0, 0, 14, 0, 8, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (65, 272, 2013, 0, 0, 14, 0, 8, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (65, 327, 2014, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (65, 373, 2015, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (65, 427, 2016, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (66, 175, 2011, 3.1, 2, 18, 0, 12, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (66, 218, 2012, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (66, 295, 2013, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (66, 346, 2014, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (66, 389, 2015, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (66, 440, 2016, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (67, 176, 2011, 2, 2, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (67, 219, 2012, 4, 0, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (67, 290, 2013, 4, 0, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (67, 347, 2014, 4, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (67, 390, 2015, 4, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (67, 441, 2016, 4, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (68, 177, 2011, 1.1, 2, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (68, 220, 2012, 3.3, 0, 20.8, 0, 14.8, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (68, 293, 2013, 3.5, 0, 21.6, 0, 15.6, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (68, 348, 2014, 3.9, 0, 23.2, 0, 23.2, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (69, 178, 2011, 0, 0, 14, 0, 8, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (69, 221, 2012, 0, 0, 14, 0, 8, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (69, 300, 2013, 0, 0, 14, 0, 8, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (69, 349, 2014, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (69, 391, 2015, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (69, 442, 2016, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (70, 179, 2011, 3.1, 2, 26, 0, 20, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (71, 180, 2011, 2, 2, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (71, 227, 2012, 4, 0, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (71, 291, 2013, 4, 0, 8, 0, 2, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (71, 355, 2014, 4, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (71, 397, 2015, 4, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (71, 450, 2016, 4, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (74, 189, 2012, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (74, 242, 2013, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (74, 330, 2014, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (74, 376, 2015, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (74, 406, 2016, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (75, 190, 2012, 0, 0, 22, 0, 16, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (75, 280, 2013, 0, 0, 22, 0, 16, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (75, 333, 2014, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (75, 379, 2015, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (75, 437, 2016, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (76, 191, 2012, 0, 0, 22, 0, 16, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (76, 271, 2013, 0, 0, 22, 0, 16, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (77, 192, 2012, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (77, 258, 2013, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (78, 193, 2012, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (78, 261, 2013, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (78, 303, 2014, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (78, 360, 2015, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (78, 419, 2016, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (79, 194, 2012, 0, 0, 16, 0, 16, 0, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (79, 265, 2013, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (79, 305, 2014, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (80, 195, 2012, 0, 0, 16, 0, 16, 0, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (80, 257, 2013, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (80, 313, 2014, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (81, 196, 2012, 0, 0, 16, 0, 16, 0, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (81, 260, 2013, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (81, 308, 2014, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (82, 197, 2012, 0, 0, 16, 0, 16, 0, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (82, 262, 2013, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (82, 311, 2014, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (83, 198, 2012, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (83, 267, 2013, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (83, 323, 2014, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (83, 369, 2015, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (83, 423, 2016, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (84, 199, 2012, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (84, 266, 2013, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (84, 338, 2014, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (84, 381, 2015, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (84, 421, 2016, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (85, 200, 2012, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (85, 259, 2013, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (85, 316, 2014, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (85, 363, 2015, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (85, 417, 2016, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (86, 201, 2012, 0, 0, 20.8, 0, 20.8, 0, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (86, 264, 2013, 0, 0, 21.6, 0, 21.6, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (86, 326, 2014, 0, 0, 23.2, 0, 23.2, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (87, 202, 2012, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (87, 269, 2013, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (87, 319, 2014, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (87, 366, 2015, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (87, 425, 2016, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (88, 203, 2012, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (88, 268, 2013, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (88, 329, 2014, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (88, 372, 2015, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (88, 424, 2016, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (89, 204, 2012, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (89, 263, 2013, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (89, 332, 2014, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (89, 375, 2015, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (89, 420, 2016, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (90, 205, 2012, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (90, 270, 2013, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (90, 335, 2014, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (90, 378, 2015, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (90, 426, 2016, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (92, 206, 2010, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 415000, 0);
INSERT INTO tarifs VALUES (92, 207, 2011, 0, 0, 26, 0, 20, 6, 0, 0, 0, 0, 0, 0, 463000, 0);
INSERT INTO tarifs VALUES (92, 208, 2012, 0, 0, 26, 0, 20, 6, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (92, 281, 2013, 0, 0, 26, 0, 20, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (92, 339, 2014, 0, 0, 26, 0, 26, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (92, 382, 2015, 0, 0, 26, 0, 26, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (92, 432, 2016, 0, 0, 26, 0, 26, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (93, 210, 2012, 5.1, 0, 22, 0, 16, 6, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (93, 283, 2013, 5.1, 0, 22, 0, 16, 6, 0, 0, 0, 0, 0, 0, 568000, 10);
INSERT INTO tarifs VALUES (93, 342, 2014, 5.1, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 624000, 10);
INSERT INTO tarifs VALUES (93, 386, 2015, 5.1, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 711000, 10);
INSERT INTO tarifs VALUES (93, 451, 2016, 5.1, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 796000, 10);
INSERT INTO tarifs VALUES (94, 211, 2012, 5.1, 0, 22, 0, 16, 6, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (94, 284, 2013, 5.1, 0, 22, 0, 16, 6, 0, 0, 0, 0, 0, 0, 568000, 10);
INSERT INTO tarifs VALUES (94, 343, 2014, 5.1, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 624000, 10);
INSERT INTO tarifs VALUES (94, 387, 2015, 5.1, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 711000, 10);
INSERT INTO tarifs VALUES (94, 452, 2016, 5.1, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 796000, 10);
INSERT INTO tarifs VALUES (95, 212, 2012, 2.3, 0, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (95, 285, 2013, 3.7, 0, 21, 0, 15, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (95, 356, 2014, 3.7, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (96, 213, 2012, 2.3, 0, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (96, 286, 2013, 3.7, 0, 21, 0, 15, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (96, 357, 2014, 3.7, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (97, 214, 2012, 2.3, 0, 16, 0, 10, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (97, 287, 2013, 3.7, 0, 21, 0, 15, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (97, 358, 2014, 3.7, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (98, 222, 2012, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (98, 296, 2013, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (98, 350, 2014, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (98, 392, 2015, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (98, 443, 2016, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (99, 223, 2012, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (99, 297, 2013, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (99, 351, 2014, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (99, 393, 2015, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (99, 444, 2016, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (100, 224, 2012, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (100, 298, 2013, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (100, 352, 2014, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (100, 394, 2015, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (100, 445, 2016, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (101, 225, 2012, 5.1, 0, 22, 0, 16, 6, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (101, 299, 2013, 5.1, 0, 22, 0, 16, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (102, 226, 2012, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 512000, 0);
INSERT INTO tarifs VALUES (102, 294, 2013, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (102, 353, 2014, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (102, 395, 2015, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (102, 446, 2016, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (103, 228, 2012, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (103, 244, 2013, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (104, 229, 2012, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (104, 247, 2013, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (104, 302, 2014, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (104, 359, 2015, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (104, 409, 2016, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (105, 230, 2012, 0, 0, 16, 0, 16, 0, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (105, 251, 2013, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (105, 304, 2014, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (106, 231, 2012, 0, 0, 16, 0, 16, 0, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (106, 243, 2013, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (106, 312, 2014, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (107, 232, 2012, 0, 0, 16, 0, 16, 0, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (107, 246, 2013, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (107, 307, 2014, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (108, 233, 2012, 0, 0, 16, 0, 16, 0, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (108, 248, 2013, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (108, 310, 2014, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (109, 234, 2012, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (109, 253, 2013, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (109, 322, 2014, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (109, 368, 2015, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (109, 413, 2016, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (110, 235, 2012, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (110, 252, 2013, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (110, 337, 2014, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (110, 380, 2015, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (110, 411, 2016, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (111, 236, 2012, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (111, 245, 2013, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (111, 315, 2014, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (111, 362, 2015, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (111, 407, 2016, 0, 0, 8, 0, 8, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (112, 237, 2012, 0, 0, 20.8, 0, 20.8, 0, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (112, 250, 2013, 0, 0, 21.6, 0, 21.6, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (112, 325, 2014, 0, 0, 23.2, 0, 23.2, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (113, 238, 2012, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (113, 255, 2013, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (113, 318, 2014, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (113, 365, 2015, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (113, 415, 2016, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (114, 239, 2012, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (114, 254, 2013, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (114, 328, 2014, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (114, 371, 2015, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (114, 414, 2016, 0, 0, 14, 0, 14, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (115, 240, 2012, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (115, 249, 2013, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (115, 331, 2014, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (115, 374, 2015, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (115, 410, 2016, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (116, 241, 2012, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 512000, 10);
INSERT INTO tarifs VALUES (116, 256, 2013, 0, 0, 22, 0, 22, 0, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (116, 334, 2014, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (116, 377, 2015, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (116, 416, 2016, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (117, 301, 2013, 0, 0, 20, 0, 14, 6, 0, 0, 0, 0, 0, 0, 568000, 0);
INSERT INTO tarifs VALUES (117, 354, 2014, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 624000, 0);
INSERT INTO tarifs VALUES (117, 396, 2015, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (117, 447, 2016, 0, 0, 20, 0, 20, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (118, 398, 2015, 0, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (118, 428, 2016, 0, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (119, 399, 2015, 0, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (119, 408, 2016, 0, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (120, 400, 2015, 0, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (120, 418, 2016, 0, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (121, 401, 2015, 0, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (121, 434, 2016, 0, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (122, 402, 2015, 0, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (122, 412, 2016, 0, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (123, 403, 2015, 0, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (123, 422, 2016, 0, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (124, 404, 2015, 0.1, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (124, 448, 2016, 0.1, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (125, 405, 2015, 0.1, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 711000, 0);
INSERT INTO tarifs VALUES (125, 449, 2016, 0.1, 0, 6, 0, 6, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (126, 453, 2016, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (127, 454, 2016, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (128, 455, 2016, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 796000, 0);
INSERT INTO tarifs VALUES (129, 456, 2016, 0.1, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 796000, 0);


-- Completed on 2017-11-27 17:41:38

--
-- PostgreSQL database dump complete
--
     