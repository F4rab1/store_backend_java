DROP FUNCTION IF EXISTS public.find_products_by_price(numeric, numeric);

CREATE OR REPLACE PROCEDURE public.find_products_by_price(
  IN min_price numeric(10,2),
  IN max_price numeric(10,2)
)
LANGUAGE sql
AS $$
SELECT id,
       name,
       description,
       price,
       category_id
FROM products
WHERE price BETWEEN min_price AND max_price
ORDER BY name;
$$;
