import java.util.Scanner;

public class MergeSort {

	//�鲢����
	public static void mergeSort(int[] data){
		int[] temp =new int[data.length];
		sort(data,temp,0,data.length-1);
	}
	
	/** 
	 * �ݹ���� 
	 * @param data1 ��������
	 * @param data2 ��ʱ���飬��С��data1��ͬ
	 * @param left ��ָ��
	 * @param right ��ָ�� 
	 */
	public static void sort(int[] data1, int[] data2,int left, int right) {
		if(left < right){
			// �ҳ��м����� 
			int mid = (left+right)/2;
			sort(data1,data2,left,mid);// �����������еݹ�  
			sort(data1,data2,mid+1,right);// ���ұ�������еݹ�  
			merge(data1,data2,left,mid,right);//�ϲ�
		}
	}
	
	//�ϲ��������������
	public static void merge(int data[],int temp[], int left, int mid, int right) {
		//[left,mid] [mid+1,right]
		int i = left ;
		int j = mid + 1 ;
		int k = 0 ;
		//// ������������ȡ����С�ķ�����ʱtemp����
		while(i <= mid && j <= right){
			if(data[i]<=data[j])
				temp[k++] = data[i++];
			else
				temp[k++] = data[j++];
		}
		// ʣ�ಿ�����η���temp���飨ʵ��������whileֻ��ִ������һ����
		//��ĳ��������ֻʣ1��Ԫ��ʱ��ֱ�Ӹ���
		while(i<=mid)
			temp[k++] = data[i++];
		while(j<=right)
			temp[k++] = data[j++];
		
		//����ʱ�����е����ݿ�����ԭ������
		for(i=0;i<k;i++){
			data[left+i] = temp[i];
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
		
		mergeSort(data);
		
		System.out.print("�����");
		for(int i = 0;i<length;i++){
			if(i==length-1)
				System.out.print(data[i]+".");
			else
				System.out.print(data[i]+",");
		}
	}
}