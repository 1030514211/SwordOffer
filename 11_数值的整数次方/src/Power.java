import java.util.Scanner;

public class Power {

	static boolean g_InvalidInput = false;
	
	// base������     
	// exponent��ָ��
	static double power(double base,int exponent) {
		
		g_InvalidInput = false;
		
		if(exponent == 0)
	        return 1.0;
	    if(exponent == 1)
	        return base;
	    
		// ������Ϊ0��ָ��Ϊ��ʱ����Ҫ��������Ȼ���0�������³������г���
		// ����ͨ��һ��ȫ�ֱ������ߺ����ĵ����߳������������
		if( equal(base, 0.0) && exponent < 0){
			g_InvalidInput = true;
			return 0.0;
		}
			
		// absExponent�������ľ���ֵ
		int absExponent = exponent;
		if( exponent < 0 )
			absExponent = -absExponent;
		
		/*//��һ�ַ���
		double result = 1.0;
		for(int i = 1; i <= absExponent ; ++i)
			result *= base;*/
		
		//�ڶ��ַ���
		double result = PowerWithUnsignedExponent(base, absExponent);
		
		if( exponent < 0 )
			result = 1.0 / result;
		
		return result;
	}
	
	//����ķ���
	static double PowerWithUnsignedExponent(double base, int exponent){
		
		if(exponent == 0)
	        return 1.0;
	    if(exponent == 1)
	        return base;
	    
	    double result =PowerWithUnsignedExponent(base, exponent >> 1);
	    result *= result;
	    //��λ�������㣬�ж�һ��������������ż��������1Ϊ������
	    if( (exponent & 0x1) == 1)
	    	result *= base;
	    
		return result;
	}
	
	//�ڼ�����ڱ�ʾС��ʱ�����������Բ�����==�ж��Ƿ���ȣ�ֻ���ж�����֮��ľ���ֵ�ǲ����ں�С��һ����Χ��
	static boolean equal(double num1,double num2) {
		if( (num1 - num2) > -0.0000001 && (num1 - num2) < 0.0000001)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		System.out.println("����Ϊ��");
		Scanner sc1 = new Scanner(System.in);	
		double sc11 = sc1.nextDouble();
		
		System.out.println("ָ��Ϊ��");
		Scanner sc2 = new Scanner(System.in);	
		int sc21 = sc2.nextInt();
		
		System.out.println(sc11+"��"+sc21+"�η�Ϊ��"+power(sc11,sc21));
		sc1.close();
		sc2.close();
	}
}
