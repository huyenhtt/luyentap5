package com.example.luyentap5.dto;

import java.math.BigDecimal;
import java.util.UUID;

public interface HoaDonCustom {
    //viết đúng cú pháp bên hoá đơn chính entity
    Long getMaHoaDon();
    String getNguoiLap();
    String getSdtnhan();
    BigDecimal getPhigiaohang();
    UUID getDiachigiao();
}
