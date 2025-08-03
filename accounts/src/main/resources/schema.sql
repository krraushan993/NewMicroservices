CREATE TABLE IF NOT EXISTS customer (
  customer_id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  mobile_number VARCHAR(20) NOT NULL,
  created_at DATE NOT NULL,
  created_by VARCHAR(20) NOT NULL,
  updated_at DATE DEFAULT NULL,
  updated_by VARCHAR(20) DEFAULT NULL
);

create table if not exists accounts(
customer_id int not null,
account_number int auto_increment primary key,
account_type varchar(100) not null,
branch_address varchar(200) not null,
created_at date not null,
created_by varchar(20) not null,
updated_at date DEFAULT NULL,
updated_by varchar(20) default null
);

