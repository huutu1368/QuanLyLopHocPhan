import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TaiKhoan {
    private String tenDangNhap;
    private String matKhau;
    private String vaiTro;
    private Date ngayTao;
    private boolean trangThai;
    private Scanner sc = new Scanner(System.in);

    public TaiKhoan() {}

    public TaiKhoan(String tenDangNhap, String matKhau, String vaiTro, Date ngayTao, boolean trangThai) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }
    public String getTenDangNhap() { return tenDangNhap; }
    public void setTenDangNhap(String tenDangNhap) { this.tenDangNhap = tenDangNhap; }
    public String getMatKhau() { return matKhau; }
    public void setMatKhau(String matKhau) { this.matKhau = matKhau; }
    public String getVaiTro() { return vaiTro; }
    public void setVaiTro(String vaiTro) { this.vaiTro = vaiTro; }
    public Date getNgayTao() { return ngayTao; }
    public void setNgayTao(Date ngayTao) { this.ngayTao = ngayTao; }
    public boolean isTrangThai() { return trangThai; }
    public void setTrangThai(boolean trangThai) { this.trangThai = trangThai; }
    public void nhap() 
    {
        System.out.print("Nhap ten dang nhap: ");
        this.tenDangNhap = sc.nextLine();
        System.out.print("Nhap mat khau: ");
        this.matKhau = sc.nextLine();
        System.out.print("Nhap vai tro (Admin/GiangVien/SinhVien): ");
        this.vaiTro = sc.nextLine();
        this.ngayTao = new Date();
        this.trangThai = true;
    }
    public void xuat() {
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Ten dang nhap: " + this.tenDangNhap);
        System.out.println("Mat khau: " + this.matKhau);
        System.out.println("Vai tro: " + this.vaiTro);
        System.out.println("Ngay tao: " + d.format(this.ngayTao));
        System.out.println("Trang thai: " + (this.trangThai ? "Kich hoat" : "Vo hieu"));
    }
}