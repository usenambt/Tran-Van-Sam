/*Viet cau lenh hien thi tat ca cac dong co ten Huong*/
select * from sinhvien where ten='Huong';
/*Viet cau lenh lay ra tong so tien cua Huong*/
select ten,sum(sotien) from sinhvien where ten='Huong' group by ten;
/*Viet cau lenh lay ra ten danh sach hoc vien khong trung lap*/
select distinct ten from sinhvien