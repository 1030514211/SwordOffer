import java.util.Scanner;

//ð������
public class bubbleSort {

	public static int[] BubbleSort(int[] data){
		int len = data.length;
		int middle=0;
		for(int i = 0;i<len-1;i++)
			for(int j = 0;j<len-1-i;j++){
				if(data[j]>data[j+1]){
					middle=data[j];
					data[j]=data[j+1];
					data[j+1]=middle;
			}
		}	
		return data;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������Ҫ���������,�ö��Ÿ�����");
		System.out.print("����ǰ��");
		String inputString = sc.next();
		String[] stringArray = inputString.split(",");
		int length = stringArray.length;
		int[] data = new int[length];
		int[] data1 = new int[length];
		for(int i = 0;i<length;i++){
			data[i]=Integer.parseInt(stringArray[i]);
		}
		sc.close();
		
		data1=BubbleSort(data);

		System.out.print("�����");
		for(int i = 0;i<length;i++){
			if(i==length-1)
				System.out.print(data1[i]+".");
			else
				System.out.print(data1[i]+",");
		}
	}
}

