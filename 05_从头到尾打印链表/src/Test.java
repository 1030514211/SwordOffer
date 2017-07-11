import java.util.Stack;

public class Test {
	
	public static class ListNode{
		int value;//结点的值
		ListNode nxt;//下一个节点
	}
	
	//采用栈的方式
	public static void printListInverselyUsingIteration(ListNode root){
		//创建一个栈
		Stack<ListNode> stack = new Stack<>();
		if(root == null){
			System.out.println("链表为空");
		}
		while(root != null){
			stack.push(root);
			root = root.nxt;
		}
		ListNode tmp;
		while(!stack.isEmpty()){
			tmp = stack.pop();
			System.out.print(tmp.value+" ");
		}
	}
	
	public static void creatListNode(ListNode root1,int value,ListNode root2){
		if(root1 == null){
			System.out.println("链表为空");
		}
		root1.value = value;
		root1.nxt = root2;
		System.out.print(value + " ");
	}

	public static void main(String[] args) {

		ListNode root1 = new ListNode();
		ListNode root2 = new ListNode();
		ListNode root3 = new ListNode();
		ListNode root4 = new ListNode();
		ListNode root5 = new ListNode();
		ListNode root6 = new ListNode();
  
		System.out.print("链表反转前：");
		creatListNode(root1,12,root2);
		creatListNode(root2, 4,root3);
		creatListNode(root3,14,root4);
		creatListNode(root4, 8,root5);
		creatListNode(root5, 2,root6);
		creatListNode(root6,30, null);
		
		System.out.println();
		System.out.print("链表反转后：");
        printListInverselyUsingIteration(root1);
        System.out.println();
        printListInverselyUsingIteration(null);
	}
}
