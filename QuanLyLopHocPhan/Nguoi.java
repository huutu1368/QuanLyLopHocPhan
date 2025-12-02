import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Pattern;

public abstract class Nguoi{
    protected String ma;
    protected String hoTen;
    protected Date ngaySinh;
    protected String gioiTinh;
    protected String diaChi;
    protected String sdt;
    protected String email;
    protected Scanner sc = new Scanner(System.in);
    
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@gmail\\.com$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[0-9]{10}$");

    public Nguoi() {}

    public Nguoi(String ma, String hoTen, Date ngaySinh, String gioiTinh, String diaChi, String sdt, String email) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
    }
    
     public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public static Pattern getEmailPattern() {
        return EMAIL_PATTERN;
    }

    public static Pattern getPhonePattern() {
        return PHONE_PATTERN;
    }
    
    public long tinhTuoi(Date ngaySinh) {
        Calendar c = new GregorianCalendar();
        c.setTime(ngaySinh);
        LocalDate ngaySinhLocal = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DAY_OF_MONTH));
        LocalDate ngayHienTai = LocalDate.now();
        long tuoi = ChronoUnit.YEARS.between(ngaySinhLocal, ngayHienTai);
        return Math.abs(tuoi);
    }
    
    public void nhap() {
        do {
            System.out.print("Nhap ma: ");
            this.ma = sc.nextLine().trim();
            if (this.ma.isEmpty()) {
                System.out.println("Ma khong duoc bo trong! Vui long nhap lai.");
            }
        } while (this.ma.isEmpty());
        do {
            System.out.print("Nhap ten: ");
            this.hoTen = sc.nextLine().trim();
            if (this.hoTen.isEmpty()) {
                System.out.println("Ten khong duoc bo trong! Vui long nhap lai.");
            }
        } while (this.hoTen.isEmpty());
        do {
            System.out.print("Nhap gioi tinh: ");
            this.gioiTinh = sc.nextLine().trim();
            if (this.gioiTinh.isEmpty()) {
                System.out.println("Gioi tinh khong duoc bo trong! Vui long nhap lai.");
            }
        } while (this.gioiTinh.isEmpty());
        do {
            System.out.print("Nhap so dien thoai (10 so): ");
            this.sdt = sc.nextLine().trim();
            if (this.sdt.isEmpty()) {
                System.out.println("So dien thoai khong duoc bo trong! Vui long nhap lai.");
            } else if (!PHONE_PATTERN.matcher(this.sdt).matches()) {
                System.out.println("So dien thoai phai co dung 10 chu so! Vui long nhap lai.");
                this.sdt = ""; 
            }
        } while (this.sdt.isEmpty());
        do {
            System.out.print("Nhap dia chi: ");
            this.diaChi = sc.nextLine().trim();
            if (this.diaChi.isEmpty()) {
                System.out.println("Dia chi khong duoc bo trong! Vui long nhap lai.");
            }
        } while (this.diaChi.isEmpty());

        do {
            System.out.print("Nhap email (username@gmail.com): ");
            this.email = sc.nextLine().trim();
            if (this.email.isEmpty()) 
            {
                System.out.println("Email khong duoc bo trong! Vui long nhap lai.");
            } else if (!EMAIL_PATTERN.matcher(this.email).matches()) {
                System.out.println("Email khong dung dinh dang! Phai co dang username@gmail.com.");
                this.email = "";
            }
        } while (this.email.isEmpty());
        boolean hopLe = false;
        Date ngayHienTai = new Date();
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        d.setLenient(false);
        do {
            System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
            String ngaySinhStr = sc.nextLine().trim();
            if (ngaySinhStr.isEmpty()) {
                System.out.println("Ngay sinh khong duoc bo trong! Vui long nhap lai.");
                continue;
            }
            try {
                Date ngayNhap = d.parse(ngaySinhStr);
                if (ngayNhap.after(ngayHienTai)) {
                    System.out.println("Ngay sinh khong duoc lon hon ngay hien tai. Vui long nhap lai!");
                    hopLe = false;
                } else if (tinhTuoi(ngayNhap) >= 18) {
                    this.ngaySinh = ngayNhap;
                    hopLe = true;
                } else {
                    System.out.println("Chua du 18 tuoi. Vui long kiem tra hoac nhap lai!");
                    hopLe = false;
                }
            } catch (ParseException ex) {
                System.out.println("Ngay sinh khong dung dinh dang (dd/MM/yyyy). Vui long nhap lai!");
                hopLe = false;
            }
        } while (!hopLe);
    }
    
    public void xuat() {
        System.out.println("Ma: " + this.ma);
        System.out.println("Ten: " + this.hoTen);
        SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Ngay sinh: " + d.format(this.ngaySinh));
        System.out.println("Gioi tinh: " + this.gioiTinh);
        System.out.println("Dia chi: " + this.diaChi);
        System.out.println("So dien thoai: " + this.sdt);
        System.out.println("Email: " + this.email);
    }
}