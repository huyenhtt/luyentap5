package com.example.luyentap5.repository;

import com.example.luyentap5.dto.HoaDonCustom;
import com.example.luyentap5.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepo extends JpaRepository<HoaDon,Long> {
    @Query(value = "select h.MaHoaDon,h.NguoiLap,p.SdtNhan,p.PhiGiaoHang,p.DiaChiGiao from PhieuGiaoHang p join HoaDon h on h.MaHoaDon=p.HoaDonGiao",nativeQuery = true)
    List<HoaDonCustom> getList();
}
