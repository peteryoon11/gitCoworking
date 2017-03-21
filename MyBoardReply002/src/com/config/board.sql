-- sys
create user board
identified by board;

grant resource,connect
to board;


-- board/board
create table board
( num NUMBER(4) constraints board_num_pk PRIMARY KEY,
  author VARCHAR2(10) NOT NULL,
  title VARCHAR2(100) NOT NULL,
  content VARCHAR2(4000) NOT NULL,
  writeday DATE DEFAULT SYSDATE,
  readcnt NUMBER(4) DEFAULT 0
);

create sequence board_seq;