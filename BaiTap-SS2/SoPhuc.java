
public class SoPhuc {
	private double thuc;
	private double ao;
	
	SoPhuc(double x, double y) {
		thuc = x;
		ao = y;
	}
	public void congSoPhuc(SoPhuc a) {
		double x = this.thuc + a.thuc;
		double y = this.ao + a.ao;
		this.inSoPhuc();
		System.out.print(" + ");
		a.inSoPhuc();
		System.out.print(" = ");
		(new SoPhuc(x, y)).inSoPhuc();
	}
	public void truSoPhuc(SoPhuc a) {
		double x = this.thuc - a.thuc;
		double y = this.ao - a.ao;
		this.inSoPhuc();
		System.out.print(" - ");
		a.inSoPhuc();
		System.out.print(" = ");
		(new SoPhuc(x, y)).inSoPhuc();
	}
	public void nhanSoPhuc(SoPhuc a) {
		double x = this.thuc * a.thuc - this.ao * a.ao;
		double y = this.ao * a.thuc + this.thuc * a.ao;
		this.inSoPhuc();
		System.out.print(" * ");
		a.inSoPhuc();
		System.out.print(" = ");
		(new SoPhuc(x, y)).inSoPhuc();
	}
	public void chiaSoPhuc(SoPhuc a) {
		double x = this.thuc * a.thuc + this.ao * a.ao;
		double y = this.ao * a.thuc - this.thuc * a.ao;
		x = x / (a.thuc * a.thuc + a.ao*a.ao);
		y = y / (a.thuc * a.thuc + a.ao*a.ao);
		this.inSoPhuc();
		System.out.print(" / ");
		a.inSoPhuc();
		System.out.print(" = ");
		(new SoPhuc(x, y)).inSoPhuc();
	}
	public void inSoPhuc() {
		System.out.print("("+thuc + " + " + ao + "i)");
	}
	
	public static void main(String[] args) {
		SoPhuc a = new SoPhuc(3, 3);
		SoPhuc b = new SoPhuc(3, 3);
		a.congSoPhuc(b);
		System.out.println();
		a.truSoPhuc(b);
		System.out.println();
		a.nhanSoPhuc(b);
		System.out.println();
		a.chiaSoPhuc(b);
	}

}
