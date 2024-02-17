package com.example.server_register.repository;

import com.example.server_register.model.SubjectSemester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectSemesterRepo extends JpaRepository<SubjectSemester, Integer> {

    //CREATE DEFINER=`root`@`localhost` PROCEDURE `subjectStudentCanRegister`(IN idSVK INT, IN idKihoc INT)
    //BEGIN
    //    DROP TEMPORARY TABLE IF EXISTS ketquamon;
    //    CREATE TEMPORARY TABLE ketquamon AS
    //    SELECT l.idmonhoc, SUM(k.diem*l.tile) as ketqua
    //    FROM tblmonhoc h, tbldangkihoc i, tblketqua k, tblmonhocdaudiem l
    //    WHERE i.idsinhvienkhoa =idSVK AND k.iddangkihoc = i.id
    //    AND l.id = k.idmonhocdaudiem
    //    GROUP BY l.idmonhoc;
    //
    //    DROP TEMPORARY TABLE IF EXISTS idmondaqua;
    //    CREATE TEMPORARY TABLE idmondaqua AS
    //    SELECT idmonhoc FROM ketquamon WHERE ketqua >=4;
    //
    //    DROP TEMPORARY TABLE IF EXISTS idmonchuaqua;
    //    CREATE TEMPORARY TABLE idmonchuaqua AS
    //    SELECT idmonhoc FROM ketquamon WHERE ketqua <4;
    //
    //    SELECT a.id as idmhkh, b.id as idmh, b.ten as tenmh, b.sotc
    //    FROM tblmonhockihoc a, tblmonhoc b
    //    WHERE a.idkihoc = idKihoc AND b.id = a.idmonhoc
    //    AND b.id NOT IN (SELECT idmonhoc FROM ketquamon WHERE ketqua >=4)
    //    AND (b.id IN (SELECT idmonhoc FROM idmonchuaqua) OR
    //        ((SELECT g.idmontienquyet
    //        FROM tblmontienquyet g
    //        WHERE g.idmonhoc = b.id) IN (SELECT idmonhoc FROM idmondaqua))
    //        OR b.id NOT IN (SELECT idmonhoc FROM tblmontienquyet));
    //END

    @Procedure("subjectStudentCanRegister")
    public List<SubjectSemester> getSubjectOfStudent(Integer idStudent,
                                                     Integer idSemester);

    //CREATE DEFINER=`root`@`localhost` PROCEDURE `subjectsOfTeacher`(IN idGV int, IN idKihoc int)
    //BEGIN
    //    SELECT distinctrow a.id as idmh, a.ten as tenmh, a.sotc, b.id as idmhkh
    //    FROM tblmonhoc a, tblmonhockihoc b, tbllophocphan c, tbllichhoc d
    //    WHERE b.idKihoc = idKihoc AND a.id = b.idmonhoc
    //    AND c.idmonhockihoc = b.id AND d.idlophocphan = c.id
    //    AND d.idgiangvien = idGV;
    //END
    @Procedure("subjectsOfTeacher")
    public List<SubjectSemester> getSubjectOfTeacher(Integer idStudent,
                                                     Integer idSemester);

}
