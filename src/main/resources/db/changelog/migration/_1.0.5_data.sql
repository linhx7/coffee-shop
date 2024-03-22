ALTER TABLE order_item
ADD COLUMN menu_id DECIMAL(10,2);

ALTER TABLE order_item
DROP  COLUMN item_id;

