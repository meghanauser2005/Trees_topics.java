public class AVLtree {

    static class Node {
        int data;
        int height;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    int max(int x, int y) {
        return (x > y) ? x : y;
    }

    // Right Rotation
    Node Rightrotate(Node m) {
        Node n = m.left;
        Node t2 = n.right;

        n.right = m;
        m.left = t2;

        m.height = max(height(m.left), height(m.right)) + 1;
        n.height = max(height(n.left), height(n.right)) + 1;

        return n;
    }

    // Left Rotation
    Node Leftrotate(Node u) {
        Node v = u.right;
        Node t2 = v.left;

        v.left = u;
        u.right = t2;

        u.height = max(height(u.left), height(u.right)) + 1;
        v.height = max(height(v.left), height(v.right)) + 1;

        return v;
    }

    // Balance Factor
    int balance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Insert a value into the AVLTTree
    Node Insert(Node b, int value) {

        // Base condition
        if (b == null) {
            return new Node(value);
        }

        if (value < b.data) {
            b.left = Insert(b.left, value);
        } else if (value > b.data) {
            b.right = Insert(b.right, value);
        } else {
            return b; // Duplicate values are ignored
        }

        // Update height
        b.height = 1 + max(height(b.left), height(b.right));

        int calculate = balance(b);

        // LL Case
        if (calculate > 1 && value < b.left.data) {
            return Rightrotate(b);
        }

        // RR Case
        if (calculate < -1 && value > b.right.data) {
            return Leftrotate(b);
        }

        // LR Case
        if (calculate > 1 && value > b.left.data) {
            b.left = Leftrotate(b.left);
            return Rightrotate(b);
        }

        // RL Case
        if (calculate < -1 && value < b.right.data) {
            b.right = Rightrotate(b.right);
            return Leftrotate(b);
        }

        return b;
    }

    void RecursiveInsert(int value) {
        root = Insert(root, value);
    }

    // Inorder: Left, Root, Right
    void Inordertraverse(Node node) {
        if (node != null) {
            Inordertraverse(node.left);
            System.out.print(node.data + " ");
            Inordertraverse(node.right);
        }
    }

    // Preorder: Root, Left, Right
    void PreOrdertraverse(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            PreOrdertraverse(node.left);
            PreOrdertraverse(node.right);
        }
    }

    public static void main(String[] args) {
        AVLtree tree = new AVLtree();

        tree.RecursiveInsert(5);
        tree.RecursiveInsert(10);
        tree.RecursiveInsert(15);
        tree.RecursiveInsert(20);
        tree.RecursiveInsert(30);

        System.out.println("Inorder Traversal:");
        tree.Inordertraverse(tree.root);

        System.out.println("\n------------");

        System.out.println("Preorder Traversal:");
        tree.PreOrdertraverse(tree.root);

        System.out.println("\n------------");

        System.out.println("Root Data: " + tree.root.data);
        System.out.println("Root Height: " + tree.root.height);
    }
}