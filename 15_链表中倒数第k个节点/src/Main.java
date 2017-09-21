import java.util.Scanner;

import com.sun.corba.se.spi.orbutil.fsm.Input;

class ListNode {
	public int data;
	public ListNode next;
}

public class Main {
	//node:null
	//����:1 3 5 7
	//����7 5 3 1 null
	//���ҵ�����k����ʵ���ǲ����������������k��
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
		System.out.print("�����뵥����Ľڵ�����");
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			ListNode node = new ListNode();
			node.next = null;
			int N = in.nextInt();//���������
			if(N <= 0){
				System.out.println("Input Error!");
				return;
			}
			System.out.print("����������(�Կո����)��");
			for (int i = 0; i < N; i++) {
				//��p�ڵ�嵽node�ڵ����,���Բ��������������������˳���෴
				ListNode p = new ListNode();
				p.data = in.nextInt();
				p.next = node.next;
				node.next = p;
			}

			System.out.print("������Ӻ���ǰ��ѯ��λ��k��");
			int k = in.nextInt();//������k��ֵ
			if(k > N){
				System.out.println("Input Error!");
				return;
			}

			ListNode kthNode = findK(node,k);
			System.out.println("��������k���ڵ��ֵΪ��"+kthNode.data);
		}
		in.close();
	}
}