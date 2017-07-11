public class Fibonacci {

	public static long fibonacci(int num) {
		int result[] = {0,1};
		if(num <2)
			return result[num];

		long FibOne = 1;
		long FibTwo = 0;
		long FibResult = 0;
		for(int i = 2; i <= num; ++i ){
			FibResult = FibOne + FibTwo; 

			FibTwo = FibOne;
			FibOne = FibResult;
		}		
		return FibResult;
	}
	public static void main(String[] args) {

		System.out.println("fibonacci(0)="+fibonacci(0)+".结果:"+(fibonacci(0)==0));
		System.out.println("fibonacci(1)="+fibonacci(1)+".结果:"+(fibonacci(1)==1));
		System.out.println("fibonacci(2)="+fibonacci(2)+".结果:"+(fibonacci(2)==1));
		System.out.println("fibonacci(3)="+fibonacci(3)+".结果:"+(fibonacci(3)==2));
		System.out.println("fibonacci(4)="+fibonacci(4)+".结果:"+(fibonacci(4)==3));
		System.out.println("fibonacci(5)="+fibonacci(5)+".结果:"+(fibonacci(5)==5));
		System.out.println("fibonacci(6)="+fibonacci(6)+".结果:"+(fibonacci(6)==8));
		System.out.println("fibonacci(7)="+fibonacci(7)+".结果:"+(fibonacci(7)==13));
		System.out.println("fibonacci(8)="+fibonacci(8)+".结果:"+(fibonacci(8)==21));
		System.out.println("fibonacci(9)="+fibonacci(9)+".结果:"+(fibonacci(9)==34));
		System.out.println("fibonacci(10)="+fibonacci(10)+".结果:"+(fibonacci(10)==55));
		System.out.println("fibonacci(40)="+fibonacci(40)+".结果:"+(fibonacci(40)==102334155));
		//最多46，否则会超过范围
		System.out.println("fibonacci(46)="+fibonacci(46)+".结果:"+(fibonacci(46)==1836311903));

	}

}
