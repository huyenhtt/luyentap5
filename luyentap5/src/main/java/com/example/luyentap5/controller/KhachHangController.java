package com.example.luyentap5.controller;

import com.example.luyentap5.dto.KhachHangRequest;
import com.example.luyentap5.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangController {
    @Autowired
    KhachHangService service;

    @GetMapping("/list")
    public ResponseEntity<?> getList() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/list2")
    public ResponseEntity<?> listKH(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseEntity.ok(service.getListKH(page));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid KhachHangRequest request, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.ok(service.add(request));
    }

    @PutMapping("/update/{ma}")
    public ResponseEntity<?> update(@PathVariable Long ma, @Valid @RequestBody KhachHangRequest re, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.ok(service.update(ma, re));
    }

    @DeleteMapping("/delete/{ma}")
    public ResponseEntity<?> delete(@PathVariable Long ma) {
        return ResponseEntity.ok(service.delele(ma));
    }

    @GetMapping("/getOne/{ma}")
    public ResponseEntity<?> getKH(@PathVariable Long ma) {
        return ResponseEntity.ok(service.getOne(ma));
    }
}
