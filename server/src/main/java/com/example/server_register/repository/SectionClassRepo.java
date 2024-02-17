package com.example.server_register.repository;

import com.example.server_register.model.SectionClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SectionClassRepo extends JpaRepository<SectionClass, Integer> {

    //CREATE DEFINER=`root`@`localhost` PROCEDURE `LHPchoSVdangki`(IN idSVK int,IN idMHKH int)
    //BEGIN
    //    DECLARE idKH INT;
    //    SELECT idkihoc INTO idKH
    //    FROM tblmonhockihoc WHERE id = idMHKH;
    //
    //    DROP TEMPORARY TABLE IF EXISTS slotdadangki;
    //    CREATE TEMPORARY TABLE slotdadangki AS
    //    SELECT a.idtuan, a.idngay, a.idkip
    //    FROM tbllichhoc a, tbllophocphan b, tbldangkihoc c, tblmonhockihoc d
    //    WHERE d.idkihoc = idKH AND b.idmonhockihoc = d.id
    //    AND a.idlophocphan = b.id AND c.idlophocphan = b.id
    //    AND c.idsinhvienkhoa = idSVK;
    //
    //    DROP TEMPORARY TABLE IF EXISTS lhpchuaday;
    //    CREATE TEMPORARY TABLE lhpchuaday AS
    //    SELECT a.id, a.ten, a.sisotoida, a.idmonhockihoc,
    //    COUNT(e.id) as sisothuc
    //    FROM tbllophocphan a LEFT JOIN tbldangkihoc e
    //    ON e.idlophocphan = a.id
    //    WHERE a.idmonhockihoc = idMHKH
    //   GROUP BY a.id
    //   HAVING a.sisotoida > sisothuc;
    //
    //    SELECT a.*, b.idkihoc, d.id as idmh, d.ten as tenmh, d.sotc
    //    FROM lhpchuaday a, tblmonhockihoc b, tblmonhoc d
    //    WHERE a.id NOT IN
    //        (SELECT b.id FROM tbllichhoc b, slotdadangki c
    //        WHERE b.idtuan = c.idtuan AND
    //        b.idngay = c.idngay AND b.idkip = c.idkip)
    //    AND b.id = a.idmonhockihoc AND d.id = b.idmonhoc;
    //END
    @Procedure("sectionClassForStudentRegister")
    public List<SectionClass> getSectionClassForStudent(Integer idStudentDepartment,
                                                        Integer idSubjectSemester);

    //CREATE DEFINER=`root`@`localhost` PROCEDURE `LHPmaGVday`(IN idGV int, IN idMHKH int)
    //BEGIN
    //    SELECT distinctrow a.*
    //    FROM tbllophocphan a, tbllichhoc b
    //    WHERE a.idmonhockihoc = idMHKH AND b.idlophocphan = a.id
    //    AND b.idgiangvien = idGV;
    //END
    @Procedure("sectionClassForTeacher")
    public List<SectionClass> getSectionClassForTeacher(Integer idTeacher,
                                                        Integer idSubjectSemester);
}
