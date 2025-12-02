import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLyLopHocPhan q = QuanLyLopHocPhan.getInstance();
        Scanner sc = new Scanner(System.in);
        khoiTaoDuLieuMau(q);
        
        int chon;
        do {
            System.out.println("\n====== HE THONG QUAN LY LOP HOC PHAN ======");
            System.out.println("1. Them doi tuong\t2. Sua doi tuong\t3. Xoa doi tuong");
            System.out.println("4. Tim kiem\t\t5. Hien thi danh sach\t6. Sap xep");
            System.out.println("7. Thong ke\t\t8. Doc/Ghi file\t\t9. Thoat");
            System.out.print("Moi nhap lua chon: ");
            
            try {
                chon = Integer.parseInt(sc.nextLine());
                switch(chon) {
                    case 1: themDoiTuong(q, sc); break;
                    case 2: suaDoiTuong(q, sc); break;
                    case 3: xoaDoiTuong(q, sc); break;
                    case 4: timKiemDoiTuong(q, sc); break;
                    case 5: hienThiDanhSach(q, sc); break;
                    case 6: sapXepDoiTuong(q, sc); break;
                    case 7: thongKeTheoLop(q, sc); break;
                    case 8: docGhiFile(q, sc); break;
                    case 9: System.out.println("Cam on da su dung!"); break;
                    default: System.out.println("Lua chon khong hop le!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Loi: Vui long nhap so nguyen!");
                chon = -1;
            }
        } while(chon != 9);
        
        sc.close();
    }
    private static void khoiTaoDuLieuMau(QuanLyLopHocPhan q) {
        try {       
            GiangVien gv = new GiangVien("GV01", "Nguyen Van A", new Date(), "Nam", 
                                       "123 ABC, Ha Noi", "0123456789", "gv01@example.com", 
                                       "CNPM", "Thac si", 5);
            TaiKhoan tkGV = new TaiKhoan("GV01", "123456", "GiangVien", new Date(), true);
            SinhVien sv1 = new SinhVien("SV01", "L01", new Date(), "Dang hoc",
                    "Nguyen Van C", new Date(), "Nam", "456 XYZ, Ha Noi", 
                    "0987654321", "sv001@example.com");
            TaiKhoan tkSV1 = new TaiKhoan("SV01", "123456", "SinhVien", new Date(), true);
            SinhVien sv2 = new SinhVien("SV02", "L01", new Date(), "Dang hoc",
                    "Le Thi A", new Date(), "Nu", "789 DEF, HCM", 
                    "0912345678", "sv002@example.com");
            TaiKhoan tkSV2 = new TaiKhoan("SV02", "123456", "SinhVien", new Date(), true);
            LopHoc lop = new LopHoc("L01", "Lap trinh Java", "K23", "CNTT", gv, new ArrayList<>());
            MonHoc mh1 = new MonHoc("MH01", "Lap trinh Java", 3, "Java co ban", 45);
            MonHoc mh2 = new MonHoc("MH02", "Co so du lieu", 3, "Mon hoc ve CSDL", 45);
            Diem d1 = new Diem("SV01", "MH01", 8.5, 7.5);
            Diem d2 = new Diem("SV02", "MH01", 6.5, 7.0);
            q.them(gv);q.them(tkGV); q.them(sv1);q.them(tkSV1); q.them(sv2);q.them(tkSV2);
            q.them(lop); q.them(mh1); q.them(mh2);
            q.them(d1); q.them(d2);
            
            System.out.println("Da khoi tao du lieu mau thanh cong!");
        } catch (Exception e) {
            System.out.println("Loi khi khoi tao du lieu mau: " + e.getMessage());
        }
    }

    private static void themDoiTuong(QuanLyLopHocPhan q, Scanner sc) {
        String c;
        do {
            System.out.println("\n--- THEM DOI TUONG ---");
            System.out.println("1. Sinh vien\t2. Giang vien\t3. Lop hoc");
            System.out.println("4. Mon hoc\t5. Diem\t\t6. Tai khoan\t0. Quay lai");
            System.out.print("Chon loai doi tuong: ");
            
            int loai = Integer.parseInt(sc.nextLine());
            switch(loai) {
                case 1: 
                    SinhVien sv = new SinhVien(); 
                    sv.nhap(); 
                    q.them(sv); 
                    break;
                case 2: 
                    GiangVien gv = new GiangVien(); 
                    gv.nhap(); 
                    q.them(gv); 
                    break;
                case 3: 
                    LopHoc lh = new LopHoc();
                    System.out.println("Nhap vao ma giang vien chu nhiem cho lop hoc:");
                    String maGV = sc.nextLine().trim();
                    GiangVien gv1 = null;
                    for (GiangVien g : q.getDanhSachGiangVien()) 
                    {
                        if (g.getMa().equalsIgnoreCase(maGV)) 
                        {
                            gv1 = g;
                            break;
                        }
                    }
                    if (gv1 != null) 
                    {
                        lh.nhap(gv1);
                        q.them(lh); 
                    } 
                    else 
                    {
                        System.out.println("Khong the them vi giang vien khong ton tai!");
                        System.out.println("Ban co muon tao giang vien moi? (Y/N)");
                        String taoMoi = sc.nextLine();
                        if (taoMoi.equalsIgnoreCase("Y")) 
                        {
                            GiangVien gvMoi = new GiangVien();
                            gvMoi.nhap();
                            q.them(gvMoi);
                            lh.nhap(gvMoi);
                            q.them(lh);
                        }
                    }
                break;
                    
                case 4: 
                    MonHoc mh = new MonHoc(); 
                    mh.nhap(); 
                    q.them(mh); 
                    break;
                case 5: 
                    System.out.println("Nhap vao ma sinh vien can nhap diem:");
                    String maSV=sc.nextLine();
                    System.out.println("Nhap vao ma mon can nhap diem:");
                    String maMon=sc.nextLine();
                    if (q.timKiem(maSV)!=null&&q.timKiem(maMon)!=null)
                    {
                        Diem d = new Diem(); 
                        d.nhap(maSV,maMon); 
                        q.them(d);
                    }
                    else 
                    {
                        System.out.println("Ma sinh vien hoac ma lop sai vui long kiem tra lai!");
                    }
                    break;
                case 6: 
                    TaiKhoan tk = new TaiKhoan(); 
                    tk.nhap(); 
                    q.them(tk); 
                    break;
                case 0: 
                    return;
                default: 
                    System.out.println("Lua chon khong hop le!");
            }
            
            System.out.print("Tiep tuc them? (Y/N): ");
            c = sc.nextLine();
        } while(c.equalsIgnoreCase("Y"));
    }
    
    private static void suaDoiTuong(QuanLyLopHocPhan q, Scanner sc) {
    int chon;
    do {
        System.out.println("\n--- SUA DOI TUONG ---");
        System.out.println("1. Sua Sinh vien");
        System.out.println("2. Sua Giang vien");
        System.out.println("3. Sua Lop hoc");
        System.out.println("4. Sua Mon hoc");
        System.out.println("5. Sua Diem");
        System.out.println("6. Sua Tai khoan");
        System.out.println("0. Quay lai");
        System.out.print("Chon loai doi tuong can sua: ");
        
        try {
            chon = Integer.parseInt(sc.nextLine());
            
            switch(chon) {
                case 1:
                    SinhVien sv = new SinhVien();
                    sv.nhap();
                    q.sua(sv);
                    break;
                case 2:
                    GiangVien gv = new GiangVien();
                    gv.nhap();
                    q.sua(gv);
                    break;
                case 3:
                    LopHoc lh = new LopHoc();
                    System.out.println("Nhap vao ma giang vien chu nhiem cho lop hoc:");
                    String maGV = sc.nextLine().trim();
                    GiangVien gv1 = null;
                    for (GiangVien g : q.getDanhSachGiangVien()) 
                    {
                        if (g.getMa().equalsIgnoreCase(maGV)) 
                        {
                            gv1 = g;
                            break;
                        }
                    }
                    if (gv1 != null) 
                    {
                        lh.nhap(gv1);
                        q.sua(lh);
                    } else {
                        System.out.println("Khong the sua vi giang vien khong ton tai!");
                    }
                    break;
                case 4:
                    MonHoc mh = new MonHoc();
                    mh.nhap();
                    q.sua(mh);
                    break;
                case 5:
                    System.out.println("Nhap vao ma sinh vien can sua diem:");
                    String maSV=sc.nextLine();
                    System.out.println("Nhap vao ma mon can sua diem:");
                    String maMon=sc.nextLine();
                    if (q.timKiem(maSV)!=null&&q.timKiem(maMon)!=null)
                    {
                        Diem d = new Diem();
                        d.nhap(maSV,maMon);
                        q.sua(d);}
                    else 
                    {
                        System.out.println("Ma sinh vien hoac ma lop sai vui long kiem tra lai!");
                    }
                    break;
                case 6:
                    TaiKhoan tk = new TaiKhoan();
                    tk.nhap();
                    q.sua(tk);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Loi: Vui long nhap so nguyen!");
            chon = -1;
        }
        
        if (chon >= 1 && chon <= 6) {
            System.out.print("Ban co muon tiep tuc sua? (Y/N): ");
            String tiepTuc = sc.nextLine();
            if (!tiepTuc.equalsIgnoreCase("Y")) {
                break;
            }
        }
        } while(chon != 0);
    }
    
    private static void xoaDoiTuong(QuanLyLopHocPhan q, Scanner sc) {
        String c;
        do {
            System.out.print("\nNhap ma doi tuong can xoa: ");
            String ma = sc.nextLine();
            q.xoa(ma);
            System.out.println("Da xoa doi tuong: " + ma);
            System.out.print("Tiep tuc xoa? (Y/N): ");
            c = sc.nextLine();
        } while(c.equalsIgnoreCase("Y"));
    }
    
    private static void timKiemDoiTuong(QuanLyLopHocPhan q, Scanner sc) {
        String c;
        do {
            System.out.print("\nNhap ma can tim: ");
            String id = sc.nextLine();
            q.timKiem(id);
            System.out.print("Tiep tuc tim? (Y/N): ");
            c = sc.nextLine();
        } while(c.equalsIgnoreCase("Y"));
    }
    
    private static void hienThiDanhSach(QuanLyLopHocPhan q, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- HIEN THI DANH SACH ---");
            System.out.println("1. Tat ca\t2. Sinh vien\t3. Giang vien");
            System.out.println("4. Lop hoc\t5. Mon hoc\t6. Diem\t7.Tai khoan\t0. Quay lai");
            System.out.print("Chon danh sach: ");
            
            c = Integer.parseInt(sc.nextLine());
            switch(c) {
                case 1: q.hienThiDanhSach(); break;
                case 2: q.hienThiSinhVien();; break;
                case 3: q.hienThiGiangVien();; break;
                case 4: q.hienThiLopHoc(); break;
                case 5: q.hienThiMonHoc(); break;
                case 6: q.hienThiDiem(); break;
                case 7:q.hienThiTaiKhoan();break;
                case 0: return;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while(c != 0);
    }
    
    private static void sapXepDoiTuong(QuanLyLopHocPhan q, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- SAP XEP ---");
            System.out.println("1. Theo ma SV\t2. Theo ho ten\t0. Quay lai");
            System.out.print("Chon kieu sap xep: ");
            
            c = Integer.parseInt(sc.nextLine());
            switch(c) {
                case 1: q.sapXepTheoMaSV(); System.out.println("Da sap xep theo ma!"); break;
                case 2: q.sapXepTheoHoTen(); System.out.println("Da sap xep theo ho ten!"); break;
                case 0: return;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while(c != 0);
    }
    
    private static void thongKeTheoLop(QuanLyLopHocPhan q, Scanner sc) {
        System.out.println("\n--- THONG KE ---");
        System.out.println("Nhap vao ma lop can thong ke:");
        String maL=sc.nextLine();
        q.thongKeTheoLop(maL);
    }
    
    private static void docGhiFile(QuanLyLopHocPhan q, Scanner sc) {
        int c;
        do {
            System.out.println("\n--- DOC/GHI FILE ---");
            System.out.println("1. Ghi file\t2. Doc file\t0. Quay lai");
            System.out.print("Chon thao tac: ");
            
            c = Integer.parseInt(sc.nextLine());
            switch(c) {
                case 1: q.writeData(); break;
                case 2: q.readData(); break;
                case 0: return;
                default: System.out.println("Lua chon khong hop le!");
            }
        } while(c != 0);
    }
}