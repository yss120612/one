-- Table: public.spravka

-- DROP TABLE public.spravka;

CREATE TABLE public.spravka
(
    id bigint NOT NULL DEFAULT nextval('spravka_id_seq'::regclass),
    vc_client character varying(12) COLLATE pg_catalog."default" NOT NULL,
    vc_ins character varying(14) COLLATE pg_catalog."default" NOT NULL,
    ts_q timestamp without time zone NOT NULL,
    ts_a timestamp without time zone,
    szi_new bytea,
    raschet bytea,
    pravo date,
    pens numeric(15,2),
    CONSTRAINT pk_id_spravka PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.spravka
    OWNER to userpp;
COMMENT ON TABLE public.spravka
    IS 'Таблица для справок';

COMMENT ON COLUMN public.spravka.id
    IS 'Счетчик';

COMMENT ON COLUMN public.spravka.vc_client
    IS 'Рег.номер';

COMMENT ON COLUMN public.spravka.vc_ins
    IS 'СНИЛС';

COMMENT ON COLUMN public.spravka.ts_q
    IS 'Дата и время запроса';

COMMENT ON COLUMN public.spravka.ts_a
    IS 'Дата и время ответа';

COMMENT ON COLUMN public.spravka.szi_new
    IS 'Новая СЗИ-6';

COMMENT ON COLUMN public.spravka.raschet
    IS 'Описание расчета';

COMMENT ON COLUMN public.spravka.pravo
    IS 'Дата права';

COMMENT ON COLUMN public.spravka.pens
    IS 'Размер пенсии';