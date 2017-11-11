CREATE SEQUENCE public.roles_id
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.roles_id
    OWNER TO postgres;

COMMENT ON SEQUENCE public.roles_id
    IS 'sequense for id roles';

-- Table: public.roles

-- DROP TABLE public.roles;

CREATE TABLE public.roles
(
    id bigint NOT NULL DEFAULT nextval('roles_id'::regclass),
    rolename character varying(100) COLLATE pg_catalog."default" NOT NULL DEFAULT ''::character varying,
    CONSTRAINT roles_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.roles
    OWNER to postgres;
COMMENT ON TABLE public.roles
    IS 'roles for users';

COMMENT ON COLUMN public.roles.id
    IS 'id for roles';