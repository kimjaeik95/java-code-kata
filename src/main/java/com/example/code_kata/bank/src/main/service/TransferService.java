package com.example.code_kata.bank.src.main.service;

import com.example.code_kata.bank.src.main.config.JdbcConfig;
import com.example.code_kata.bank.src.main.dao.AccountDao;
import com.example.code_kata.bank.src.main.dao.TransferDao;
import com.example.code_kata.bank.src.main.domain.Account;
import com.example.code_kata.bank.src.main.dto.TransferRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import java.sql.Connection;
import java.sql.SQLException;

/**
 * packageName    : com.example.code_kata.bank.src.main.service
 * fileName       : TransferService
 * author         : JAEIK
 * date           : 5/1/26
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 5/1/26        JAEIK       최초 생성
 */
@RequiredArgsConstructor
@Service
public class TransferService {
     /*  A와 B의 계좌를 조회한다.
         검증
         - A , B 계좌 존재
         - if A 잔액 >= 송금 금액
         - if 계좌가 자기자신인지 확인
         (A가 B에 송금을 한다.)
        A balance 송금한 만큼  금액을 차감한다. update A
        B balance 받은 만큼 금액을 올린다.  update B
        둘다 성공하면 commit  else rollback
     */
    private final AccountDao accountDao;
    private final TransferDao transferDao;


    /*
        여러 커넥션이 지금 두개 연결되어있어서 트랜잭션이 깨질 위험이 있다.
        JdbcTemplate은 내부적으로 동일한 Connection을 사용하도록 도와주지만,
        수동 JDBC 방식에서도 하나의 Connection만 일관되게 사용해야한다.

        application.yml에 DataSource를 설정하지 않고 config 클래스에 DriverManager로 JDBC를 수동 관리했다.
        그 결과 Spring의 트랜잭션 관리가 적용되지 않기 때문에 개발자가 직접 Connection 생성,
        commit/rollback, close까지 개발자가 처리해야 한다.
        스프링이 관리하는게 아니라 커넥션 풀을 사용하지 못하고 @Transactional 같은 Spring 기능도 사용할 수 없다.
     */
    public Account tranceFer(TransferRequest transferRequest) {
        Connection con = null;
        if (transferRequest.getFromAccountId().equals(transferRequest.getToAccountId())) {
            throw new IllegalArgumentException("본인 계좌에 이체 불가능합니다.");
        }

        try {
            con = JdbcConfig.getConnection();
            con.setAutoCommit(false); // 자동커밋안하고 한번에 해야함
            Account myAccount = accountDao.transacFindById(con, transferRequest.getFromAccountId())
                    .orElseThrow(() -> new IllegalArgumentException("계좌가 없습니다."));

            Account tranceFerAccount = accountDao.transacFindById(con, transferRequest.getToAccountId())
                    .orElseThrow(() -> new IllegalArgumentException("계좌가 없습니다."));


            // A 계좌 금액 차감
            myAccount.minusAmount(transferRequest.getAmount());
            // B 계좌 금액 플러스
            tranceFerAccount.plusAmount(transferRequest.getAmount());

            transferDao.updateBalance(con, myAccount.getId(), myAccount.getBalance());
            transferDao.updateBalance(con, tranceFerAccount.getId(), tranceFerAccount.getBalance());
            con.commit();
            return myAccount;
        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
