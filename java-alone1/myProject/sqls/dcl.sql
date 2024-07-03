ALTER SESSION SET "_ORACLE_SCRIPT"=TRUE
;

-- 1. 사용자 계정 생성
CREATE USER boarduser1 IDENTIFIED BY 1234
;
-- 4. 계정 권한 부여
GRANT resource, dba, CONNECT TO boarduser1
;

--test계정에 테아블 생성 권한 부여
GRANT CREATE ANY TABLE TO boarduser1
;