alter sequence acteurdispo_id_seq restart;
alter sequence plateaudispo_id_seq restart;
alter sequence scene_id_seq restart;
alter sequence act_id_seq restart;
alter sequence planning_id_seq restart;

delete from planning where true;
delete from act where true;
delete from scene where true;
delete from Plateaudispo where true;
delete from acteurdispo where true;