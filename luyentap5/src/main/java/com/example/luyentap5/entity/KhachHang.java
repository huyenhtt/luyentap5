package com.example.luyentap5.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "khachhang")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long makhachhang;
    private String tenkhachhang;
    private Boolean gioitinh;
    private String sodienthoai;
    @ManyToOne
    @JoinColumn(name = "hangkhachhang")
    private HangKhachHang hangkhachhang;
}
