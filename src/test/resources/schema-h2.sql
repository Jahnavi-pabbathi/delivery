-- DROP TABLE IF EXISTS orders_delivery;

CREATE TABLE IF NOT EXISTS orders_delivery
(
    id integer PRIMARY KEY,
    customer_id integer NOT NULL,
    store_id integer NOT NULL,
    order_id integer NOT NULL,
    image_id integer NOT NULL,
    payment_status character varying(10),
    delivery_status character varying(10),
    pickup_date timestamp with time zone,
    CONSTRAINT order_delivery_pkey PRIMARY KEY (id),
    CONSTRAINT customer_order_store_unique UNIQUE (customer_id, order_id, store_id)
)


