-- Table: public.vznos

-- DROP TABLE public.vznos;

CREATE TABLE public.vznos
(
  id bigint NOT NULL, -- Номер запроса справки
  dptcod integer NOT NULL, -- Код района
  dcinmb bigint NOT NULL, -- Входящий номер ПТК СПУ
  year integer, -- Год
  ctmcod character varying(10), -- Период
  asr real, -- Сумма
  cprcod integer, -- Код ЗЛ
  regnum character varying(14) -- Номер страхователя
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.vznos
  OWNER TO userpp;
COMMENT ON TABLE public.vznos
  IS 'Взносы';
COMMENT ON COLUMN public.vznos.id IS 'Номер запроса справки';
COMMENT ON COLUMN public.vznos.dptcod IS 'Код района';
COMMENT ON COLUMN public.vznos.dcinmb IS 'Входящий номер ПТК СПУ';
COMMENT ON COLUMN public.vznos.year IS 'Год';
COMMENT ON COLUMN public.vznos.ctmcod IS 'Период';
COMMENT ON COLUMN public.vznos.asr IS 'Сумма';
COMMENT ON COLUMN public.vznos.cprcod IS 'Код ЗЛ';
COMMENT ON COLUMN public.vznos.regnum IS 'Номер страхователя';


-- Index: public.vznos_id

-- DROP INDEX public.vznos_id;

CREATE INDEX vznos_id
  ON public.vznos
  USING btree
  (id);

