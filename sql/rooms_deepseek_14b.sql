CREATE TABLE rooms(
   hotel_id    INTEGER  NOT NULL
  ,room_number INTEGER  NOT NULL
  ,type        VARCHAR(255) NOT NULL
  ,max_guests  INTEGER  NOT NULL
  ,amenities   VARCHAR(255) NOT NULL
  ,price       INTEGER NOT NULL
  ,PRIMARY KEY (hotel_id, room_number)
);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (1,101,'Studio Apartment',2,'Free WiFi, Coffee Maker, MiniFridge, Microwave', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (1,102,'Studio Apartment',2,'Free WiFi, Coffee Maker, MiniFridge, Microwave', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (1,103,'Studio Apartment',2,'Free WiFi, Coffee Maker, MiniFridge, Microwave', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (1,104,'Studio Apartment',2,'Free WiFi, Coffee Maker, MiniFridge, Microwave', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (2,101,'Executive Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (2,102,'Executive Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (2,103,'Executive Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (2,104,'Executive Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (3,101,'Queen Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (3,102,'Queen Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (3,103,'Queen Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (3,104,'Queen Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (4,101,'Presidential Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (4,102,'Presidential Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (4,103,'Presidential Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (4,104,'Presidential Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (5,101,'Double Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Eco-Friendly Products', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (5,102,'Double Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Eco-Friendly Products', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (5,103,'Double Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Eco-Friendly Products', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (5,104,'Double Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Eco-Friendly Products', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (6,101,'Beachfront Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (6,102,'Beachfront Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (6,103,'Beachfront Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (6,104,'Beachfront Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (7,101,'King Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, City View', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (7,102,'King Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, City View', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (7,103,'King Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, City View', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (7,104,'King Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, City View', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (8,101,'Deluxe Room',2,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Mountain View, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (8,102,'Deluxe Room',2,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Mountain View, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (8,103,'Deluxe Room',2,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Mountain View, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (8,104,'Deluxe Room',2,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Mountain View, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (9,101,'Imperial Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (9,102,'Imperial Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (9,103,'Imperial Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (9,104,'Imperial Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (10,101,'Spa Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Spa Access, Massage Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (10,102,'Spa Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Spa Access, Massage Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (10,103,'Spa Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Spa Access, Massage Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (10,104,'Spa Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Spa Access, Massage Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (11,101,'Villa Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Private Pool, Garden Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (11,102,'Villa Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Private Pool, Garden Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (11,103,'Villa Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Private Pool, Garden Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (11,104,'Villa Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Private Pool, Garden Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (12,101,'Premium Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (12,102,'Premium Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (12,103,'Premium Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (12,104,'Premium Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (13,101,'Cozy Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (13,102,'Cozy Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (13,103,'Cozy Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (13,104,'Cozy Room',2,'Free WiFi, Coffee Maker, MiniFridge, Hairdryer, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (14,101,'Grand Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (14,102,'Grand Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (14,103,'Grand Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (14,104,'Grand Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Fitness Center Access, Spa Services', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (15,101,'Harmony Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Yoga Studio Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (15,102,'Harmony Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Yoga Studio Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (15,103,'Harmony Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Yoga Studio Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (15,104,'Harmony Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Balcony, Yoga Studio Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (16,101,'Oceanfront Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (16,102,'Oceanfront Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (16,103,'Oceanfront Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (16,104,'Oceanfront Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (17,101,'Country Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Garden Access, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (17,102,'Country Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Garden Access, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (17,103,'Country Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Garden Access, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (17,104,'Country Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Garden Access, Fireplace', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (18,101,'Skyline Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Skyline View, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (18,102,'Skyline Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Skyline View, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (18,103,'Skyline Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Skyline View, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (18,104,'Skyline Suite',6,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Skyline View, Fitness Center Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (19,101,'Sunset Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (19,102,'Sunset Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (19,103,'Sunset Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (19,104,'Sunset Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, Beach Access, Pool Access', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (20,101,'Loft Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, City View, Modern Design', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (20,102,'Loft Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, City View, Modern Design', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (20,103,'Loft Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, City View, Modern Design', 50000);
INSERT INTO rooms(hotel_id,room_number,type,max_guests,amenities,price) VALUES (20,104,'Loft Suite',4,'Free WiFi, Coffee Maker, MiniFridge, Microwave, City View, Modern Design', 50000);
