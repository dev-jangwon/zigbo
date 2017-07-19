-- interest insert
-- int memberCode, int sellingCode
insert into interest values(1, 1);
insert into interest values(2, 2);
insert into interest values(3, 3);
insert into interest values(4, 4);

-- member insert
-- int memberCode, String email, String password, String phone, String address, String account
insert into member values(1,'ktsvvv@naver.com','1234','01027532415','서울','국민');
insert into member values(2,'abcdef@naver.com','1234','01011111111','경기','신한');
insert into member values(3,'ghijkl@naver.com','1234','01022222222','부산','우리');
insert into member values(4,'mnopqr@naver.com','1234','01033333333','대전','하나');

-- payment insert
-- int paymentCode, int sellingCode, int memberCode, String address
insert into payment values(1,1,1,'서울1');
insert into payment values(2,2,2,'경기1');
insert into payment values(3,3,3,'부산1');
insert into payment values(4,4,4,'대전1');

-- selling insert
-- int sellingCode, int memberCode, int itemCode, int views, String upload, String progress, String location
insert into selling values(1,1,1,100,'20170719','진행','서울');
insert into selling values(2,2,2,200,'20170718','진행','경기');
insert into selling values(3,3,3,300,'20170717','진행','부산');
insert into selling values(4,4,4,400,'20170716','진행','대전');

-- apply insert
-- int applyCode, int requestCode, int memberCode, String detail
insert into apply values(1,1,1,'상세정보1');
insert into apply values(2,2,2,'상세정보1');
insert into apply values(3,3,3,'상세정보1');
insert into apply values(4,4,4,'상세정보1');

-- request insert
-- int requestCode, int itemCode, int memberCode, int views, String upload, String progress, String location
insert into selling values(1,1,1,100,'20170719','진행','서울');
insert into selling values(2,2,2,200,'20170718','진행','경기');
insert into selling values(3,3,3,300,'20170717','진행','부산');
insert into selling values(4,4,4,400,'20170716','진행','대전');

-- item insert
-- int itemCode, String price, String detail, String location, String picture1, String picture2
insert into item values(1, '이름1','1000원','상세정보1','서울','사진1');
insert into item values(2, '이름2','2000원','상세정보2','경기','사진1');
insert into item values(3, '이름3','3000원','상세정보3','부산','사진1');
insert into item values(4, '이름4','4000원','상세정보4','대전','사진1');



commit;