import java.util.Scanner;

import com.sun.corba.se.spi.orbutil.fsm.Input;

class ListNode {
	public int data;
	public ListNode next;
}

public class Main {
	//node:null
	//输入:1 3 5 7
	//链表：7 5 3 1 null
	//查找倒数第k个其实就是产生的链表的正数第k个
	public static ListNode findK(ListNode node, int k){
		if(node.next == null || k <= 0){
			System.out.println("Input Error!");
			return null;
		}
		int start = 0;
		while(node.next != null && start < k){
			start++;
			node = node.next;
		}
		return node;
	}
	
	public static void main(String[] args) {
		System.out.print("请输入单链表的节点数：");
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			ListNode node = new ListNode();
			node.next = null;
			int N = in.nextInt();//链表结点个数
			if(N <= 0){
				System.out.println("Input Error!");
				return;
			}
			System.out.print("请输入链表(以空格隔开)：");
			for (int i = 0; i < N; i++) {
				//把p节点插到node节点后面,所以产生的链表与输入的链表顺序相反
				ListNode p = new ListNode();
				p.data = in.nextInt();
				p.next = node.next;
				node.next = p;
			}

			System.out.print("请输入从后往前查询的位置k：");
			int k = in.nextInt();//倒数第k个值
			if(k > N){
				System.out.println("Input Error!");
				return;
			}

			ListNode kthNode = findK(node,k);
			System.out.println("链表倒数第k个节点的值为："+kthNode.data);
		}
		in.close();
	}
}