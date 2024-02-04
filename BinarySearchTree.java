import com.sun.source.tree.Tree;

public class BinarySearchTree {

     public class TreeNode{
          TreeNode left;
          TreeNode right;
          int value;

          public TreeNode insert(TreeNode n , int value){
               if(n==null) {
                    return createNode(value);
               }

               if(value < n.value){
                    n.left = insert(n.left,value);
               }else if( value > n.value){
                    n.right = insert(n.right,value);
               }
               return n;
          }

          public TreeNode createNode(int value){
               TreeNode treeNode = new TreeNode();
               treeNode.value = value;
               treeNode.right = null;
               treeNode.left = null;
               return treeNode;
          }

     }
}

