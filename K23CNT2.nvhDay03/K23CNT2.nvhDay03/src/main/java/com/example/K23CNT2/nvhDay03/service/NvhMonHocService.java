package com.example.K23CNT2.nvhDay03.service;

import com.example.K23CNT2.nvhDay03.entity.NvhMonHoc;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class NvhMonHocService {
    private List<NvhMonHoc> monHocs = new ArrayList<>();

    public NvhMonHocService() {
        monHocs.addAll(Arrays.asList(
                new NvhMonHoc("MH01", "Lập trình Java", 45),
                new NvhMonHoc("MH02", "Cơ sở dữ liệu", 30),
                new NvhMonHoc("MH03", "Toán rời rạc", 60),
                new NvhMonHoc("MH04", "Phân tích thiết kế HTTT", 45),
                new NvhMonHoc("MH05", "Mạng máy tính", 40)
        ));
    }

    public List<NvhMonHoc> getAll() { return monHocs; }
    public NvhMonHoc getById(String nvhMaMH) {
        return monHocs.stream().filter(m -> m.getNvhMaMH().equalsIgnoreCase(nvhMaMH)).findFirst().orElse(null);
    }
    public NvhMonHoc add(NvhMonHoc mh) { monHocs.add(mh); return mh; }
    public NvhMonHoc update(String nvhMaMH, NvhMonHoc mh) {
        NvhMonHoc existing = getById(nvhMaMH);
        if (existing != null) {
            existing.setNvhTenMH(mh.getNvhTenMH());
            existing.setNvhSoTiet(mh.getNvhSoTiet());
        }
        return existing;
    }
    public boolean delete(String nvhMaMH) {
        NvhMonHoc existing = getById(nvhMaMH);
        return existing != null && monHocs.remove(existing);
    }
}
