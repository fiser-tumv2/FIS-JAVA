import java.util.Scanner;

public class Chuoi {
	
	public void inDaoNguoc() {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String xau1 = input.nextLine();
		StringBuilder xau2 = new StringBuilder(xau1); 
		System.out.println("Dao nguoc: " + xau2.reverse());
		input.close();
	}
	public void vietHoaChuDau() {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String xau1 = input.nextLine();
		StringBuilder xau2 = new StringBuilder();
		int i = 0;
		char kitu = '\0';
		for(i = 0; i < xau1.length(); i++) {
			if(xau1.charAt(i) != ' ') {
				kitu = xau1.toUpperCase().charAt(i);
				break;
			}
			xau2.append(xau1.charAt(i));
		}
		xau2.append(kitu);
		for(int j = i+1; j < xau1.length(); j++) {
			xau2.append(xau1.charAt(j));
		}
		System.out.println("Viet hoa chu dau chuoi: " + xau2);
		input.close();
	}
	
	public void vietHoaChuDauTungTu() {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String xau1 = input.nextLine();
		StringBuilder xau2 = new StringBuilder(xau1);
		int i = 0;
		char kitu;
		if(xau2.charAt(0) != ' ') {
			kitu = xau1.toUpperCase().charAt(0);
			xau2.insert(0, kitu);
			xau2.delete(1, 2);
		}
		for(i = 0; i < xau1.length(); i++) {
			if(xau2.charAt(i) == ' ' && xau2.charAt(i+1) != ' ') {
				kitu = xau1.toUpperCase().charAt(i + 1);
				xau2.insert(i + 1, kitu);
				xau2.delete(i + 2, i + 3);
			}	
		}
		System.out.println("Viet hoa chu dau tu: " + xau2);
		input.close();
	}
	
	public void inChuoiChuHoa() {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String xau1 = input.nextLine();
		StringBuilder xau2 = new StringBuilder();
		for(int i = 0; i < xau1.length(); i++) {
			if(xau1.charAt(i) >= 65 && xau1.charAt(i) <= 90) {
				xau2.append(xau1.charAt(i));
			}	
		}
		System.out.println("Chuoi chu hoa trong chuoi: " + xau2);
		input.close();
	}
	public void maHoaLech() {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhap chuoi: ");
		String xau1 = input.nextLine();
		StringBuilder xau2 = new StringBuilder();
		for(int i = 0; i < xau1.length(); i++) {	
			if(xau1.charAt(i) != ' ') {
				char kitu = xau1.charAt(i);
				int x = (int)kitu + 1;
				kitu = (char)x;
				xau2.append(kitu);
			}
			else {
				xau2.append(xau1.charAt(i));
			}
		}
		System.out.println("Ma hoa lech 1 ki tu: " + xau2);
		input.close();
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Chuoi chuoi = new Chuoi();
		System.out.println("1. In dao nguoc");
		System.out.println("2. In ra chuoi co chu dau thanh chu hoa");
		System.out.println("3. In ra chuoi co chu dau tung tu thanh chu hoa");
		System.out.println("4. In ra chuoi la chu hoa trong chuoi");
		System.out.println("5. In ra chuoi ma hoa lech mot ky tu.");
		System.out.println("6. Thoat");
		String a = input.next();
		switch(a.trim()) {
			case "1": chuoi.inDaoNguoc(); break;
			case "2": chuoi.vietHoaChuDau(); break;
			case "3": chuoi.vietHoaChuDauTungTu(); break;
			case "4": chuoi.inChuoiChuHoa(); break;
			case "5": chuoi.maHoaLech(); break;
			default: System.exit(0);
		}
		input.close();
	}
}
