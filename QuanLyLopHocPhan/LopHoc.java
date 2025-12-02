import java.util.ArrayList;
import java.util.Scanner;

public class LopHoc{
    private String maLop;
    private String tenLop;
    private String khoaHoc;
    private String nganhHoc;
    private GiangVien giangVienChuNhiem;
    private ArrayList<SinhVien> danhSachSinhVien;
    private Scanner sc = new Scanner(System.in);
    
    public LopHoc() {
        this.danhSachSinhVien = new ArrayList<>();
    }
    
    public LopHoc(String maLop, String tenLop, String khoaHoc, String nganhHoc, GiangVien gv, ArrayList<SinhVien> danhSachSinhVien) {
        this();
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.khoaHoc = khoaHoc;
        this.nganhHoc = nganhHoc;
        this.giangVienChuNhiem = gv;
        if (danhSachSinhVien != null)
            this.danhSachSinhVien.addAll(danhSachSinhVien);
    }
    
    public LopHoc(String maLop, String tenLop, String khoaHoc, String nganhHoc, GiangVien gv) {
        this();
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.khoaHoc = khoaHoc;
        this.nganhHoc = nganhHoc;
        this.giangVienChuNhiem = gv;
    } 
    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public GiangVien getGiangVienChuNhiem() {
        return giangVienChuNhiem;
    }

    public void setGiangVienChuNhiem(GiangVien giangVienChuNhiem) {
        this.giangVienChuNhiem = giangVienChuNhiem;
    }

    public ArrayList<SinhVien> getDanhSachSinhVien() {
        return danhSachSinhVien;
    }

    public void setDanhSachSinhVien(ArrayList<SinhVien> danhSachSinhVien) {
        this.danhSachSinhVien = danhSachSinhVien;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }
    public void nhap(GiangVien gv) {
        do {
            System.out.print("Nhap ma lop: ");
            this.maLop = sc.nextLine().trim();
            if (this.maLop.isEmpty()) {
                System.out.println("Ma lop khong duoc bo trong! Vui long nhap lai.");
            }
        } while (this.maLop.isEmpty());
        do {
            System.out.print("Nhap ten lop: ");
            this.tenLop = sc.nextLine().trim();
            if (this.tenLop.isEmpty()) {
                System.out.println("Ten lop khong duoc bo trong! Vui long nhap lai.");
            }
        } while (this.tenLop.isEmpty());
        do {
            System.out.print("Nhap khoa hoc: ");
            this.khoaHoc = sc.nextLine().trim();
            if (this.khoaHoc.isEmpty()) {
                System.out.println("Khoa hoc khong duoc bo trong! Vui long nhap lai.");
            }
        } while (this.khoaHoc.isEmpty());
        do {
            System.out.print("Nhap nganh hoc: ");
            this.nganhHoc = sc.nextLine().trim();
            if (this.nganhHoc.isEmpty()) {
                System.out.println("Nganh hoc khong duoc bo trong! Vui long nhap lai.");
            }
        } while (this.nganhHoc.isEmpty());
        System.out.println("Nhap thong tin giang vien chu nhiem:");
        this.giangVienChuNhiem = gv;
        System.out.println("Da gan giang vien chu nhiem: " + gv.getHoTen());
    }
    
    public void xuat() {
        System.out.println("Ma lop: " + this.maLop);
        System.out.println("Ten lop: " + this.tenLop);
        System.out.println("Khoa hoc: " + this.khoaHoc);
        System.out.println("Nganh hoc: " + this.nganhHoc);  
        if (this.giangVienChuNhiem != null) {
            System.out.println("Giang vien chu nhiem:");
            this.giangVienChuNhiem.xuat();
        }
    }

    
}