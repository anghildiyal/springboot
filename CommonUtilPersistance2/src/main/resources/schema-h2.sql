CREATE TABLE reservation (
id int(1) NOT NULL AUTO_INCREMENT,
user_id int(1) NOT NULL,
party_size int(1) NOT NULL,
dt timestamp  DEFAULT CURRENT_TIMESTAMP,
restaurant_id int(1) NOT NULL, 
);