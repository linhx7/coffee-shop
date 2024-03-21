-- Sample data for customer table
INSERT INTO customer (username, password, email, name)
VALUES
('john_doe', 'password123', 'john@example.com', 'John Doe'),
('alice_smith', 'abc123', 'alice@example.com', 'Alice Smith'),
('bob_jackson', 'pass123', 'bob@example.com', 'Bob Jackson');

-- Sample data for shop table
INSERT INTO shop (location, contact_details, opening_time, closing_time)
VALUES
('123 Main St, City A', '123-456-7890', '08:00:00', '18:00:00'),
('456 Elm St, City B', '987-654-3210', '09:00:00', '17:00:00'),
('789 Oak St, City C', '555-555-5555', '07:30:00', '19:00:00');

-- Sample data for shop_owner table
INSERT INTO shop_owner (shop_id, username, password, email, name)
VALUES
(1, 'owner1', 'ownerpass1', 'owner1@example.com', 'Owner 1'),
(2, 'owner2', 'ownerpass2', 'owner2@example.com', 'Owner 2'),
(3, 'owner3', 'ownerpass3', 'owner3@example.com', 'Owner 3');
INSERT INTO queues (shop_id, queue_name, max_size)
VALUES
(1, 'Morning Rush', 10),
(2, 'Afternoon Queue', 8),
(3, 'Evening Line', 5);

-- Sample data for item table
INSERT INTO item (shop_id, name, description)
VALUES
(1, 'Espresso', 'Strong coffee brewed by forcing hot water under pressure through finely ground coffee beans.'),
(2, 'Latte', 'Coffee made with espresso and steamed milk.'),
(3, 'Cappuccino', 'Coffee with equal parts steamed milk and milk froth.');

-- Sample data for menu table
INSERT INTO menu (shop_id, item_id, price)
VALUES
(1, 1, 2.50),
(2, 2, 3.00),
(3, 3, 2.75);

-- Sample data for orders table
INSERT INTO orders (customer_id, shop_id, queue_id, status)
VALUES
(1, 1, 1, 'pending'),
(2, 2, 2, 'completed'),
(3, 3, 3, 'pending');

-- Sample data for order_item table
INSERT INTO order_item (order_id, item_id, quantity)
VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 3);

-- Sample data for queue table
