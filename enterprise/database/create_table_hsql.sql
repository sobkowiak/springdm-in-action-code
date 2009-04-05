CREATE SEQUENCE seq_enterprise_user_iduser AS INTEGER START WITH 1 INCREMENT BY 1; 

create table enterprise_user(iduser integer not null, firstname varchar(255), lastname varchar(255), primary key (iduser));

-- insert sample
-- insert into enterprise_user (iduser,firstname,lastname) values (NEXT VALUE FOR seq_enterprise_user_iduser,'arnaud','cogoluegnes');