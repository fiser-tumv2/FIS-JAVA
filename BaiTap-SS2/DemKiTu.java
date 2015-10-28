import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DemKiTu {
	
	private ArrayList<Note> list = new ArrayList<Note>();
	
	public String docDuLieu() {
		String xau = "";
		try {
			FileReader file = new FileReader("text.txt");
			Scanner input = new Scanner(file);
			while(input.hasNextLine()) {
				xau += input.nextLine();
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return xau;
	}
	public void demKiTu(String xau) {
		for(int i = 0; i < xau.length(); i++) {
			if(kiemTra(xau.charAt(i)) >= 0) {
				list.get(kiemTra(xau.charAt(i))).soluong++;
			}
			else {
				Note nut = new Note();
				nut.set(xau.charAt(i), 1);
				list.add(nut);
			}
		}
	}
	public int kiemTra(char a) {
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).kitu == a) {
				return i;
			}
		}
		return -1;
	}
	
	public void inKetQua() {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).kitu + " " + list.get(i).soluong);
		}
	}
	public static void main(String[] args) {
		DemKiTu dem = new DemKiTu();
		dem.demKiTu(dem.docDuLieu());
		dem.inKetQua();
	}

}

class Note {
	public char kitu;
	public int soluong;
	public void set(char a, int b) {
		kitu = a;
		soluong = b;
	}
}
