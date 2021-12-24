create database thuvien;
use thuvien;

create table tinhthanhpho(
matinhthanhpho int not null primary key,
tentinhthanhpho varchar(50) not null,
kieutinhthanhpho varchar(10) not null
);
create table quanhuyen(
maquanhuyen int not null primary key,
tenquanhuyen varchar(50) not null,
kieuquanhuyen varchar(10) not null,
matinhthanhpho int not null,
foreign key (matinhthanhpho) references tinhthanhpho(matinhthanhpho)
);
create table phuongxa(
maphuongxa int not null primary key,
tenphuongxa varchar(50) not null,
kieuphuongxa varchar(10) not null,
maquanhuyen int not null,
foreign key(maquanhuyen) references quanhuyen(maquanhuyen)
);

create table nhaxuatban(
manxb int not null primary key,
tennxb varchar(50) not null,
chitietnxb text default null
);
create table theloai(
matheloai int not null primary key,
tentheloai varchar(50) not null
);
create table tacgia(
matacgia int not null primary key,
tentacgia varchar(50) not null,
namsinh date default null,
chitiettacgia text default null
);
create table sach(
masach int not null primary key,
tensach varchar(100) not null,
manxb int not null,
matacgia int not null,
namxuatban year not null,
solanxuatban smallint not null,
gia int not null,
matheloai int not null,
foreign key (manxb) references nhaxuatban(manxb),
foreign key (matacgia) references tacgia(matacgia),
foreign key (matheloai) references theloai(matheloai)   
);
create table sinhvien(
masv int not null primary key,
tensv varchar(50) not null,
maphuongxa int not null,
email varchar(50) default null,
anhsv varchar(100) default null,
foreign key (maphuongxa) references phuongxa(maphuongxa)
);
create table muonsach(
masach int not null,
masv int not null,
ngaymuon date not null,
ngaytraquydinh date not null,
ngaytrathucte date default null,
tienphat int default null,
trangthai varchar(50) default null,
primary key(masach, masv),
foreign key (masach) references sach(masach),
foreign key (masv) references sinhvien(masv)
);