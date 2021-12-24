insert into customers
values(1,'Tran Thanh Phuong','ttphuong172@gmail.com','Quang Nam','0915010414');
insert into accounts
values(0101031188,1,'VIP','2020-01-01',400);

DELIMITER $$
create procedure selectAccount()
begin
select * from customers;
end; $$
DELIMITER ;

call selectAccount();

DELIMITER $$
create procedure selectAccount1(in cusNum int)
begin
select * from customers where customer_number=cusNum;
end; $$
DELIMITER ;

call selectAccount1(1);