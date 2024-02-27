package com.example.luyentap5.dto;

import com.example.luyentap5.entity.HangKhachHang;
import com.example.luyentap5.entity.KhachHang;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class KhachHangRequest {
    @NotNull(message = "khong trong")
    private Integer mahang;
    @NotBlank(message = "khong trong")
    private String tenkhachhang;
    @NotBlank(message = "khong trong")
    private String sodienthoai;
    @NotNull(message = "khong trong")
    private Boolean gioitinh;

    public KhachHang map(KhachHang kh) {
        kh.setGioitinh(this.getGioitinh());
        kh.setHangkhachhang(HangKhachHang.builder().mahang(this.getMahang()).build());
        kh.setSodienthoai(this.getSodienthoai());
        kh.setTenkhachhang(this.getTenkhachhang());
        return kh;
    }
}
