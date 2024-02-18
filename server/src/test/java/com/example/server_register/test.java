package com.example.server_register;

import com.example.server_register.dto.MemberDto;
import com.example.server_register.model.Member;
import com.example.server_register.repository.MemberRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.Query;
import jakarta.persistence.StoredProcedureQuery;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.test.annotation.Rollback;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class test {

    @Autowired
    EntityManager entityManager;

    @Test
    public void thichtest() throws ParseException {

//        entityManager.createNamedStoredProcedureQuery("firstProcedure")
//                .setParameter("usr", "b20dccn352")
//                .setParameter("pwd", "123456");
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("checkAccount", "MemberMapper")
                .registerStoredProcedureParameter("usr", String.class, ParameterMode.IN)
                .setParameter("usr", "b20dccn352")
                .registerStoredProcedureParameter("pwd", String.class, ParameterMode.IN)
                .setParameter("pwd", "123456");
        Member member = (Member)query.getSingleResult();
        System.out.println( member.getRole());
    }
}
