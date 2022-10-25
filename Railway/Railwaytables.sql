drop database railwayreservation;
create database RailwayReservation;
create table Passenger(
Pass_no int primary key auto_increment ,
Pass_name varchar(25),
Pass_age int ,
Pass_gender varchar(1),
Pass_address varchar (60),
Pass_email varchar (30),
pass_pass varchar(15));

create table Train (
Train_no int primary key,
Train_name varchar(25)
);

create table Location 
(
Train_no int ,
Train_from varchar (25) ,
Train_to varchar (25),
foreign key (Train_no)references Train(Train_no)
);

create table Seat ( 
Train_no int ,
Upper_seat int ,
Lower_seat int ,
RAC_seat int,
Ticket_cost Double,
foreign key (Train_no)references Train(Train_no)
);

create table Booking (
Booking_id int auto_increment primary key,
PNR_no int ,
Train_no int ,
Ticket_no int,
Date_time varchar(25),

foreign key (Train_no)references Train(Train_no));

create table Payment(
Payment_id int primary key auto_increment,
Booking_id int,
ticket_cost Double ,
Date_time varchar (20),
foreign key (Booking_id)references Booking(Booking_id));
select * from Passenger;
select * from Train;
select * from Bookings;
select * from Location;
select * from Seat;
select * from Payment;
