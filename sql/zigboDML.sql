-- comment insert
-- int divisionCode, int textCode, int memberCode, String comment, String reply

insert into comment values(16,'i7-7700','GTX 980','8G','HDD');

-- interest insert
-- int memberCode, int sellingCode
insert into interest values(4,'±è¼Ò¿¬');

-- member insert
-- String email, String password, String phone, String address, String account
insert into member values(8,'HDD');

-- payment insert
-- int paymentCode, int sellingCode, int memberCode, String address
insert into payment values(4,4,15);

-- selling insert
-- int memberCode, int itemCode, String location
insert into selling values(1,1,1);

-- apply insert
-- int applyCode, int requestCode, int memberCode, String detail
insert into apply values(1,1,1);

-- request insert
-- int requestCode, int itemCode, int memberCode, int views, String progress, String location
insert into request values(1,1,1);

-- item insert
-- int itemCode, String price, String detail, String location, String picture1, String picture2
insert into item values(1,1,1);

commit;