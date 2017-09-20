import java.util.Scanner;

public class ReorderArray {
	
	//������ǰ��ż���ں�
	private static boolean func1(int n) {	
		return (n % 2 == 1);
	}
	
	//������ǰ���Ǹ����ں�
	private static boolean func2(int n) {	
		return (n < 0);
	}
	
	//�ܱ�3������ǰ�����ܵ��ں�
	private static boolean func(int n) {	
		return (n % 3 == 0);
	}
	
	private static void order(int[] data) {
		if(data == null || data.length <2)
			return;
		int start = 0;
		int end = data.length-1;
		while(start<end){			
			while(start<end && func(data[start]))
				start++;
			while(start<end && !func(data[end]))
				end--;
			
			int temp = data[start];
			data[start] = data[end];
			data[end] = temp;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		String[] stringArray = inputString.split("\\s+");
		int length = stringArray.length;
		int[] data = new int[length];
		for(int i = 0;i < length;i++){
			data[i]=Integer.parseInt(stringArray[i]);
		}
		order(data);
		for(int i = 0;i < length;i++){
			System.out.print(data[i] + " ");
		}
		sc.close();
	}
}