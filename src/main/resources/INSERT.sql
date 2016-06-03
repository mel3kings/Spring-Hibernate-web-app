insert into business(business_name, business_address, business_city, description)
Values('scumbusiness','Philippines based scumbusiness', 'Manila', 'testing account for initial testing purposes');

insert into customer(user_id, business_id, name, address,city,email, mobile_number, telephone_number, parent,customer_type, parent_user_id)
select 'melt_321',business_id,'Melchor','Singapore Address','SG','meltatlonghari3@gmail.com','12341234','12341234',1,'ADMIN',null
 from business where business_name='scumbusiness';
 
 insert into album(customer_user_id, location, title, name, description, date)
select user_id, 'Singapore Jurong West Address', 'Farewell Party', 'System_Generated_Album_Name','Test Album',
curdate() from customer where user_id = 'melt_321';

insert into media (album_id, media_name, media_location, media_type) 
select album_id,'System_generated_name.avi','/resources/movies/', 'VIDEO' from album where title='Farewell Party';
