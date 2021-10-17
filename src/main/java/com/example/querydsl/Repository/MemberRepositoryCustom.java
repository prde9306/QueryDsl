package com.example.querydsl.Repository;


import com.example.querydsl.dto.MemberSerarchCondition;
import com.example.querydsl.dto.MemberTeamDto;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberTeamDto> search(MemberSerarchCondition condition);
}
