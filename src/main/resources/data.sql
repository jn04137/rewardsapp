INSERT INTO customer (id, customer_name) VALUES
    (1, 'Jonathan Nguyen'),
    (2, 'Keanu Reeves'),
    (3, 'Shia Lebeouf');

-- A person can have multiple transactions
-- Transactions will contain a collection of products that were bought
INSERT INTO TRANSACTION (id, TRANSACTION_DATE, CUSTOMER_ID) VALUES
    (1, '2026-02-16', 1),
    (2, '2026-01-19', 1),
    (7, '2026-01-25', 1),
    (3, '2025-12-01', 1),
    (4, '2025-11-01', 1),
    (5, '2026-02-01', 2),
    (6, '2026-02-10', 3);

INSERT INTO PRODUCT (id, PRODUCT_NAME, PRODUCT_PRICE) VALUES
    (1, 'RTX 3080', 699.99),
    (2, 'RTX 3070', 399.99),
    (3, 'RTX 3060', 269.99),
    (4, 'Intel Core i9 14900K', 499.99),
    (5, 'Intel Core i7 13900K', 359.99),
    (6, 'Intel Core i5 12900K', 259.99),
    (7, 'Crucial DDR5 64GB RAM', 259.99),
    (8, 'Crucial DDR5 32GB RAM', 159.99),
    (9, 'Crucial DDR5 16GB RAM', 129.99),
    (10, 'Corsair 500D', 59.99),
    (11, 'NZXT 510', 159.99),
    (12, 'Noctua Fan', 14.99);

-- Corporate bulk Purchase of graphics card
INSERT INTO PRODUCT_TRANSACTION (PRODUCTS_ID,TRANSACTION_ID)  VALUES
    (1, 1),
    (1, 1),
    (1, 1);

--- Buying parts for cousin getting into PCs
INSERT INTO PRODUCT_TRANSACTION (PRODUCTS_ID,TRANSACTION_ID)  VALUES
    (10, 2),
    (3, 2),
    (6, 2),
    (9, 2);


--- Buying parts for Brother getting into PCs
INSERT INTO PRODUCT_TRANSACTION (PRODUCTS_ID,TRANSACTION_ID)  VALUES
    (11, 3),
    (2, 3),
    (5, 3),
    (8, 3);

--- Buying parts for myself
INSERT INTO PRODUCT_TRANSACTION (PRODUCTS_ID,TRANSACTION_ID)  VALUES
    (1, 4),
    (4, 4),
    (7, 4);

--- Buying parts for myself
INSERT INTO PRODUCT_TRANSACTION (PRODUCTS_ID,TRANSACTION_ID)  VALUES
    (1, 4),
    (4, 4),
    (7, 4);

-- Keanu starting his PC Build with a case (Within $50-$100 mark)
-- There should be about 9 points worth of rewards for Keanu
INSERT INTO PRODUCT_TRANSACTION (PRODUCTS_ID,TRANSACTION_ID)  VALUES
    (10, 5);

-- Shia Lebeouf buying two case fans (under $50 mark)
-- There should be no rewards for Shia
INSERT INTO PRODUCT_TRANSACTION (PRODUCTS_ID,TRANSACTION_ID)  VALUES
    (12, 6),
    (12, 6);

-- purchased a new case and fans for myself
INSERT INTO PRODUCT_TRANSACTION (PRODUCTS_ID,TRANSACTION_ID)  VALUES
    (11, 7),
    (12,7),
    (12,7),
    (12,7),
    (12,7);
