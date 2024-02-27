package com.example.luyentap5.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "phieugiaohang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PhieuGiaoHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID maphieugiao;
    private String sdtnhan;
    private BigDecimal phigiaohang;
    private UUID diachigiao;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "hoadongiao")
    HoaDon hoadongiao;
}
