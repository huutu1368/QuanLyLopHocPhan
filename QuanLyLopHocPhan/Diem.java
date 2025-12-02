import java.util.Scanner;
public class Diem {
    private String maSV;
    private String maMon;
    private double diemQuaTrinh;
    private double diemThi;
    private double diemTong;
    private Scanner sc = new Scanner(System.in);
    public Diem() {}
    public Diem(String maSV, String maMon, double diemQuaTrinh, double diemThi, double diemTong) {
        this.maSV = maSV;
        this.maMon = maMon;
        this.diemQuaTrinh = diemQuaTrinh;
        this.diemThi = diemThi;
        this.diemTong = diemTong;
    }
    
    public Diem(String maSV, String maMon, double diemQuaTrinh, double diemThi) {
        this.maSV = maSV;
        this.maMon = maMon;
        this.diemQuaTrinh = diemQuaTrinh;
        this.diemThi = diemThi;
        tinhDiemTong();
    }
    public String getMaSV() {
        return maSV;
    }
    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }
    public String getMaMon() {
        return maMon;
    }
    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }
    public double getDiemQuaTrinh() {
        return diemQuaTrinh;
    }
    public void setDiemQuaTrinh(double diemQuaTrinh) {
        this.diemQuaTrinh = diemQuaTrinh;
        tinhDiemTong();
    }
    public double getDiemThi() {
        return diemThi;
    }
    public void setDiemThi(double diemThi) {
        this.diemThi = diemThi;
        tinhDiemTong();
    }
    public double getDiemTong() {
        return diemTong;
    }
    public void setDiemTong(double diemTong) {
        this.diemTong = diemTong;
    }
    public void tinhDiemTong() {
        this.diemTong = Math.round((diemQuaTrinh * 0.4 + diemThi * 0.6) * 100.0) / 100.0;
    }
    public String xepLoai() {
        tinhDiemTong();
        if (diemTong >= 8.0) 
            return "Gioi";
        else if (diemTong >= 6.5) 
            return "Kha";
        else if (diemTong >= 5.0) 
            return "Trung binh";
        else 
            return "Yeu";
    }
    public void nhap(String maSV, String maMon) 
    {
        this.maSV = maSV;
        this.maMon = maMon;
        while (true) 
        {
            System.out.print("Nhap diem qua trinh (0-10): ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) 
            {
                System.out.println("Diem qua trinh khong duoc bo trong! Vui long nhap lai.");
                continue;
            }
            try {
                this.diemQuaTrinh = Double.parseDouble(input);
                if (this.diemQuaTrinh >= 0 && this.diemQuaTrinh <= 10) 
                {
                    break;
                } 
                else 
                {
                    System.out.println("Diem phai tu 0 den 10. Vui long nhap lai!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Diem phai la so. Vui long nhap lai!");
            }
        }
        while (true) {
            System.out.print("Nhap diem thi (0-10): ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Diem thi khong duoc bo trong! Vui long nhap lai.");
                continue;
            }
            try {
                this.diemThi = Double.parseDouble(input);
                if (this.diemThi >= 0 && this.diemThi <= 10) {
                    break;
                } else {
                    System.out.println("Diem phai tu 0 den 10. Vui long nhap lai!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Diem phai la so. Vui long nhap lai!");
            }
        } 
        tinhDiemTong();
    }
    public void xuat() {
        System.out.println("Ma sinh vien: " + this.maSV);
        System.out.println("Ma mon hoc: " + this.maMon);
        System.out.println("Diem qua trinh: " + this.diemQuaTrinh);
        System.out.println("Diem thi: " + this.diemThi);
        System.out.println("Diem tong: " + this.diemTong);
        System.out.println("Xep loai: " + this.xepLoai());
    }
}