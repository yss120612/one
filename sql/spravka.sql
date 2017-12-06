 CREATE SEQUENCE spravka_id_seq
     INCREMENT BY 1
     NO MAXVALUE
     NO MINVALUE
     CACHE 1;
     
-- Table: public.spravka

-- DROP TABLE public.spravka;

CREATE TABLE public.spravka
(
  id bigint NOT NULL DEFAULT nextval('spravka_id_seq'::regclass), -- Счетчик
  vc_client character varying(12) NOT NULL, -- Рег.номер
  vc_ins character varying(14) NOT NULL, -- СНИЛС
  ts_q timestamp without time zone NOT NULL, -- Дата и время запроса
  ts_a timestamp without time zone, -- Дата и время ответа
  szi_new bytea, -- Новая СЗИ-6
  raschet bytea, -- Описание расчета
  pravo date, -- Дата права
  pens numeric(15,2), -- Размер пенсии
  vc_ip character varying(15), -- IP клиента
  CONSTRAINT pk_id_spravka PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.spravka
  OWNER TO userpp;
COMMENT ON TABLE public.spravka
  IS 'Таблица для справок';
COMMENT ON COLUMN public.spravka.id IS 'Счетчик';
COMMENT ON COLUMN public.spravka.vc_client IS 'Рег.номер';
COMMENT ON COLUMN public.spravka.vc_ins IS 'СНИЛС';
COMMENT ON COLUMN public.spravka.ts_q IS 'Дата и время запроса';
COMMENT ON COLUMN public.spravka.ts_a IS 'Дата и время ответа';
COMMENT ON COLUMN public.spravka.szi_new IS 'Новая СЗИ-6';
COMMENT ON COLUMN public.spravka.raschet IS 'Описание расчета';
COMMENT ON COLUMN public.spravka.pravo IS 'Дата права';
COMMENT ON COLUMN public.spravka.pens IS 'Размер пенсии';
COMMENT ON COLUMN public.spravka.vc_ip IS 'IP клиента';

