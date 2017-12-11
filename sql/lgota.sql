--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.0

-- Started on 2017-12-08 17:53:26

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
-- TOC entry 217 (class 1259 OID 17753)
-- Name: lgota; Type: TABLE; Schema: public; Owner: userpp
--

CREATE TABLE lgota (
    lgota character varying NOT NULL,
    field character varying(20),
    half real,
    man_os real,
    man_ss real,
    man_pens real,
    women_os real,
    women_ss real,
    women_pens real,
    man_d real,
    women_d real,
    man_ds real,
    women_ds real,
    lepro real,
    sever real
);


ALTER TABLE lgota OWNER TO userpp;

--
-- TOC entry 2221 (class 0 OID 0)
-- Dependencies: 217
-- Name: TABLE lgota; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON TABLE lgota IS 'Таблица льгот и параметров их обработки';


--
-- TOC entry 2222 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN lgota.lgota; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN lgota.lgota IS 'Наименование льготы';


--
-- TOC entry 2223 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN lgota.field; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN lgota.field IS 'имя поля в базе АС400';


--
-- TOC entry 2224 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN lgota.half; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN lgota.half IS 'можно ли выбрать часть льготного стажа (это делитель)';


--
-- TOC entry 2225 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN lgota.man_os; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN lgota.man_os IS 'Мужчины. Общий стаж.';


--
-- TOC entry 2226 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN lgota.man_ss; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN lgota.man_ss IS 'Мужчины. Спец. стаж.';


--
-- TOC entry 2227 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN lgota.man_pens; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN lgota.man_pens IS 'Мужчины выход на пенсию, если весь спецстаж';


--
-- TOC entry 2228 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN lgota.women_os; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN lgota.women_os IS 'Женщины. Общий стаж.';


--
-- TOC entry 2229 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN lgota.women_ss; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN lgota.women_ss IS 'Женщины. Спец. стаж.';


--
-- TOC entry 2230 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN lgota.women_pens; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN lgota.women_pens IS 'Женщины выход на пенсию, если весь спецстаж';


--
-- TOC entry 2231 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN lgota.lepro; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN lgota.lepro IS 'Как влияет эта категория на другие';


--
-- TOC entry 2232 (class 0 OID 0)
-- Dependencies: 217
-- Name: COLUMN lgota.sever; Type: COMMENT; Schema: public; Owner: userpp
--

COMMENT ON COLUMN lgota.sever IS 'как влияет эта категория на другие';


--
-- TOC entry 2216 (class 0 OID 17753)
-- Dependencies: 217
-- Data for Name: lgota; Type: TABLE DATA; Schema: public; Owner: userpp
--

INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-1', 'cwcext', 2, 20, 10, 50, 15, 7.5, 45, 1, 1, 1, 1, 2, 1.5);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-10', 'cwcext', 0, 25, 20, 55, 20, 15, 50, 0, 0, 0, 0, 2, 1.5);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-11ВП', 'cspext', 0, 0, 20, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-11ГР', 'cspext', 0, 0, 25, 0, 0, 25, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-12', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-14', 'cspext', 0, 25, 12.5, 55, 20, 10, 50, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-15', 'cspext', 0, 25, 20, 55, 20, 15, 50, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-2', 'cwcext', 2, 25, 12.5, 55, 20, 10, 50, 2.5, 2, 1, 1, 2, 1.5);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-3', 'cwcext', 0, 0, 0, 0, 20, 15, 50, 0, 0, 0, 0, 2, 1.5);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-4', 'cwcext', 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 2, 1.5);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-5', 'cwcext', 0, 25, 12.5, 55, 20, 10, 50, 0, 0, 0, 0, 2, 1.5);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-6', 'cwcext', 0, 25, 12.5, 55, 20, 10, 50, 0, 0, 0, 0, 2, 1.5);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-7', 'cwcext', 0, 25, 12.5, 55, 20, 10, 50, 0, 0, 0, 0, 2, 1.5);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-8', 'cwcext', 0, 25, 20, 55, 20, 15, 50, 0, 0, 0, 0, 2, 1.5);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-9', 'cwcext', 0, 25, 12.5, 55, 20, 10, 50, 0, 0, 0, 0, 2, 1.5);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-ГД', 'cspext', 0, 0, 30, 0, 0, 30, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-ГДХР', 'cspext', 0, 0, 30, 0, 0, 30, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-ОС', 'cwcext', 0, 25, 15, 55, 20, 10, 50, 0, 0, 0, 0, 2, 1.5);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-ПД', 'cspext', 0, 0, 25, 0, 0, 25, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-ПДРК', 'cspext', 0, 0, 25, 0, 0, 25, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-ПЖ', 'cwcext', 0, 0, 25, 50, 0, 25, 50, 0, 0, 0, 0, 2, 1.5);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-СМ', 'cspext', 0, 0, 25, 0, 0, 25, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-СМХР', 'cspext', 0, 0, 25, 0, 0, 25, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('27-СП', 'cspext', 0, 0, 15, 40, 0, 15, 40, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('28-СЕВ', 'cwcext', 0, 0, 25, 50, 0, 20, 45, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('ВЫСШПИЛ', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('ЗП12Л', 'cwcext', 0, 0, 15, 40, 0, 15, 40, 0, 0, 0, 0, 2, 1.5);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('ИНСПЕКТ', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('ИСПКЛС1', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('ИТСИСП', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('ИТСМАВ', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('ЛЕТИСП', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('ЛЕТРАБ', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('МКС', 'cggext', 2, 25, 20, 55, 20, 20, 50, 16, 16, 4, 4, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('НОРМАПР', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('НОРМСП', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('ОПЫТИСП', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('РЕАКТИВН', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('РКС', 'cggext', 2, 25, 15, 55, 20, 15, 50, 12, 12, 4, 4, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('САМОЛЕТ', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('СПАСАВ', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('СПЕЦАВ', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('ТВОРЧ15', 'cspext', 0, 0, 15, 0, 0, 15, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('ТВОРЧ20', 'cspext', 0, 0, 20, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('ТВОРЧ25', 'cspext', 0, 0, 25, 0, 0, 25, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('ТВОРЧ30', 'cspext', 0, 0, 30, 0, 0, 30, 0, 0, 0, 0, 0, 1, 1);
INSERT INTO lgota (lgota, field, half, man_os, man_ss, man_pens, women_os, women_ss, women_pens, man_d, women_d, man_ds, women_ds, lepro, sever) VALUES ('УЧЛЕТ', 'cspext', 0, 0, 25, 0, 0, 20, 0, 0, 0, 0, 0, 1, 1);


--
-- TOC entry 2094 (class 2606 OID 17760)
-- Name: lgota lgota_pkey; Type: CONSTRAINT; Schema: public; Owner: userpp
--

ALTER TABLE ONLY lgota
    ADD CONSTRAINT lgota_pkey PRIMARY KEY (lgota);


-- Completed on 2017-12-08 17:53:28

--
-- PostgreSQL database dump complete
--
