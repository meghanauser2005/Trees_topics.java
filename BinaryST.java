public class BinaryST {

static class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
Node root;
BinaryST(){
    root=null;
}
void Insert(int a){
    root=InsertRecord(root, a);
}
Node InsertRecord(Node root,int value){
    if(root==null){
        return new Node(value);
    }
    if(value<root.data){
        root.left=InsertRecord(root.left, value);
    }else if(value>root.data){
        root.right=InsertRecord(root.right, value);
    }else{
        System.out.println(value+"already exists");
    }
    return root;
}
void Display(Node node){
    if(node==null){
        return;
    }
    System.out.println("node"+node.data);
    System.out.println("left child"+node.left.data);
    System.out.println("right child"+node.right.data);
    Display(node.left);
    Display(node.right);

}


public static void main(String[] args) {
    BinaryST list=new BinaryST();

    list.Insert(80);
    list.Insert(60);
    list.Insert(30);
    list.Insert(90);
    list.Insert(100);
    // list.Inorder(list.root);
    list.Display(list.root);

}

}
