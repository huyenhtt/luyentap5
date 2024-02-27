package com.example.luyentap5.controller;

import com.example.luyentap5.entity.KhachHang;
import com.example.luyentap5.service.KhachHangService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/kh")
public class ImportController {
  private KhachHangService khachHangService;

  @PostMapping("/upload-khachhang-data")
    public ResponseEntity<?> uploadData(@RequestParam("file")MultipartFile file) throws IllegalAccessException {
      this.khachHangService.saveKhachHangToDataBase(file);
      return ResponseEntity.ok(Map.of("Message", " Customers data uploaded and saved to database successfully"));
  }
    @GetMapping
    public ResponseEntity<List<KhachHang>> getCustomers(){
        return new ResponseEntity<>(khachHangService.getList(), HttpStatus.FOUND);
    }
}
