
CREATE TABLE item (
                      item_id BIGSERIAL PRIMARY KEY,
                      shop_id BIGINT,
                      name VARCHAR(255),
                      description TEXT,
                      CONSTRAINT fk_item_shop FOREIGN KEY (shop_id) REFERENCES shop(shop_id)
);

CREATE TABLE menu (
                      menu_id BIGSERIAL PRIMARY KEY,
                      shop_id BIGINT,
                      item_id BIGINT,
                      price DECIMAL(10,2),
                      CONSTRAINT fk_menu_shop FOREIGN KEY (shop_id) REFERENCES shop(shop_id),
                      CONSTRAINT fk_menu_item FOREIGN KEY (item_id) REFERENCES item(item_id)
);


CREATE TABLE orders (
                        order_id BIGSERIAL PRIMARY KEY,
                        customer_id BIGINT,
                        shop_id BIGINT,
                        queue_id BIGINT,
                        status VARCHAR(50),
                        CONSTRAINT fk_orders_customer FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
                        CONSTRAINT fk_orders_shop FOREIGN KEY (shop_id) REFERENCES shop(shop_id),
                        CONSTRAINT fk_orders_queue FOREIGN KEY (queue_id) REFERENCES queues(queue_id)
);

CREATE TABLE order_item (
                            order_item_id BIGSERIAL PRIMARY KEY,
                            order_id BIGINT,
                            item_id BIGINT,
                            quantity INT,
                            CONSTRAINT fk_order_item_order FOREIGN KEY (order_id) REFERENCES orders(order_id),
                            CONSTRAINT fk_order_item_item FOREIGN KEY (item_id) REFERENCES item(item_id)
);
