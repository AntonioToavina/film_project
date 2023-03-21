-- CREATE DATABASE Film_production1;
-- \c film_production1

-- SEQUENCE

    CREATE SEQUENCE gender_id_seq start 1 increment 1;
    CREATE SEQUENCE filmcgt_id_seq start 1 increment 1;
    CREATE SEQUENCE acttype_id_seq start 1 increment 1;
    CREATE SEQUENCE plateauctg_id_seq start 1 increment 1;
    CREATE SEQUENCE acteur_id_seq start 1 increment 1;
    CREATE SEQUENCE acteurdispo_id_seq start 1 increment 1;
    CREATE SEQUENCE plateau_id_seq start 1 increment 1;
    CREATE SEQUENCE plateaudispo_id_seq start 1 increment 1;
    CREATE SEQUENCE film_id_seq start 1 increment 1;
    CREATE SEQUENCE scene_id_seq start 1 increment 1;
    CREATE SEQUENCE emotion_id_seq start 1 increment 1;
    CREATE SEQUENCE act_id_seq start 1 increment 1;
    CREATE SEQUENCE scenestatus_id_seq start 1 increment 1;
    CREATE SEQUENCE planning_id_seq start 1 increment 1;

-- TABLES

CREATE TABLE Gender(
    id integer primary key default nextval('gender_id_seq'),
    gendername varchar(80) unique not null
);
INSERT INTO Gender (gendername) VALUES
                                    ('Femme'),
                                    ('Homme'),
                                    ('Non-binaire'),
                                    ('Autre');

CREATE TABLE Emotion(
    id integer primary key default nextval('emotion_id_seq'),
    emotionname varchar(80) unique not null
);
INSERT INTO Emotion (emotionname) VALUES
                                      ('Joie'),
                                      ('Tristesse'),
                                      ('Colère'),
                                      ('Peur'),
                                      ('Surprise'),
                                      ('Dégoût'),
                                      ('Calme'),
                                      ('Amour'),
                                      ('Honte'),
                                      ('Jalousie');


CREATE TABLE Filmctg(
    id integer primary key default nextval('filmcgt_id_seq'),
    ctgname varchar(80) unique not null
);
INSERT INTO Filmctg (ctgname) VALUES
                                  ('Action'),
                                  ('Comedy'),
                                  ('Drama'),
                                  ('Horror'),
                                  ('Romance'),
                                  ('Science Fiction'),
                                  ('Thriller'),
                                  ('Documentary');

CREATE TABLE Acttype(
    id integer primary key default nextval('acttype_id_seq'),
    typename varchar(80) unique not null
);
INSERT INTO Acttype values (default,'discussion'),
                           (default,'action'),
                           (default,'observation');

CREATE TABLE Plateauctg(
    id integer primary key default nextval('plateauctg_id_seq'),
    ctgname varchar(80) unique not null
);
INSERT INTO Plateauctg values (default,'exterieur'),
                                (default,'interieur');


CREATE TABLE Acteur(
    id integer primary key default nextval('acteur_id_seq'),
    nom_acteur varchar(80) not null,
    gender_id integer REFERENCES Gender(id) not null,
    birthday date not null check(birthday<current_date)
);
INSERT INTO ACTEUR values(default,'Dwayne Johnson',2,'2003-02-02'),
                         (default,'Vin Diesel',2,'2003-02-02'),
                         (default,'Robert Downey Jr',2,'2003-02-02'),
                         (default,'Chris Hemsworth',2,'2003-02-02'),
                         (default,'Leonardo DiCaprio',2,'2003-02-02'),
                         (default,'Ryan Reynolds',2,'2003-02-02'),
                         (default,'Chris Pratt',2,'2003-02-02');



-- CREATE TABLE Acteurdispo(
--     id varchar(4) primary key default nextval('acteurdispo_id_seq'),
--     dow smallint  not null check(dow>0 and dow<8),
--     firstHour time not null default CURRENT_TIME,
--     lastHour time not null check(lastHour>=firstHour) default CURRENT_TIME,
--     acteur_id varchar(4) REFERENCES Acteur(id) not null
-- );
CREATE TABLE Acteurdispo(
    id integer primary key default nextval('acteurdispo_id_seq'),
    notavailableDate date not null default current_date,
    observation varchar(80),
    acteur_id integer REFERENCES Acteur(id) not null
);

-- INSERT INTO ActeurDispo VALUES(default, 1, '08:00', '12:00', 1),
--                               (default, 2, '13:00', '18:00', 1),
--                               (default, 3, '09:00', '17:00', 1),
--                               (default, 4, '10:00', '15:00', 2),
--                               (default, 5, '12:00', '16:00', 2),
--                               (default, 6, '08:00', '12:00', 3),
--                               (default, 7, '13:00', '17:00', 3),
--                               (default, 1, '08:00', '12:00', 4),
--                               (default, 2, '13:00', '18:00', 4),
--                               (default, 3, '09:00', '17:00', 4),
--                               (default, 4, '10:00', '15:00', 5),
--                               (default, 5, '12:00', '16:00', 5),
--                               (default, 6, '08:00', '12:00', 6),
--                               (default, 7, '13:00', '17:00', 6),
--                               (default, 1, '08:00', '12:00', 7),
--                               (default, 2, '13:00', '18:00', 7),
--                               (default, 3, '09:00', '17:00', 7);

CREATE TABLE Plateau(
    id integer primary key default nextval('plateau_id_seq'),
    location varchar(80),
    description varchar(150),
    price double precision not null default 0 check(price>0), 
    plateauctg_id integer REFERENCES Plateauctg(id) not null
);
INSERT INTO PLATEAU VALUES
                        (default, 'Studios Paramount', 'Plateau de tournage pour les productions Paramount', 1500,1),
                        (default, 'Universal Studios', 'Plateau de tournage pour les productions Universal', 2000,2),
                        (default, 'Warner Bros Studios', 'Plateau de tournage pour les productions Warner Bros', 1800,1),
                        (default, 'Pinewood Studios', 'Plateau de tournage pour les productions Pinewood', 2500,1),
                        (default, 'Fox Studios', 'Plateau de tournage pour les productions Fox', 2200,1),
                        (default, 'Cinecittà Studios', 'Plateau de tournage pour les productions Cinecittà', 3000,2),
                        (default, 'Babelsberg Studio', 'Plateau de tournage pour les productions Babelsberg', 1900,2);

CREATE TABLE Plateaudispo(
    id integer primary key default nextval('plateaudispo_id_seq'),
    notavailableDate date not null default current_date,
    observation varchar(80),
    plateau_id integer REFERENCES Plateau(id) not null
);
-- INSERT INTO Plateaudispo VALUES
--                              (default, 1, '08:00', '18:00', 1),
--                              (default, 2, '09:00', '17:00', 1),
--                              (default, 3, '10:00', '16:00', 1),
--                              (default, 4, '12:00', '20:00', 1),
--                              (default, 5, '08:00', '18:00', 1),
--                              (default, 6, '09:00', '17:00', 1),
--                              (default, 7, '10:00', '16:00', 1),
--                              (default, 1, '08:00', '18:00', 2),
--                              (default, 2, '09:00', '17:00', 2),
--                              (default, 3, '10:00', '16:00', 2),
--                              (default, 4, '12:00', '20:00', 2),
--                              (default, 5, '08:00', '18:00', 2),
--                              (default, 6, '09:00', '17:00', 2),
--                              (default, 7, '10:00', '16:00', 2),
--                              (default, 1, '08:00', '18:00', 3),
--                              (default, 2, '09:00', '17:00', 3),
--                              (default, 3, '10:00', '16:00', 3),
--                              (default, 4, '12:00', '20:00', 3),
--                              (default, 5, '08:00', '18:00', 3),
--                              (default, 6, '09:00', '17:00', 3),
--                              (default, 7, '10:00', '16:00', 3),
--                              (default, 1, '08:00', '18:00', 4),
--                              (default, 2, '09:00', '17:00', 4),
--                              (default, 3, '10:00', '16:00', 4),
--                              (default, 4, '12:00', '20:00', 4),
--                              (default, 5, '08:00', '18:00', 4),
--                              (default, 6, '09:00', '17:00', 4),
--                              (default, 7, '10:00', '16:00', 4),
--                              (default, 1, '08:00', '18:00', 5),
--                              (default, 2, '09:00', '17:00', 5),
--                              (default, 3, '10:00', '16:00', 5),
--                              (default, 4, '12:00', '20:00', 5),
--                              (default, 5, '08:00', '18:00', 5),
--                              (default, 6, '09:00', '17:00', 5),
--                              (default, 7, '10:00', '16:00', 5),
--                              (default, 1, '08:00', '18:00', 6),
--                              (default, 2, '09:00', '17:00', 6);
CREATE TABLE Film(
    id integer primary key default nextval('film_id_seq'),
    title varchar(80) not null,
    description text,
    filmctg_id integer REFERENCES Filmctg(id) not null,
    fond double precision not null default 0 check(fond>0),
    production_date date not null
);
INSERT INTO FILM values (default,'Fast and furious','Un film d action hors norme',1,50000000,'2023-03-20'),
                        (default,'Sherlock holmes','Un film haletant',3,50000000,'2023-03-22'),
                        (default,'Avengers Endgame','Le plus film marvel',1,50000000,'2023-03-18'),
                        (default, 'The Godfather', 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.',1, 50.00,'2023-03-20'),
                        (default, 'The Shawshank Redemption', 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.',2, 40.00,'2023-03-25'),
                        (default, 'The Dark Knight', 'When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.',3, 60.00,'2023-03-30'),
                        (default, 'Pulp Fiction', 'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.',2, 35.00,'2023-03-28'),
                        (default, 'Forrest Gump', 'The presidencies of Kennedy and Johnson, the events of Vietnam, Watergate and other historical events unfold through the perspective of an Alabama man with an IQ of 75.',4, 45.00,'2023-03-24');

CREATE TABLE SceneStatus (
    id integer primary key default nextval('scenestatus_id_seq'),
    status varchar(80) unique not null,
    value smallint unique not null
);

-- ! mila atao en cours aloha ilay status an'ilay scène vao afaka mi-créer action
-- ! rehefa achevé ilay écriture dia tsy afaka mi-créer action intsony ao amin'ilay scène

INSERT INTO SceneStatus VALUES 
(1,'créé',0), 
(2,'écriture en cours',8),
(3,'écriture achevé',20);

CREATE TABLE Scene(
    id integer primary key default nextval('scene_id_seq'),
    film_id integer REFERENCES Film(id) not null,
    plateau_id integer REFERENCES Plateau(id) not null,
    description TEXT,
    scenestatus_id integer REFERENCES SceneStatus(id) default 1 not null
);
INSERT INTO Scene (id, film_id, plateau_id, description,scenestatus_id)
VALUES (1, 1, 2, 'Opening Scene',2),
       (2, 1, 1, 'Action Scene',2),
       (3, 2, 3, 'Dramatic Scene',1),
       (4, 2, 2, 'Romantic Scene',1),
       (5, 3, 1, 'Comedy Scene',1);

-- duration in minute
CREATE TABLE Act(
    id integer primary key default nextval('act_id_seq'),
    acttype_id integer REFERENCES Acttype(id) not null,
    scene_id integer REFERENCES Scene(id) not null,
    acteur_id integer REFERENCES Acteur(id),
    firstHour time,
    lastHour time,
    duration integer not null check(duration>0) default 1,
    action TEXT NOT NULL,
    emotion_id integer REFERENCES Emotion(id),
    act_id integer REFERENCES Act(id)
);


INSERT INTO Act (id, acttype_id, scene_id, acteur_id, firstHour , lastHour,duration, action, emotion_id,act_id)
VALUES
    (1, 2, 1, 3, '08:00:00', '08:30:00',2, 'Enters the room', 2,null),
    (2, 1, 1, 1, null,null ,default,  'Greets the guests', 1,1),
    (3, 2, 1, 4, null,null,2, 'Pours a drink', 3,2),
    (4, 3, 2, 2, '09:00:00','11:30:00',20, 'Fights with the antagonist', 4,null);

CREATE TABLE Planning (
    id integer primary key default nextval('planning_id_seq'),
    planningdate timestamp not null,
    act_id integer REFERENCES Act(id) not null
);

CREATE TABLE Limitpage(
    id serial primary key,
    valeur smallint not null default 5
);

INSERT INTO limitpage(valeur) values(5);

CREATE SEQUENCE personne_id_seq start 1 increment 1;
create table personne(
                         id integer primary key default nextval('personne_id_seq'),
                         nom varchar(50),
                         prenom varchar(50)
);
INSERT INTO personne(nom, prenom) VALUES
                                      ('Doe', 'John'),
                                      ('Smith', 'Jane'),
                                      ('Williams', 'Mike'),
                                      ('Brown', 'Sarah'),
                                      ('Taylor', 'David'),
                                      ('Johnson', 'Emily'),
                                      ('Anderson', 'Chris'),
                                      ('Martin', 'Amanda'),
                                      ('Jones', 'Brian'),
                                      ('Wilson', 'Laura');
alter table scene add column auteur_id integer references personne(id);
update scene set auteur_id = id where true;
alter table scene alter column auteur_id set not null;

-- Vue pour le status des scènes avec planifié ou non

CREATE OR REPLACE VIEW v_scenestatus_tmp AS
SELECT s.id scene_id,s.scenestatus_id,COALESCE(count(a.id),0) actions_number from 
Scene s left join Act a on s.id=a.scene_id
group by s.id , s.scenestatus_id;


CREATE OR REPLACE VIEW v_scenestatus_tmp2 AS
SELECT s.scene_id,s.scenestatus_id,s.actions_number,COALESCE(count(p.id),0) planning_actionsNumber from  
Planning p left join Act a on  p.act_id = a.id left join Scene sp on a.scene_id = sp.id
right join v_scenestatus_tmp s on sp.Id = s.scene_id 
group by s.scene_id,s.scenestatus_id,s.actions_number;

CREATE OR REPLACE VIEW v_scenestatus AS
SELECT s.scene_id,case 
  when s.actions_number!=0 and s.actions_number=planning_actionsnumber then 
  'plannifié'
  else st.status 
end status,case 
  when s.actions_number!=0 and s.actions_number=planning_actionsnumber then 
  30
  else st.value
end value
from
v_scenestatus_tmp2 s join SceneStatus st on s.scenestatus_id = st.id;