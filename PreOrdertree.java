public class PreOrdertree {

static class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}

public static void PreOrder(Node root){
    if(root==null){
        return;
    }
    System.out.println(root.data);
    PreOrder(root.left);
    PreOrder(root.right);
}
public static void Inorder(Node root){
    if(root==null){
        return;
    }
    Inorder(root.left);
    System.out.println(root.data);
    Inorder(root.right);
}
public static void Postorder(Node root){
    if(root==null){
        return;
    }
    Postorder(root.left);
    Postorder(root.right);
    System.out.println(root.data);
}

public static void main(String[] args) {
    Node root=new Node(1);
    root.left=new Node(2);
    root.right=new Node(3);
    root.left.left=new Node(4);
    root.left.right=new Node(5);
    System.out.println("preorder");
    PreOrder(root);
    System.out.println("inorder");
    Inorder(root);
    System.out.println("postorder");
    Postorder(root);
}
}
