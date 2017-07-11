import java.util.Scanner;

public class NumberOf1 {

	//基本思路2
	public static int numberOf1_1(int n) {
		int count = 0;
		int flag = 1;

		while(flag!=0){
			if((n & flag)!=0)
				count++;
			
			flag = flag << 1;
		}
		return count;		
	}
	//基本思路3
	public static int numberOf1_2(int n) {
		int count = 0;
		
		while(n!=0){
			++count;
			n = (n - 1) & n;
		}
		return count;	
	}
	
	public static void main(String[] args) {
		System.out.print("请输入一个十进制整数：");
		Scanner sc = new Scanner(System.in);	
		int sc1 = sc.nextInt();
		System.out.println("该数的二进制为："+Integer.toBinaryString(sc1));
		System.out.println("思路2：该数的二进制中包含1的个数为："+numberOf1_1(sc1));
		System.out.println("思路3：该数的二进制中包含1的个数为："+numberOf1_2(sc1));
		sc.close();
	}

}
