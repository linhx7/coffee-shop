CREATE TABLE customer (
                          customer_id BIGSERIAL PRIMARY KEY,
                          username VARCHAR(100),
                          password VARCHAR(100),
                          email VARCHAR(255),
                          name VARCHAR(500)
);

CREATE TABLE shop (
                      shop_id BIGSERIAL PRIMARY KEY,
                      location VARCHAR(255),
                      contact_details VARCHAR(255),
                      opening_time TIME,
                      closing_time TIME
);
CREATE TABLE queues (
                        queue_id BIGSERIAL PRIMARY KEY,
                        shop_id BIGINT,
                        queue_name VARCHAR(255),
                        max_size INT,
                        CONSTRAINT fk_queue_shop FOREIGN KEY (shop_id) REFERENCES shop(shop_id)
);
CREATE TABLE shop_owner (
                            owner_id BIGSERIAL PRIMARY KEY,
                            shop_id BIGINT NOT NULL,
                            username VARCHAR(100),
                            password VARCHAR(100),
                            email VARCHAR(255),
                            name VARCHAR(500),
                            CONSTRAINT fk_shop_owner_shop FOREIGN KEY (shop_id) REFERENCES shop(shop_id)
);

