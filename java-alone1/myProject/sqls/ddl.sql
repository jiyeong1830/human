CREATE TABLE shoppingmallboard( 
	seq          NUMBER         PRIMARY KEY,      -- 상품 번호
	title         VARCHAR2(300)  NOT NULL,         -- 상품명
	content      clob           NOT NULL,         -- 상품 설명 
	create_date  DATE           DEFAULT sysdate,  -- 상품 등록일자(값이 없으녀 현재날짜로 등록이 됨)
	price        NUMBER                           -- 상품 가격
); 

-- comment 등록 sql품
COMMENT ON COLUMN shoppingmallboard.seq IS '상품 번호';
COMMENT ON COLUMN shoppingmallboard.title IS '상품 이름';
COMMENT ON COLUMN shoppingmallboard.content IS '상품 설명';
COMMENT ON COLUMN shoppingmallboard.create_date IS '상품 등록일자';
COMMENT ON COLUMN shoppingmallboard.price IS '가격';

-- sequence 생성
CREATE SEQUENCE seq_shoppingmallboard_no 
       INCREMENT BY 1 
       START WITH 1
;