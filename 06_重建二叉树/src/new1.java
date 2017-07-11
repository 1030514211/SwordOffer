public class new1 {  
    /** 
     * �������ڵ��� 
     */  
    public static class BinaryTreeNode {  
        int Value;  
        BinaryTreeNode Left;  
        BinaryTreeNode Right;  
    }  
  
    /** 
     * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡� 
     * 
     * @param preOrder ǰ����� 
     * @param inOrder  ������� 
     * @return ���ĸ���� 
     */  
    public static BinaryTreeNode construct(int[] preOrder, int[] inOrder) {   
    	// ����ĺϷ����жϣ��������鶼����Ϊ�գ����Ҷ������ݣ��������ݵ���Ŀ��ͬ  
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length || inOrder.length < 1) {  
        	return null;  
        } 
        return construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);  
    }  
  
    /** 
     * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡� 
     * 
     * @param preOrder ǰ����� 
     * @param preStart       ǰ������Ŀ�ʼλ�� 
     * @param preEnd       ǰ������Ľ���λ�� 
     * @param inOrder  ������� 
     * @param inStart       ��������Ŀ�ʼλ�� 
     * @param inEnd       ��������Ľ���λ�� 
     * @return ���ĸ���� 
     */  
    public static BinaryTreeNode construct(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {  
         
        // ��ʼλ�ô��ڽ���λ��˵���Ѿ�û����Ҫ�����Ԫ����  
        if (preStart > preEnd) {  
            return null;  
        }  
        // ȡǰ������ĵ�һ�����֣����ǵ�ǰ�ĸ����  
        int rootValue = preOrder[preStart];  
        int index = inStart;  
        // ������������������Ҹ�����λ��  
        while (index <= inEnd && inOrder[index] != rootValue) {  
            index++;  
        }  
  
        // ������������������������û���ҵ���˵������Ĳ����ǲ��Ϸ��ģ��׳��쳣  
        if (index > inEnd) {  
        	throw new RuntimeException("Invalid input");
        }  
  
        // ������ǰ�ĸ���㣬����Ϊ��㸳ֵ  
        BinaryTreeNode node = new BinaryTreeNode();  
        node.Value = rootValue;  
  
        // �ݹ鹹����ǰ����������������������Ԫ�ظ�����index-inStart+1��  
        // ��������Ӧ��ǰ�������λ����[preStart+1, preStart+index-inStart]  
        // ��������Ӧ�����������λ����[inStart, index-1]  
        node.Left = construct(preOrder, preStart + 1, preStart + index - inStart, inOrder, inStart, index - 1);  
        // �ݹ鹹����ǰ����������������������Ԫ�ظ�����inEnd-index��  
        // ��������Ӧ��ǰ�������λ����[preStart+index-inStart+1, preEnd]  
        // ��������Ӧ�����������λ����[index+1, inEnd]  
        node.Right = construct(preOrder, preStart + index - inStart + 1, preEnd, inOrder, index + 1, inEnd);  
  
        // ���ش����ĸ����  
        return node;  
    }  
  
    public static void printTreeNode(BinaryTreeNode Node){
    	if(Node != null)
        {
    		System.out.println("value of this node is:"+ Node.Value);

            if(Node.Left != null)
            	System.out.println("value of its left child is: "+Node.Left.Value);
            else
            	System.out.println("left child is null");

            if(Node.Right != null)
            	System.out.println("value of its right child is:"+Node.Right.Value);
            else
            	System.out.println("right child is null");
        }
        else
        {
        	System.out.println("this node is null");
        }

    	System.out.println();
    }

    public static void printTree(BinaryTreeNode root) {  
    	printTreeNode(root);
    	if(root != null)
        {
            if(root.Left != null)
                printTree(root.Left);

            if(root.Right != null)
                printTree(root.Right);
        }
    } 
    
    public static void Test(String testName, int[] preorder, int[] inorder){
    	int length = preorder.length;
    	if(testName != null)
    		System.out.println(testName+" begins:");
    	
    	System.out.println("The preorder sequence is: ");
    	for(int i = 0; i < length; ++ i)
    		System.out.print(preorder[i]+" ");
    	System.out.println();
    	
    	System.out.println("The inorder sequence is: ");
        for(int i = 0; i < length; ++ i)
        	System.out.print(inorder[i]+" ");
        System.out.println("\n");
        
        BinaryTreeNode root = construct(preorder, inorder);
		printTree(root);
    }
    // ��ͨ������  
    //              1  
    //           /     \  
    //          2       3  
    //         /       / \  
    //        4       5   6  
    //         \         /  
    //          7       8  
    private static void Test1() {  
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};  
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};  
        Test("Test1", preOrder, inOrder); 
    }  
  
    // ���н�㶼û�����ӽ��  
    //            1  
    //           /  
    //          2  
    //         /  
    //        3  
    //       /  
    //      4  
    //     /  
    //    5  
//    private static void Test2() {  
//        int[] preOrder = {1, 2, 3, 4, 5};  
//        int[] inOrder = {5, 4, 3, 2, 1};  
//        Test("Test2", preOrder, inOrder);  
//    }  
  
    // ���н�㶼û�����ӽ��  
    //            1  
    //             \  
    //              2  
    //               \  
    //                3  
    //                 \  
    //                  4  
    //                   \  
    //                    5  
//    private static void Test3() {  
//        int[] preOrder = {1, 2, 3, 4, 5};  
//        int[] inOrder = {1, 2, 3, 4, 5};  
//        Test("Test3", preOrder, inOrder);  
//    }  
  
    // ����ֻ��һ�����  
//    private static void Test4() {  
//        int[] preOrder = {1};  
//        int[] inOrder = {1};  
//        Test("Test4", preOrder, inOrder);  
//    }  
  
    // ��ȫ������  
    //              1  
    //           /     \  
    //          2       3  
    //         / \     / \  
    //        4   5   6   7  
//    private static void Test5() {  
//        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};  
//        int[] inOrder = {4, 2, 5, 1, 6, 3, 7};  
//        Test("Test5", preOrder, inOrder); 
//    }  
   
//    // ������������в�ƥ��  
//    private static void Test6() {  
//        int[] preOrder = {1, 2, 4, 5, 3, 6, 7};  
//        int[] inOrder = {4, 2, 8, 1, 6, 3, 7};  
//        Test("Test6", preOrder, inOrder);  
//    }  
  
    public static void main(String[] args) {  
  
    	  Test1();
    	//Test2();
    	//Test3();
    	//Test4();
    	//Test5();
    	//Test6();
    }  
}  