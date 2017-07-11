import java.util.Scanner;

public class MergeSort {

	//归并排序
	public static void mergeSort(int[] data){
		int[] temp =new int[data.length];
		sort(data,temp,0,data.length-1);
	}
	
	/** 
	 * 递归分治 
	 * @param data1 待排数组
	 * @param data2 临时数组，大小和data1相同
	 * @param left 左指针
	 * @param right 右指针 
	 */
	public static void sort(int[] data1, int[] data2,int left, int right) {
		if(left < right){
			// 找出中间索引 
			int mid = (left+right)/2;
			sort(data1,data2,left,mid);// 对左边数组进行递归  
			sort(data1,data2,mid+1,right);// 对右边数组进行递归  
			merge(data1,data2,left,mid,right);//合并
		}
	}
	
	//合并两个有序的数组
	public static void merge(int data[],int temp[], int left, int mid, int right) {
		//[left,mid] [mid+1,right]
		int i = left ;
		int j = mid + 1 ;
		int k = 0 ;
		//// 从两个数组中取出最小的放入临时temp数组
		while(i <= mid && j <= right){
			if(data[i]<=data[j])
				temp[k++] = data[i++];
			else
				temp[k++] = data[j++];
		}
		// 剩余部分依次放入temp数组（实际上两个while只会执行其中一个）
		//当某个数组里只剩1个元素时，直接复制
		while(i<=mid)
			temp[k++] = data[i++];
		while(j<=right)
			temp[k++] = data[j++];
		
		//将临时数组中的内容拷贝回原数组中
		for(i=0;i<k;i++){
			data[left+i] = temp[i];
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
		
		mergeSort(data);
		
		System.out.print("排序后：");
		for(int i = 0;i<length;i++){
			if(i==length-1)
				System.out.print(data[i]+".");
			else
				System.out.print(data[i]+",");
		}
	}
}