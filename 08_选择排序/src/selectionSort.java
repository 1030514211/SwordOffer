import java.util.Scanner;

public class selectionSort {

	public static void selection_sort(int[] arr) {
		int min,temp;
		
		//i:δ�������е���λ
		for(int i = 0 ; i <arr.length-1;i++){
			//�ҳ���С��������λ����
			min = i;
			for(int j = i+1 ;j<arr.length;j++){
				if(arr[min]>arr[j])
					min = j ;
				//����Сֵ��δ�������е���λ����
				temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ҫ���������,�ö��Ÿ�����");
		System.out.print("����ǰ��");
		String inputString = sc.next();
		String[] stringArray = inputString.split(",");
		int length = stringArray.length;
		int[] data = new int[length];
		for(int i = 0;i<length;i++){
			data[i]=Integer.parseInt(stringArray[i]);
		}
		sc.close();

		selection_sort(data);
		System.out.print("�����");
		for(int i = 0;i<length;i++){
			if(i==length-1)
				System.out.print(data[i]+".");
			else
				System.out.print(data[i]+",");
		}
	}
}

