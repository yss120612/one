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
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2002-02-01', 479.25, 639, 1.06500006, 1.06500006, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2002-04-01', 479.25, 639, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2002-08-01', 522.380005, 696.51001, 1.09000003, 1.09000003, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2002-09-01', 522.380005, 696.51001, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2002-10-01', 522.380005, 696.51001, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2003-02-01', 553.719971, 738.299988, 1.05999994, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2003-04-01', 553.719971, 738.299988, 1, 1.12600005, 1, 1.30700004, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2003-08-01', 598.02002, 797.359985, 1.08000004, 1.08000004, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2003-09-01', 598.02002, 797.359985, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2004-01-01', 598.02002, 797.359985, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2004-04-01', 621, 828, 1.03842676, 1.09000003, 1, 1.17700005, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2004-07-01', 621, 828, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2004-08-01', 660, 880, 1.06280196, 1.06280005, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2005-03-01', 900, 1200, 1.36363637, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2005-04-01', 900, 1200, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2005-08-01', 954, 1272, 1.05999994, 1.05999994, 1.04799998, 1.11399996, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2005-10-01', 954, 1272, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2006-01-01', 954, 1272, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2006-04-01', 1035.08997, 1380.12, 1.08500004, 1.06299996, 1, 1.12699997, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2006-08-01', 1035.08997, 1380.12, 1, 1.06200004, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2006-12-01', 1035.08997, 1380.12, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2007-01-01', 1035.08997, 1380.12, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2007-04-01', 1112.71997, 1483.63, 1.07500005, 1.09200001, 1, 1.15999997, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2007-10-01', 1260, 1680, 1.13236034, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2007-12-01', 1560, 2080, 1.23809528, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2008-01-01', 2340, 3120, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2008-02-01', 2340, 3120, 1, 1.12, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2008-04-01', 2340, 3120, 1, 1.07500005, 1, 1.204, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2008-07-01', 2340, 3120, 1, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2008-08-01', 2691, 3588, 1.14999998, 1.08000004, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2009-03-01', 2925, 3900, 1.0869565, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2009-04-01', 2925, 3900, 1, 1.17499995, 1, 1.26900005, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2009-08-01', 2925, 3900, 1, 1.07500005, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2009-12-01', 3843, 5124, 1.31384611, 1, 1, 1, 0);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2010-01-01', 3843, 5124, 1, 1, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2010-04-01', 4085.11011, 5446.81006, 1.06299996, 1.06299996, 1, 1.14269996, 1.08800006);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2010-07-01', 4085.11011, 5446.81006, 1, 1, 1, 1, 1.03410006);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2011-02-01', 4444.6001, 5926.12988, 1.08800006, 1.08800006, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2011-04-01', 4444.6001, 5926.12988, 1, 1, 1, 1.08800006, 1.1027);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2012-02-01', 4755.72021, 6340.95996, 1.07000005, 1.07000005, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2012-04-01', 4917.89014, 6557.18994, 1.03410006, 1.03410006, 1, 1.10650003, 1.14100003);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2013-01-01', 4917.89014, 6557.18994, 1, 1, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2013-02-01', 5242.47021, 6989.95996, 1.06599998, 1.06599998, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2013-04-01', 5415.47021, 7220.62988, 1.03299999, 1.03299999, 1, 1.10099995, 1.01810002);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2014-02-01', 5767.47998, 7689.97021, 1.06500006, 1.06500006, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2014-04-01', 5865.52979, 7820.7002, 1.01699996, 1.01699996, 1, 1.08299994, 1.171);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2015-01-01', 5902.5, 7870, 1.00630629, 1, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2015-02-01', 6575.39014, 8767.19043, 1.11399996, 1, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2015-04-01', 6575.39014, 8767.19043, 1, 1, 1, 1, 1.10300004);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2016-02-01', 6838.3999, 9117.86035, 1.03999996, 1, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2016-04-01', 6838.3999, 9117.86035, 1, 1, 1, 1, 1.03999996);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2017-02-01', 7207.66992, 9610.21973, 1.05400002, 1, 1, 1, 1);
INSERT INTO ur (datev, rtv1, rtv2, k_baz, k_strah, k_strd, k_str, k_soc) VALUES ('2017-04-01', 7207.66992, 9610.21973, 1, 1, 1, 1, 1.01499999);     