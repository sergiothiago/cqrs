-- V1__Create_person_table.sql
CREATE TABLE IF NOT EXISTS person (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(80) NOT NULL,
  last_name VARCHAR(80) NOT NULL,
  address VARCHAR(100) NOT NULL,
  gender VARCHAR(6) NOT NULL
);
