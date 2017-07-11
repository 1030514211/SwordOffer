import java.util.Scanner;

public class insertionSort {

	public static void InsertionSort(int[] data){
		int length = data.length;
		for(int i = 0; i < length-1 ; i++ )
			for(int j = i+1 ; j > 0 ; j-- )
				if(data[j-1]>data[j]){
					int temp = data[j];
					data[j] = data[j-1];
					data[j-1] = temp;
				}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入需要排序的数组,用逗号隔开：");
		System.out.print("排序前：");
		String inputString = sc.next();
		String[] stringArray = inputString.split(",");
		int length = stringArray.length;
		int[] data = new int[length];
		for(int i = 0;i<length;i++){
			data[i]=Integer.parseInt(stringArray[i]);
		}
		sc.close();
		
		InsertionSort(data);
		
		System.out.print("排序后：");
		for(int i = 0;i<length;i++){
			if(i==length-1)
				System.out.print(data[i]+".");
			else
				System.out.print(data[i]+",");
		}
	}
}
