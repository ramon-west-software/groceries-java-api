-- 1. create test REX
insert into groceries.users (user_name, password)
values('Rex', 'password');
select * from groceries.users;
-- 2. create storage area for user / associate storage area to user
insert into groceries.storage_areas (storage_name)
values('Rex fridge');
insert into groceries.user_storage_areas(user_id, storage_id)
values(3,3);-- fridge
insert into groceries.storage_areas (storage_name)
values('Rex freezer');
insert into groceries.user_storage_areas(user_id, storage_id)
values(3,4);-- freezer
insert into groceries.storage_areas (storage_name)
values('Rex pantry');
insert into groceries.user_storage_areas(user_id, storage_id)
values(3,5); -- pantry
select * from groceries.storage_areas;
select * from groceries.user_storage_areas;
-- 3. add categories / associate to storage area
select * from groceries.categories;
select * from groceries.storage_area_categories;
insert into groceries.categories (category_name) values('Drinks');
	insert into groceries.storage_area_categories (storage_id, category_id)
	values(3, 15);
insert into groceries.categories (category_name) values('Dairy');
	insert into groceries.storage_area_categories (storage_id, category_id)
	values(3, 16);
insert into groceries.categories (category_name) values('Produce');
	insert into groceries.storage_area_categories (storage_id, category_id)
	values(3, 17);
insert into groceries.categories (category_name) values('Meats');
	insert into groceries.storage_area_categories (storage_id, category_id)
	values(4, 18);
insert into groceries.categories (category_name) values('Snacks');
	insert into groceries.storage_area_categories (storage_id, category_id)
	values(5, 19);
insert into groceries.categories (category_name) values('Canned Foods');
	insert into groceries.storage_area_categories (storage_id, category_id)
	values(5, 20);
-- 4. add grocery items / associate to categories
insert into groceries.grocery_items (name, purchase_date, item_duration) values ('Orange Juice', '2023-10-09', 14);
select category_id from groceries.categories where category_name = 'Drinks'; -- 15
select grocery_item_id from groceries.grocery_items where name = 'Orange Juice'; -- 3
	insert into category_grocery_items (category_id, grocery_item_id) values (15, 3);
insert into groceries.grocery_items (name, purchase_date, item_duration) values ('Apple Juice', '2023-10-09', 14);
	insert into category_grocery_items (category_id, grocery_item_id) values (15, 4);
insert into groceries.grocery_items (name, purchase_date, item_duration) values ('Coconut Water', '2023-10-09', 14);
	insert into category_grocery_items (category_id, grocery_item_id) values (15, 5);






-- create user Ahsoka
insert into groceries.users (user_name, password)
values('Ahsoka', 'password');
-- create storage areas
insert into groceries.storage_areas (storage_name)
values('Ahsoka fridge');
-- associate storage areas to users
insert into groceries.user_storage_areas(user_id, storage_id)
values(4,6);




-- create user Anakin
insert into groceries.users (user_name, password)
values('Anakin', 'password');
-- create storage areas
insert into groceries.storage_areas (storage_name)
values('Anakin pantry');
insert into groceries.storage_areas (storage_name)
values('Anakin freezer');
-- associate storage areas to users
insert into groceries.user_storage_areas(user_id, storage_id)
values(5,7);
insert into groceries.user_storage_areas(user_id, storage_id)
values(5,8);
-- add categories


