import java.io.FileReader;
import java.util.Scanner;

public class BanHang {
	public String user;
	public String pass;
	public int dem = 0;
	Scanner input = new Scanner(System.in);
	
	public boolean kiemTra() {
		try {
			FileReader file = new FileReader("input.txt");
			Scanner in = new Scanner(file);
			while (in.hasNextLine()) {
				String chuoi = in.nextLine();
				String[] mang = chuoi.split(" ");
				if(mang[0].trim().equals(user.trim()) && mang[1].trim().equals(pass.trim())) {
					in.close();
					return true;
				}
			}
			in.close();
			return false;
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public void dangNhap() {
		System.out.print("Nhap username: ");
		String us = input.nextLine();
		System.out.print("Nhap password: ");
		String p = input.nextLine();
		user = us;
		pass = p;
		if(kiemTra()) {
			menu1();
		}
		else {
			dem++;
			if(dem > 2) {
				System.out.println("Doi 1 phut...");
				for(int i = 60; i >= 0; i--) {
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				dangNhap();
			}
			System.out.println("Dang nhap loi");
			System.out.println("Co dang nhap lai khong(y/n)");
			String x = input.nextLine();
			if(x.trim().toLowerCase().equals("y")) {
				dangNhap();
			}
			else {
				System.exit(0);
			}
		}
	}
	
	public void menu1() {
		System.out.println("1. Nhap kho");
		System.out.println("2. Xuat kho");
		System.out.println("3. Quan li gia");
		System.out.println("4. In hoa don");
		System.out.println("5. Thoat");
		String a = input.next();
		switch(a.trim()) {
			case "1": nhapKho(); break;
			case "2": xuatKho(); break;
			case "3": quanLiGia(); break;
			case "4": inHoaDon(); break;
			default: thoat();
			
		}
	}
	public void nhapKho() {
		System.out.println("1. Nhap kho so luong mot don vi");
		System.out.println("2. Nhap theo thung 20 don vi");
		System.out.println("3. Nhap theo ta 10 don vi");
		System.out.println("4. Chinh sua so luong");
		System.out.println("5. Quay lai menu 1");
		String a = input.next();
		switch(a.trim()) {
			default: menu1();
			
		}
	}
	
	public void xuatKho() {
		System.out.println("1. Xuat theo mot don vi");
		System.out.println("2. Xuat theo thung");
		System.out.println("3. Xuat theo ta");
		System.out.println("4. Chinh sua so luong");
		System.out.println("5. Kiem tra so luong");
		System.out.println("6. Quay lai menu 1");
		String a = input.next();
		switch(a.trim()) {
			default: menu1();
			
		}
	}
	
	public void quanLiGia() {
		System.out.println("1. Hien thi gia");
		System.out.println("2. Sua gia");
		System.out.println("3. Tong tien hang");
		System.out.println("4. Quay lai menu 1");
		String a = input.next();
		switch(a.trim()) {
			default: menu1();;
			
		}
	}
	
	public void inHoaDon() {
		System.out.println("1. In theo luong hang");
		System.out.println("2. In theo gia");
		System.out.println("3. In theo ca hang va gia");
		System.out.println("4. Quay lai menu 1");
		String a = input.next();
		switch(a.trim()) {
			default: menu1();
			
		}
	}
	public void thoat() {
		System.out.println("Co muon thoat khong(y / n)?");
		String a = input.next();
		switch(a.trim().toLowerCase()) {
			case "n": menu1(); break;
			default: System.exit(0);
			
		}
	}
	public static void main(String[] args) {
		BanHang bh = new BanHang();
		bh.dangNhap();

	}

}
