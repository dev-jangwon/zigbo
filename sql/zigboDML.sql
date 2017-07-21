
-- member insert
-- int memberCode, String email, String password, String phone, String address, String account
insert into member values(MEMBER_CODE_SEQ.nextval,'김태수@naver.com','1234','01027532415','서울','국민');
insert into member values(MEMBER_CODE_SEQ.nextval,'김소연@naver.com','1234','01011111111','경기','신한');
insert into member values(MEMBER_CODE_SEQ.nextval,'윤인아@naver.com','1234','01022222222','부산','우리');
insert into member values(MEMBER_CODE_SEQ.nextval,'김장원@naver.com','1234','01033333333','대전','하나');
insert into member values(MEMBER_CODE_SEQ.nextval,'김혜경@naver.com','1234','01027532415','서울','국민');
insert into member values(MEMBER_CODE_SEQ.nextval,'최윤진@naver.com','1234','01011111111','경기','신한');
insert into member values(MEMBER_CODE_SEQ.nextval,'홍길동@naver.com','1234','01022222222','부산','우리');
insert into member values(MEMBER_CODE_SEQ.nextval,'성춘향@naver.com','1234','01033333333','대전','하나');


-- item insert
-- int itemCode, String title, String price, String detail, String location, String picture1, String picture2
insert into item values(ITEM_CODE_SEQ.nextval, '위베어 파우치','22000','판매처는 어딘지 정확히 잘모르겠으나 혹시나 여행중에 보신다면 하나씩 총 세개 꼭 부탁드립니다','태국','img/item1.png');
insert into item values(ITEM_CODE_SEQ.nextval, '시로이코이비토','34000','일본면세점에서 구입란 과자입니다','일본','img/item2.png');
insert into item values(ITEM_CODE_SEQ.nextval, 'Benzac','68000','세트 구성으로 좀 저렴하게 치료하실수 있어요.','호주','img/item3.png');
insert into item values(ITEM_CODE_SEQ.nextval, '식기 선물세트','51000','아기를 위한 다채로운 어린이 식기 선물 세트예요','독일','img/item4.png');
insert into item values(ITEM_CODE_SEQ.nextval, '호빵맨바스볼 10개','50000','물에 풀어진후 나오는 장난감','일본','img/item5.png');
insert into item values(ITEM_CODE_SEQ.nextval, '닥스훈트 사냥꾼옷','57000','닥스훈트 사냥꾼옷','미국','img/item6.png');
insert into item values(ITEM_CODE_SEQ.nextval, '제니쿠키','48000','침사추이 "미라도맨션"에 제니쿠키가있습니다','홍콩','img/item7.png');
insert into item values(ITEM_CODE_SEQ.nextval, 'INS MINION','60000','후지필름 즉석 카메라 한정 미니온 콜라보 제품','일본','img/item8.png');

-- selling insert
-- int sellingCode, int memberCode, int itemCode, int views, Date upload, String progress, String location
insert into selling values(SELLING_CODE_SEQ.nextval,1,1,100,sysdate,'W','태국');
insert into selling values(SELLING_CODE_SEQ.nextval,2,2,200,sysdate,'W','일본');
insert into selling values(SELLING_CODE_SEQ.nextval,3,3,300,sysdate,'W','호주');
insert into selling values(SELLING_CODE_SEQ.nextval,4,4,400,sysdate,'W','독일');

-- payment insert
-- int paymentCode, int sellingCode, int memberCode, String address
insert into payment values(PAYMENT_CODE_SEQ.nextval,1,5,'서울');
insert into payment values(PAYMENT_CODE_SEQ.nextval,2,6,'경기');
insert into payment values(PAYMENT_CODE_SEQ.nextval,3,7,'부산');
insert into payment values(PAYMENT_CODE_SEQ.nextval,4,8,'대전');

-- request insert
-- int requestCode, int itemCode, int memberCode, int views, Date upload, String progress, String location
insert into request values(REQUEST_CODE_SEQ.nextval,5,5,100,sysdate,'W','일본');
insert into request values(REQUEST_CODE_SEQ.nextval,6,6,200,sysdate,'W','미국');
insert into request values(REQUEST_CODE_SEQ.nextval,7,7,300,sysdate,'W','홍콩');
insert into request values(REQUEST_CODE_SEQ.nextval,8,8,400,sysdate,'W','일본');

-- apply insert
-- int applyCode, int requestCode, int memberCode, String detail
insert into apply values(APPLY_CODE_SEQ.nextval,1,1,'조심히 다루어주세요.');
insert into apply values(APPLY_CODE_SEQ.nextval,2,2,'최대한 빨리 사다주세요.');
insert into apply values(APPLY_CODE_SEQ.nextval,3,3,'비슷한 것도 상관없습니다.');
insert into apply values(APPLY_CODE_SEQ.nextval,4,4,'천천히 찾아주세요.');

commit;