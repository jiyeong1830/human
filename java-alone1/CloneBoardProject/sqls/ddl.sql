-- 게시판 테이블
DROP TABLE board;

CREATE TABLE board( 
	seq          NUMBER         PRIMARY KEY,      -- 게시판 번호
	title        VARCHAR2(300)  NOT NULL,         -- 게시판 제목
	contect      clob           NOT NULL,         -- 게시판 내용 
	create_date  DATE           DEFAULT sysdate,  -- 게시판 등록일자(값이 없으녀 현재날짜로 등록이 됨)
	read_count   NUMBER                           -- 게시판 조회수
); 

-- comment 등록 sql
COMMENT ON COLUMN board.seq IS '게시판 번호';
COMMENT ON COLUMN board.title IS '게시판 제목';
COMMENT ON COLUMN board.contect IS '게시판 내용';
COMMENT ON COLUMN board.create_date IS '게시판 등록일자';
COMMENT ON COLUMN board.read_count IS '게시판 조회수';

-- sequence 생성
CREATE SEQUENCE seq_board_no 
       INCREMENT BY 1 
       START WITH 1
;

-- 수정일자 컬럼 추가
ALTER TABLE board ADD update_date DATE; 

CREATE TABLE member(
	seq             NUMBER            PRIMARY KEY,
	name            VARCHAR2(300)     NOT NULL,
	create_date     DATE              DEFAULT sysdate
);

--board 테이블에 글 작성한 회원 번호 컬럼 추가
ALTER TABLE board ADD member_seq NUNBER;

--board와 member 테이블 간의 fk설정
ALTER TABLE board ADD CONSTRAINT fk_board_member
FOREIGN KEY(member_seq) REFERENCES member(seq)
;