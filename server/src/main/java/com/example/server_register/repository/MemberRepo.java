package com.example.server_register.repository;

import com.example.server_register.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer> {

//    CREATE DEFINER=`root`@`localhost` PROCEDURE `checkAccount`(IN usr VARCHAR(255), IN pwd VARCHAR(255))
//    BEGIN
//        SELECT * FROM tblthanhvien
//        WHERE username = usr AND password = pwd;
//    END
    @Procedure(value = "checkAccount")
    public boolean checkAccount(Member member);


}
