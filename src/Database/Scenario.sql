INSERT INTO scene VALUES (default,1,1,'A',3,1),
                         (default,1,1,'B',3,1),
                         (default,1,1,'C',3,1),
                         (default,1,1,'D',3,1),
                         (default,1,1,'E',3,1),
                         (default,1,1,'F',3,1),
                         (default,1,1,'G',3,1),
                         (default,1,1,'H',3,1),
                         (default,1,1,'I',3,1),
                         (default,1,1,'J',3,1),

                         (default,1,2,'K',3,2),
                         (default,1,2,'L',3,2),
                         (default,1,2,'M',3,2),
                         (default,1,2,'N',3,2),
                         (default,1,2,'O',3,2),
                         (default,1,2,'P',3,2),
                         (default,1,2,'Q',3,2),

                         (default,1,3,'R',3,1),
                         (default,1,3,'S',3,1),
                         (default,1,3,'T',3,1),
                         (default,1,3,'U',3,1),
                         (default,1,3,'V',3,1),
                         (default,1,3,'W',3,1),
                         (default,1,3,'X',3,1),
                         (default,1,3,'Y',3,1);

-- cas simple : si l'id du plateau est impaire , ces dates d'indisponibilités sont des dates impaires
-- et si l'id et paire => dates d'indisponibilités sont paires
INSERT INTO Plateaudispo VALUES (default,'2023-03-13','plateauA',1),
                                (default,'2023-03-15','plateauA',1),
                                (default,'2023-03-17','plateauA',1),
                                (default,'2023-03-19','plateauA',1),
                                (default,'2023-03-21','plateauA',1),

                                (default,'2023-03-14','plateauB',2),
                                (default,'2023-03-16','plateauB',2),
                                (default,'2023-03-18','plateauB',2),
                                (default,'2023-03-20','plateauB',2),
                                (default,'2023-03-22','plateauB',2),

                                (default,'2023-03-13','plateauC',3),
                                 (default,'2023-03-15','plateauC',3),
                                (default,'2023-03-17','plateauC',3),
                                (default,'2023-03-19','plateauC',3),
                                (default,'2023-03-21','plateauC',3);


-- cas radom : more random data
-- INSERT INTO Plateaudispo 
-- VALUES 
--     (default, '2023-04-02', 'plateauA', 1),
--     (default, '2023-04-10', 'plateauA', 1),
--     (default, '2023-04-18', 'plateauA', 1),
--     (default, '2023-04-26', 'plateauA', 1),
--     (default, '2023-05-04', 'plateauA', 1),
--     (default, '2023-04-04', 'plateauB', 2),
--     (default, '2023-04-12', 'plateauB', 2),
--     (default, '2023-04-20', 'plateauB', 2),
--     (default, '2023-04-28', 'plateauB', 2),
--     (default, '2023-05-06', 'plateauB', 2),
--     (default, '2023-04-03', 'plateauC', 3),
--     (default, '2023-04-11', 'plateauC', 3),
--     (default, '2023-04-19', 'plateauC', 3),
--     (default, '2023-04-27', 'plateauC', 3),
--     (default, '2023-05-05', 'plateauC', 3);


-- cas simple : si l'id de l'acteur est impaire , ces dates d'indisponibilités sont des dates impaires
-- et si l'id et paire => dates d'indisponibilités sont paires
INSERT INTO acteurdispo values(default,'2023-03-13','observationActeur1N1',1),
                              (default,'2023-03-15','observationActeur1N2',1),
                              (default,'2023-03-17','observationActeur1N3',1),
                              (default,'2023-03-19','observationActeur1N4',1),
                              (default,'2023-03-21','observationActeur1N5',1),
                              (default,'2023-03-23','observationActeur1N6',1),
                              (default,'2023-03-25','observationActeur1N7',1),
                              (default,'2023-03-27','observationActeur1N8',1),
                              (default,'2023-03-29','observationActeur1N9',1),
                              (default,'2023-03-31','observationActeur1N10',1),


                              (default,'2023-03-14','observationActeur2N1',2),
                              (default,'2023-03-16','observationActeur2N2',2),
                              (default,'2023-03-18','observationActeur2N3',2),
                              (default,'2023-03-20','observationActeur2N4',2),
                              (default,'2023-03-22','observationActeur2N5',2),
                              (default,'2023-03-24','observationActeur2N6',2),
                              (default,'2023-03-26','observationActeur2N7',2),
                              (default,'2023-03-28','observationActeur2N8',2),
                              (default,'2023-03-30','observationActeur2N9',2),
                              (default,'2023-04-01','observationActeur2N10',2),


                              (default,'2023-03-13','observationActeur3N1',3),
                              (default,'2023-03-15','observationActeur3N2',3),
                              (default,'2023-03-17','observationActeur3N3',3),
                              (default,'2023-03-19','observationActeur3N4',3),
                              (default,'2023-03-21','observationActeur3N5',3),
                              (default,'2023-03-23','observationActeur3N6',3),
                              (default,'2023-03-25','observationActeur3N7',3),
                              (default,'2023-03-27','observationActeur3N8',3),
                              (default,'2023-03-29','observationActeur3N9',3),
                              (default,'2023-03-31','observationActeur3N10',3),


                              (default,'2023-03-14','observationActeur4N1',4),
                              (default,'2023-03-16','observationActeur4N2',4),
                              (default,'2023-03-18','observationActeur4N3',4),
                              (default,'2023-03-20','observationActeur4N4',4),
                              (default,'2023-03-22','observationActeur4N5',4),
                              (default,'2023-03-24','observationActeur4N6',4),
                              (default,'2023-03-26','observationActeur4N7',4),
                              (default,'2023-03-28','observationActeur4N8',4),
                              (default,'2023-03-30','observationActeur4N9',4),
                              (default,'2023-04-01','observationActeur4N10',4),

                              (default,'2023-03-13','observationActeur5N1',5),
                              (default,'2023-03-15','observationActeur5N2',5),
                              (default,'2023-03-17','observationActeur5N3',5),
                              (default,'2023-03-19','observationActeur5N4',5),
                              (default,'2023-03-21','observationActeur5N5',5),
                              (default,'2023-03-23','observationActeur5N6',5),
                              (default,'2023-03-25','observationActeur5N7',5),
                              (default,'2023-03-27','observationActeur5N8',5),
                              (default,'2023-03-29','observationActeur5N9',5),
                              (default,'2023-03-31','observationActeur5N10',5),

                              (default,'2023-03-14','observationActeur64N1',6),
                              (default,'2023-03-16','observationActeur6N2',6),
                              (default,'2023-03-18','observationActeur6N3',6),
                              (default,'2023-03-20','observationActeur6N4',6),
                              (default,'2023-03-22','observationActeur6N5',6),
                              (default,'2023-03-24','observationActeur6N6',6),
                              (default,'2023-03-26','observationActeur6N7',6),
                              (default,'2023-03-28','observationActeur6N8',6),
                              (default,'2023-03-30','observationActeur6N9',6),
                              (default,'2023-04-01','observationActeur6N10',6),

                              (default,'2023-03-13','observationActeur7N1',7),
                              (default,'2023-03-15','observationActeur7N2',7),
                              (default,'2023-03-17','observationActeur7N3',7),
                              (default,'2023-03-19','observationActeur7N4',7),
                              (default,'2023-03-21','observationActeur7N5',7),
                              (default,'2023-03-23','observationActeur7N6',7),
                              (default,'2023-03-25','observationActeur7N7',7),
                              (default,'2023-03-27','observationActeur7N8',7),
                              (default,'2023-03-29','observationActeur7N9',7),
                              (default,'2023-03-31','observationActeur7N10',7);

INSERT INTO ACT VALUES
                    (default,1,1,1,'09:00','11:00',180,'une action',null),
                    (default,2,2,2,'06:00','23:00',120,'une observation',null),
                    (default,3,3,3,'08:00','08:30',240,'une discussion',null),
                    (default,1,4,4,null,null,60,'une action 2 ',null),
                    (default,2,5,5,null,null,20,'une observation 2',null),
                    (default,3,6,6,'09:00','11:00',10,'une discussion 2',null),
                    (default,1,7,7,'18:00','21:00',55,'une action 3',null),
                    (default,2,8,1,'23:00','23:30',30,'une observation 3',null),
                    (default,3,9,2,'01:00','02:00',25,'une discussion 3 ',null),
                    (default,1,10,3,'6:00','17:00',42,'une action 4',null),


                    (default,2,11,1,null,null,15,'une observation 4',null),
                    (default,3,12,2,null,null,75,'une discussion 4',null),
                    (default,1,13,3,'08:00','08:30',240,'une action 5',null),
                    (default,1,14,4,'09:30','10:30',90,'une action 6',null),
                    (default,2,15,5,'11:00','13:00',150,'une observation 5',null),
                    (default,3,16,6,'14:00','16:00',120,'une discussion 5',null),
                    (default,1,17,7,'19:00','21:30',75,'une action 7',null),



                    (default,2,18,1,'23:30','23:50',20,'une observation 6',null),
                    (default,3,19,2,'03:00','04:00',50,'une discussion 6 ',null),
                    (default,1,20,3,'8:00','11:00',180,'une action 8',null),
                    (default,2,21,1,'06:00','07:00',30,'une observation 7',null),
                    (default,3,22,2,'10:00','11:00',60,'une discussion 7',null),
                    (default,1,23,3,'12:00','13:00',45,'une action 9',null),
                    (default,2,24,1,null,null,10,'une observation 8',null),
                    (default,3,25,2,null,null,90,'une discussion 8',null);