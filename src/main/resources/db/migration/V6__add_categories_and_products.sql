CREATE TABLE categories (
    id   SMALLSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE products (
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(255)     NOT NULL,
    price       DECIMAL(10,2)    NOT NULL,
    category_id SMALLINT,
    CONSTRAINT fk_category
        FOREIGN KEY (category_id)
        REFERENCES categories (id)
        ON DELETE RESTRICT
);
