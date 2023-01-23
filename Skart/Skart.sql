 use Skart;
select * from Register;

create database Skart;
create table Register(RegNo int auto_increment ,RegisterName varchar(25),Age int,Username varchar(25) unique,Password varchar (25),Address varchar (50) ,PRIMARY KEY (RegNo));
drop table Admin;
select * from Register;

update Register set Password="Saran@2001" where RegNo=2;
drop table Register;
delete from Register where RegNo=2;
create table Admin( userName varchar(24),password varchar(12));
insert into Admin values ("1234","@#123");
select * from Admin;


create table Products(productId int auto_increment primary key not null,productImageUrl varchar (500),productName varchar(100),productDecription varchar(500),productPrice int,productCount int,vendorId   varchar(50)  );
drop table Products;
insert into Products values  ( 1,"https://rukminim1.flixcart.com/image/416/416/kd1zngw0/headphone/v/k/n/tws-l21-mini-wireless-bluetooth-headset-earphone-dayneo-original-imafuf4ffbvgxckc.jpeg?q=70","DAYNEO Bluetooth Earphone","Dayneo TrueWireless stereo technology, enjoy with earbuds.",498,500,"mac@gmail.com");

							
select * from Products;
update Products  set productDecription="You can use the LG 8 kg Fully Automatic Front-loading Washing Machine for washing clothes and saving time for other chores. 
" where productId=7; 
delete from Products where productId=5;


create table DeliveryAddress(
deliveryId int primary key  auto_increment,
streetAddress varchar (25),
  town_city varchar(25),
  state_county varchar (20),
  postcode_zip varchar(20),mobno bigint ,foreign key (deliveryId) REFERENCES customerOrders(orderId) ON DELETE cascade on update no action);
  
drop table DeliveryAddress;

select * from Products;


CREATE TABLE customerOrders(
orderId int auto_increment primary key,
imageurl  varchar(700),
customer_id varchar(50),
productName  varchar(50),
productPrice int,
productQny int,
paymentType varchar (30),
deliveryCharge int,
orderDate varchar (12),
vendorname varchar (30),
totalcost int
);



alter table customerOrders add totalcost int;
alter table customerOrders change column orderId  orderId primary key ;
drop table customerOrders;


create table Vendor (supplierId int  auto_increment primary key ,supplierName varchar (50),companyName varchar (50),username varchar(50)  ,password varchar(20),email varchar (30) ,mobNo bigint ,checked tinyint);
drop table Vendor;
select * from Vendor;


select concat('skart', LPAD(orderId, 3, 0)) as orderId,customer_id,productId,orderDate  from customerOrders;
Drop table customerOrders;
delete   from   mobileNumber;j
delete   from   mobileNumber;
ALTER TABLE customerOrders
DROP COLUMN mobileNumber;

delete from   DeliveryAddress where deliveryId=1;
delete from customerOrders where orderId=124;
select * from Products; 
drop table Products;

update  Register set Password='Saran' where Username='saranramasamy864@gmail.com';
ALTER TABLE  DeliveryAddress  AUTO_INCREMENT=100;
ALTER TABLE  customerOrders AUTO_INCREMENT=100;
select * from DeliveryAddress;
select * from customerOrders;
update  Products set  productCount=productCount+7 where productId=1;
select * from  DeliveryAddress where (select orderId  from customerOrders where vendorname= 'Apple123' )=deliveryId limit 0,100;

 
SELECT  concat( 'skart ',LPAD(deliveryId, 3, 0)) as deliveryId, streetAddress,town_city,state_county,postcode_zip,mobno
FROM DeliveryAddress as d
INNER JOIN customerOrders as c
ON d.deliveryId=c.orderId;

create table Mycart (cardId int primary key auto_increment ,CusId varchar(50) ,prodId int , FOREIGN KEY (CusId) REFERENCES Register(Username),FOREIGN KEY (prodId) REFERENCES Products(productId));
select * from Mycart;
insert into Mycart values(1, 'saransugan864@gmail.com', 1) where prodId!=1;
drop table Mycart;
ALTER TABLE Mycart
DROP INDEX prodId;
select m.prodId,p.productImageUrl,p.productName,p.productPrice 
from Products as p,Mycart as m
where m.prodId=p.productId and m.CusId='';
delete from Vendor where supplierId=7;
delete from Mycart where CusId=? and prodId=?;
update Register set password ='Saran@864'where Username='saransugan864@gmail.com';
delete from Products where productId=1;
select * from Admin;
select * from Register;
select * from Vendor;
select * from Products;
select * from Mycart;
select * from customerOrders;
select * from DeliveryAddress;

update  Products set productDecription='24-bit Hi-Fi audio. The upgraded Samsung Seamless Codec encodes the full 24-bit audio and is decoded via Galaxy Buds2 Pro, 24-bit high-quality sound with Smooth Wear buds' where productId=7;

delete from customerOrders where orderId=3;

