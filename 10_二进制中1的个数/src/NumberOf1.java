import java.util.Scanner;

public class NumberOf1 {

	//����˼·2
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
	//����˼·3
	public static int numberOf1_2(int n) {
		int count = 0;
		
		while(n!=0){
			++count;
			n = (n - 1) & n;
		}
		return count;	
	}
	
	public static void main(String[] args) {
		System.out.print("������һ��ʮ����������");
		Scanner sc = new Scanner(System.in);	
		int sc1 = sc.nextInt();
		System.out.println("�����Ķ�����Ϊ��"+Integer.toBinaryString(sc1));
		System.out.println("˼·2�������Ķ������а���1�ĸ���Ϊ��"+numberOf1_1(sc1));
		System.out.println("˼·3�������Ķ������а���1�ĸ���Ϊ��"+numberOf1_2(sc1));
		sc.close();
	}

}
