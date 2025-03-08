create database userDetails;
use userDetails;

CREATE TABLE frontend_details (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255),
    email_id VARCHAR(255) UNIQUE NOT NULL
);

select * from frontend_details;
show tables;

drop table frontend_details;
