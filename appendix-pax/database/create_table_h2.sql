CREATE SEQUENCE seq_directory_contact_idcontact START WITH 1 INCREMENT BY 1; 

create table directory_contact(idcontact integer not null, firstname varchar(255), lastname varchar(255), primary key (idcontact));

-- insert sample
insert into directory_contact (idcontact,firstname,lastname) values (NEXT VALUE FOR seq_directory_contact_idcontact,'Arnaud','Cogoluegnes');
insert into directory_contact (idcontact,firstname,lastname) values (NEXT VALUE FOR seq_directory_contact_idcontact,'Andy','Piper');
insert into directory_contact (idcontact,firstname,lastname) values (NEXT VALUE FOR seq_directory_contact_idcontact,'Thierry','Templier');