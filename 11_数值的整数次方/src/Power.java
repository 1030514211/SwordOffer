import java.util.Scanner;

public class Power {

	static boolean g_InvalidInput = false;
	
	// base：底数     
	// exponent：指数
	static double power(double base,int exponent) {
		
		g_InvalidInput = false;
		
		if(exponent == 0)
	        return 1.0;
	    if(exponent == 1)
	        return base;
	    
		// 当底数为0，指数为负时，需要做处理，不然会对0求倒数导致程序运行出错
		// 并且通过一个全局变量告诉函数的调用者出现了这个错误
		if( equal(base, 0.0) && exponent < 0){
			g_InvalidInput = true;
			return 0.0;
		}
			
		// absExponent：底数的绝对值
		int absExponent = exponent;
		if( exponent < 0 )
			absExponent = -absExponent;
		
		/*//第一种方法
		double result = 1.0;
		for(int i = 1; i <= absExponent ; ++i)
			result *= base;*/
		
		//第二种方法
		double result = PowerWithUnsignedExponent(base, absExponent);
		
		if( exponent < 0 )
			result = 1.0 / result;
		
		return result;
	}
	
	//更快的方法
	static double PowerWithUnsignedExponent(double base, int exponent){
		
		if(exponent == 0)
	        return 1.0;
	    if(exponent == 1)
	        return base;
	    
	    double result =PowerWithUnsignedExponent(base, exponent >> 1);
	    result *= result;
	    //按位做与运算，判断一个数是奇数还是偶数，等于1为奇数。
	    if( (exponent & 0x1) == 1)
	    	result *= base;
	    
		return result;
	}
	
	//在计算机内表示小数时，都有误差，所以不能用==判断是否相等，只能判断他们之差的绝对值是不是在很小的一个范围内
	static boolean equal(double num1,double num2) {
		if( (num1 - num2) > -0.0000001 && (num1 - num2) < 0.0000001)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		System.out.println("底数为：");
		Scanner sc1 = new Scanner(System.in);	
		double sc11 = sc1.nextDouble();
		
		System.out.println("指数为：");
		Scanner sc2 = new Scanner(System.in);	
		int sc21 = sc2.nextInt();
		
		System.out.println(sc11+"的"+sc21+"次方为："+power(sc11,sc21));
		sc1.close();
		sc2.close();
	}
}
