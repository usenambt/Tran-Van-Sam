/*Tao view*/
create view viewProducts as 
select productCode, productName, productPrice, productStatus
from Products;

/*Chinh sua view*/
create or replace view viewProducts as
select productCode, productName, productPrice, productAmount, productStatus
from Products;
/*Drop view*/
drop view viewProducts