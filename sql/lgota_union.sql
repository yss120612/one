--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

-- Started on 2017-12-22 13:59:12

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
-- TOC entry 222 (class 1259 OID 26149)
-- Name: union_lgota; Type: TABLE; Schema: public; Owner: userpp
--

CREATE TABLE union_lgota (
    kod1 character varying(50) NOT NULL,
    kod2 character varying(50) NOT NULL,
    usl_m real NOT NULL,
    usl_w real NOT NULL,
    koef real NOT NULL,
    main character varying(50) NOT NULL
);


ALTER TABLE union_lgota OWNER TO userpp;

--
-- TOC entry 2235 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN union_lgota.kod1; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN union_lgota.kod1 IS 'Рассчитываемая льгота';


--
-- TOC entry 2236 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN union_lgota.kod2; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN union_lgota.kod2 IS 'Суммируемая льгота';


--
-- TOC entry 2237 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN union_lgota.usl_m; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN union_lgota.usl_m IS 'Условия суммирования для мужчин';


--
-- TOC entry 2238 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN union_lgota.usl_w; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN union_lgota.usl_w IS 'Условия суммирования для женщин';


--
-- TOC entry 2239 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN union_lgota.koef; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN union_lgota.koef IS 'Коэффициент суммирования';


--
-- TOC entry 2240 (class 0 OID 0)
-- Dependencies: 222
-- Name: COLUMN union_lgota.main; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN union_lgota.main IS 'Основная льгота(при пересечении)';


--
-- TOC entry 2230 (class 0 OID 26149)
-- Dependencies: 222
-- Data for Name: union_lgota; Type: TABLE DATA; Schema: public; Owner: userpp
--

INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-1', 'Ч36', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-2', '27-1', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-2', '27-5', 12.5, 10, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-2', '27-6', 12.5, 10, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-2', '27-7', 12.5, 10, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-2', '27-9', 12.5, 10, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-2', 'Ч36', 12.5, 10, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-3', '27-1', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-3', '27-2', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-3', '27-5', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-3', '27-6', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-3', '27-7', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-3', '27-8', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-3', '27-9', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-3', '27-10', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-3', 'Ч36', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-4', '27-1', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-4', '27-2', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-4', '27-3', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-4', '27-5', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-4', '27-6', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-4', '27-7', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-4', '27-8', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-4', '27-9', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-4', '27-10', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-4', 'Ч36', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-5', '27-1', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-5', '27-2', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-5', '27-6', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-5', '27-7', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-5', '27-9', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-5', 'Ч36', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-6', '27-1', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-6', '27-2', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-6', '27-5', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-6', '27-7', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-6', '27-9', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-6', 'Ч36', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-7', '27-1', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-7', '27-2', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-7', '27-5', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-7', '27-6', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-7', '27-9', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-7', 'Ч36', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-8', '27-1', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-8', '27-2', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-8', '27-3', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-8', '27-5', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-8', '27-6', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-8', '27-7', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-8', '27-9', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-8', '27-10', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-8', 'Ч36', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-9', '27-1', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-9', '27-2', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-9', '27-5', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-9', '27-6', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-9', '27-7', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-9', 'Ч36', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-10', '27-1', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-10', '27-2', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-10', '27-3', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-10', '27-5', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-10', '27-6', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-10', '27-7', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-10', '27-8', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-10', '27-9', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('27-10', 'Ч36', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('ТВОРЧ30', 'ТВОРЧ15', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('ТВОРЧ30', 'ТВОРЧ20', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('ТВОРЧ30', 'ТВОРЧ25', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('ТВОРЧ25', 'ТВОРЧ15', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('ТВОРЧ25', 'ТВОРЧ20', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('ТВОРЧ20', 'ТВОРЧ15', 0, 0, 1, '');
INSERT INTO union_lgota (kod1, kod2, usl_m, usl_w, koef, main) VALUES ('РКС', 'МКС', 0, 0, 0.75, '');


--
-- TOC entry 2108 (class 1259 OID 26152)
-- Name: union_lgota_kod1; Type: INDEX; Schema: public; Owner: userpp
--

CREATE INDEX union_lgota_kod1 ON union_lgota USING btree (kod1);


-- Completed on 2017-12-22 13:59:12

--
-- PostgreSQL database dump complete
--
