package com.example.querydsl.Repository;


import com.example.querydsl.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * 스프링 data jpa로 만들기
 * 뒤에 MemberRepositoryCustom 이거 이렇게 해주면 된다.
 * 구현체는 MemberRepositoryImpl로
 * 이 인터페이스에 +Impl만 하고!!
 */
public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom {
    //findById, findAll..등은 기본으로 들어가있고
    //username으로 쿼리 만들어줌
    List<Member> findByUsername(String username);
}
