public class replaceBlank {
	
	//请实现一个函数，把字符串中的每个空格替换成"%20"
	//例如“We are happy.”，则输出“We%20are%20happy.”
	//length:最大长度        originalLength：字符串的实际长度
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
		//newLength：替换后的字符串的长度
		int newLength = originalLength + numberOfBlank * 2;
 
		if(newLength > length)
			return ;
		
		//从后往前
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
			System.out.print("字符串输入错误");
			return  ;
		}
		int originalLength = input.length();
		System.out.println("原字符串："+ input);
		for(int i=0;i<originalLength;i++)
		{
			char ch = input.charAt(i);
			output[i] = ch;
		}
		
		replaceBlank a = new replaceBlank();
		a.replace(output,max,originalLength);
		
		System.out.print("现字符串：");
		System.out.println(output);
	}
	
	
	public static void main(String[] args) {
		int max=100;

		String str1 = "hello world";// 空格在句子中间
		output(str1,max);
		String str2 = "hello  world";// 连续有两个空格
		output(str2,max);
		String str3 = " helloworld";// 空格在句子开头
		output(str3,max);
		String str4 = " helloworld ";// 空格在句子末尾
		output(str4,max);
		String str5 = "";// 传入内容为空的字符串
		output(str5,max);
		String str6 = " ";// 传入内容为一个空格的字符串
		output(str6,max);
		String str7 = "       ";// 传入的字符串全是空格
		output(str7,max);
		String str8 = null;// 传入NULL
		output(str8,max);
	}
}
