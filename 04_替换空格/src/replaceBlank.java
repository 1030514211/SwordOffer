public class replaceBlank {
	
	//��ʵ��һ�����������ַ����е�ÿ���ո��滻��"%20"
	//���硰We are happy.�����������We%20are%20happy.��
	//length:��󳤶�        originalLength���ַ�����ʵ�ʳ���
	public void replace(char string[],int length,int originalLength)
	{
		if(string == null || length <= 0)
		{
			return  ;
		}
			
		
		int numberOfBlank = 0;
		for(int i=0;i<originalLength;i++)
		{
			if(string[i] == ' ')
			{
				numberOfBlank++;
			}
		}
		//newLength���滻����ַ����ĳ���
		int newLength = originalLength + numberOfBlank * 2;
 
		if(newLength > length)
			return ;
		
		//�Ӻ���ǰ
		int indexOfOriginal = originalLength-1;
		int indexOfNew = newLength-1;

		while(indexOfOriginal >= 0 && indexOfNew >= indexOfOriginal)
		{
			if(string[indexOfOriginal] == ' ')
			{
				string[indexOfNew--] = '0';
				string[indexOfNew--] = '2';
				string[indexOfNew--] = '%';
			}
			else
			{
				string[indexOfNew--] = string[indexOfOriginal];
			}
			indexOfOriginal--;
		}	
	}

	public static void output(String input,int max)
	{
		//max = 50;
		char[] output= new char[max];
		if(input == null)
		{
			System.out.print("�ַ����������");
			return  ;
		}
		int originalLength = input.length();
		System.out.println("ԭ�ַ�����"+ input);
		for(int i=0;i<originalLength;i++)
		{
			char ch = input.charAt(i);
			output[i] = ch;
		}
		
		replaceBlank a = new replaceBlank();
		a.replace(output,max,originalLength);
		
		System.out.print("���ַ�����");
		System.out.println(output);
	}
	
	
	public static void main(String[] args) {
		int max=100;

		String str1 = "hello world";// �ո��ھ����м�
		output(str1,max);
		String str2 = "hello  world";// �����������ո�
		output(str2,max);
		String str3 = " helloworld";// �ո��ھ��ӿ�ͷ
		output(str3,max);
		String str4 = " helloworld ";// �ո��ھ���ĩβ
		output(str4,max);
		String str5 = "";// ��������Ϊ�յ��ַ���
		output(str5,max);
		String str6 = " ";// ��������Ϊһ���ո���ַ���
		output(str6,max);
		String str7 = "       ";// ������ַ���ȫ�ǿո�
		output(str7,max);
		String str8 = null;// ����NULL
		output(str8,max);
	}
}
