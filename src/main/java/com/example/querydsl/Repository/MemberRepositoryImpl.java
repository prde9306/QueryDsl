package com.example.querydsl.Repository;

import com.example.querydsl.dto.MemberSerarchCondition;
import com.example.querydsl.dto.MemberTeamDto;

import java.util.List;

//여기 주의 MemberRepository라는 jpa상속받고 있는 이름 바로 뒤에 Impl써야 된다.
//여기서 쿼리 작성이겠지 당연히

public class MemberRepositoryImpl implements MemberRepositoryCustom {
    @Override
    public List<MemberTeamDto> search(MemberSerarchCondition condition) {
        return null;
    }
}
