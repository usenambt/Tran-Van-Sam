create database demo;
use demo;
create table Products(
id int not null primary key,
productCode varchar(255) not null,
productName varchar(255) not null,
productPrice int not null,
productAmount int not null,
productDescription varchar(255) default null,
productStatus varchar(255) default null
);
insert into Products(id, productCode,productName,productPrice,productAmount,productDescription,productStatus)
VALUES (1,"1DA62855-9080-D5CC-0D57-EDF0F5EC933C","Lisandra","5.96",100,"cursus. Integer mollis. Integer tincidunt","amet"),(2,"D3EF204C-FA04-7794-22BB-E50C6A48A4B7","Aspen","7.81",68,"ipsum porta elit, a feugiat tellus lorem eu metus.","velit eu sem. Pellentesque ut ipsum ac"),(3,"47601353-B446-9D44-C5BD-1639C8206FFD","Hasad","4.71",81,"semper, dui lectus","tristique ac, eleifend vitae, erat."),(4,"93BA05D0-093E-2601-858D-B3BC3B7AFF88","Armando","6.22",54,"sapien, gravida non, sollicitudin a, malesuada id, erat.","pede. Suspendisse dui. Fusce diam nunc, ullamcorper eu, euismod"),(5,"F02280EA-DBFD-1535-A899-727451312522","Nell","9.34",31,"enim non nisi. Aenean","consectetuer"),(6,"5BF12108-ABD6-17C4-FBF1-8DCA370B4196","Martin","8.37",29,"vulputate","velit justo"),(7,"8EAD2891-5317-EEC3-41A6-2D83D813B1EA","Ray","4.57",27,"vel sapien imperdiet ornare. In faucibus. Morbi vehicula.","quis turpis vitae purus gravida sagittis. Duis gravida."),(8,"1C85E0BC-6670-3DE3-B01A-0D9E25886F8B","Aurora","7.24",61,"mauris","Vivamus rhoncus. Donec est."),(9,"F7545849-17F0-3E6E-227E-901588924AE5","Hamilton","8.65",30,"magnis dis","gravida. Praesent eu nulla"),(10,"81366215-CD99-EA43-034A-8F2BD9352A9C","Abdul","4.31",59,"vel","lobortis. Class aptent taciti sociosqu ad");
