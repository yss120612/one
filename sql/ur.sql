-- Table: public.ur

-- DROP TABLE public.ur;

CREATE TABLE public.ur
(
    datev date NOT NULL,
    rtv1 real NOT NULL,
    rtv2 real NOT NULL,
    k_baz real NOT NULL,
    k_strah real NOT NULL,
    k_strd real NOT NULL,
    k_str real NOT NULL,
    k_soc real NOT NULL,
    CONSTRAINT ur_pkey PRIMARY KEY (datev)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.ur
    OWNER to userpp;
COMMENT ON TABLE public.ur
    IS 'Условия расчета';

INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2002-01-01', 450, 600, 1, 1, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2002-02-01', 479.25, 639, 1.065, 1.065, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2002-04-01', 479.25, 639, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2002-08-01', 522.380005, 696.51, 1.09, 1.09, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2002-09-01', 522.380005, 696.51, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2002-10-01', 522.380005, 696.51, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2003-02-01', 553.719971, 738.3, 1.06, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2003-04-01', 553.719971, 738.3, 1, 1.126, 1, 1.307, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2003-08-01', 598.02002, 797.36, 1.08, 1.08, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2003-09-01', 598.02002, 797.36, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2004-01-01', 598.02002, 797.36, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2004-04-01', 621, 828, 1.03842676, 1.09, 1, 1.177, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2004-07-01', 621, 828, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2004-08-01', 660, 880, 1.06280196, 1.0628, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2005-03-01', 900, 1200, 1.36363637, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2005-04-01', 900, 1200, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2005-08-01', 954, 1272, 1.06, 1.06, 1.048, 1.114, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2005-10-01', 954, 1272, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2006-01-01', 954, 1272, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2006-04-01', 1035.09, 1380.12, 1.085, 1.063, 1, 1.127, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2006-08-01', 1035.09, 1380.12, 1, 1.062, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2006-12-01', 1035.09, 1380.12, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2007-01-01', 1035.09, 1380.12, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2007-04-01', 1112.72, 1483.63, 1.075, 1.092, 1, 1.16, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2007-10-01', 1260, 1680, 1.13236034, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2007-12-01', 1560, 2080, 1.23809528, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2008-01-01', 2340, 3120, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2008-02-01', 2340, 3120, 1, 1.12, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2008-04-01', 2340, 3120, 1, 1.075, 1, 1.204, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2008-07-01', 2340, 3120, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2008-08-01', 2691, 3588, 1.15, 1.08, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2009-03-01', 2925, 3900, 1.0869565, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2009-04-01', 2925, 3900, 1, 1.175, 1, 1.269, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2009-08-01', 2925, 3900, 1, 1.075, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2009-12-01', 3843, 5124, 1.31384611, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2010-01-01', 3843, 5124, 1, 1, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2010-04-01', 4085.11011, 5446.81006, 1.063, 1.063, 1, 1.1427, 1.088);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2010-07-01', 4085.11011, 5446.81006, 1, 1, 1, 1, 1.0341);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2011-02-01', 4444.6001, 5926.12988, 1.088, 1.088, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2011-04-01', 4444.6001, 5926.12988, 1, 1, 1, 1.088, 1.1027);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2012-02-01', 4755.72021, 6340.95996, 1.07, 1.07, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2012-04-01', 4917.89014, 6557.18994, 1.0341, 1.0341, 1, 1.1065, 1.141);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2013-01-01', 4917.89014, 6557.18994, 1, 1, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2013-02-01', 5242.47021, 6989.95996, 1.066, 1.066, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2013-04-01', 5415.47021, 7220.62988, 1.033, 1.033, 1, 1.101, 1.0181);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2014-02-01', 5767.47998, 7689.97021, 1.065, 1.065, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2014-04-01', 5865.52979, 7820.7002, 1.017, 1.017, 1, 1.083, 1.171);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2015-01-01', 5902.5, 7870, 1.00630629, 1, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2015-02-01', 6575.39014, 8767.19043, 1.114, 1, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2015-04-01', 6575.39014, 8767.19043, 1, 1, 1, 1, 1.103);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2016-02-01', 6838.3999, 9117.86035, 1.04, 1, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2016-04-01', 6838.3999, 9117.86035, 1, 1, 1, 1, 1.04);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2017-02-01', 7207.66992, 9610.21973, 1.054, 1, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2017-04-01', 7207.66992, 9610.21973, 1, 1, 1, 1, 1.015);     