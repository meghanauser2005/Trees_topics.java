import java.util.ArrayList;
import java.util.List;

public class General {
   
static class TreeNode{
    int data;
    List<TreeNode> children;
    TreeNode(int data){
        this.data=data;
        this.children=new ArrayList<>();
    }
    void addchild(TreeNode child){
        children.add(child);
    }
}
TreeNode root;
General(int rootdata){
    root=new TreeNode(rootdata);
}
public void display(TreeNode a,String b){
    if(a==null){
        return;
    }
    System.out.println(b+a.data);
    for(TreeNode n:a.children){
        display(n, b+"--");
    }
    
}
public static void main(String[] args) {
    General g1=new General(1);
    TreeNode c1=new TreeNode(2);
    TreeNode c2=new TreeNode(3);
    TreeNode c3=new TreeNode(4);
    g1.root.addchild(c1);
    g1.root.addchild(c2);
    g1.root.addchild(c3);
    c1.addchild(new TreeNode(5));
    c1.addchild(new TreeNode(6));
    c2.addchild(new TreeNode(7));
    c3.addchild(new TreeNode(8));
    c3.addchild(new TreeNode(9));
    c3.addchild(new TreeNode(10));
    g1.display(g1.root, "");
}


}
