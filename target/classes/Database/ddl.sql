-- Base tables
CREATE TABLE users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE storage_areas (
    storage_id INT PRIMARY KEY AUTO_INCREMENT,
    storage_name VARCHAR(255) NOT NULL
);

CREATE TABLE categories (
    category_id INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(255) NOT NULL
);

CREATE TABLE grocery_items (
    grocery_item_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    purchase_date Date,
    item_duration INT
);

-- user cross reference tables
CREATE TABLE user_storage_areas (
    user_storage_area_id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    storage_id INT,
	KEY user_idx (user_id),
	KEY storage_idx (storage_id)
);

-- REDUNDANT AND UNNECESSARY
-- CREATE TABLE user_categories (
--     user_category_id INT PRIMARY KEY AUTO_INCREMENT,
--     user_id INT,
--     category_id INT,
-- 	KEY user_idx (user_id),
-- 	KEY category_idx (category_id)
-- );

-- CREATE TABLE user_grocery_items (
--     user_grocery_item_id INT PRIMARY KEY AUTO_INCREMENT,
--     user_id INT,
--     grocery_item_id INT,
--     KEY user_idx (user_id),
-- 	KEY grocery_item_idx (grocery_item_id)
-- );

-- storage/category/groceries cross reference
CREATE TABLE storage_area_categories (
    category_storage_id INT PRIMARY KEY AUTO_INCREMENT,
    storage_id INT,
    category_id INT,
    KEY storage_idx (storage_id),
	KEY category_idx (category_id)

);

CREATE TABLE category_grocery_items (
    category_grocery_item_id INT PRIMARY KEY AUTO_INCREMENT,
    category_id INT,
    grocery_item_id INT,
	KEY category_idx (category_id),
	KEY grocery_item_idx (grocery_item_id)
);


-- ADD USER
-- create new user
insert into groceries.users (user_name, password)
values ('Molly', 'password');
-- validate record
select u.user_id from users u where user_name = 'Molly';

-- ADD STORAGE
-- create new storage area
insert into groceries.storage_areas (storage_name)
values ("Refrigerator");
-- validate insert
select sa.storage_id from groceries.storage_areas sa;

-- relate storage to user
insert into groceries.user_storage_areas (user_id, storage_id)
values (2,2);
-- validate insert to user_storage_areas
select * from groceries.user_storage_areas where user_id = 2;

-- ADD CATEGORY
-- create new category
insert into groceries.categories (category_name)
values ("Fruits"); -- insert to stg_categories, then merge?
-- validate insert
select c.* from groceries.categories c;

-- REDUNDANT AND UNNECESSARY
-- relate category to user
-- insert into groceries.user_categories (user_id, category_id)
-- values (1,1);
-- validate insert to user_categories
-- select * from groceries.user_categories where user_id = 1;

-- relate category to storage
insert into groceries.storage_area_categories (storage_id, category_id)
values (2,2);
-- validate insert to storage_area_categories
select * from groceries.storage_area_categories;

-- ADD GROCERY ITEM
-- create new grocery item
insert into grocery_items (name, item_duration, purchase_date)
values ('Strawberries', 8, '2023-10-31');
-- validate insert
select * from grocery_items;

-- UNNECESSARY / REDUNDANT
-- relate item to user
-- insert into groceries.user_grocery_items (user_id, grocery_item_id)
-- values (1,1);
-- validate insert
-- select * from groceries.user_grocery_items;

-- relate item to category
insert into groceries.category_grocery_items (category_id, grocery_item_id)
values (2,3);
-- validate insert
select * from groceries.category_grocery_items;



-- SELECT ALL DATA BY USER
select sa.storage_id, sa.storage_name, c.category_id, c.category_name, item.grocery_item_id, item.name, item.item_duration, item.purchase_date
from groceries.user_storage_areas usa
left join groceries.storage_areas sa
on sa.storage_id = usa.storage_id
left join groceries.storage_area_categories sac
on sac.storage_id = sa.storage_id
left join groceries.categories c
on sac.category_id = c.category_id
left join groceries.category_grocery_items cgi
on cgi.category_id = c.category_id
left join groceries.grocery_items item
on item.grocery_item_id = cgi.grocery_item_id
where usa.user_id = 3
group by sa.storage_id, sa.storage_name, c.category_id, c.category_name, item.grocery_item_id, item.name, item.item_duration, item.purchase_date;


-- select user storage areas
SELECT sa.storage_id, storage_name 
            FROM users u 
            JOIN user_storage_areas usa ON u.user_id = usa.user_id 
            JOIN storage_areas sa ON usa.storage_id = sa.storage_id
            WHERE u.user_id = 3;
