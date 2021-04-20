import java.util.*;
import java.io.*;
class BinarySearchTree implements Serializable
{
    private static final long serialVersionUID=1l;
    private TreeNode root;
    public class TreeNode implements Serializable
    {
        private static final long serialVersionUID=1l;
        private int key;
        private Object element;
        private TreeNode left;
        private TreeNode right;

        TreeNode()
        {
            key = 0;
            element = null;
            left = null;
            right = null;
        }

        TreeNode(int p_key,Object e)
        {
            key = p_key;
            element = e;
            left = null;
            right = null;
        }

        void setLeft(TreeNode leftNd)
        {
            left = leftNd;
        }

        void setRight(TreeNode rightNd)
        {
            right = rightNd;
        }

        void setKey(int n_key)
        {
            key = n_key;
        }

        TreeNode getLeft()
        {
            return this.left;
        }

        TreeNode getRight()
        {
            return this.right;
        }

        Object getElement()
        {
            return this.element;
        }

        int getKey()
        {
            return this.key;
        }

    }

    BinarySearchTree()
    {
        root = null;
    }

    public Object find(int fKey)
    {
        Object toFind = findRecursive(fKey,root);
        return toFind;
    }

    private Object findRecursive(int fKey,TreeNode curNd)
    {
        Object val = curNd.getElement();
        if(curNd == null)
        {
            throw new NoSuchElementException("Invalid Node");
        }
        else if(fKey == curNd.getKey())
        {
            val = curNd.getElement();
        }
        else if(fKey < curNd.getKey())
        {
            val = findRecursive(fKey,curNd.getLeft());
        }
        else
        {
            val = findRecursive(fKey,curNd.getRight());
        }
        return val;
    }

    void insert(int key, Object data)
    {
        if(data == null)
        {
            throw new IllegalArgumentException("Inserted data is null");
        }
        else if(root == null)
        {
            root = new TreeNode(key,data);
        }
        else
        {
            insertRecurse(key,data,root);
        }
    }

    private TreeNode insertRecurse(int key, Object data, TreeNode curNd)
    {
        TreeNode updateNode = curNd;
        if(updateNode == null)
        {
            curNd = new TreeNode(key,data);
            updateNode = curNd;
        }
        else if(key < updateNode.getKey())
        {
            curNd.setLeft(insertRecurse(key,data,updateNode.getLeft()));
        }
        else
        {
            curNd.setRight(insertRecurse(key,data,updateNode.getRight()));
        }
        return updateNode;
    }

    void delete(int key)
    {
        if(root == null)
        {
            throw new IllegalArgumentException("Tree is empty");
        }
        else if(root.getLeft() != null && root.getRight() == null)
        {
            root = root.getLeft();
        }
        else if(root.getLeft() == null && root.getRight() !=null)
        {
            root = root.getRight();
        }
        else
        {
            deleteRecurse(key,root);
        }
    }

    private TreeNode deleteNode(int key, TreeNode curNd)
    {
        //Best case when node has no child
        if(curNd.getLeft() == null && curNd.getRight() == null)
        {
            curNd = null;
        }
        //When node has left only
        else if(curNd.getLeft() != null && curNd.getRight() == null)
        {
            curNd = curNd.getLeft();
        }
        //When node has right only
        else if(curNd.getLeft() == null && curNd.getRight() != null)
        {
            curNd = curNd.getRight();
        }
        //When node has both
        else
        {
            //We need to find the appropriate node successor to replace the old one
            //Look to the right node
            TreeNode update = findSuccessorRecurse(curNd.getRight());
            if(update != curNd.getRight())
            {
                update.setRight(curNd.getRight());
            }
            update.setLeft(curNd.getLeft());
            curNd = update;
        }
        return curNd;
    }

    private TreeNode deleteRecurse(int key, TreeNode curNd)
    {
        //Traversed through the BST, Key not found
        if(curNd == null)
        {
            throw new NoSuchElementException(key + " does not exist");
        }
        //Found match, now delete
        else if(key == curNd.getKey())
        {
            curNd = deleteNode(key,curNd);
        }
        else if(key < curNd.getKey())
        {
            curNd.setLeft(deleteRecurse(key,curNd.getLeft()));
        }
        else
        {
            curNd.setRight(deleteRecurse(key,curNd.getRight()));
        }
        return curNd;
    }

    //Import the right node of what to delete
    TreeNode findSuccessorRecurse(TreeNode curNd)
    {
        TreeNode successor = curNd;
        if(curNd.getLeft() != null)
        {
            successor = findSuccessorRecurse(curNd.getLeft());
            if(successor == curNd.getLeft())
            {
                curNd.setLeft(successor.getRight());
            }
        }
        return successor;
    }

    public DSAQueue<TreeNode> inOrder()
    {
        DSAQueue<TreeNode> inOrderList = new Queue<TreeNode>();
        if(root == null)
        {
            throw new NoSuchElementException("No Elements in the binary search tree");
        }
        else
        {
            inOrderList = inorderRecurse(root, inOrderList);
        }
        return inOrderList;
    }

    public int max()
    {
        int maxKey = 0;
        if(root == null)
        {
            throw new NoSuchElementException("Tree is empty");
        }
        else
        {
            maxKey = maxRecurse(root);
        }
        return maxKey;
    }
    private int maxRecurse(TreeNode curNd)
    {
        int maxKey = 0;
        if(curNd.getRight() != null)
        {
            maxKey = maxRecurse(curNd.getRight());
        }
        else
        {
            maxKey = curNd.getKey();
        }
        return maxKey;
    }

    float balance()
    {
        int min = minLevel(root);
        int max = maxLevel(root);
        int height = height();
        float balance =(1-((((float)min+(float)max)/2)/(float)height))*100;
        return balance;
    }

    public int maxlv()
    {
        return maxLevel(root);
    }

    public int minlv()
    {
        return minLevel(root);
    }
    private int maxLevel(TreeNode curNd)
    {
        int level = 0;
        while(curNd.getRight() != null)
        {
            level++;
            curNd = curNd.getRight();
        }
        return level;
    }
    private int minLevel(TreeNode curNd)
    {
        int level = 0;
        while(curNd.getLeft() != null)
        {
            level++;
            curNd = curNd.getLeft();
        }
        return level;
    }

    public int min()
    {
        int minKey = 0;
        if(root == null)
        {
            throw new NoSuchElementException("No key found");
        }
        else
        {
            minKey = minRecurse(root);
        }
        return minKey;
    }

    private int minRecurse(TreeNode curNd)
    {
        int minKey  = 0;

        if(curNd.getLeft() != null)
        {
            minKey = minRecurse(curNd.getLeft());
        }
        else
        {
            minKey = curNd.getKey();
        }
        return minKey;
    }

    public int height()
    {
        int height = 0;
        if(root != null)
        {
            height = intHeightRec(root);
        }
        return height-1;
    }

    private int intHeightRec(TreeNode curNd)
    {
        int i=0;
        int leftHeight=0;
        int rightHeight=0;
        int totalHeight=0;
        if(curNd == null)
        {
            i = -1;
        }
        else
        {
            leftHeight = intHeightRec(curNd.getLeft());
            rightHeight = intHeightRec(curNd.getRight());
            if(leftHeight > rightHeight)
            {
                totalHeight = leftHeight+1;
            }
            else
            {
                totalHeight = rightHeight+1;
            }
        }
        return totalHeight;
    }
    private DSAQueue<TreeNode> inorderRecurse(TreeNode curNd, DSAQueue<TreeNode> inorderList)
    {
        if(curNd != null)
        {
            inorderRecurse(curNd.getLeft(),inorderList);
            inorderList.enQueue(curNd);
            inorderRecurse(curNd.getRight(), inorderList);
        }
        return inorderList;
    }

    public DSAQueue<TreeNode> preOrder()
    {
        DSAQueue<TreeNode> preOrderQ = new Queue<TreeNode>();
        if(root == null)
        {
            throw new NoSuchElementException("Empty tree");
        }
        else
        {
            preOrderQ = preorderRecurse(root,preOrderQ);
        }
        return preOrderQ;
    }

    private DSAQueue<TreeNode> preorderRecurse(TreeNode curNd, DSAQueue<TreeNode> preorderList)
    {
        if(curNd != null)
        {
            preorderList.enQueue(curNd);
            preorderRecurse(curNd.getLeft(),preorderList);
            preorderRecurse(curNd.getRight(),preorderList);
        }
        return preorderList;
    }

    public DSAQueue<TreeNode> postOrder()
    {
        DSAQueue<TreeNode> post = new Queue<TreeNode>();
        if(root != null)
        {
            post = postorderRecurse(root,post);
        }
        else
        {
            throw new NoSuchElementException("Empty Tree");
        }
        return post;
    }
    private DSAQueue<TreeNode> postorderRecurse(TreeNode curNd, DSAQueue<TreeNode> postorder)
    {
        if(curNd != null)
        {
            postorderRecurse(curNd.getLeft(),postorder);
            postorderRecurse(curNd.getRight(),postorder);
            postorder.enQueue(curNd);
        }
        return postorder;
    }
    public void save(String file)
    {
        saveTree(this,file);
    }

    private void saveTree(BinarySearchTree tree, String file)
    {
        FileOutputStream strm;
        ObjectOutputStream obj;
        try
        {
            strm = new FileOutputStream(file);
            obj = new ObjectOutputStream(strm);
            obj.writeObject(tree);

            strm.close();
            obj.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }   
    }

    public BinarySearchTree load(String file)
    {
        return loadTree(file);
    }

    private BinarySearchTree loadTree(String file)
    {
        FileInputStream strm;
        ObjectInputStream obj;
        BinarySearchTree t = null;
        try
        {
            strm = new FileInputStream(file);
            obj = new ObjectInputStream(strm);
            t = (BinarySearchTree)obj.readObject();

            strm.close();
            obj.close();
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return t;
    }

    void read(String file, BinarySearchTree t){
        FileInputStream fStrm = null;
        InputStreamReader rdr;
        BufferedReader bfrR;
        String line;

        try{
            fStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fStrm);
            bfrR = new BufferedReader(rdr);
            line = bfrR.readLine();
            while(line != null){
                processLine(line,t);
                line = bfrR.readLine();
            }
            fStrm.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }

    void processLine(String line, BinarySearchTree t){
        String sep[] = line.split(",");
        int keys = Integer.parseInt(sep[0]);
        t.insert(keys,sep[1]);
    }

    void toCsv(String file, DSAQueue<TreeNode> order){
        FileOutputStream toFile = null;
        PrintWriter write;
        try{
            toFile = new FileOutputStream(file);
            write = new PrintWriter(file);
            while(!order.isEmpty()){
                TreeNode obj = order.deQueue();
                String toString = obj.getKey() + "," + obj.getElement();
                write.println(toString);
            }
            write.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

