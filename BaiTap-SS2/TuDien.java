import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TuDien {
	private ArrayList<Nut> list = new ArrayList<Nut>();
	
	public void docDuLieu() {
		try {
			FileReader file = new FileReader("tudien.txt");
			Scanner input = new Scanner(file);
			while(input.hasNextLine()) {
				String xau = input.nextLine();
				String[] mang = xau.split("[:]");
				Nut nut = new Nut();
				nut.set(mang[0], mang[1]);
				list.add(nut);
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void themTu() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap tu: ");
		String tu = input.nextLine();
		System.out.println("Nhap nghia: ");
		String nghia = input.nextLine();
		Nut nut = new Nut();
		int dem = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).tu.trim().equals(tu.trim()) && 
					!list.get(i).nghia.trim().equals(nghia.trim())) {
				list.get(i).nghia = list.get(i).nghia + ", " + nghia;
				break;
			}
			else if (list.get(i).tu.trim().equals(tu.trim()) && 
					list.get(i).nghia.trim().equals(nghia.trim())){
				break;
			}
			else {
				dem++;
			}
		}
		if(dem >= list.size()) { 
			nut.tu = tu;
			nut.nghia = " " + nghia;
			list.add(nut);
		}
		System.out.println("Them thanh cong!");
		menu();
		input.close();
	}
	
	public void traTu() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap tu: ");
		String tu = input.nextLine();
		int dem = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).tu.trim().equals(tu.trim())) {
				System.out.println(list.get(i).tu + ":" + list.get(i).nghia);
				break;
			}
			else {
				dem++;
			}
		}
		if(dem >= list.size()) {
			System.out.println("Khong co tu can tim.");
		}
		input.nextLine();
		menu();
		input.close();
	}
	
	public void xoa() {
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap tu can xoa: ");
		String tu = input.nextLine();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).tu.trim().equals(tu.trim())) {
				list.remove(i);
				break;
			}
		}
		System.out.println("Da xoa.");
		menu();
		input.close();
	}
	
	public void thoat() {
		System.out.println("Co thoat khong? (Y/N)");
		Scanner input = new Scanner(System.in);
		String a = input.next();
		if(a.trim().equals("n")) {
			menu();
		}
		input.close();
	}
	public void ghiDuLieu() {
		try {
			FileWriter file = new FileWriter("tudien.txt");
			for(int i = 0; i < list.size(); i++) {
				String xau = list.get(i).tu + ":" + list.get(i).nghia;
				file.write(xau + "\r\n");
			}
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void menu() {
		Scanner input = new Scanner(System.in);
		System.out.println("1. Them tu");
		System.out.println("2. Tra tu");
		System.out.println("3. Xoa");
		System.out.println("4. Thoat");
		String a = input.next();
		switch(a.trim()) {
			case "1": themTu(); break;
			case "2": traTu(); break;
			case "3": xoa(); break;
			default: thoat(); break;
		}
		input.close();
	}
	
	public static void main(String[] args) {
		TuDien tudien = new TuDien();
		tudien.docDuLieu();
		tudien.menu();
		tudien.ghiDuLieu();
	}
}

class Nut {
	public String tu;
	public String nghia;
	public void set(String a, String b) {
		tu = a;
		nghia = b;
	}
}
