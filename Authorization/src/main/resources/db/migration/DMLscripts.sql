/*** ROLES **/
INSERT INTO roles(name) VALUES('ADMIN');
INSERT INTO roles(name) VALUES('DEVICE'); 

Insert into users (username,password,is_active) values('Admin1','$2a$10$YytGoIeJO8744hYopbKjHeiIRrv9OCmMSzSYgNUmHzvH8DI7tp.fS',true); 
Insert into users (username,password,is_active) values('Admin2','$2a$10$YytGoIeJO8744hYopbKjHeiIRrv9OCmMSzSYgNUmHzvH8DI7tp.fS',true);
Insert into users (username,password,is_active) values('DeviceUser1','$2a$10$YytGoIeJO8744hYopbKjHeiIRrv9OCmMSzSYgNUmHzvH8DI7tp.fS',true);
Insert into users (username,password,is_active) values('DeviceUser2','$2a$10$YytGoIeJO8744hYopbKjHeiIRrv9OCmMSzSYgNUmHzvH8DI7tp.fS',true);


/*** USER ROLES MAPPING **/
insert into user_roles(user_id,role_id) values 
((select user_id from users where username='Admin1'), (select id from roles where name='ADMIN'));

insert into user_roles(user_id,role_id) values 
((select user_id from users where username='Admin2'), (select id from roles where name='ADMIN'));


insert into user_roles(user_id,role_id) values 
((select user_id from users where username='DeviceUser2'), (select id from roles where name='DEVICE'));


/*** USER DEVICE mapping **/
insert into device(device_id) values('D-123');
insert into device(device_id) values('D-456');

insert into vehicle (vin) values('V-123');
insert into vehicle (vin) values('V-456');


Select * from user_device;
insert into user_device(device_id,user_id)  values 
((select id from device where device_id='D-456'), (select user_id from users where username='DeviceUser2')); 

update device set vin='V-123' where device_id='D-123';
update device set vin='V-456' where device_id='D-456';

commit;

