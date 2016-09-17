import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by ndodakheswa on 2016/09/14.
 */
public class TreeNode {

    String item;

    private static Node root;                   //Points to root of the tree

    public TreeNode() {
        this.root = null;
    }

    public void treeInsert(String newItem) {
        if (root == null) {
            root = new Node(newItem);
            return;
        }
        Node runner;                            //Runs down the tree to find a place for newItem
        runner = root;                          //Start at the root
        while ( true ) {
            if (newItem.compareTo(runner.item) < 0) {
                //newItem is less than item.  Look in the left subtree
                if (runner.left == null) {
                    runner.left = new Node( newItem );
                    return;
                } else {
                    runner = runner.left;
                }
            } else {
                if (runner.right == null) {
                    runner.right = new Node( newItem );
                    return;
                } else {
                    runner = runner.right;
                }
            }
        }//End while()
    } //End treeInsert()

    public boolean treeContains(Node root, String item) {
        if (root == null) {
            return false;
        } else if (item.equals(root.item)) {
            return true;                        //item found in the root node
        } else if (item.compareTo(root.item) < 0) {
            //item must be on the left side of the root node
            return treeContains(root.left, item);
        } else {
            return treeContains(root.right, item);
        }
    }

    public void treeList(Node root) {
        if (root != null) {
            treeList(root.left);
            System.out.println(" " + root.item);
            treeList(root.right);
        }
    }

    public static void main(String[] args) {
        System.out.print("Please enter an item to insert in the tree\n");
        System.out.print("If an item is already in the list it will be ignored\n");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TreeNode newNode = new TreeNode();
        try {
            while (bufferedReader != null) {
                String newItem = bufferedReader.readLine();
                newNode.treeInsert(newItem);
                newNode.treeList(root);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


