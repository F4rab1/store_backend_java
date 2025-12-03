CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE carts
(
    id           UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    date_created DATE NOT NULL DEFAULT CURRENT_DATE
);

CREATE TABLE cart_items
(
    id         BIGSERIAL PRIMARY KEY,
    cart_id    UUID    NOT NULL,
    product_id BIGINT  NOT NULL,
    quantity   INT     NOT NULL DEFAULT 1,

    CONSTRAINT cart_items_cart_product_unique
        UNIQUE (cart_id, product_id),

    CONSTRAINT cart_items_carts_id_fk
        FOREIGN KEY (cart_id)
            REFERENCES carts (id)
            ON DELETE CASCADE,

    CONSTRAINT cart_items_products_id_fk
        FOREIGN KEY (product_id)
            REFERENCES products (id)
            ON DELETE CASCADE
);

CREATE INDEX idx_cart_items_cart_id ON cart_items(cart_id);
CREATE INDEX idx_cart_items_product_id ON cart_items(product_id);
