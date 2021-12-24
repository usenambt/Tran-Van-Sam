DELIMITER $$
create procedure updateNameProduct (in oldName varchar(255),in newName varchar(255))
begin
update Products
set productName=newName
where productName=oldName;
end; $$
DELIMITER ;

call updateNameProduct('Chau','Toyota');

select * from products;