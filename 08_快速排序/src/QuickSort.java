import java.util.Scanner;

public class QuickSort {

	//选择数组中的一个数，把数组中数字分成两部分，比该数小的移到左边，比该数大的移到右边
	public static int partition(int[] data,int start,int end){
		int pivot = 0;
		int left = start;
		int right = end;
		if(left<=right){
			//pivot：基准元素
			pivot = data[start];
			//从左右两边交替扫描,直到left=right
			while(left!=right){
				//从右往左扫描，找到第一个比基准元素小的元素
				while( right > left && data[right] >= pivot)
					right--;
				//找到这种元素data[right]后与data[left]交换
				data[left] = data[right];
				
				//从左往右扫描，找到第一个比基准元素大的元素
				while( left < right && data[left] <= pivot)
					left++;
				//找到这种元素data[left]后与data[right]交换
				data[right] = data[left];
			}
		}
		data[right] = pivot;//基准元素归位
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

		quickSort(data,0,length-1);
		System.out.print("排序后：");
		for(int i = 0;i<length;i++){
			if(i==length-1)
				System.out.print(data[i]+".");
			else
				System.out.print(data[i]+",");
		}
	}
}
