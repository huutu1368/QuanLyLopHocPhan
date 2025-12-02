import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SinhVien extends Nguoi {
    private String maLop;
    private Date ngayNhapHoc;
    private String trangThai;
    private TaiKhoan taikhoan;
    private Scanner sc = new Scanner(System.in);
    public SinhVien() {}
    
    public SinhVien(String maSV, String maLop, Date ngayNhapHoc, String trangThai,
                    String hoTen, Date ngaySinh, String gioiTinh, String diaChi, String sdt, String email, TaiKhoan taikhoan) {
        super(maSV, hoTen, ngaySinh, gioiTinh, diaChi, sdt, email);
        this.maLop = maLop;
        this.ngayNhapHoc = ngayNhapHoc;
        this.trangThai = trangThai;
        this.taikhoan = taikhoan;
    }
    public SinhVien(String maSV, String maLop, Date ngayNhapHoc, String trangThai,
                    String hoTen, Date ngaySinh, String gioiTinh, String diaChi, String sdt, String email) {
        super(maSV, hoTen, ngaySinh, gioiTinh, diaChi, sdt, email);
        this.maLop = maLop;
        this.ngayNhapHoc = ngayNhapHoc;
        this.trangThai = trangThai;
    }
    public String getMaLop() {
        return maLop;
    }
    
    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
    
    public Date getNgayNhapHoc() {
        return ngayNhapHoc;
    }
    
    public void setNgayNhapHoc(Date ngayNhapHoc) {
        this.ngayNhapHoc = ngayNhapHoc;
    }
    
    public String getTrangThai() {
        return trangThai;
    }
    
    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    public TaiKhoan getTaikhoan() {
        return taikhoan;
    }
    
    public void setTaikhoan(TaiKhoan taikhoan) {
        this.taikhoan = taikhoan;
    }
    @Override
    public void nhap() {
        super.nhap();
        do {
            System.out.print("Nhap ma lop: ");
            this.maLop = sc.nextLine().trim();
            if (this.maLop.isEmpty()) {
                System.out.println("Ma lop khong duoc bo trong! Vui long nhap lai.");
            }
        } while (this.maLop.isEmpty());
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            System.out.print("Nhap ngay nhap hoc (dd/MM/yyyy): ");
            String ngayStr = sc.nextLine();
            try {
                this.ngayNhapHoc = d.parse(ngayStr);
                break;
            } catch (ParseException e) {
                System.out.println("Sai dinh dang ngay vui long nhap lai!");
            }
        }
        do {
            System.out.print("Nhap trang thai: "); 
            trangThai = sc.nextLine().trim();
            if (trangThai.isEmpty()) {
                System.out.println("Trang thai khong duoc bo trong! Vui long nhap lai.");
            }
        } while (trangThai.isEmpty());
        taikhoan = new TaiKhoan();
        taikhoan.setTenDangNhap(ma);
        taikhoan.setMatKhau("123456");
        taikhoan.setVaiTro("SinhVien");
        taikhoan.setNgayTao(new Date());
        taikhoan.setTrangThai(true);
        QuanLyLopHocPhan.getInstance().them(taikhoan);
        System.out.println("Da tao tai khoan cho sinh vien. Ten dang nhap: " + ma + ", Mat khau: 123456");
    }
    @Override
    public void xuat() 
    {
        super.xuat();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Ma Lop: " + this.maLop);
        System.out.println("Ngay nhap hoc: " + d.format(this.ngayNhapHoc));
        if (this.taikhoan != null) {
            System.out.println("Ten dang nhap: " + this.taikhoan.getTenDangNhap());
            System.out.println("Ten dang nhap: " + this.taikhoan.getTenDangNhap());
        }
    }
    public void xuatMa(String maLop) 
    {
        if (this.maLop.equalsIgnoreCase(maLop))
        {
            super.xuat();
            SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Ngay nhap hoc: " + d.format(this.ngayNhapHoc));
            System.out.println("Trang thai: " + this.trangThai);   
        }
        System.out.println("--------------------------");
    }
}