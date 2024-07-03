INSERT INTO shoppingmallboard(seq, title, content, create_date, price) 
values(seq_board_no.NEXTVAL, '나시원피스', '검은색 Free사이즈', sysdate, 17800);
INSERT INTO shoppingmallboard(seq, title, content, create_date, price) 
values(seq_board_no.NEXTVAL, '테니스스커트', '베이색 S사이즈', sysdate, 13000);
INSERT INTO shoppingmallboard(seq, title, content, create_date, price) 
values(seq_board_no.NEXTVAL, '무지티셔츠', '흰색 M사이즈 ', sysdate, 9900);

SELECT * FROM shoppingmallboard;

SELECT seq, title, content, create_date, price FROM shoppingmallboard;

ALTER TABLE shoppingmallboard ADD update_date DATE; 