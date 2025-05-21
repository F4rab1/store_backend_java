CREATE OR REPLACE FUNCTION public.find_products_by_price(
    min_price NUMERIC(10,2),
    max_price NUMERIC(10,2)
)
RETURNS TABLE (
    id           INTEGER,
    name         TEXT,
    description  TEXT,
    price        NUMERIC(10,2),
    category_id  INTEGER
)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
        SELECT id, name, description, price, category_id
        FROM products
        WHERE price BETWEEN min_price AND max_price
        ORDER BY name;
END;
$$;
