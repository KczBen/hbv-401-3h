CREATE TABLE rooms(
   hotel_id    INTEGER  NOT NULL
  ,room_number INTEGER  NOT NULL
  ,type        INTEGER NOT NULL
  ,max_guests  INTEGER  NOT NULL
  ,amenities   VARCHAR(255) NOT NULL
  ,price       INTEGER NOT NULL
  ,PRIMARY KEY (hotel_id, room_number)
);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (1,101,1,2,'Free WiFi, Coffee Maker, MiniFridge, Microwave', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (1,102,1,2,'Free WiFi, Coffee Maker, MiniFridge, Microwave', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (1,103,1,2,'Free WiFi, Coffee Maker, MiniFridge, Microwave', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (1,104,1,2,'Free WiFi, Coffee Maker, MiniFridge, Microwave', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (2,101,3,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (2,102,3,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (2,103,3,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (2,104,3,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (3,101,2,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (3,102,2,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (3,103,2,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (3,104,2,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (4,101,2,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (4,102,2,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (4,103,2,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (4,104,2,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (5,101,1,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Eco-Friendly Products', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (5,102,1,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Eco-Friendly Products', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (5,103,1,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Eco-Friendly Products', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (5,104,1,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Eco-Friendly Products', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (6,101,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (6,102,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (6,103,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (6,104,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (7,101,3,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, City View', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (7,102,3,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, City View', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (7,103,3,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, City View', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (7,104,3,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, City View', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (8,101,1,2,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Mountain View, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (8,102,1,2,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Mountain View, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (8,103,1,2,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Mountain View, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (8,104,1,2,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Mountain View, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (9,101,1,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (9,102,1,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (9,103,1,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (9,104,1,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (10,101,2,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Spa Access, Massage Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (10,102,2,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Spa Access, Massage Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (10,103,2,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Spa Access, Massage Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (10,104,2,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Spa Access, Massage Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (11,101,2,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Private Pool, Garden Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (11,102,2,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Private Pool, Garden Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (11,103,2,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Private Pool, Garden Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (11,104,2,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Private Pool, Garden Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (12,101,3,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (12,102,3,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (12,103,3,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (12,104,3,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (13,101,1,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (13,102,1,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (13,103,1,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (13,104,1,2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (14,101,1,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (14,102,1,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (14,103,1,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (14,104,1,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (15,101,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Yoga Studio Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (15,102,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Yoga Studio Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (15,103,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Yoga Studio Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (15,104,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Yoga Studio Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (16,101,2,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (16,102,2,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (16,103,3,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (16,104,3,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (17,101,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Garden Access, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (17,102,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Garden Access, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (17,103,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Garden Access, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (17,104,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Garden Access, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (18,101,1,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Skyline View, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (18,102,1,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Skyline View, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (18,103,1,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Skyline View, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (18,104,1,6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Skyline View, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (19,101,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (19,102,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (19,103,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (19,104,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (20,101,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, City View, Modern Design', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (20,102,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, City View, Modern Design', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (20,103,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, City View, Modern Design', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (20,104,1,4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, City View, Modern Design', 50000);
