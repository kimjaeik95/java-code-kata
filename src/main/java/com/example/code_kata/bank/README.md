## JDBC를 학습을 위해 간단한 은행 계좌 관리 시스템을 구현했습니다.
### 고객 생성, 계좌 생성, 조회, 수정, 삭제 및 계좌 이체 기능을 포함합니다.


### 🔐 JDBC 사용 방식  (JdbcTemplate 방식 X)
1. PreparedStatement 사용 (SQL Injection 방지)
2. executeQuery() → SELECT
3. executeUpdate() → INSERT / UPDATE / DELETE