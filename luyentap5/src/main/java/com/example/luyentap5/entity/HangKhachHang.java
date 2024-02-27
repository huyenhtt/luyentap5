package com.example.luyentap5.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hangkhachhang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class HangKhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer mahang;
    private String tenhang;
}
