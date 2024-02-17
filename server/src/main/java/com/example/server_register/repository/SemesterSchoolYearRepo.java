package com.example.server_register.repository;

import com.example.server_register.model.SemesterSchoolYear;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface SemesterSchoolYearRepo {

    //CREATE DEFINER=`root`@`localhost` PROCEDURE `semesterRegistered`()
    //BEGIN
    //    SELECT a.id as idnamhoc, a.ten as namhoc, b.id as idhocki,
    //    b.ten as hocki, c.id as idkihoc
    //    FROM tblnamhoc a, tblhocki b, tblkihoc c
    //    WHERE c.idnamhoc = a.id AND c.idhocki = b.id AND c.dangdk = 1;
    //END
    @Procedure("semesterRegistered")
    public SemesterSchoolYear getSemesterRegister();


    //CREATE DEFINER=`root`@`localhost` PROCEDURE `presentSemester`()
    //BEGIN
    //    SELECT a.id as idnamhoc, a.ten as namhoc, b.id as idhocki,
    //    b.ten as hocki, c.id as idkihoc
    //    FROM tblnamhoc a, tblhocki b, tblkihoc c
    //    WHERE c.idnamhoc = a.id AND c.idhocki = b.id AND c.danghoc = 1;
    //END
    @Procedure("presentSemester")
    public SemesterSchoolYear getPresentSemesterSchoolYear();

    //CREATE DEFINER=`root`@`localhost` PROCEDURE `allSemester`()
    //BEGIN
    //    SELECT a.id as idnamhoc, a.ten as namhoc, b.id as idhocki,
    //    b.ten as hocki, c.id as idkihoc
    //    FROM tblnamhoc a, tblhocki b, tblkihoc c
    //    WHERE c.idnamhoc = a.id AND c.idhocki = b.id
    //    ORDER BY idnamhoc, idhocki;
    //END
    @Procedure("allSemester")
    public List<SemesterSchoolYear> getAllSemesterSchoolYear();

}
