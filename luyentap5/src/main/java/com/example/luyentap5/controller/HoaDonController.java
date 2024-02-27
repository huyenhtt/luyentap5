package com.example.luyentap5.controller;

import com.example.luyentap5.dto.HoaDonRequest;
import com.example.luyentap5.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hoadon")
public class HoaDonController {
    @Autowired
    HoaDonService service;

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/list2")
    public ResponseEntity<?> list(@RequestParam(defaultValue = "0", name = "page") Integer page) {
        return ResponseEntity.ok(service.getList(page));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody HoaDonRequest request) {
        return ResponseEntity.ok(service.add(request));
    }

    @DeleteMapping("/delete/{ma}")
    public ResponseEntity<?> delete(@PathVariable Long ma) {
        return ResponseEntity.ok(service.delete(ma));
    }

    @PutMapping("/update/{ma}")
    public ResponseEntity<?> update(@RequestBody HoaDonRequest request, @PathVariable Long ma) {
        return ResponseEntity.ok(service.update(ma, request));
    }
}
