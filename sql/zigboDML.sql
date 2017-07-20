
-- member insert
-- int memberCode, String email, String password, String phone, String address, String account
insert into member values(1,'ktsvvv@naver.com','1234','01027532415','����','����');
insert into member values(2,'abcdef@naver.com','1234','01011111111','���','����');
insert into member values(3,'ghijkl@naver.com','1234','01022222222','�λ�','�츮');
insert into member values(4,'mnopqr@naver.com','1234','01033333333','����','�ϳ�');

-- item insert
-- int itemCode, String price, String detail, String location, String picture1, String picture2
insert into item values(1, '�̸�1','1000','������1','����','����1');
insert into item values(2, '�̸�2','2000','������2','���','����1');
insert into item values(3, '�̸�3','3000','������3','�λ�','����1');
insert into item values(4, '�̸�4','4000','������4','����','����1');

-- selling insert
-- int sellingCode, int memberCode, int itemCode, int views, Date upload, String progress, String location
insert into selling values(1,1,1,100,sysdate,'W','����');
insert into selling values(2,2,2,200,sysdate,'W','���');
insert into selling values(3,3,3,300,sysdate,'W','�λ�');
insert into selling values(4,4,4,400,sysdate,'W','����');

-- payment insert
-- int paymentCode, int sellingCode, int memberCode, String address
insert into payment values(1,1,1,'����1');
insert into payment values(2,2,2,'���1');
insert into payment values(3,3,3,'�λ�1');
insert into payment values(4,4,4,'����1');

-- request insert
-- int requestCode, int itemCode, int memberCode, int views, Date upload, String progress, String location
insert into request values(1,1,1,100,sysdate,'W','����');
insert into request values(2,2,2,200,sysdate,'W','���');
insert into request values(3,3,3,300,sysdate,'W','�λ�');
insert into request values(4,4,4,400,sysdate,'W','����');

-- apply insert
-- int applyCode, int requestCode, int memberCode, String detail
insert into apply values(1,1,1,'������1');
insert into apply values(2,2,2,'������1');
insert into apply values(3,3,3,'������1');
insert into apply values(4,4,4,'������1');

-- interest insert
-- int memberCode, int sellingCode
insert into interest values(1, 1);
insert into interest values(2, 2);
insert into interest values(3, 3);
insert into interest values(4, 4);

commit;