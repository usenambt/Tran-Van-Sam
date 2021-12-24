DELIMITER $$
create procedure selectProduct()
begin
select * from Products;
end; $$
DELIMITER ;

call selectProduct;