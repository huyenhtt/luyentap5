package com.example.luyentap5.service;

import com.example.luyentap5.dto.HoaDonCustom;
import com.example.luyentap5.dto.HoaDonRequest;
import com.example.luyentap5.entity.HoaDon;
import com.example.luyentap5.entity.PhieuGiaoHang;
import com.example.luyentap5.repository.HoaDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HoaDonService {
    @Autowired
    HoaDonRepo repo;

    public List<HoaDonCustom> getAll() {
        return repo.getList();
    }

    public Page<HoaDon> getList(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return repo.findAll(pageable);
    }

    public HoaDon update(Long ma, HoaDonRequest request) {
        Optional<HoaDon> optional = repo.findById(ma);
        return optional.map(o -> {
            o.setPhieuGiaoHangList((List<PhieuGiaoHang>) PhieuGiaoHang.builder().maphieugiao(request.getMaphieugiao()).build());
            o.setNguoilap(request.getNguoilap());
            return repo.save(o);
        }).orElse(null);
    }

    public HoaDon add(HoaDonRequest request) {
        HoaDon h = request.map(new HoaDon());
        return repo.save(h);

    }

    public HoaDon delete(Long ma) {
        Optional<HoaDon> optional = repo.findById(ma);
        return optional.map(o -> {
            repo.delete(o);
            return o;
        }).orElse(null);
    }

}
