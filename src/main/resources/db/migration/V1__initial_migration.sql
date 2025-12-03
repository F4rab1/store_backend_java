CREATE TABLE users (
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE addresses (
    id      BIGSERIAL PRIMARY KEY,
    street  VARCHAR(255) NOT NULL,
    city    VARCHAR(255) NOT NULL,
    state   VARCHAR(255) NOT NULL,
    zip     VARCHAR(255) NOT NULL,
    user_id BIGINT NOT NULL
);

CREATE TABLE categories (
    id   SMALLSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE products (
    id            BIGSERIAL PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    price         NUMERIC(10, 2) NOT NULL,
    description   TEXT NOT NULL,
    category_id   SMALLINT
);

CREATE TABLE profiles (
    id             BIGINT PRIMARY KEY,
    bio            TEXT,
    phone_number   VARCHAR(15),
    date_of_birth  DATE,
    loyalty_points INTEGER DEFAULT 0
);

CREATE TABLE wishlist (
    product_id BIGINT NOT NULL,
    user_id    BIGINT NOT NULL,
    PRIMARY KEY (product_id, user_id)
);

ALTER TABLE addresses
    ADD CONSTRAINT addresses_users_id_fk
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE NO ACTION;

CREATE INDEX idx_addresses_user_id ON addresses (user_id);

ALTER TABLE products
    ADD CONSTRAINT fk_category
        FOREIGN KEY (category_id)
            REFERENCES categories (id)
            ON DELETE NO ACTION;

CREATE INDEX idx_products_category_id ON products (category_id);

ALTER TABLE wishlist
    ADD CONSTRAINT fk_wishlist_on_product
        FOREIGN KEY (product_id)
            REFERENCES products (id)
            ON DELETE CASCADE;

ALTER TABLE wishlist
    ADD CONSTRAINT fk_wishlist_on_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE NO ACTION;

CREATE INDEX idx_wishlist_user_id ON wishlist (user_id);

ALTER TABLE profiles
    ADD CONSTRAINT profiles_users_fk
        FOREIGN KEY (id)
            REFERENCES users (id)
            ON DELETE NO ACTION;
