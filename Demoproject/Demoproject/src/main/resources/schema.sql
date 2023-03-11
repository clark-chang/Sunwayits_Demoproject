CREATE TABLE COIN (
   Id BIGINT NOT NULL PRIMARY KEY,
   Time VARCHAR(100) NOT NULL,
   Disclaimer VARCHAR(1000) NOT NULL,
   Chartname VARCHAR(100) NOT NULL,
   Coinchinesename VARCHAR(100) NOT NULL,
   Bpi VARCHAR(100) NOT NULL,
   Code VARCHAR(100) NOT NULL,
   Symbol VARCHAR(100) NOT NULL,
   Rate VARCHAR(100) NOT NULL,
   Description VARCHAR(100) NOT NULL,
   Ratefloat DECIMAL(20,4) NOT NULL
);