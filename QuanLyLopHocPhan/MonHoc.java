import java.util.Scanner;

public class MonHoc {
    private String maMon;
    private String tenMon;
    private int soTinChi;
    private String moTa;
    private int soTiet;
    private Scanner sc = new Scanner(System.in);
    
    public MonHoc() {}
    public MonHoc(String maMon, String tenMon, int soTinChi, String moTa, int soTiet) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.soTinChi = soTinChi;
        this.moTa = moTa;
        this.soTiet = soTiet;
    }
    
    public String getMaMon() { return maMon; }
    public void setMaMon(String maMon) { this.maMon = maMon; }
    public String getTenMon() { return tenMon; }
    public void setTenMon(String tenMon) { this.tenMon = tenMon; }
    public int getSoTinChi() { return soTinChi; }
    public void setSoTinChi(int soTinChi) { this.soTinChi = soTinChi; }
    public String getMoTa() { return moTa; }
    public void setMoTa(String moTa) { this.moTa = moTa; }
    public int getSoTiet() { return soTiet; }
    public void setSoTiet(int soTiet) { this.soTiet = soTiet; }
    
    public void nhap() {
        do {
            System.out.print("Nhap ma mon: ");
            this.maMon = sc.nextLine().trim();
            if (this.maMon.isEmpty()) {
                System.out.println("Ma mon khong duoc bo trong! Vui long nhap lai.");
            }
        } while (this.maMon.isEmpty());
        do {
            System.out.print("Nhap ten mon: ");
            this.tenMon = sc.nextLine().trim();
            if (this.tenMon.isEmpty()) {
                System.out.println("Ten mon khong duoc bo trong! Vui long nhap lai.");
            }
        } while (this.tenMon.isEmpty());
        while (true) {
            System.out.print("Nhap so tin chi: ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("So tin chi khong duoc bo trong! Vui long nhap lai.");
                continue;
            }
            try {
                this.soTinChi = Integer.parseInt(input);
                if (this.soTinChi > 0) {
                    break;
                } else {
                    System.out.println("So tin chi phai lon hon 0. Vui long nhap lai!");
                }
            } catch (NumberFormatException e) {
                System.out.println("So tin chi phai la so nguyen. Vui long nhap lai!");
            }
        }
        while (true) {
            System.out.print("Nhap so tiet: ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("So tiet khong duoc bo trong! Vui long nhap lai.");
                continue;
            }
            try {
                this.soTiet = Integer.parseInt(input);
                if (this.soTiet > 0) {
                    break;
                } else {
                    System.out.println("So tiet phai lon hon 0. Vui long nhap lai!");
                }
            } catch (NumberFormatException e) {
                System.out.println("So tiet phai la so nguyen. Vui long nhap lai!");
            }
        }
        do {
            System.out.print("Nhap mo ta: ");
            this.moTa = sc.nextLine().trim();
            if (this.moTa.isEmpty()) {
                System.out.println("Mo ta khong duoc bo trong! Vui long nhap lai.");
            }
        } while (this.moTa.isEmpty());
    }
    
    public void xuat() {
        System.out.println("Ma mon: " + this.maMon);
        System.out.println("Ten mon: " + this.tenMon);
        System.out.println("So tin chi: " + this.soTinChi);
        System.out.println("So tiet: " + this.soTiet);
        System.out.println("Mo ta: " + this.moTa);
    }
}