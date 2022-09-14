DROP TABLE IF EXISTS tbl_transaction;  
CREATE TABLE tbl_transaction (
  id_transaction INT NOT NULL PRIMARY KEY,
  date_transaction TIMESTAMP,
  id_customer INT NOT NULL,
  id_product INT NOT NULL,
  quantity_transaction INT, 
  amount_transaction INT,
  reward_points_transaction INT
 );