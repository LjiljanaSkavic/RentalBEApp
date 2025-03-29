-- Insert into file (user profile images)
INSERT INTO rentaldb.file (id, name, path, type, is_deleted)
VALUES (1, 'profile_pic_admin.jpg', 'src/main/resources/uploads/profile_pic_admin.png', 'image/png', 0),
       (2, 'profile_pic_jane.jpg', 'src/main/resources/uploads/profile_pic_jane.png', 'image/png', 0),
       (3, 'profile_pic_amy.jpg', 'src/main/resources/uploads/profile_pic_amy.png', 'image/png', 0),
       (4, 'profile_pic_mike.jpg', 'src/main/resources/uploads/profile_pic_mike.png', 'image/png', 0),
       (5, 'profile_pic_john.jpg', 'src/main/resources/uploads/profile_pic_john.png', 'image/png', 0);

-- Insert into user
INSERT INTO rentaldb.user (id, first_name, last_name, username, password, email, phone, profile_picture_id)
VALUES (1, 'Admin', 'Admin', 'admin_admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918',
        'admin@gmail.com', '+123456789', 1),
       (2, 'Jane', 'Smith', 'jane_smith',
        '1dde1123436545181e16f999462e21b51e9e88da7f1f11475ba5a87b24c4c25adec2b73933b7f9f454b297089a0404e5f6a3826db7d41e5cbcd70143b01e17e6',
        'jane.smith@gmail.com', '+987654321', 2),
       (3, 'Amy', 'Wong', 'amy_wong',
        '115a465e9aa883f59880db05068a0e2850e3d85979b58c2e1bce297cd695c3297d5cbf3b0d658beeaf547f81e2717d1d1981095af3478e1cda0660bf18b56546',
        'amy.wong@gmai.com', '+987654661', 3),
       (4, 'Mike', 'Smith', 'mike_smith',
        '115a465e9aa883f59880db05068a0e2850e3d85979b58c2e1bce297cd695c3297d5cbf3b0d658beeaf547f81e2717d1d1981095af3478e1cda0660bf18b56546',
        'mike.smith@gmai.com', '+987688661', 4),
       (5, 'John', 'Doe', 'john_doe',
        'ad8a7934f46531bc97ce69f8782187eda723a37a8a3b59e402b54f7a69b4f3bc11eced54290af3438ca8ecbacdfb2b9d2c291fce02601a5edcfa07f39376f6eb',
        'john.doe@gmai.com', '+987681261', 5);

-- Insert into employee
INSERT INTO rentaldb.employee (id, role)
VALUES (1, 'Admin'),
       (2, 'Manager'),
       (3, 'Operator');

-- Insert into client
INSERT INTO rentaldb.client (id, card_number, is_blocked)
VALUES (4, '1234567890', false),
       (5, '0987654321', false);

-- Insert into manufacturer
INSERT INTO rentaldb.manufacturer (id, name, country, address, email, phone, fax, is_deleted)
VALUES (1, 'Tesla', 'USA', '3500 Deer Creek Road, Palo Alto, CA', 'contact@tesla.com', '123-456-7890', '123-456-7891',
        false),
       (2, 'Yamaha', 'Japan', '2500 Shingai, Iwata, Shizuoka', 'contact@yamaha.com', '987-654-3210', '987-654-3211',
        false),
       (3, 'BMW', 'Germany', 'Petuelring 130, Munich', 'contact@bmw.com', '111-222-3333', '111-222-3334', false),
       (4, 'Honda', 'Japan', '1-1, Minami-Aoyama, Minato-ku, Tokyo', 'contact@honda.com', '555-666-7777',
        '555-666-7778', false),
       (5, 'Ford', 'USA', 'World Headquarters, 1 American Road, Dearborn, MI', 'contact@ford.com', '234-567-8901',
        '234-567-8902', false),
       (6, 'Audi', 'Germany', 'Auto-Union-Straße 1, Ingolstadt', 'contact@audi.com', '345-678-9012', '345-678-9013',
        false),
       (7, 'Chevrolet', 'USA', '300 Renaissance Center, Detroit, MI', 'contact@chevrolet.com', '456-789-0123',
        '456-789-0124', false),
       (8, 'Nissan', 'Japan', '1-1 Takashima, Nishi-ku, Yokohama', 'contact@nissan.com', '567-890-1234', '567-890-1235',
        false),
       (9, 'Toyota', 'Japan', '1-1, Toyoda-cho, Kariya, Aichi', 'contact@toyota.com', '678-901-2345', '678-901-2346',
        false),
       (10, 'Mercedes-Benz', 'Germany', 'Mercedesstraße 120, Stuttgart', 'contact@mercedes-benz.com', '789-012-3456',
        '789-012-3457', false),
       (11, 'Volkswagen', 'Germany', 'Berliner Ring 2, Wolfsburg', 'contact@volkswagen.com', '890-123-4567',
        '890-123-4568', false),
       (12, 'Hyundai', 'South Korea', '12, Eoui-ro, Uiwang-si, Gyeonggi-do', 'contact@hyundai.com', '901-234-5678',
        '901-234-5679', false),
       (13, 'Kia', 'South Korea', '12, Gwangmyeong-ro, Gwangmyeong-si, Gyeonggi-do', 'contact@kia.com', '112-345-6789',
        '112-345-6790', false),
       (14, 'Mazda', 'Japan', '3-1, Takuma, Aki, Hiroshima', 'contact@mazda.com', '223-456-7890', '223-456-7891',
        false),
       (15, 'Ferrari', 'Italy', 'Via Emilia Est 1163, Modena', 'contact@ferrari.com', '334-567-8901', '334-567-8902',
        false),
       (16, 'Lamborghini', 'Italy', 'Via Modena, Sant’Agata Bolognese, Bologna', 'contact@lamborghini.com',
        '445-678-9012', '445-678-9013', false),
       (17, 'Porsche', 'Germany', 'Porschestraße 1, Zuffenhausen', 'contact@porsche.com', '556-789-0123',
        '556-789-0124', false),
       (18, 'Land Rover', 'UK', 'Abbey Road, Whitley, Coventry', 'contact@landrover.com', '667-890-1234',
        '667-890-1235', false),
       (19, 'Jaguar', 'UK', 'Whitley, Coventry, West Midlands', 'contact@jaguar.com', '778-901-2345', '778-901-2346',
        false),
       (20, 'Volvo', 'Sweden', 'Lundby, Gothenburg', 'contact@volvo.com', '889-012-3456', '889-012-3457', false),
       (21, 'Peugeot', 'France', '2-10 Rue René Cassin, 78190 Trappes', 'contact@peugeot.com', '900-123-4567',
        '900-123-4568', false),
       (22, 'Citroën', 'France', 'Rond-Point du Colonel Pierre Avia, Paris', 'contact@citroen.com', '111-234-5678',
        '111-234-5679', false),
       (23, 'Renault', 'France', '13-15 Quai Le Gallo, Boulogne-Billancourt', 'contact@renault.com', '222-345-6789',
        '222-345-6790', false),
       (24, 'BMW Motorrad', 'Germany', 'Petuelring 130, Munich', 'contact@bmw-motorrad.com', '333-456-7890',
        '333-456-7891', false);

-- Insert into file (vehicle images)
INSERT INTO rentaldb.file (id, name, path, type, is_deleted)
VALUES (6, 'tesla_model3.jpg', '/images/tesla_model3.jpg', 'image/jpeg', 0),
       (7, 'tesla_modelx.jpg', '/images/tesla_modelx.jpg', 'image/jpeg', 0),
       (8, 'yamaha_ebike.jpg', '/images/yamaha_ebike.jpg', 'image/jpeg', 0),
       (9, 'yamaha_escooter.jpg', '/images/yamaha_escooter.jpg', 'image/jpeg', 0),
       (10, 'bmw_i3.jpg', '/images/bmw_i3.jpg', 'image/jpeg', 0),
       (11, 'honda_ebike.jpg', '/images/honda_ebike.jpg', 'image/jpeg', 0),
       (12, 'honda_escooter.jpg', '/images/honda_escooter.jpg', 'image/jpeg', 0);

-- Insert into vehicle with populated vehicle_type
INSERT INTO rentaldb.vehicle (id, vehicle_code, purchase_price, model, status, is_deleted, manufacturer_id,
                              vehicle_picture_id)
VALUES (1, 'TESLA-MODEL3', 45000, 'Model 3', 'Available', false, 1, 6),
       (2, 'TESLA-MODELX', 90000, 'Model X', 'Rented', false, 1, 7),
       (3, 'YAMAHA-EBIKE', 3000, 'Yamaha E-Bike', 'Available', false, 2, 8),
       (4, 'YAMAHA-ESCOOTER', 1500, 'Yamaha E-Scooter', 'Broken', false, 2, 9),
       (5, 'BMW-i3', 35000, 'BMW i3', 'Available', false, 3, 10),
       (6, 'HONDA-EBIKE', 2800, 'Honda E-Bike', 'Rented', false, 4, 11),
       (7, 'HONDA-ESCOOTER', 1600, 'Honda E-Scooter', 'Available', false, 4, 12);

-- Insert into car
INSERT INTO rentaldb.car (id, acquisition_date, description)
VALUES (1, '2024-03-24 08:00:00', 'Tesla Model 3 - Electric Car'),
       (2, '2022-07-29 08:00:00', 'Tesla Model X - Luxury Electric SUV'),
       (3, '2021-12-01 08:00:00', 'BMW i3 - Compact Electric Car');

-- Insert into electric_bike
INSERT INTO rentaldb.electric_bike (id, range_per_charge)
VALUES (4, 120),
       (5, 130);

-- Insert into electric_scooter
INSERT INTO rentaldb.electric_scooter (id, max_speed)
VALUES (6, 45),
       (7, 50);

-- Insert into malfunction
INSERT INTO rentaldb.malfunction (id, date, time, description, is_deleted, vehicle_id)
VALUES (1, '2024-03-20', '08:00', 'Battery not charging', false, 1),
       (2, '2024-03-22', '14:30', 'Brakes malfunctioning', false, 1),
       (3, '2024-03-23', '10:15', 'Motor overheating', false, 1),

       (4, '2024-03-21', '09:00', 'Door not closing properly', false, 2),
       (5, '2024-03-23', '16:30', 'Suspension failure', false, 2),
       (6, '2024-03-24', '13:00', 'Windshield wipers malfunctioning', false, 2),

       (7, '2024-03-20', '11:00', 'Tire puncture', false, 3),
       (8, '2024-03-22', '17:45', 'Controller not responsive', false, 3),
       (9, '2024-03-23', '09:30', 'Battery not holding charge', false, 3),

       (10, '2024-03-19', '08:45', 'Handlebar loose', false, 4),
       (11, '2024-03-21', '13:30', 'Motor not starting', false, 4),
       (12, '2024-03-23', '15:00', 'Brakes not functioning properly', false, 4),

       (13, '2024-03-18', '10:30', 'Electrical short', false, 5),
       (14, '2024-03-20', '12:00', 'Overheating', false, 5),
       (15, '2024-03-22', '14:30', 'Lights not working', false, 5),


       (16, '2024-03-21', '10:00', 'Flat tire', false, 6),
       (17, '2024-03-23', '12:45', 'Chain slipping', false, 6),
       (18, '2024-03-24', '15:30', 'Battery draining too quickly', false, 6),

       (19, '2024-03-19', '09:30', 'Faulty throttle', false, 7),
       (20, '2024-03-21', '11:15', 'Speed limiter malfunction', false, 7),
       (21, '2024-03-22', '16:45', 'Motor failure', false, 7);

-- Insert into rental with updated locations (Banja Luka to other towns)
INSERT INTO rentaldb.rental (start, end, start_location_lat, start_location_lng, end_location_lat, end_location_lng, duration, identification_card, driver_licence,
                             client_id, vehicle_id)
VALUES ('2024-03-25 10:00:00', '2024-03-25 12:00:00', 44.7732, 17.1910, 43.8486, 18.3564, '02:00:00',
        '1234567890', 'D1234567', 1, 1), -- Tesla Model 3 rental (Banja Luka to Sarajevo)
       ('2024-03-24 08:00:00', '2024-03-24 09:30:00', 44.7732, 17.1910, 44.7716, 18.1473, '01:30:00',
        '0987654321', 'D7654321', 2, 2), -- Tesla Model X rental (Banja Luka to Doboj)
       ('2024-03-23 14:00:00', '2024-03-23 16:30:00', 44.7732, 17.1910, 44.8734, 18.8045, '02:30:00',
        '1122334455', 'D1122334', 1, 3), -- BMW i3 rental (Banja Luka to Brcko)
       ('2024-03-22 11:00:00', '2024-03-22 13:00:00', 44.7732, 17.1910, 43.3438, 17.8070, '02:00:00',
        '2233445566', 'D2233445', 2, 6); -- Honda E-Bike rental (Banja Luka to Mostar)