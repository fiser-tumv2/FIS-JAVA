import java.util.Arrays;
import java.util.Scanner;

public class BaiTap3 {
    
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            String chuoi = input.nextLine();
            String[] a = chuoi.toLowerCase().replaceAll(",", "").replaceAll("[.]", "").split(" ");
            int n = a.length;
            String[] mangdem = new String[n];
            int k = 0;
            Arrays.sort(a);//sắp xếp dãy
            //tạo mảng các chuỗi gồm: chữ + số lần xuất hiện
            for(int i = 0; i < n; i++) {
                mangdem[k] = a[i] + " " + kiemTra(a, n, a[i]);
                i = i + kiemTra(a, n, a[i]) - 1;
                k++;
           }
            //sắp xếp theo thứ tự giảm số lần xuất hiện
            for(int i = 0; i < k - 1; i++) {
               for(int j = 0; j < k - 1; j++) {
                   if(soSanh(mangdem[j], mangdem[i+1]) < 0) {
                       String xau = mangdem[j];
                       mangdem[j] = mangdem[i+1];
                       mangdem[i+1] = xau;
                   }
                   if(soSanh(mangdem[j], mangdem[i+1]) == 0) {
                       if(mangdem[j].compareTo(mangdem[i+1]) > 0) {
                            String xau = mangdem[j];
                            mangdem[j] = mangdem[i+1];
                            mangdem[i+1] = xau;
                       }
                   }
               }
            } 
           for(int i = 0; i < k; i++) {
                if(mangdem[i] != null)
                    System.out.println(mangdem[i]);
           }
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    //đếm số lần xuất hiện của phần tử trong mảng đã sắp xếp 
    public static int kiemTra(String[] mang, int n, String x) {
        int dem = 0;
        for(int i = 0; i < n; i++) {
            if(x.equals(mang[i])) {
                dem++;
            }
        }
        return dem;
    }
    //so sánh 2 chuỗi với số lần suất hiện
    public static int soSanh(String a, String b) {
        if(a != null && b != null) {
            char a1 = a.charAt(a.length() - 1);
            char b1 = b.charAt(b.length() - 1);
            return a1 - b1;
        }
        else return 0;
    }
}

