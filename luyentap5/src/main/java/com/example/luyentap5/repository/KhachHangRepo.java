package com.example.luyentap5.repository;

import com.example.luyentap5.dto.KhachHangCustom;
import com.example.luyentap5.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang,Long> {
    @Query(value = "select k.MaKhachHang,k.GioiTinh,k.TenKhachHang,k.SoDienThoai,h.MaHang,h.TenHang from KhachHang k join HangKhachHang h on h.MaHang=k.HangKhachHang",nativeQuery = true)
    List<KhachHangCustom> getAll();
}
