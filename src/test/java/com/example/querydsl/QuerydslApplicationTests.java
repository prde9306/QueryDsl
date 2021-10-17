package com.example.querydsl;


import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
@Commit
class QuerydslApplicationTests {

    @Autowired
    EntityManager em;

    //이렇게 필드로 가져가도 괜찮다.
    JPAQueryFactory jpaQueryFactory;


    @Test
    void contextLoads() {
        jpaQueryFactory = new JPAQueryFactory(em);



    }

}
