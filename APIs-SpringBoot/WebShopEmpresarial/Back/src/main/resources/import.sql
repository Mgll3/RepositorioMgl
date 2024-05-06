INSERT INTO user_type (type) VALUES ('USER'), ('ADMIN');

INSERT INTO category (name) VALUES ('Cargadores'), ('Fundas'), ('Auriculares'), 
('Baterias'), ('Cables'), ('Protectores de pantalla'), ('Tarjetas de memoria'), 
('Soportes'), ('Otros');


INSERT INTO user (total_authorization, user_type_id, email, lastname, name, address, password) VALUES (true, 2, 'admin@gmail.com', 'Admin', 'Admin', 'Direccion', 'admin');



