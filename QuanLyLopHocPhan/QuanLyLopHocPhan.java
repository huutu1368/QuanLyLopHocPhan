import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Date;
public class QuanLyLopHocPhan implements IQuanLy, IReadWrite {
    private List<MonHoc> danhSachMonHoc;
    private List<LopHoc> danhSachLopHoc;
    private List<SinhVien> danhSachSinhVien;
    private List<GiangVien> danhSachGiangVien;
    private List<Diem> danhSachDiem;
    private List<TaiKhoan> danhSachTaiKhoan;
    private static QuanLyLopHocPhan instance;
    public static QuanLyLopHocPhan getInstance() {
        if (instance == null) {
            instance = new QuanLyLopHocPhan();
        }
        return instance;
    }
    public QuanLyLopHocPhan() {
        danhSachMonHoc = new ArrayList<>();
        danhSachLopHoc = new ArrayList<>();
        danhSachSinhVien = new ArrayList<>();
        danhSachGiangVien = new ArrayList<>();
        danhSachDiem = new ArrayList<>();
        danhSachTaiKhoan = new ArrayList<>();
    }
    @Override
    public void them(Object obj) {
        if (obj instanceof MonHoc) {
            for (MonHoc m : danhSachMonHoc) {
                if (m.getMaMon().equalsIgnoreCase(((MonHoc) obj).getMaMon())) {
                    System.out.println("Da ton tai mon hoc voi ma nay khong the them.");
                    return;
                }
            }
            danhSachMonHoc.add((MonHoc) obj);
            System.out.println("Them mon hoc thanh cong!");
        } 
        else if (obj instanceof LopHoc) {
            for (LopHoc l : danhSachLopHoc) {
                if (l.getMaLop().equalsIgnoreCase(((LopHoc) obj).getMaLop())) {
                    System.out.println("Da ton tai lop hoc voi ma nay khong the them.");
                    return;
                }
            }
            danhSachLopHoc.add((LopHoc) obj);
            System.out.println("Them lop hoc thanh cong!");
        } 
        else if (obj instanceof SinhVien) {
            for (SinhVien sv : danhSachSinhVien) {
                if (sv.getMa().equalsIgnoreCase(((SinhVien) obj).getMa())) {
                    System.out.println("Da ton tai sinh vien voi ma nay khong the them.");
                    return;
                }
            }
            danhSachSinhVien.add((SinhVien) obj);
            System.out.println("Them sinh vien thanh cong!");
        } 
        else if (obj instanceof GiangVien) {
            for (GiangVien gv : danhSachGiangVien) {
                if (gv.getMa().equalsIgnoreCase(((GiangVien) obj).getMa())) {
                    System.out.println("Da ton tai giang vien voi ma nay khong the them.");
                    return;
                }
            }
            danhSachGiangVien.add((GiangVien) obj);
            System.out.println("Them giang vien thanh cong!");
        } 
        else if (obj instanceof Diem) {
            Diem newDiem = (Diem) obj;
            for (Diem d : danhSachDiem) {
                if (d.getMaSV().equalsIgnoreCase(newDiem.getMaSV()) && 
                    d.getMaMon().equalsIgnoreCase(newDiem.getMaMon())) {
                    System.out.println("Da ton tai diem cua sinh vien nay cho mon hoc nay khong the them.");
                    return;
                }
            }
            danhSachDiem.add(newDiem);
            System.out.println("Them diem thanh cong!");
        } 
        else if (obj instanceof TaiKhoan) 
        {
            TaiKhoan tk = (TaiKhoan) obj;
            if (danhSachTaiKhoan.stream().anyMatch(x -> x.getTenDangNhap().equalsIgnoreCase(tk.getTenDangNhap()))) {
                System.out.println("Da ton tai tai khoan!");
            } else {
                danhSachTaiKhoan.add(tk); 
                System.out.println("Them tai khoan thanh cong!");
            }
        }
    }
    private boolean suaTaiKhoan(TaiKhoan tkMoi) {
    for (int i = 0; i < danhSachTaiKhoan.size(); i++) {
        if (danhSachTaiKhoan.get(i).getTenDangNhap().equals(tkMoi.getTenDangNhap())) {
            danhSachTaiKhoan.set(i, tkMoi);
            System.out.println("Da cap nhat tai khoan: " + tkMoi.getTenDangNhap());
            return true;
        }
    }
    System.out.println("Khong tim thay tai khoan: " + tkMoi.getTenDangNhap());
    return false;
    }

    @Override
    public void sua(Object obj) 
    {
    if (obj == null) {
        System.out.println("Doi tuong can sua la null!");
        return;
    }
    boolean daSua = false;
    if (obj instanceof MonHoc) {
        MonHoc monMoi = (MonHoc) obj;
        for (int i = 0; i < danhSachMonHoc.size(); i++) {
            if (danhSachMonHoc.get(i).getMaMon().equals(monMoi.getMaMon())) {
                danhSachMonHoc.set(i, monMoi);
                System.out.println("Da cap nhat mon hoc: " + monMoi.getMaMon());
                daSua = true;
                break;
            }
        }
        if (!daSua) {
            System.out.println("Khong tim thay mon hoc co ma: " + monMoi.getMaMon());
        }
    } else if (obj instanceof LopHoc) {
        LopHoc lopMoi = (LopHoc) obj;
        for (int i = 0; i < danhSachLopHoc.size(); i++) {
            if (danhSachLopHoc.get(i).getMaLop().equals(lopMoi.getMaLop())) {
                danhSachLopHoc.set(i, lopMoi);
                System.out.println("Da cap nhat lop hoc: " + lopMoi.getMaLop());
                daSua = true;
                break;
            }
        }
        if (!daSua) {
            System.out.println("Khong tim thay lop hoc co ma: " + lopMoi.getMaLop());
        }
    } else if (obj instanceof SinhVien) {
        SinhVien svMoi = (SinhVien) obj;
        for (int i = 0; i < danhSachSinhVien.size(); i++) {
            if (danhSachSinhVien.get(i).getMa().equals(svMoi.getMa())) {
                if (svMoi.getTaikhoan() != null) {
                    suaTaiKhoan(svMoi.getTaikhoan());
                }
                danhSachSinhVien.set(i, svMoi);
                System.out.println("Da cap nhat sinh vien: " + svMoi.getMa());
                daSua = true;
                break;
            }
        }
        if (!daSua) {
            System.out.println("Khong tim thay sinh vien co ma: " + svMoi.getMa());
        }
        
    } else if (obj instanceof GiangVien) {
        GiangVien gvMoi = (GiangVien) obj;
        for (int i = 0; i < danhSachGiangVien.size(); i++) {
            if (danhSachGiangVien.get(i).getMa().equals(gvMoi.getMa())) {
                if (gvMoi.getTaiKhoan() != null) {
                    suaTaiKhoan(gvMoi.getTaiKhoan());
                }
                danhSachGiangVien.set(i, gvMoi);
                System.out.println("Da cap nhat giang vien: " + gvMoi.getMa());
                daSua = true;
                break;
            }
        }
        if (!daSua) {
            System.out.println("Khong tim thay giang vien co ma: " + gvMoi.getMa());
        }
        
    } else if (obj instanceof Diem) {
        Diem diemMoi = (Diem) obj;
        for (int i = 0; i < danhSachDiem.size(); i++) {
            Diem diemCu = danhSachDiem.get(i);
            if (diemCu.getMaSV().equals(diemMoi.getMaSV()) && 
                diemCu.getMaMon().equals(diemMoi.getMaMon())) {
                danhSachDiem.set(i, diemMoi);
                System.out.println("Da cap nhat diem - SV: " + diemMoi.getMaSV() + 
                                 ", Mon: " + diemMoi.getMaMon());
                daSua = true;
                break;
            }
        }
        if (!daSua) {
            System.out.println("Khong tim thay diem - SV: " + diemMoi.getMaSV() + 
                             ", Mon: " + diemMoi.getMaMon());
        }
        
    } else if (obj instanceof TaiKhoan) {
        TaiKhoan tkMoi = (TaiKhoan) obj;
        suaTaiKhoan(tkMoi);
    } else {
        System.out.println("Khong ho tro sua doi tuong loai: " + obj.getClass().getSimpleName());
    }
    }
    @Override
    public void xoa(String id) 
    {
        int count = 0;
        count += danhSachMonHoc.removeIf(mon -> mon.getMaMon().equals(id)) ? 1 : 0;
        count += danhSachLopHoc.removeIf(lop -> lop.getMaLop().equals(id)) ? 1 : 0;
        count += danhSachSinhVien.removeIf(sv -> sv.getMa().equals(id)) ? 1 : 0;
        count += danhSachGiangVien.removeIf(gv -> gv.getMa().equals(id)) ? 1 : 0;
        count += danhSachDiem.removeIf(diem -> diem.getMaSV().equals(id) || diem.getMaMon().equals(id)) ? 1 : 0;
        count += danhSachTaiKhoan.removeIf(tk -> tk.getTenDangNhap().equals(id)) ? 1 : 0;
        if (count > 0) {
            System.out.println("Da xoa thanh cong doi tuong co ma: " + id);
        } else {
            System.out.println("Khong tim thay doi tuong nao co ma: " + id);
        }
    }
    @Override
    public Object timKiem(String keyword) {
        for (MonHoc mon : danhSachMonHoc) {
            if (mon.getMaMon().contains(keyword) || mon.getTenMon().contains(keyword)) {
                System.out.println("Tim thay mon hoc nay:");
                mon.xuat();
                return mon;
            }
        }
        for (LopHoc lop : danhSachLopHoc) {
            if (lop.getMaLop().contains(keyword) || lop.getTenLop().contains(keyword)) {
                System.out.println("Tim thay lop nay:");
                lop.xuat();
                return lop;
            }
        }
        for (SinhVien sv : danhSachSinhVien) {
            if (sv.getMa().contains(keyword) || sv.getHoTen().contains(keyword)) {
                System.out.println("Tim thay sinh vien nay:");
                sv.xuat();
                return sv;
            }
        }
        for (GiangVien gv : danhSachGiangVien) {
            if (gv.getMa().contains(keyword) || gv.getHoTen().contains(keyword)) {
                System.out.println("Tim thay sinh vien nay:");
                gv.xuat();
                return gv;
            }
        }
        System.out.println("Khong tim thay!");
        return null;
    }
    @Override
    public void hienThiDanhSach() {
        System.out.println("=== TONG QUAN HE THONG ===");
        System.out.println("So mon hoc: " + danhSachMonHoc.size());
        System.out.println("So lop hoc: " + danhSachLopHoc.size());
        System.out.println("So sinh vien: " + danhSachSinhVien.size());
        System.out.println("So giang vien: " + danhSachGiangVien.size());
        System.out.println("So diem: " + danhSachDiem.size());
        System.out.println("So tai khoan: " + danhSachTaiKhoan.size());
    }
    @Override
    public void writeData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            
            writer.println("=== DANH SACH TAI KHOAN ===");
            for (TaiKhoan tk : danhSachTaiKhoan) {
                writer.println("TAIKHOAN|" + tk.getTenDangNhap() + "|" + tk.getMatKhau() + "|" + 
                            tk.getVaiTro() + "|" + df.format(tk.getNgayTao()) + "|" + tk.isTrangThai());
            }
            
            writer.println("=== DANH SACH MON HOC ===");
            for (MonHoc mh : danhSachMonHoc) {
                writer.println("MONHOC|" + mh.getMaMon() + "|" + mh.getTenMon() + "|" + 
                            mh.getSoTinChi() + "|" + mh.getSoTiet() + "|" + mh.getMoTa());
            }
            
            writer.println("=== DANH SACH LOP HOC ===");
            for (LopHoc lh : danhSachLopHoc) {
                writer.println("LOPHOC|" + lh.getMaLop() + "|" + lh.getTenLop() + "|" + 
                            lh.getKhoaHoc() + "|" + lh.getNganhHoc() + "|" + 
                            (lh.getGiangVienChuNhiem() != null ? lh.getGiangVienChuNhiem().getMa() : "null"));
            }
            
            writer.println("=== DANH SACH SINH VIEN ===");
            for (SinhVien sv : danhSachSinhVien) {
                writer.println("SINHVIEN|" + sv.getMa() + "|" + sv.getHoTen() + "|" + 
                            df.format(sv.getNgaySinh()) + "|" + sv.getGioiTinh() + "|" + 
                            sv.getDiaChi() + "|" + sv.getSdt() + "|" + sv.getEmail() + "|" + 
                            sv.getMaLop() + "|" + df.format(sv.getNgayNhapHoc()) + "|" + sv.getTrangThai());
            }
            
            writer.println("=== DANH SACH GIANG VIEN ===");
            for (GiangVien gv : danhSachGiangVien) {
                writer.println("GIANGVIEN|" + gv.getMa() + "|" + gv.getHoTen() + "|" + 
                            df.format(gv.getNgaySinh()) + "|" + gv.getGioiTinh() + "|" + 
                            gv.getDiaChi() + "|" + gv.getSdt() + "|" + gv.getEmail() + "|" + 
                            gv.getChuyenMon() + "|" + gv.getTrinhDo() + "|" + gv.getKinhNghiem());
            }
            
            writer.println("=== DANH SACH DIEM ===");
            for (Diem d : danhSachDiem) {
                writer.println("DIEM|" + d.getMaSV() + "|" + d.getMaMon() + "|" + 
                            d.getDiemQuaTrinh() + "|" + d.getDiemThi() + "|" + d.getDiemTong());
            }
            
            System.out.println("Luu du lieu thanh cong vao file: " + filename);
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }
    @Override
    public void readData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            danhSachMonHoc.clear();
            danhSachLopHoc.clear();
            danhSachSinhVien.clear();
            danhSachGiangVien.clear();
            danhSachDiem.clear();
            danhSachTaiKhoan.clear();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            String line;
            
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("===")) continue;
                
                String[] parts = line.split("\\|");
                if (parts.length < 2) continue;
                
                String type = parts[0];
                
                try {
                    switch (type) {
                        case "TAIKHOAN":
                            if (parts.length >= 6) {
                                Date ngayTao = df.parse(parts[4]);
                                boolean trangThai = Boolean.parseBoolean(parts[5]);
                                TaiKhoan tk = new TaiKhoan(parts[1], parts[2], parts[3], ngayTao, trangThai);
                                danhSachTaiKhoan.add(tk);
                            }
                            break;
                            
                        case "MONHOC":
                            if (parts.length >= 6) {
                                int soTinChi = Integer.parseInt(parts[3]);
                                int soTiet = Integer.parseInt(parts[4]);
                                MonHoc mh = new MonHoc(parts[1], parts[2], soTinChi, parts[5], soTiet);
                                danhSachMonHoc.add(mh);
                            }
                            break;
                            
                        case "LOPHOC":
                            if (parts.length >= 6) {
                                LopHoc lh = new LopHoc(parts[1], parts[2], parts[3], parts[4], null);
                                if (!parts[5].equals("null")) {
                                    for (GiangVien gv : danhSachGiangVien) {
                                        if (gv.getMa().equals(parts[5])) {
                                            lh.setGiangVienChuNhiem(gv);
                                            break;
                                        }
                                    }
                                }
                                danhSachLopHoc.add(lh);
                            }
                            break;
                            
                        case "SINHVIEN":
                            if (parts.length >= 11) {
                                Date ngaySinh = df.parse(parts[3]);
                                Date ngayNhapHoc = df.parse(parts[9]);
                                SinhVien sv = new SinhVien(parts[1], parts[8], ngayNhapHoc, parts[10], 
                                                        parts[2], ngaySinh, parts[4], parts[5], parts[6], parts[7]);
                                danhSachSinhVien.add(sv);
                            }
                            break;
                            
                        case "GIANGVIEN":
                            if (parts.length >= 11) {
                                Date ngaySinh = df.parse(parts[3]);
                                GiangVien gv = new GiangVien(parts[1], parts[2], ngaySinh, parts[4], 
                                                            parts[5], parts[6], parts[7], parts[8], 
                                                            parts[9], Integer.parseInt(parts[10]));
                                danhSachGiangVien.add(gv);
                            }
                            break;
                            
                        case "DIEM":
                            if (parts.length >= 6) {
                                double diemQT = Double.parseDouble(parts[3]);
                                double diemThi = Double.parseDouble(parts[4]);
                                Diem d = new Diem(parts[1], parts[2], diemQT, diemThi);
                                danhSachDiem.add(d);
                            }
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Loi khi doc dong: " + line + " - " + e.getMessage());
                }
            }
            lienKetSinhVienVoiLop();   
            System.out.println("Doc du lieu thanh cong tu file: " + filename);
            System.out.println("Tai khoan: " + danhSachTaiKhoan.size());
            System.out.println("Mon hoc: " + danhSachMonHoc.size());
            System.out.println("Lop hoc: " + danhSachLopHoc.size());
            System.out.println("Sinh vien: " + danhSachSinhVien.size());
            System.out.println("Giang vien: " + danhSachGiangVien.size());
            System.out.println("Diem: " + danhSachDiem.size());
            
        } catch (FileNotFoundException e) {
            System.out.println("File khong ton tai, tao file moi khi luu.");
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }
    private void lienKetSinhVienVoiLop() {
        for (SinhVien sv : danhSachSinhVien) {
            for (LopHoc lop : danhSachLopHoc) {
                if (lop.getMaLop().equals(sv.getMaLop())) {
                    lop.getDanhSachSinhVien().add(sv);
                    break;
                }
            }
        }
}
    public List<MonHoc> getDanhSachMonHoc() {
        return danhSachMonHoc;
    }
    public List<LopHoc> getDanhSachLopHoc() {
        return danhSachLopHoc;
    }
    public List<SinhVien> getDanhSachSinhVien() {
        return danhSachSinhVien;
    }
    public List<GiangVien> getDanhSachGiangVien() {
        return danhSachGiangVien;
    }
    public List<Diem> getDanhSachDiem() {
        return danhSachDiem;
    }
    public List<TaiKhoan> getDanhSachTaiKhoan() {
        return danhSachTaiKhoan;
    }
    public void hienThiMonHoc() {
        System.out.println("=== DANH SACH MON HOC ===");
        for (MonHoc mon : danhSachMonHoc) {
            mon.xuat();
            System.out.println("-------------------");
        }
    }
    public void hienThiLopHoc() {
        System.out.println("=== DANH SACH LOP HOC ===");
        for (LopHoc lop : danhSachLopHoc) {
            lop.xuat();
            System.out.println("-------------------");
        }
    }
    public void hienThiSinhVien() {
        System.out.println("=== DANH SACH SINH VIEN ===");
        for (SinhVien sv : danhSachSinhVien) {
            sv.xuat();
            System.out.println("-------------------");
        }
    }
    public void hienThiGiangVien() {
        System.out.println("=== DANH SACH GIANG VIEN ===");
        for (GiangVien gv : danhSachGiangVien) {
            gv.xuat();
            System.out.println("-------------------");
        }
    }
    public void hienThiDiem() {
        System.out.println("=== DANH SACH DIEM ===");
        for (Diem d : danhSachDiem) {
            d.xuat();
            System.out.println("-------------------");
        }
    }
    public void hienThiTaiKhoan() {
        System.out.println("=== DANH SACH Tai Khoan ===");
        for (TaiKhoan tk : danhSachTaiKhoan) {
            tk.xuat();
            System.out.println("-------------------");
        }
    }
    public void sapXepTheoMaSV() {
        getDanhSachSinhVien().sort(Comparator.comparing(Nguoi::getMa, Comparator.nullsLast(String::compareTo)));
        System.out.println("Da sap xep sinh vien theo ma sinh vien.");
    }
    
    public void sapXepTheoHoTen() {
        getDanhSachSinhVien().sort(Comparator.comparing(Nguoi::getHoTen, Comparator.nullsLast(String::compareTo)));
        System.out.println("Da sap xep sinh vien theo ten sinh vien");
    }
    public void thongKeTheoLop(String maL) 
    {
        
        for (LopHoc l:danhSachLopHoc)
        {
            if (l.getMaLop().equalsIgnoreCase(maL))
            {
                for(SinhVien sv:danhSachSinhVien)
                {
                    sv.xuatMa(maL);
                }
                return;
            }
        }
        System.out.println("Khong tim thay ma lop de thong ke");
    }
}