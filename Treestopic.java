public class Treestopic {
public static void main(String[] args) {

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
TreeNode root=new TreeNode(1);
TreeNode node2=new TreeNode(2);
TreeNode node3=new TreeNode(3);
TreeNode node4=new TreeNode(4);
TreeNode node5=new TreeNode(5);
root.left = node2;
root.right = node3;
node2.left = node4;
node2.right = node5;

System.out.println(root.data);
System.out.println(root.left.data);
System.out.println(root.right.data);
System.out.println(node2.left.data);
System.out.println(node2.right.data);
}
}
