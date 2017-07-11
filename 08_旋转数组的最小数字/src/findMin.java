
public class findMin {

	//顺序查找
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

				//若起点、终点、中间点的值都相等时，无法通过移动两个指针来缩小范围，只能采用顺序查找的方法
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

		//arr数组是一个递增数组旋转之后的旋转数组
		// 1、典型输入，单调升序的数组的一个旋转
		int arr1[] = { 4, 5, 2, 3 };
		// 2、有重复数字，并且重复的数字刚好的最小的数字
		int arr2[] = { 3, 4, 5, 1, 1, 2 };
		// 3、有重复数字，但重复的数字不是第一个数字和最后一个数字
		int arr3[] = { 3, 4, 5, 1, 2, 2};
		// 4、有重复的数字，并且重复的数字刚好是第一个数字和最后一个数字
		int arr4[] = { 1, 0, 1, 1, 1};
		// 5、单调升序数组，旋转0个元素，也就是单调升序数组本身
		int arr5[] = { 4, 5, 6, 7, 8, 9 };
		// 6、数组中只有一个数字
		int arr6[] = { 8 };
		// 7、输入NULL
		int arr7[] = null;

		System.out.println("arr1数组最小值为："+findmin(arr1));
		System.out.println("arr2数组最小值为："+findmin(arr2));
		System.out.println("arr3数组最小值为："+findmin(arr3));
		System.out.println("arr4数组最小值为："+findmin(arr4));
		System.out.println("arr5数组最小值为："+findmin(arr5));
		System.out.println("arr6数组最小值为："+findmin(arr6));
		System.out.println("arr7数组最小值为："+findmin(arr7));


	}

}
