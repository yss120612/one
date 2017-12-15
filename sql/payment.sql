-- Table: public.payment

-- DROP TABLE public.payment;

CREATE TABLE public.payment
(
  id bigint NOT NULL, -- Номер запроса справки
  datestart date NOT NULL, -- Дата с
  dateend date NOT NULL, -- Дата по
  raion integer, -- Район
  region integer, -- Регион
  summa real -- Сумма
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.payment
  OWNER TO userpp;
COMMENT ON TABLE public.payment
  IS 'Платежи';
COMMENT ON COLUMN public.payment.id IS 'Номер запроса справки';
COMMENT ON COLUMN public.payment.datestart IS 'Дата с ';
COMMENT ON COLUMN public.payment.dateend IS 'Дата по';
COMMENT ON COLUMN public.payment.raion IS 'Район';
COMMENT ON COLUMN public.payment.region IS 'Регион';
COMMENT ON COLUMN public.payment.summa IS 'Сумма';


-- Index: public.payment_id

-- DROP INDEX public.payment_id;

CREATE INDEX payment_id
  ON public.payment
  USING btree
  (id);

