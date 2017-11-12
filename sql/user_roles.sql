-- Table: public.users_roles

-- DROP TABLE public.users_roles;

CREATE TABLE public.users_roles
(
    id_user bigint NOT NULL,
    id_role bigint NOT NULL,
    CONSTRAINT users_roles_pkey PRIMARY KEY (id_user, id_role)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.users_roles
    OWNER to postgres;