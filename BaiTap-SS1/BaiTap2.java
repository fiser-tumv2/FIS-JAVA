import java.util.Scanner;
import java.util.Stack;

public class BaiTap2 {
    
    public  int demcong = 0;
    public  int demnhan = 0;

    private Stack<Integer> stack = new Stack<Integer>();
    
    private int tong = 0;
    private int tich = 1;
    
    public int toHopCong(int[] data, int first, int last, int m) {
        if (tong == m && stack.size() > 1) {
            demcong++;
        }
        for (int i = first; i < last; i++) {
            if (tong + data[i] <= m) {
                stack.push(data[i]);
                tong += data[i];
                toHopCong(data, i + 1, last, m);
                tong = tong - stack.pop();
            }
        }
        return demcong;
    }
    
    public int toHopTru(int[] data, int first, int last, int m) { 
        int dem = 0;
        for(int i = first; i < last; i++) {
            if(data[i] >= m)
                dem +=  toHopCong(data, first, last, data[i] - m);
        }
        return dem;
    }
    public int toHopNhan(int[] data, int first, int last, int m) {
        if (tich == m && stack.size()>1) {
            demnhan++;
        }
        for (int i = first; i < last; i++) {
            if (tich * data[i] <= m) {
                stack.push(data[i]);
                tich *= data[i];
                toHopNhan(data, i + 1, last, m);
                try {
                    tich = tich / stack.pop();
                }
                catch(Exception ex) {
                    System.out.println(ex.getMessage());
                }            
            }
        }
        return demnhan;
    }
    
    public int toHopChia(int[] data, int first, int last, int m) { 
        int dem = 0;
        for(int i = first; i < last; i++) {
            if(data[i] >= m && data[i]%m == 0)
                dem +=  toHopNhan(data, first, last, data[i] / m);
        }
        return dem;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] data = new int[n];
        for(int i = 0; i < n; i++) {
            data[i] = input.nextInt();
        }
        int m = input.nextInt();
        
        BaiTap2 get = new BaiTap2();
        System.out.println("-------------------------");
        System.out.println(get.toHopCong(data, 0, n, m));
        System.out.println(get.toHopTru(data, 0, n, m));
        System.out.println(get.toHopNhan(data, 0, n, m));
        System.out.println(get.toHopChia(data, 0, n, m));
    }
}