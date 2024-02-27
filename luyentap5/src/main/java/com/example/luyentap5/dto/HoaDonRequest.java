package com.example.luyentap5.dto;

import com.example.luyentap5.entity.HoaDon;
import com.example.luyentap5.entity.PhieuGiaoHang;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class HoaDonRequest {
    private Long mahoadon;
    private String nguoilap;
    private UUID maphieugiao;

    public HoaDon map(HoaDon h) {
        h.setMahoadon(this.getMahoadon());
        h.setNguoilap(this.getNguoilap());
        h.setPhieuGiaoHangList((List<PhieuGiaoHang>) PhieuGiaoHang.builder().maphieugiao(this.getMaphieugiao()).build());
        return h;
    }
}
