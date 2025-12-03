CREATE TABLE orders
(
    id           BIGSERIAL PRIMARY KEY,
    customer_id  BIGINT NOT NULL,
    status       VARCHAR(20) NOT NULL,
    created_at   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total_price  NUMERIC(10, 2) NOT NULL,

    CONSTRAINT orders_users_id_fk
        FOREIGN KEY (customer_id)
            REFERENCES users (id)
            ON DELETE NO ACTION
);

CREATE INDEX idx_orders_customer_id ON orders(customer_id);

CREATE TABLE order_items
(
    id           BIGSERIAL PRIMARY KEY,
    order_id     BIGINT NOT NULL,
    product_id   BIGINT NOT NULL,
    unit_price   NUMERIC(10, 2) NOT NULL,
    quantity     INT NOT NULL,
    total_price  NUMERIC(10, 2) NOT NULL,

    CONSTRAINT order_items_orders_id_fk
        FOREIGN KEY (order_id)
            REFERENCES orders (id)
            ON DELETE CASCADE,

    CONSTRAINT order_items_products_id_fk
        FOREIGN KEY (product_id)
            REFERENCES products (id)
            ON DELETE NO ACTION
);

CREATE INDEX idx_order_items_order_id ON order_items(order_id);
CREATE INDEX idx_order_items_product_id ON order_items(product_id);
