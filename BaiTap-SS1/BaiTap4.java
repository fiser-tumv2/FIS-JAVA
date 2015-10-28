import java.util.Scanner;
public class BaiTap4 {
    
    public static int hangNgang(char[][] a, int n, int m, String chuoi) {
        int dem = 0;
        if(chuoi.length() > m) return 0;
        else {
            for(int i = 0; i < n+1; i++) {
                //từ trái qua phải
                for(int j = 0; j <= (m - chuoi.length()); j++){
                    String xau = "";
                    for(int k = j; k < (j + chuoi.length()); k++) {
                        xau+=a[i][k];
                    }
                    if(xau.equals(chuoi)) dem++;
                }
                //từ phải qua trái
                for(int j = m - 1; j >= chuoi.length() - 1; j--){
                    String xau = "";
                    for(int k = j; k > (j - chuoi.length()); k--) {
                        xau+=a[i][k];
                    }
                    if(xau.equals(chuoi)) dem++;
                }
            }
        }
        return dem;
    }
    
    public static int hangDoc(char[][] a, int n, int m, String chuoi) {
        int dem = 0;
        if(chuoi.length() > n+1) return 0;
        else {
            for(int i = 0; i < m; i++) {
                //từ trên xuống dưới
                for(int j = 0; j <= (n + 1 - chuoi.length()); j++){
                    String xau = "";
                    for(int k = j; k < (j + chuoi.length()); k++) {
                        xau+=a[k][i];
                    }
                    
                    if(xau.equals(chuoi)) dem++;
                }
                //từ dưới lên trên
                for(int j = n; j >= chuoi.length() - 1; j--){
                    String xau = "";
                    for(int k = j; k > (j - chuoi.length()); k--) {
                        xau+=a[k][i];
                    }
                    if(xau.equals(chuoi)) dem++;
                }
            }
        }
        return dem;
    }
        
    public static int hangCheo(char[][] a, int n, int m, String chuoi) {
        int dem = 0;
        if(chuoi.length() > n+1 || chuoi.length() > m) return 0;
        else {
            //trái trên -> phải dưới 
            for(int i = 0; i <= n+1-chuoi.length(); i++) {
                for(int j = 0; j <= m - chuoi.length(); j++){
                    String xau = "";
                    for(int k = j; k < (j + chuoi.length()); k++) {
                        xau+=a[k-j+i][k];
                    }
                    if(xau.equals(chuoi)) dem++;
                }
            }
            //phải dưới -> trái trên
            for(int i = n; i >= chuoi.length() - 1; i--) {
                for(int j = m-1; j >= chuoi.length() - 1; j--){
                    String xau = "";
                    for(int k = j; k > (j - chuoi.length()); k--) {
                        xau+=a[i+k-j][k];
                    }
                    if(xau.equals(chuoi)) dem++;
                }
            }
            //trái dưới -> phải trên
            for(int i = n; i >= chuoi.length() - 1; i--) {
                for(int j = 0; j <= m - chuoi.length(); j++){
                    String xau = "";
                    for(int k = j; k < (j + chuoi.length()); k++) {
                        xau+=a[i+j-k][k];
                    }
                    if(xau.equals(chuoi)) dem++;
                }
            }
            //phải trên -> trái dưới
            for(int i = 0; i <= n+1-chuoi.length(); i++) {
                for(int j = m - 1; j >= chuoi.length() - 1; j--){
                    String xau = "";
                    for(int k = j; k > (j - chuoi.length()); k--) {
                        xau+=a[i+j-k][k];
                    }
                    if(xau.equals(chuoi)) dem++;
                }
            }
        }
        return dem;
        
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        
        char[][] mang = new char[n+1][m];
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < m; j++) {
                mang[i][j] = input.next().charAt(0);
            }
        }
        String chuoi = input.next();
        System.out.println("-------------------");
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(mang[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println(hangNgang(mang, n, m, chuoi.trim()));
        System.out.println(hangDoc(mang, n, m, chuoi.trim()));
        System.out.println(hangCheo(mang, n, m, chuoi.trim()));
    }
}