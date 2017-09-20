import java.util.Scanner;

public class Print1ToMax {

	//对数字进行加1操作
	public static boolean Increment(int[] num){
		boolean isOverflow = false;
		int nTakeOver = 0;
		for(int i=num.length-1; i >= 0;i--){
			int nSum = num[i] +nTakeOver;
			if(i == num.length-1)
				nSum++;
			if(nSum >= 10){
				if(i == 0)
					isOverflow = true;
				else{
					nTakeOver = 1;
					nSum = nSum - 10;
					num[i] = nSum;
				}
			}
			else{
				num[i] = nSum;
				break;
			}
		}
		return isOverflow;	
	}
	
	public static void PrintNumber(int[] num) {
		boolean isBeginning = true;
		for(int i = 0 ; i< num.length;i++){
			if(isBeginning && num[i] != 0)
				isBeginning = false;
			if(!isBeginning)
				System.out.print(num[i]);
			}
		}
	
	//打印从1到最大的n位数
	public static void Test(int n) {
		if(n <= 0)
			System.out.println("Input Error!");
		int[] num = new int[n];
		while(!Increment(num)){
			PrintNumber(num);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please input number:");
		int num = scanner.nextInt();
		Test(num);
		scanner.close();
	}
}
