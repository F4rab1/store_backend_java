CREATE SEQUENCE addresses_id_seq;

ALTER TABLE addresses
    ALTER COLUMN id SET DEFAULT nextval('addresses_id_seq'),
ALTER COLUMN id SET NOT NULL;