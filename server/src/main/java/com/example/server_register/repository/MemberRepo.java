package com.example.server_register.repository;


import com.example.server_register.model.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepo {

    private final EntityManager entityManager;

    public Member checkAccount(Member member){

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("checkAccount", "MemberMapper")
                .registerStoredProcedureParameter("usr", String.class, ParameterMode.IN)
                .setParameter("usr", "b20dccn352")
                .registerStoredProcedureParameter("pwd", String.class, ParameterMode.IN)
                .setParameter("pwd", "123456");

        return (Member) query.getSingleResult();
    }
}
