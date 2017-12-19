-- Table: public.stag

-- DROP TABLE public.stag;

CREATE TABLE public.stag
(
  id bigint NOT NULL, -- Номер запроса справки
  vid smallint NOT NULL, -- Тип источника
  dstart date NOT NULL, -- Дата с
  dend date NOT NULL, -- Дата по
  regn character varying(15), -- Рег.номер страхователя
  predpr_name character varying(100), -- Наименование страхователя
  vid_deyat character varying(40), -- Вид деятельности
  cggext character varying(30), -- Территориальные условия
  cspext character varying(30), -- Выслуга лет
  ctpext character varying(30), -- Исчесляемый стаж
  cwcext character varying(30), -- Особые условия
  dopctpext character varying(60), -- Доп.параметры к исчесляемому стажу
  dopcspext character varying(60) -- Доп. параметры к выслуги лет
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.stag
  OWNER TO userpp;
COMMENT ON TABLE public.stag
  IS 'Стаж';
COMMENT ON COLUMN public.stag.id IS 'Номер запроса справки';
COMMENT ON COLUMN public.stag.vid IS 'Тип источника';
COMMENT ON COLUMN public.stag.dstart IS 'Дата с';
COMMENT ON COLUMN public.stag.dend IS 'Дата по';
COMMENT ON COLUMN public.stag.regn IS 'Рег.номер страхователя';
COMMENT ON COLUMN public.stag.predpr_name IS 'Наименование страхователя';
COMMENT ON COLUMN public.stag.vid_deyat IS 'Вид деятельности';
COMMENT ON COLUMN public.stag.cggext IS 'Территориальные условия';
COMMENT ON COLUMN public.stag.cspext IS 'Выслуга лет';
COMMENT ON COLUMN public.stag.ctpext IS 'Исчесляемый стаж';
COMMENT ON COLUMN public.stag.cwcext IS 'Особые условия';
COMMENT ON COLUMN public.stag.dopctpext IS 'Доп.параметры к исчесляемому стажу';
COMMENT ON COLUMN public.stag.dopcspext IS 'Доп. параметры к выслуги лет';


-- Index: public.stag_id

-- DROP INDEX public.stag_id;

CREATE INDEX stag_id
  ON public.stag
  USING btree
  (id);

