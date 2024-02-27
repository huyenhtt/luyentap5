package com.example.luyentap5.service;

import com.example.luyentap5.entity.HangKhachHang;
import com.example.luyentap5.entity.KhachHang;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ExcelUploadService {
    public static boolean isValidExcelFile(MultipartFile file) {
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    public static List<KhachHang> getKhachHangFromExcel(InputStream inputStream) {
        List<KhachHang> khachHangs = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("page1");
            int rowIndex = 0;
            for (Row row : sheet) {
                if (rowIndex == 0) {
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                KhachHang khachHang = new KhachHang();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cellIndex) {
                        case 0 -> khachHang.setMakhachhang((long) cell.getNumericCellValue());
                        case 1 -> khachHang.setTenkhachhang(cell.getStringCellValue());
                        case 2 -> khachHang.setSodienthoai(cell.getStringCellValue());
                        case 3 -> khachHang.setGioitinh(cell.getBooleanCellValue());
                        case 4 -> {
                            int hangKhachHangData = (int) cell.getNumericCellValue();
                            HangKhachHang hangKhachHang = new HangKhachHang();
                            // Thiết lập ID của hạng khách hàng từ dữ liệu lấy được từ ô Excel
                            hangKhachHang.setMahang(hangKhachHangData); // Giả sử ID được lưu dưới dạng số
                            khachHang.setHangkhachhang(hangKhachHang);
                        }
                        default -> {
                        }
                    }
                    cellIndex++;
                }
                khachHangs.add(khachHang);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return khachHangs;
    }
}
