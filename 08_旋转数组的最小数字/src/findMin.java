
public class findMin {

	//˳�����
	public static int MinInOrder(int[] arr,int start,int end) {

		int result = arr[start];
		for(int i = start + 1;i<=end;i++){
			if(arr[i]<result)
				result = arr[i];
		}
		return result;
	}

	public static int findmin(int[] arr){
		
			try {
				if(arr == null || arr.length <= 0)
					System.out.println("Invalid parameters");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			int start = 0;
			int end = arr.length - 1;
			int mid = start;

			if(arr[end]>arr[start] || end==start )
				return arr[start];

			while((end-start)>1){
				mid = start + (end - start)/2;

				//����㡢�յ㡢�м���ֵ�����ʱ���޷�ͨ���ƶ�����ָ������С��Χ��ֻ�ܲ���˳����ҵķ���
				if(arr[mid]==arr[start] && arr[start]<=arr[end])
					return MinInOrder(arr,start,end);

				if(arr[mid]>=arr[start])
					start = mid;
				else if(arr[mid]<=arr[end])
					end = mid;
			}
		return arr[end];
		
	}

	public static void main(String[] args) {

		//arr������һ������������ת֮�����ת����
		// 1���������룬��������������һ����ת
		int arr1[] = { 4, 5, 2, 3 };
		// 2�����ظ����֣������ظ������ָպõ���С������
		int arr2[] = { 3, 4, 5, 1, 1, 2 };
		// 3�����ظ����֣����ظ������ֲ��ǵ�һ�����ֺ����һ������
		int arr3[] = { 3, 4, 5, 1, 2, 2};
		// 4�����ظ������֣������ظ������ָպ��ǵ�һ�����ֺ����һ������
		int arr4[] = { 1, 0, 1, 1, 1};
		// 5�������������飬��ת0��Ԫ�أ�Ҳ���ǵ����������鱾��
		int arr5[] = { 4, 5, 6, 7, 8, 9 };
		// 6��������ֻ��һ������
		int arr6[] = { 8 };
		// 7������NULL
		int arr7[] = null;

		System.out.println("arr1������СֵΪ��"+findmin(arr1));
		System.out.println("arr2������СֵΪ��"+findmin(arr2));
		System.out.println("arr3������СֵΪ��"+findmin(arr3));
		System.out.println("arr4������СֵΪ��"+findmin(arr4));
		System.out.println("arr5������СֵΪ��"+findmin(arr5));
		System.out.println("arr6������СֵΪ��"+findmin(arr6));
		System.out.println("arr7������СֵΪ��"+findmin(arr7));


	}

}
