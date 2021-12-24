DELIMITER $$
create procedure deleteNameProduct (in valueName varchar(255))
begin
delete from Products
where productName=valueName;
end; $$
DELIMITER ;

call deleteNameProduct('Toyota');

select * from products;