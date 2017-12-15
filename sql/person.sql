-- Table: public.person

-- DROP TABLE public.person;

CREATE TABLE public.person
(
  id bigint NOT NULL, -- Номер запроса справки
  insnmb character varying(14), -- СНИЛС
  fio character varying(100),
  prnsex character(1) NOT NULL, -- Пол
  prnbrd date, -- Дата рождения
  CONSTRAINT pk_id_person PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.person
  OWNER TO userpp;
COMMENT ON TABLE public.person IS 'Анкетные данные';
COMMENT ON COLUMN public.person.id IS 'Номер запроса справки';
COMMENT ON COLUMN public.person.insnmb IS 'СНИЛС';
COMMENT ON COLUMN public.person.prnsex IS 'Пол';
COMMENT ON COLUMN public.person.prnbrd IS 'Дата рождения';

