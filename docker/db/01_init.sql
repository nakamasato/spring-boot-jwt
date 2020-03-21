CREATE DATABASE IF NOT EXISTS db_example;
CREATE USER 'spring_boot'@'%' identified BY 'password';
GRANT ALL ON db_example.* TO 'spring_boot'@'%';
