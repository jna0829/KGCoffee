create table map_table(

	  address_name varchar2(200)
	  ,category_group_code varchar2(200)
	  ,category_group_name varchar2(200)
	  ,category_name varchar2(200)
	  ,map_id number constraint map_id_pk primary key
	  ,place_name varchar2(200)
	  ,place_url varchar2(200)
	  ,phone varchar2(200)
	  ,road_address_name varchar2(200)
	  ,x number
	  ,y number
	


) ;


create table cart(
cart_id number constraint cart_id_pk primary key;
,user_id number constraint cart_user_id_fk foreign key(users.user_id) on delete cascade not null;
,menu_id number constraint cart_menu_id_fk foreign key(Menu.menuId) on delete cascade not null;
,menu_name varchar2(200)
,menu_price number
,menu_imgurl varchar2(200)
,menu_amount number
)
