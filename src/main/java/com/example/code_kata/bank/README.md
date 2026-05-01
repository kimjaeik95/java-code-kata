## JDBC를 학습을 위해 간단한 은행 계좌 관리 시스템을 구현했습니다.
### 고객 생성, 계좌 생성, 조회, 수정, 삭제 및 계좌 이체 기능을 포함합니다.


### 🔐 JDBC 사용 방식  (JdbcTemplate 방식 X)
1. PreparedStatement 사용 (SQL Injection 방지)
2. executeQuery() → SELECT
3. executeUpdate() → INSERT / UPDATE / DELETE


### JDBC config 수동방식
application.yml에 DataSource를 설정하지 않고 DriverManager로 JDBC를 수동 관리하면,
Spring의 트랜잭션 관리가 적용되지 않기 때문에 개발자가 직접 Connection 생성,
commit/rollback, close까지 모두 처리해야 한다.
또한 커넥션 풀을 사용하지 못하고 @Transactional 같은 Spring 기능도 사용할 수 없다.

단순 CRUD에서는 수동 JDBC 방식도 문제가 없지만,
여러 DAO가 동시에 동작하는 비즈니스 로직에서는 동일한 Connection을 유지하며 트랜잭션을 관리하는 것이 중요하다.
이 과정에서 JdbcTemplate을 사용하면 커넥션 관리와 트랜잭션 처리를 Spring이 자동으로 처리해주기 때문에
코드가 간결해지고 안정성이 높아진다는 점을 느꼈다.