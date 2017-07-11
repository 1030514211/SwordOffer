//���һ���࣬����ֻ�����ɸ����һ��ʵ��
import java.util.concurrent.locks.ReentrantLock;

public class Singleton {
	// ����ģʽ������ʽ���̰߳�ȫ������ֻ�����ڵ��̻߳���
	// ���ྲ̬�����ܲ�����̬�ķ����ͱ���
	public static class Singleton1
	{
		//����Ҫ��ֻ������һ��ʵ������˱���ѹ��캯����Ϊ˽�к����Խ�ֹ�����˴���ʵ����
		private Singleton1(){
		}
		
		//���ǿ��Զ���һ����̬��ʵ��
		private static Singleton1 instance = null;
		//����Ҫ��ʱ�򴴽���ʵ��
		//synchronized����һ����������һ�������ʱ���ܹ���֤��ͬһʱ�����ֻ��һ���߳�ִ�иöδ���
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
		
		//һ��static��ʼ����
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
	
	//����ģʽ��ʹ�þ�̬�ڲ��࣬�̰߳�ȫ���Ƽ��� 
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

	//��ͬ����ǰ�������ж�ʵ���Ƿ���ڣ����̡߳��Ƽ���
	public static class Singleton4
	{
		//������
        private final static ReentrantLock lock = new ReentrantLock();
		private Singleton4(){}
		private static Singleton4 instance = null;
		public static Singleton4 getInstance()
		{
			if(instance == null)
			{
				lock.lock();//����
				try{
					if(instance == null)
						instance = new Singleton4();
				}
				finally{
					lock.unlock();//�ͷ���
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
