CREATE TABLE address
(
    address_id    SERIAL PRIMARY KEY,
    house_unit_no VARCHAR(50),
    address_line1 VARCHAR(255),
    address_line2 VARCHAR(255),
    city          VARCHAR(100),
    region        VARCHAR(100),
    postal_code   VARCHAR(20),
    country       VARCHAR(100)
);


-- User Account Table
CREATE TABLE user_account
(
    username      VARCHAR(50) PRIMARY KEY,
    first_name    VARCHAR(50),
    last_name     VARCHAR(50),
    email_address VARCHAR(100)
);
-- create index for email_address
    CREATE INDEX idx_user_account_email_address ON user_account(email_address);

-- User Address Mapping Table
CREATE TABLE user_address
(
    address_id INT REFERENCES address (address_id),
    username   VARCHAR(50) REFERENCES user_account (username),
    PRIMARY KEY (address_id, username)
);
-- create index for address_id and username
    CREATE INDEX inx_user_address_address_id ON user_address(address_id);
    CREATE INDEX inx_user_address_username ON user_address(username);

-- Product Category Table
CREATE TABLE product_category
(
    category_id   SERIAL PRIMARY KEY,
    category_name VARCHAR(100)
);
-- create index for category_name
    CREATE INDEX idx_product_category_category_name ON product_category(category_name);

-- Brand Table
CREATE TABLE brand
(
    brand_id   SERIAL PRIMARY KEY,
    brand_name VARCHAR(100)
);
-- create index for brand_name
    CREATE INDEX idx_brand_brand_name ON brand(brand_name);

-- Colour Table
CREATE TABLE colour
(
    colour_id   SERIAL PRIMARY KEY,
    colour_name VARCHAR(50)
);
-- create index for color_name
CREATE INDEX idx_colour_colour_name ON colour(colour_name);

-- Size Table
CREATE TABLE size
(
    size_id   SERIAL PRIMARY KEY,
    size_name VARCHAR(50)
);
CREATE INDEX idx_size_size_name ON size(size_name);

-- Supplier Table
CREATE TABLE supplier
(
    supplier_id   SERIAL PRIMARY KEY,
    supplier_name VARCHAR(100)
);
CREATE INDEX idx_supplier_supplier_name ON supplier(supplier_name);

-- Product Table
CREATE TABLE product
(
    product_id          SERIAL PRIMARY KEY,
    product_name        VARCHAR(100),
    product_category_id INT REFERENCES product_category (category_id),
    brand_id            INT REFERENCES brand (brand_id),
    colour_id           INT REFERENCES colour (colour_id),
    size_id             INT REFERENCES size (size_id),
    supplier_id         INT REFERENCES supplier (supplier_id)
);
CREATE INDEX idx_product_product_name ON product(product_name);
CREATE INDEX idx_product_product_category_id ON product (product_category_id);
CREATE INDEX idx_brand_id ON product(brand_id);
CREATE INDEX idx_colour_id ON product(colour_id);
CREATE INDEX idx_size_id ON product(size_id);
CREATE INDEX idx_supplier_id ON product(supplier_id);


-- Customer Order Table
CREATE TABLE customer_order
(
    order_id         SERIAL PRIMARY KEY,
    order_discount   DECIMAL(10, 2),
    shipping_address INT REFERENCES address (address_id),
    billing_address  INT REFERENCES address (address_id),
    username         VARCHAR(50) REFERENCES user_account (username),
    order_date       DATE
);
CREATE INDEX idx_username ON customer_order(username);
CREATE INDEX idx_order_date ON customer_order(order_date);

-- Customer Order Line Table
CREATE TABLE customer_order_line
(
    order_line_id SERIAL PRIMARY KEY,
    product_id    INT REFERENCES product (product_id),
    qty           INT,
    discount      DECIMAL(10, 2),
    price         DECIMAL(10, 2),
    order_id      INT REFERENCES customer_order (order_id)
);
CREATE INDEX idx_product_id ON customer_order_line(product_id);
CREATE INDEX idx_order_id ON customer_order_line(order_id);

-- Supplier Order Table
CREATE TABLE supplier_order
(
    order_id       SERIAL PRIMARY KEY,
    order_discount DECIMAL(10, 2),
    supplier_id    INT REFERENCES supplier (supplier_id),
    order_date     DATE
);
CREATE INDEX idx_supplier_id_order ON supplier_order(supplier_id);
CREATE INDEX idx_order_date_supplier ON supplier_order(order_date);

-- Supplier Order Line Table
CREATE TABLE supplier_order_line
(
    order_line_id SERIAL PRIMARY KEY,
    product_id    INT REFERENCES product (product_id),
    qty           INT,
    discount      DECIMAL(10, 2),
    price         DECIMAL(10, 2),
    order_id      INT REFERENCES supplier_order (order_id)
);
CREATE INDEX idx_supplier_product_id ON supplier_order_line(product_id);
CREATE INDEX idx_supplier_order_id ON supplier_order_line(order_id);
