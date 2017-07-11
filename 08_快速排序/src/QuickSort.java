import java.util.Scanner;

public class QuickSort {

	//ѡ�������е�һ�����������������ֳַ������֣��ȸ���С���Ƶ���ߣ��ȸ�������Ƶ��ұ�
	public static int partition(int[] data,int start,int end){
		int pivot = 0;
		int left = start;
		int right = end;
		if(left<=right){
			//pivot����׼Ԫ��
			pivot = data[start];
			//���������߽���ɨ��,ֱ��left=right
			while(left!=right){
				//��������ɨ�裬�ҵ���һ���Ȼ�׼Ԫ��С��Ԫ��
				while( right > left && data[right] >= pivot)
					right--;
				//�ҵ�����Ԫ��data[right]����data[left]����
				data[left] = data[right];
				
				//��������ɨ�裬�ҵ���һ���Ȼ�׼Ԫ�ش��Ԫ��
				while( left < right && data[left] <= pivot)
					left++;
				//�ҵ�����Ԫ��data[left]����data[right]����
				data[right] = data[left];
			}
		}
		data[right] = pivot;//��׼Ԫ�ع�λ
		return right;
	}
	
	public static void quickSort(int[] data,int start,int end){
		int location = 0;
		if(start < end){
			location = partition(data,start,end);
			quickSort(data,start,location-1);
			quickSort(data,location+1,end);
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

		quickSort(data,0,length-1);
		System.out.print("�����");
		for(int i = 0;i<length;i++){
			if(i==length-1)
				System.out.print(data[i]+".");
			else
				System.out.print(data[i]+",");
		}
	}
}
