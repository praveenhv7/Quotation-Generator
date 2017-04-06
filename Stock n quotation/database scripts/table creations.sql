CREATE SEQUENCE supplier_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
 commit;


create table arbutus_Supplier_info
(
supplier_name varchar2(50) unique,
supplier_number number  primary key 
)

commit;

insert into arbutus_Supplier_info values('PANASONIC',supplier_seq.nextval);

select * from arbutus_Supplier_info;

delete from arbutus_Supplier_info where supplier_name='ASDAS';

create table arbutus_items_info
(
supplier_number number,
item_name varchar2(25),
description varchar2(50),
spq number,
moq number,
lead_time varchar2(25),
primary key(supplier_number,item_name),
foreign key(supplier_number) references arbutus_Supplier_info(supplier_number)
);


select * from arbutus_items_info

delete from arbutus_items_info where supplier_number=4

insert into arbutus_items_info values(1,'EEUEE2D470','')

ALTER TABLE arbutus_items_info
ADD unit_price number(6,2);

insert into arbutus_items_info values    (1,    'EEUEE2D470','47mfd,200V,12.5 x 20, 1000 H',100,2000,'10-12 Weeks',2500,32);
                    
insert into arbutus_items_info values    (1,    'EEUFR1H100','10mfd,50V,5 x 11 8000 H',0,0,'4 Weeks',6000,8.75);
                    
insert into arbutus_items_info values    (1,    'EEUFR1H4R7','4.7mfd, 50V, 5 x 11 8000 H',200,1000,'10-12 Weeks',1000,10.75);
                    
insert into arbutus_items_info values    (1,    'EEHFR1H101','100mfd, 50V, 8 x 11 8000 H',0,0,'4 Weeks',1500,15.5);
                    
insert into arbutus_items_info values    (1,    'EECF5RH105','Super Capacitor',100,2000,'10-12 Weeks',1000,185);                    


create table arbutus_customer_info
(
company_name varchar2(30),
customer_name varchar2(40),
customer_mob_number number,
division varchar2(20),
address varchar2(100),
designation varchar2(10),
creation_date date,
primary key(company_name,customer_name)
);

desc arbutus_customer_info

ALTER TABLE arbutus_customer_info
ADD UNIQUE (customer_mob_number);

ALTER TABLE arbutus_customer_info
drop column arbutus_customer_id;

ALTER TABLE arbutus_customer_info
drop column  arbutus_customer_id ;


CREATE SEQUENCE QUOTATION_SEQ
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
 commit;
 
 drop SEQUENCE QUOTATION_SEQ;
 
 drop table quotation_customer;

create table quotation_customer
(
company_name varchar2(30),
customer_name varchar2(40),
quotation_id number,
QUOTATION_NUM VARCHAR2(10),
PRICE varchar2(50),
SALES_TAX number(5,2),
PAYMENT number(5,2),
FREIGHT_CHARGES varchar2(50),
VALIDITY varchar2(25),
NOTE varchar2(50),
REMARKS varchar2(50),
PRIMARY KEY(QUOTATION_NUM),
foreign key(company_name,customer_name) references arbutus_customer_info(company_name,customer_name)
);

select * from quotation_customer

delete from quotation_customer;

create table quotation_items
(
QUOTATION_NUM VARCHAR2(10),
supplier_number number,
item_name varchar2(25),
foreign key(QUOTATION_NUM) references quotation_customer(QUOTATION_NUM),
foreign key(item_name,supplier_number) references arbutus_items_info(item_name,supplier_number)
)

select * from quotation_items

delete from  quotation_items

drop table quotation_items

commit;

insert into arbutus_customer_info values('Konark Industria Pvt Ltd','Seshadri',1234567890,'SALES','Konark Industria Pvt Ltd, No.22, Industrial Lay-out, Banashankari 2nd Stage, Bangalore 560 070','MANAGER',sysdate);


select customer_name,address from  arbutus_customer_info where company_name='Konark Industria Pvt Ltd';

desc arbutus_customer_info 


ALTER TABLE arbutus_customer_info
ADD  SALES_TAX number(3,2);

ALTER TABLE arbutus_customer_info
ADD  VAT number(3,2);

commit


ALTER TABLE arbutus_customer_info
ADD  VAT number(3,2);


ALTER TABLE arbutus_customer_info
MODIFY  VAT FLOAT ;

select * from arbutus_customer_info

select * from quotation_customer

select * from arbutus_customer_info