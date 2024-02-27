package com.example.luyentap5.service;

import com.example.luyentap5.dto.KhachHangCustom;
import com.example.luyentap5.dto.KhachHangRequest;
import com.example.luyentap5.entity.HangKhachHang;
import com.example.luyentap5.entity.KhachHang;
import com.example.luyentap5.repository.KhachHangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {
    @Autowired
    KhachHangRepo repo;

    public List<KhachHangCustom> list() {
        return repo.getAll();
    }
    public List<KhachHang> getList() {
        return repo.findAll();
    }

    public Page<KhachHang> getListKH(Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return repo.findAll(pageable);
    }

    public KhachHang add(KhachHangRequest request) {
        KhachHang kh = request.map(new KhachHang());
        return repo.save(kh);
    }

    public KhachHang delele(Long ma) {
        Optional<KhachHang> op = repo.findById(ma);
        return op.map(o -> {
            repo.delete(o);
            return o;
        }).orElse(null);
    }

    public KhachHang update(Long ma, KhachHangRequest request) {
        Optional<KhachHang> op = repo.findById(ma);
        return op.map(o -> {
            o.setGioitinh(request.getGioitinh());
            o.setSodienthoai(request.getSodienthoai());
            o.setHangkhachhang(HangKhachHang.builder().mahang(request.getMahang()).build());
            o.setTenkhachhang(request.getTenkhachhang());
            return repo.save(o);
        }).orElse(null);
    }

    public KhachHang getOne(Long ma) {
        return repo.findById(ma).orElse(null);
    }
    // excel
   public  void  saveKhachHangToDataBase(MultipartFile multipartFile) throws IllegalAccessException {
        if (ExcelUploadService.isValidExcelFile(multipartFile)){
            try {
                List<KhachHang> khachHangs = ExcelUploadService.getKhachHangFromExcel(multipartFile.getInputStream());
                this.repo.saveAll(khachHangs);
            }catch (IOException e){
                throw new IllegalAccessException("The file is not a valid excel file");
            }
        }
   }
}
