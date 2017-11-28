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

INSERT INTO dojitye (year, period, period_min, period_lgot) VALUES (2002, 144, 120, 144);
INSERT INTO dojitye (year, period, period_min, period_lgot) VALUES (2003, 150, 120, 150);
INSERT INTO dojitye (year, period, period_min, period_lgot) VALUES (2004, 156, 120, 156);
INSERT INTO dojitye (year, period, period_min, period_lgot) VALUES (2005, 162, 120, 162);
INSERT INTO dojitye (year, period, period_min, period_lgot) VALUES (2006, 168, 120, 168);
INSERT INTO dojitye (year, period, period_min, period_lgot) VALUES (2007, 174, 120, 174);
INSERT INTO dojitye (year, period, period_min, period_lgot) VALUES (2008, 180, 120, 180);
INSERT INTO dojitye (year, period, period_min, period_lgot) VALUES (2009, 186, 126, 186);
INSERT INTO dojitye (year, period, period_min, period_lgot) VALUES (2010, 192, 132, 192);
INSERT INTO dojitye (year, period, period_min, period_lgot) VALUES (2011, 204, 138, 204);
INSERT INTO dojitye (year, period, period_min, period_lgot) VALUES (2012, 216, 144, 216);
INSERT INTO dojitye (year, period, period_min, period_lgot) VALUES (2013, 228, 150, 228);
INSERT INTO dojitye (year, period, period_min, period_lgot) VALUES (2014, 228, 156, 240);
INSERT INTO dojitye (year, period, period_min, period_lgot) VALUES (2015, 228, 162, 252);
INSERT INTO dojitye (year, period, period_min, period_lgot) VALUES (2016, 228, 168, 252);
 