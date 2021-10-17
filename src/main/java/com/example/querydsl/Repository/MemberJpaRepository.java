package com.example.querydsl.Repository;

import com.example.querydsl.Entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static com.example.querydsl.Entity.QMember.*;

/**
 *
 * 순수 jpa 방식
 */
@Repository
public class MemberJpaRepository {

    private final EntityManager em;
    private final JPAQueryFactory jpaQueryFactory;

    public MemberJpaRepository(EntityManager em) {
        this.em = em;
        //이렇게 해도 되고 SpringBean으로 등록해도 된다.
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    //SpringBean으로( 맨 앞 Application에 빈으로 등록 후)
//    public MemberJpaRepository(EntityManager em, JPAQueryFactory jpaQueryFactory) {
//        this.em = em;
//        this.jpaQueryFactory =jpaQueryFactory;
//    }

    public void save(Member member){
        em.persist(member);
    }

    public Optional<Member> findById(long id){
          Member findMember = em.find(Member.class, id);
          return Optional.of(findMember);

    }
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    //queryDsl
    public List<Member> findAll_querydsl(){
        return jpaQueryFactory
                .selectFrom(member)
                .fetch();
    }

    public List<Member> findByUsername(String username){
        return em.createQuery("select m from Member m where m.username =:username", Member.class)
                .getResultList();
    }


    //queryDsl
    public List<Member> findByUsername_querydsl(String username){
        return jpaQueryFactory
                .selectFrom(member)
                .where(member.username.eq(username))
                .fetch();
    }

}
