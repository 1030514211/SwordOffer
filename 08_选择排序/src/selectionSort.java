import java.util.Scanner;

public class selectionSort {

	public static void selection_sort(int[] arr) {
		int min,temp;
		
		//i:未排序序列的首位
		for(int i = 0 ; i <arr.length-1;i++){
			//找出最小数，与首位交换
			min = i;
			for(int j = i+1 ;j<arr.length;j++){
				if(arr[min]>arr[j])
					min = j ;
				//把最小值跟未排序序列的首位交换
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
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

		selection_sort(data);
		System.out.print("排序后：");
		for(int i = 0;i<length;i++){
			if(i==length-1)
				System.out.print(data[i]+".");
			else
				System.out.print(data[i]+",");
		}
	}
}

