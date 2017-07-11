public class new1 {  
    /** 
     * 二叉树节点类 
     */  
    public static class BinaryTreeNode {  
        int Value;  
        BinaryTreeNode Left;  
        BinaryTreeNode Right;  
    }  
  
    /** 
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
     * 
     * @param preOrder 前序遍历 
     * @param inOrder  中序遍历 
     * @return 树的根结点 
     */  
    public static BinaryTreeNode construct(int[] preOrder, int[] inOrder) {   
    	// 输入的合法性判断，两个数组都不能为空，并且都有数据，而且数据的数目相同  
        if (preOrder == null || inOrder == null || preOrder.length != inOrder.length || inOrder.length < 1) {  
        	return null;  
        } 
        return construct(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);  
    }  
  
    /** 
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二节树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
     * 
     * @param preOrder 前序遍历 
     * @param preStart       前序遍历的开始位置 
     * @param preEnd       前序遍历的结束位置 
     * @param inOrder  中序遍历 
     * @param inStart       中序遍历的开始位置 
     * @param inEnd       中序遍历的结束位置 
     * @return 树的根结点 
     */  
    public static BinaryTreeNode construct(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {  
         
        // 开始位置大于结束位置说明已经没有需要处理的元素了  
        if (preStart > preEnd) {  
            return null;  
        }  
        // 取前序遍历的第一个数字，就是当前的根结点  
        int rootValue = preOrder[preStart];  
        int index = inStart;  
        // 在中序遍历的数组中找根结点的位置  
        while (index <= inEnd && inOrder[index] != rootValue) {  
            index++;  
        }  
  
        // 如果在整个中序遍历的数组中没有找到，说明输入的参数是不合法的，抛出异常  
        if (index > inEnd) {  
        	throw new RuntimeException("Invalid input");
        }  
  
        // 创建当前的根结点，并且为结点赋值  
        BinaryTreeNode node = new BinaryTreeNode();  
        node.Value = rootValue;  
  
        // 递归构建当前根结点的左子树，左子树的元素个数：index-inStart+1个  
        // 左子树对应的前序遍历的位置在[preStart+1, preStart+index-inStart]  
        // 左子树对应的中序遍历的位置在[inStart, index-1]  
        node.Left = construct(preOrder, preStart + 1, preStart + index - inStart, inOrder, inStart, index - 1);  
        // 递归构建当前根结点的右子树，右子树的元素个数：inEnd-index个  
        // 右子树对应的前序遍历的位置在[preStart+index-inStart+1, preEnd]  
        // 右子树对应的中序遍历的位置在[index+1, inEnd]  
        node.Right = construct(preOrder, preStart + index - inStart + 1, preEnd, inOrder, index + 1, inEnd);  
  
        // 返回创建的根结点  
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
    // 普通二叉树  
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
  
    // 所有结点都没有右子结点  
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
  
    // 所有结点都没有左子结点  
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
  
    // 树中只有一个结点  
//    private static void Test4() {  
//        int[] preOrder = {1};  
//        int[] inOrder = {1};  
//        Test("Test4", preOrder, inOrder);  
//    }  
  
    // 完全二叉树  
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
   
//    // 输入的两个序列不匹配  
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