DELIMITER $$
create procedure insertProduct(in id int, in productCode varchar(255), in productName varchar(255), in productPrice int, in productAmount int, in productDescription varchar(255), in productStatus varchar(255) )
begin
insert into products
values
(id,productCode,productName,productPrice,productAmount,productDescription,productStatus);
end; $$
DELIMITER ;

call insertProduct(12,'Ford','Chau',100,1,'Tot','Chua su dung');