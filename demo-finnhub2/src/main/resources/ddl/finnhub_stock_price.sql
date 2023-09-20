CREATE TABLE finnhub_stock_price (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    stock_id BIGINT NOT NULL,
    datetime DATETIME,
    current_price VARCHAR(255),
    day_High NUMERIC(15,2),
    day_Low NUMERIC(15,2),
    day_Open NUMERIC(15,2),
    prev_day_close NUMERIC(15,2),
    FOREIGN KEY (stock_id) REFERENCES finnhub_stock (ID)
);
