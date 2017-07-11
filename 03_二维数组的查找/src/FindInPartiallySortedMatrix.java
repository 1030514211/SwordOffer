//��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
//�����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������

public class FindInPartiallySortedMatrix {
	
	//�����Ͻǿ�ʼ��
	/*
	 * ����ѡȡ���������Ͻǵ����֡���������ֵ���Ҫ���ҵ����֣����ҹ��̽����� 
	 * ��������ִ���Ҫ���ҵ����֣��޳�����������ڵ��У����������С��Ҫ���ҵ����֣��޳�����������ڵ��С� 
	 * Ҳ����˵���Ҫ���ҵ����ֲ�����������Ͻǣ���ÿ���ζ�������Ĳ��ҷ�Χ���޳����л���һ�У�����ÿһ����������С���ҵķ�Χ��ֱ���ҵ�Ҫ���ҵ����֣����߲��ҷ�ΧΪ�ա� 
	 */
	public static boolean Find1(int[][] matrix, int number)
	{
		boolean found = false;
		
		if( matrix == null)
			return found;
		else 
		{
			// matrix.length:����
			// matrix[0].length����0�еĳ��ȣ�������
			// matrix[1].length����һ�еĳ��ȣ�������
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
	
	//�����½ǿ�ʼ��
	/*
	 * ����ѡȡ���������Ͻǵ����֡���������ֵ���Ҫ���ҵ����֣����ҹ��̽����� 
	 * ��������ִ���Ҫ���ҵ����֣��޳�����������ڵ��У����������С��Ҫ���ҵ����֣��޳�����������ڵ��С� 
	 * Ҳ����˵���Ҫ���ҵ����ֲ�����������Ͻǣ���ÿ���ζ�������Ĳ��ҷ�Χ���޳����л���һ�У�����ÿһ����������С���ҵķ�Χ��ֱ���ҵ�Ҫ���ҵ����֣����߲��ҷ�ΧΪ�ա� 
	 */
	public static boolean Find2(int[][] matrix, int number)
	{
		boolean found = false;
		
		if( matrix == null)
			return found;
		else 
		{
			// matrix.length:����
			// matrix[0].length����0�еĳ��ȣ�������
			// matrix[1].length����һ�еĳ��ȣ�������
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
		
		System.out.println("�����Ͻǿ�ʼ��(matrix, 15): "+Find1(matrix, 15));
		System.out.println("�����Ͻǿ�ʼ��(matrix, 16): "+Find1(matrix, 16));
		System.out.println("�����Ͻǿ�ʼ��(matrix, 7): "+Find1(matrix, 7));
		System.out.println("�����Ͻǿ�ʼ��(null, 18): "+Find1(null, 18));
		System.out.println();
		System.out.println("�����½ǿ�ʼ��(matrix, 15): "+Find2(matrix, 15));
		System.out.println("�����½ǿ�ʼ��(matrix, 16): "+Find2(matrix, 16));
		System.out.println("�����½ǿ�ʼ��(matrix, 7): "+Find2(matrix, 7));
		System.out.println("�����½ǿ�ʼ��(null, 18): "+Find2(null, 18));
	}
}
