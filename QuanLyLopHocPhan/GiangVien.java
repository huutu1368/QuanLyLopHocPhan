import java.util.Date;
public class GiangVien extends Nguoi
{
    private String chuyenMon;
    private String trinhDo;
    private int kinhNghiem;
    private TaiKhoan taikhoan;
    public GiangVien() {}
    public GiangVien(String maGV, String hoTen, Date ngaySinh, String gioiTinh, 
                    String diaChi, String sdt, String email, String chuyenMon, 
                    String trinhDo, int kinhNghiem, TaiKhoan taikhoan) 
    {
        super(maGV, hoTen, ngaySinh, gioiTinh, diaChi, sdt, email);
        this.chuyenMon = chuyenMon;
        this.trinhDo = trinhDo;
        this.kinhNghiem = kinhNghiem;
        this.taikhoan = taikhoan;
    }
    public GiangVien(String maGV, String hoTen, Date ngaySinh, String gioiTinh, 
                        String diaChi, String sdt, String email, String chuyenMon, 
                        String trinhDo, int kinhNghiem) 
    {
        super(maGV, hoTen, ngaySinh, gioiTinh, diaChi, sdt, email);
        this.chuyenMon = chuyenMon;
        this.trinhDo = trinhDo;
        this.kinhNghiem = kinhNghiem;
    }
    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public int getKinhNghiem() {
        return kinhNghiem;
    }

    public void setKinhNghiem(int kinhNghiem) {
        this.kinhNghiem = kinhNghiem;
    }
    
    public TaiKhoan getTaiKhoan() {
        return taikhoan;
    }

    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taikhoan = taiKhoan;
    }
    
    @Override
    public void nhap() {
        super.nhap();
         do {
            System.out.print("Nhap chuyen mon: ");
            this.chuyenMon = sc.nextLine().trim();
            if (this.chuyenMon.isEmpty()) {
                System.out.println("Chuyen mon khong duoc bo trong! Vui long nhap lai.");
            }
        } while (this.chuyenMon.isEmpty());
        do {
            System.out.print("Nhap trinh do: ");
            this.trinhDo = sc.nextLine().trim();
            if (this.trinhDo.isEmpty()) {
                System.out.println("Trinh do khong duoc bo trong! Vui long nhap lai.");
            }
        } while (this.trinhDo.isEmpty());
        while (true) {
            System.out.print("Nhap so nam kinh nghiem: ");
            try {
                this.kinhNghiem = Integer.parseInt(sc.nextLine());
                if (this.kinhNghiem >= 0) {
                    break;
                } else {
                    System.out.println("Kinh nghiem khong duoc am. Vui long nhap lai!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Kinh nghiem phai la so nguyen. Vui long nhap lai!");
            }
        }
        taikhoan = new TaiKhoan();
        taikhoan.setTenDangNhap(ma);
        taikhoan.setMatKhau("123456");
        taikhoan.setVaiTro("GiangVien");
        taikhoan.setNgayTao(new Date());
        taikhoan.setTrangThai(true);
        QuanLyLopHocPhan.getInstance().them(taikhoan);
    }
    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Chuyen mon: " + this.chuyenMon);
        System.out.println("Trinh do: " + this.trinhDo);
        System.out.println("Kinh nghiem: " + this.kinhNghiem + " nam");
        if (this.taikhoan != null) {
            System.out.println("Ten dang nhap: " + this.taikhoan.getTenDangNhap());
            System.out.println("Vai tro: " + this.taikhoan.getVaiTro());
        }
    }
}