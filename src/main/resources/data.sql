INSERT INTO ADDRESS (id, street, postal_code, city) VALUES
(1, 'Storgatan 12', '12345', 'Stockholm'),

(2, 'Köpmansgatan 5', '54321', 'Örebro'),

(3, 'Drottninggatan 33', '67890', 'Göteborg'),

(4, 'Edugradegatan 14', '98765', 'Visby'),

(5, 'Östra Storgatan 21', '11111', 'Jönköping');

INSERT INTO MEMBER (first_name, last_name, address_id, email, phone, date_of_birth) VALUES
('Erik', 'Andersson', 1, 'Erik.andersson@example.com', '123456789', '1990-01-01'),

('Anna', 'Svensson', 2, 'Anna@example.com', '987654321', '1985-05-05'),

('Johan', 'Beam', 3, 'Beam@example.com', null, '1970-07-07'),

('Jack', 'Daniels', 4, 'jack@example.com', '123123123', '1980-08-08'),

('Hala', 'Madrid', 5, 'Madrid@example.com', '456456456', '1995-09-09');