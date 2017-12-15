-- Table: public.stag

-- DROP TABLE public.stag;

CREATE TABLE public.stag
(
  id bigint NOT NULL, -- Номер запроса справки
  vid smallint NOT NULL, -- Код района
  dstart date NOT NULL, -- Входящий номер ПТК СПУ
  dend date NOT NULL, -- Год
  regn character varying(10), -- Период
  predpr_name character varying(100), -- Сумма
  vid_deyat character varying(40), -- Код ЗЛ
  cggext character varying(30), -- Номер страхователя
  cspext character varying(30), -- Номер страхователя
  ctpext character varying(30), -- Номер страхователя
  cwcext character varying(30), -- Номер страхователя
  dopctpext character varying(60), -- Номер страхователя
  dopcspext character varying(60) -- Номер страхователя
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.stag
  OWNER TO userpp;
COMMENT ON TABLE public.stag
  IS 'Стаж';
COMMENT ON COLUMN public.stag.id IS 'Номер запроса справки';
COMMENT ON COLUMN public.stag.vid IS 'Код района';
COMMENT ON COLUMN public.stag.dstart IS 'Входящий номер ПТК СПУ';
COMMENT ON COLUMN public.stag.dend IS 'Год';
COMMENT ON COLUMN public.stag.regn IS 'Период';
COMMENT ON COLUMN public.stag.predpr_name IS 'Сумма';
COMMENT ON COLUMN public.stag.vid_deyat IS 'Код ЗЛ';
COMMENT ON COLUMN public.stag.cggext IS 'Номер страхователя';
COMMENT ON COLUMN public.stag.cspext IS 'Номер страхователя';
COMMENT ON COLUMN public.stag.ctpext IS 'Номер страхователя';
COMMENT ON COLUMN public.stag.cwcext IS 'Номер страхователя';
COMMENT ON COLUMN public.stag.dopctpext IS 'Номер страхователя';
COMMENT ON COLUMN public.stag.dopcspext IS 'Номер страхователя';


-- Index: public.stag_id

-- DROP INDEX public.stag_id;

CREATE INDEX stag_id
  ON public.stag
  USING btree
  (id);

