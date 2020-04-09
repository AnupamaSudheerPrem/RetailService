CREATE TABLE public.product_offers
(
    id serial NOT NULL ,
    product_id integer NOT NULL,
    offer_percentage double precision NOT NULL,
    CONSTRAINT product_offers_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.product_offers
    OWNER to postgres;


    CREATE TABLE public.product_price
    (
        id serial NOT NULL ,
        productid integer NOT NULL,
        price double precision,
        currency_code character varying(20) COLLATE pg_catalog."default"

    )
    WITH (
        OIDS = FALSE
    )
    TABLESPACE pg_default;

    ALTER TABLE public.product_price
        OWNER to postgres;
