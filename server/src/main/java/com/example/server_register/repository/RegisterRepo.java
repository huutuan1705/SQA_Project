package com.example.server_register.repository;

import com.example.server_register.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface RegisterRepo extends JpaRepository<Register, Integer> {

    //CREATE DEFINER=`root`@`localhost` PROCEDURE `DKcuaSVtheoKi`(IN idSVK int, IN idKihoc int)
    //BEGIN
    //    SELECT a.*, c.id as idmhkh, d.id as idmh, d.ten as tenmh, d.sotc,
    //    b.id as idlhp, b.ten as tenlhp, e.idkhoa,
    //    e.nienkhoa, e.idsinhvien, f.masv, g.hodem, g.ten as tensv
    //    FROM tbldangkihoc a, tbllophocphan b, tblmonhockihoc c,
    //    tblmonhoc d, tblsinhvienkhoa e, tblsinhvien f, tblthanhvien g,
    //    tblkhoa h
    //    WHERE a.idsinhvienkhoa = idSVK AND b.id = a.idlophocphan
    //    AND c.id = b.idmonhockihoc AND c.idkihoc = idKihoc
    //    AND d.id = c.idmonhoc AND e.id=a.idsinhvienkhoa
    //    AND f.idthanhvien = e.idsinhvien AND g.id=e.idsinhvien
    //    AND h.id = e.idkhoa;
    //END
    @Procedure("registerOfStudentFollowingSemester")
    public List<Register> getRegisterOfStudent(Integer idStudentDepartment,
                                               Integer idSemester);
}
