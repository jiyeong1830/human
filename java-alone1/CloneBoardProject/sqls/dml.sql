INSERT INTO board(seq, title, contect, create_date, read_count) 
values(seq_board_no.NEXTVAL, '제목입니다1', '내용입니다1', sysdate, 0);
INSERT INTO board(seq, title, contect, read_count) 
values(seq_board_no.NEXTVAL, '제목입니다2', '내용입니다2', 0);
INSERT INTO board(seq, title, contect) 
values(seq_board_no.NEXTVAL, '제목입니다3', '내용입니다3');

SELECT * FROM board;

SELECT seq, title, contect, create_date, read_count FROM board;