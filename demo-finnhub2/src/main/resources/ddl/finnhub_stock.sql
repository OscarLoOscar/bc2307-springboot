CREATE TABLE finnhub_stock (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(255),
    company_name VARCHAR(255),
    ipo_date DATE,
    logo VARCHAR(255),
    market_cap NUMERIC(15,2),
    currency VARCHAR(255)
);
