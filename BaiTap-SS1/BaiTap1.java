import java.util.Scanner;

public class BaiTap1 {

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            int n = input.nextInt();
            int[] mang = new int[n];
            for(int i = 0; i < n; i++) {
                mang[i] = input.nextInt();
            }
        
            System.out.println(max(mang, n) + " " + min(mang, n));
            xepTangDan(mang, n);
            System.out.println();
            xepGiamDan(mang, n);
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static int max(int[] mang, int n) {
        int max = mang[0];
        for(int i = 1; i < n; i++) {
            if(mang[i] > max) {
                max = mang[i];
            }
        }
        return max;
    }
    
    public static int min(int[] mang, int n) {
        int min = mang[0];
        for(int i = 1; i < n; i++) {
            if(mang[i] < min) {
                min = mang[i];
            }
        }
        return min;
    }
    
    public static void xepTangDan(int[] mang,int n) {
        for(int i = 0; i < n - 1 ; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(mang[j] > mang[i + 1]) {
                    int temp = mang[j];
                    mang[j] = mang[i + 1];
                    mang[i + 1] = temp;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            System.out.print(mang[i] + " ");
        }
    }
    
        public static void xepGiamDan(int[] mang,int n) {
        for(int i = 0; i < n - 1 ; i++) {
            for(int j = 0; j < n - 1; j++) {
                if(mang[j] < mang[i + 1]) {
                    int temp = mang[j];
                    mang[j] = mang[i + 1];
                    mang[i + 1] = temp;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            System.out.print(mang[i] + " ");
        }
    }
}
