package com.example.server_register.repository;

import com.example.server_register.model.StudentDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDepartmentRepo extends JpaRepository<StudentDepartment, Integer> {


    //CREATE DEFINER=`root`@`localhost` PROCEDURE `departmentOfStudent`(IN idSV INT)
    //BEGIN
    //    SELECT a.id as idkhoa, a.ten as tenkhoa, b.id as idsvk,
    //    c.masv, d.*
    //    FROM tblkhoa a, tblsinhvienkhoa b, tblsinhvien c, tblthanhvien d
    //    WHERE b.idsinhvien = idSV AND b.idkhoa = a.id
    //    AND b.danghoc = 1 AND c.idthanhvien =idSV
    //    AND d.id = idSV;
    //END
    @Procedure("departmentOfStudent")
    public List<StudentDepartment> getDepartmentOfStudent(Integer idStudent);
}
