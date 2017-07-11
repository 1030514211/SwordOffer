import java.util.Stack;

public class Test {
	
	// <>ָ�����Ͳ���,java���Ͳ���ֻ��ʹ��һ����д��ĸ������
	// T Ӧ����һ�����ͣ�����String��
	// ע�⣺���Ͳ���ֻ�ܴ������������ͣ�������ԭʼ���ͣ���int,double,char�ĵȣ���
	// java���������ͷֻ����������ͣ�ԭʼ�������ͣ���������������
	
	// ����һ�����У�������Ԫ����T���͵ġ������������ջ������ջ�͵���ջ
	public static class Queue<T>{
		//����ջ��ֻ���ڲ��������
		private Stack<T> stack1 =new Stack<>();
		//����ջ��ֻ���ڵ������� 
		private Stack<T> stack2 =new Stack<>();
		
		public Queue(){}
		
		public void appendTail(T t){
			stack1.add(t);
		}
		
		public T deleteHead(){
			// ���жϵ���ջ�Ƿ�Ϊ�գ����Ϊ�վͽ�����ջ���������ݵ���ջ
			// ���ҽ�����������ѹ�뵯��ջ��
			if(stack2.size()<=0){
				while(stack1.size()>0)
				{
					stack2.add(stack1.pop());
				}
			}	
		// �������ջ��û�����ݾ��׳��쳣
		if(stack2.size() == 0)
			throw new RuntimeException("No more element.");
		
		// ���ص���ջ��ջ��Ԫ�أ���Ӧ�ľ��Ƕ���Ԫ�ء� 
		return stack2.pop();
		}			
}
	
	public static void main(String[] args) {
		Queue<String> queue=new Queue<String>();
		queue.appendTail("abcd");
		queue.appendTail("����˭��");
		queue.appendTail("123");
		queue.appendTail("+-");
		
		String head1 = queue.deleteHead();
		System.out.println(head1);
		
		String head2 = queue.deleteHead();
		System.out.println(head2);
		
		String head3 = queue.deleteHead();
		System.out.println(head3);
		
		String head4 = queue.deleteHead();
		System.out.println(head4);
	}
}
