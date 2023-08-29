INSERT INTO flight(id, departure_date, number, departure_airport, arrival_airport)
VALUES(0, '2017-02-12 11:47:56 -02:00', 7318, 'YYZ', 'LEW');
INSERT INTO flight(id, departure_date, number, departure_airport, arrival_airport)
VALUES(1, '2022-10-27 02:35:27 -03:00', 1599, 'LAX', 'PPX');
INSERT INTO flight(id, departure_date, number, departure_airport, arrival_airport)
VALUES(2, '2015-02-23 11:59:22 -02:00', 6458, 'ANC', 'KRK');
INSERT INTO flight(id, departure_date, number, departure_airport, arrival_airport)
VALUES(3, '2023-03-12 12:47:31 -02:00', 2747, 'SEA', 'GDN');
INSERT INTO flight(id, departure_date, number, departure_airport, arrival_airport)
VALUES(4, '2015-02-06 05:46:21 -02:00', 9143, 'YYZ', 'KRK');

INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(0, 0, 165, 0, 316, 0);
INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(1, 0, 853, 1, 17, 0);
INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(2, 0, 146, 0, 886, 0);
INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(3, 0, 143, 0, 879, 0);
INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(4, 0, 611, 1, 612, 0);

INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(5, 0, 216, 0, 810, 1);
INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(6, 0, 593, 1, 571, 1);
INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(7, 0, 778, 0, 138, 1);
INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(8, 0, 914, 1, 167, 1);

INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(9, 1, 855, 1, 285, 0);
INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(10, 1, 439, 0, 600, 0);
INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(11, 1, 611, 1, 617, 0);

INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(14, 1, 646, 0, 235, 1);
INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(15, 1, 159, 1, 413, 1);
INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(16, 1, 656, 1, 172, 1);
INSERT INTO cargo(id, flight_id, weight, weight_unit, pieces, cargo_type) VALUES(17, 1, 289, 0, 773, 1);