//设计一个类，我们只能生成该类的一个实例
import java.util.concurrent.locks.ReentrantLock;

public class Singleton {
	// 单例模式，懒汉式，线程安全，但是只适用于单线程环境
	// 父类静态，才能产生静态的方法和变量
	public static class Singleton1
	{
		//由于要求只能生成一个实例，因此必须把构造函数设为私有函数以禁止其他人创建实例。
		private Singleton1(){
		}
		
		//我们可以定义一个静态的实例
		private static Singleton1 instance = null;
		//在需要的时候创建该实例
		//synchronized修饰一个方法或者一个代码块时，能够保证在同一时刻最多只有一个线程执行该段代码
		public static synchronized Singleton1 getInstance()
		{
			if(instance == null)
				instance = new Singleton1();
				
			return instance;
		}
	}

	public static class Singleton2
	{
		private static Singleton2 instance = null;
		
		//一个static初始化块
		static
		{
			instance = new Singleton2();			
		}		
		
		private Singleton2(){
		}
		
		public static  Singleton2 getInstance()
		{	
			return instance;
		}	
	}
	
	//单例模式，使用静态内部类，线程安全【推荐】 
	public static class Singleton3
	{
		private final static class SingletonHolder
		{
			private final static Singleton3 Instance=new Singleton3();
		}
		
		private Singleton3(){}
		
		public static Singleton3 getInstance(){
			return SingletonHolder.Instance;
		}
	}

	//加同步锁前后两次判断实例是否存在，多线程【推荐】
	public static class Singleton4
	{
		//锁对象
        private final static ReentrantLock lock = new ReentrantLock();
		private Singleton4(){}
		private static Singleton4 instance = null;
		public static Singleton4 getInstance()
		{
			if(instance == null)
			{
				lock.lock();//上锁
				try{
					if(instance == null)
						instance = new Singleton4();
				}
				finally{
					lock.unlock();//释放锁
				}		
			}			
			return instance;
		}	
	}
	
	public static void main(String[] args)
	{
		System.out.println(Singleton1.getInstance() == Singleton1.getInstance());
		System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
		System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
		System.out.println(Singleton4.getInstance() == Singleton4.getInstance());
	}
}
