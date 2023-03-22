CREATE SEQUENCE auteur_id_seq start 1 increment 1;
create table auteur(
                         id integer primary key default nextval('auteur_id_seq'),
                         nom varchar(50),
                         prenom varchar(50)
);
INSERT INTO auteur(nom, prenom) VALUES
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
alter table scene add column auteur_id integer references auteur(id);
update scene set auteur_id = id where true;
alter table scene alter column auteur_id set not null;