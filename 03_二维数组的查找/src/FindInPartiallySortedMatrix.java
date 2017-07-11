//在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
//请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

public class FindInPartiallySortedMatrix {
	
	//从右上角开始找
	/*
	 * 首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束： 
	 * 如果该数字大于要查找的数字，剔除这个数字所在的列：如果该数字小于要查找的数字，剔除这个数字所在的行。 
	 * 也就是说如果要查找的数字不在数组的右上角，则每－次都在数组的查找范围中剔除）行或者一列，这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。 
	 */
	public static boolean Find1(int[][] matrix, int number)
	{
		boolean found = false;
		
		if( matrix == null)
			return found;
		else 
		{
			// matrix.length:行数
			// matrix[0].length：第0行的长度，即列数
			// matrix[1].length：第一行的长度，即列数
			int rows = matrix.length; 
			int cols = matrix[1].length;
			
			int row = 0;
			int col = cols -1;
			while(row < rows && col >= 0)
			{
				if(matrix[row][col] == number)
				{
					found = true;
					break;
				}
				else if(matrix[row][col] > number)
					--col;
				else
					++row;
			}
		}	
		return found;	
	}
	
	//从左下角开始找
	/*
	 * 首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束： 
	 * 如果该数字大于要查找的数字，剔除这个数字所在的列：如果该数字小于要查找的数字，剔除这个数字所在的行。 
	 * 也就是说如果要查找的数字不在数组的右上角，则每－次都在数组的查找范围中剔除）行或者一列，这样每一步都可以缩小查找的范围，直到找到要查找的数字，或者查找范围为空。 
	 */
	public static boolean Find2(int[][] matrix, int number)
	{
		boolean found = false;
		
		if( matrix == null)
			return found;
		else 
		{
			// matrix.length:行数
			// matrix[0].length：第0行的长度，即列数
			// matrix[1].length：第一行的长度，即列数
			int rows = matrix.length; 
			int cols = matrix[1].length;
			
			int row = rows-1;
			int col = 0;
			while(row >= 0 && col < cols )
			{
				if(matrix[row][col] == number)
				{
					found = true;
					break;
				}
				else if(matrix[row][col] < number)
					++col;
				else
					--row;
			}
		}	
		return found;	
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = {  
                {1, 2, 8, 9},  
                {2, 4, 9, 12},  
                {4, 7, 10, 13},  
                {6, 8, 11, 15},
                {8, 10, 15, 18} 
        };
		
		System.out.println("从右上角开始找(matrix, 15): "+Find1(matrix, 15));
		System.out.println("从右上角开始找(matrix, 16): "+Find1(matrix, 16));
		System.out.println("从右上角开始找(matrix, 7): "+Find1(matrix, 7));
		System.out.println("从右上角开始找(null, 18): "+Find1(null, 18));
		System.out.println();
		System.out.println("从左下角开始找(matrix, 15): "+Find2(matrix, 15));
		System.out.println("从左下角开始找(matrix, 16): "+Find2(matrix, 16));
		System.out.println("从左下角开始找(matrix, 7): "+Find2(matrix, 7));
		System.out.println("从左下角开始找(null, 18): "+Find2(null, 18));
	}
}
