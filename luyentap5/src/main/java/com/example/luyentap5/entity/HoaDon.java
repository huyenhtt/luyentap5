package com.example.luyentap5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "hoadon")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mahoadon;
    private String nguoilap;

    @OneToMany(mappedBy = "hoadongiao", cascade = CascadeType.ALL)

    private List<PhieuGiaoHang> phieuGiaoHangList;
}
