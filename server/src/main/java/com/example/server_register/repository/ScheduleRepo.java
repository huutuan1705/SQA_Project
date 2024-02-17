package com.example.server_register.repository;

import com.example.server_register.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepo extends JpaRepository<Schedule, Integer> {


//    //CREATE DEFINER=`root`@`localhost` PROCEDURE `getScheduleOfSectionClass`(IN idLHP int)
//    //BEGIN
//    //    SELECT a.*, b.ten as tengv, b.hodem as hodemgv, c.ten as tenphong,
//    //    d.ten as tentuan, e.ten as tenngay, f.ten as tenkip
//    //    FROM tbllichhoc a, tblthanhvien b, tblphonghoc c,
//    //    tbltuan d, tblngay e, tblkip f
//    //    WHERE a.idlophocphan = idLHP AND b.id = a.idgiangvien
//    //    AND c.id = a.idphonghoc AND d.id = a.idtuan
//    //    AND e.id = a.idngay AND f.id = a.idkip;
//    //END
    @Procedure("getScheduleOfSectionClass")
    public List<Schedule> getSchedulesOfSectionClass(Integer idSectionClass);
}
