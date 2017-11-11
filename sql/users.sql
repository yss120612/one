CREATE SEQUENCE public.users_id
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.users_id
    OWNER TO postgres;

-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
    id bigint NOT NULL DEFAULT nextval('users_id'::regclass),
    username character varying(100) COLLATE pg_catalog."default" NOT NULL DEFAULT ''::character varying,
    password character varying(200) COLLATE pg_catalog."default" NOT NULL DEFAULT ''::character varying,
    expire boolean NOT NULL DEFAULT false,
    enable boolean NOT NULL DEFAULT true,
    credentials boolean NOT NULL DEFAULT true,
    locked boolean NOT NULL DEFAULT false,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.users
    OWNER to postgres;
COMMENT ON TABLE public.users
    IS 'users of app';

COMMENT ON COLUMN public.users.id
    IS 'id';

COMMENT ON COLUMN public.users.password
    IS 'password here';

-- Index: by_name

-- DROP INDEX public.by_name;

CREATE UNIQUE INDEX by_name
    ON public.users USING btree
    (username COLLATE pg_catalog."default")
    TABLESPACE pg_default;