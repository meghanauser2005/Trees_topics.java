public class BST {

static class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
Node root;
BST(){
    root=null;
}
void insert(int a){
    root=insertRecord(root, a);
}
Node insertRecord(Node root,int value){
    if(root==null){
        return new Node(value);
    }
    if(value<root.data){
        root.left=insertRecord(root.left, value);
    }else if(value>root.data){
        root.right=insertRecord(root.right, value);
    }else{
        System.out.println(value+"already exists");
    }
    return root;

}
void display(Node node){
    if(node==null){
        return;
    }
    System.out.println("node"+node.data);
    System.out.println("left child"+
        (node.left!=null? node.left.data:"none" )
    );
    System.out.println("right child"+
        (node.right!=null? node.right.data:"none" )
    );
    System.out.println("--------------");
    display(node.left);
    display(node.right);
}
void Inordertree(Node root){
    if(root==null){
        return;
    }
    Inordertree(root.left);
    System.out.println(root.data);
    Inordertree(root.right);
}
Node Minvalue(Node root){
    while(root.left!=null){
        root=root.left;
    }
    return root;
}
Node Deletenode(Node root,int x){
    if(root==null){
        System.out.println("value not found");
        return root;
    }
    if(x<root.data){
        root.left=Deletenode(root.left, x);
    }else if(x>root.data){
        root.right=Deletenode(root.right, x);
    }else{
        if(root.left==null&&root.right==null){
            System.out.println(x+"leaf node");
            return null;
        }else if(root.left==null){
            System.out.println(x+"left node");
            return root.right;
        }else if(root.right==null){
            System.out.println(x+"right node");
            return root.left;
        }
        System.out.println(x+"node with two children");
        Node minNode=Minvalue(root.right);
        root.data=minNode.data;
        root.right=Deletenode(root.right, minNode.data);
    }
    return root;
}



public static void main(String[] args) {
    BST obj=new BST();

    obj.insert(90);
    obj.insert(40);
    obj.insert(80);
    obj.insert(110);
    obj.insert(100);
    obj.insert(70);
    obj.insert(200);
    System.out.println("root"+obj.root.data);
    obj.display(obj.root);
    System.out.println("deleting 110");
    obj.root=obj.Deletenode(obj.root, 110);
    obj.Inordertree(obj.root);
    obj.display(obj.root);

}
}
