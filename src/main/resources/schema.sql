drop table if exists Taco_Order;
drop table if exists Taco;
drop table if exists Ingredient;
drop table if exists Ingredient_Ref;

create table if not exists Taco_Order (
id identity,
delivery_Name varchar(50) not null,
delivery_Street varchar(50) not null,
delivery_City varchar(50) not null,
delivery_State varchar(2) not null,
delivery_Zip varchar(10) not null,
cc_number varchar(16) not null,
cc_expiration varchar(5) not null,
cc_cvv varchar(3) not null,
placed_at timestamp not null,
user_id bigint not null
);

create table if not exists User (
id bigint primary key,
user_Name varchar(50) not null,
password varchar(50) not null,
user_Fullname varchar(3) not null,
user_Street varchar(50) not null,
user_City varchar(50) not null,
user_State varchar(2) not null,
user_Zip varchar(10) not null,
user_PhoneNumber varchar(16) not null
);

create table if not exists Taco (
id identity,
name varchar(50) not null,
taco_order bigint not null,
taco_order_key bigint not null,
created_at timestamp not null
);

create table if not exists Ingredient (
id varchar(4) not null primary key,
name varchar(25) not null,
type varchar(10) not null
);

create table if not exists Ingredient_Ref (
ingredient varchar(4) not null,
taco bigint not null,
taco_key bigint not null);

alter table Taco add foreign key (taco_order) references Taco_Order(id);
alter table Ingredient_Ref add foreign key (ingredient) references Ingredient(id);
alter table Taco_Order add foreign key (user_id) references User(id);
--alter table Ingredient_Ref add foreign key (taco) references Taco(id);