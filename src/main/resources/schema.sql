create table beer (
id varchar,
beer_name varchar (36),
beer_style varchar (36),
created_date DATE,
last_modified_date DATE,
min_on_hand bigserial,
quantity_to_brew bigserial,
price bigserial,
upc varchar (36),
version bigserial
);