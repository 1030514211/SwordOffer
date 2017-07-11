import java.util.Stack;

public class Test {
	
	// <>指定泛型参数,java泛型参数只是使用一个大写字母来定义
	// T 应填入一个类型，例如String。
	// 注意：类型参数只能代表引用型类型，不能是原始类型（像int,double,char的等）。
	// java的数据类型分基本数据类型（原始数据类型）和引用数据类型
	
	// 定义一个队列，队列里元素是T类型的。里面包含两个栈，插入栈和弹出栈
	public static class Queue<T>{
		//插入栈，只用于插入的数据
		private Stack<T> stack1 =new Stack<>();
		//弹出栈，只用于弹出数据 
		private Stack<T> stack2 =new Stack<>();
		
		public Queue(){}
		
		public void appendTail(T t){
			stack1.add(t);
		}
		
		public T deleteHead(){
			// 先判断弹出栈是否为空，如果为空就将插入栈的所有数据弹出栈
			// 并且将弹出的数据压入弹出栈中
			if(stack2.size()<=0){
				while(stack1.size()>0)
				{
					stack2.add(stack1.pop());
				}
			}	
		// 如果弹出栈中没有数据就抛出异常
		if(stack2.size() == 0)
			throw new RuntimeException("No more element.");
		
		// 返回弹出栈的栈顶元素，对应的就是队首元素。 
		return stack2.pop();
		}			
}
	
	public static void main(String[] args) {
		Queue<String> queue=new Queue<String>();
		queue.appendTail("abcd");
		queue.appendTail("你是谁？");
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
