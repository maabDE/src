package BST;

/**
 * BST树的节点类型
 * @param <T>
 */
class BSTNode<T extends Comparable<T>>{
    // 节点的数据域
    private T data;
    // 节点的左孩子域
    private BSTNode<T> left;
    // 节点的右孩子域
    private BSTNode<T> right;

    public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode<T> left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode<T> right) {
        this.right = right;
    }
}

/**
 * BST树的实现
 * @param <T>
 */
class BSTree<T extends Comparable<T>>{
    // 指向BST树根节点的变量
    private BSTNode<T> root;

    /**
     * BST树的初始化
     */
    public BSTree() {
        this.root = null;
    }

    /**
     * 非递归实现BST树的插入操作
     * 1.考虑特殊节点  root=null
     * 2.找到插入节点的位置
     * 3.插入到BST树  new BSTNode<T>(data,null,null)
     * @param data
     */
    public void non_insert(T data){
        //根节点为空
        if (root ==null){//
            root = new BSTNode<>(data,null,null);
            return;
        }
        //根节点不为空， 判断大小 ----> 左右子树
        BSTNode<T> parent=null;//定义父亲节点
        BSTNode<T> cur=this.root;//当前节点
        while (cur!=null){
            parent=cur;
            if (cur.getData().compareTo(data)>0){
                cur=cur.getLeft();
            }
            else if (cur.getData().compareTo(data)<0){
                cur=cur.getRight();
            }else {
                return;
            }
        }
        if (parent.getData().compareTo(data)<0){
            /*设置为父亲节点右子树 该节点的左右子树均为null*/
            parent.setRight(new BSTNode<T>(data,null,null));
        }else if (parent.getData().compareTo(data)>0){
            /*设置为父亲节点左子树 该节点的左右子树均为null*/
            parent.setLeft(new BSTNode<T>(data,null,null));
        }
    }

    /**
     * 递归实现BST树的插入的API接口
     * @param data
     */
    public void recurrence_insert(T data){
        recurrence_insert(this.root,data);
    }

    private BSTNode<T> recurrence_insert(BSTNode<T> root, T data) {
    if (root==null){
       return this.root=new BSTNode<>(data,null,null);
    }
    if (root.getLeft().getData().compareTo(data)>0){
        return recurrence_insert(root.getLeft(),data);
    }
    else if (root.getRight().getData().compareTo(data)<0){
        return recurrence_insert(root.getRight(),data);
    }else {
        return root;
    }
    }

    public void non_remove(T data){
        if (root.getData().compareTo(data)==0){
            return;
        }
        BSTNode<T> parent=null;
        BSTNode<T> cur=null;
        if (root.getData().compareTo(data)>0){
            cur=root.getRight();
            while (cur!=null){
                parent=parent.getRight();
                cur=cur.getRight();
                if (cur.getData().compareTo(data)==0) return;
            }
        }
        if (root.getData().compareTo(data)<0){
            while (root.getLeft()!=null){
                cur=cur.getLeft();
                parent=parent.getLeft();
                if (cur.getData().compareTo(data)==0) return ;
            }
        }
        //返回的待删除节点 cur
        //父节点为 cur
    }
    public void preOrder(){

    }
    public void inOrder(BSTNode<T> root){

    }
    public void postOrder(){

    }
    /*递归实现BST树的层序遍历API接口*/
    public void levelOrder(){
        int level=level();
        for (int i=0;i<level;i++){
            levelOrder(this.root,level);
        }
    }

    private void levelOrder(BSTNode<T> root,int level) {
        if (root==null){
            return ;
        }
        if (level==0){
            System.out.println(root.getData()+" ");
        }
        levelOrder(root.getLeft(),level-1);
        levelOrder(root.getRight(),level-1);
    }
    /*求BST树的镜像*/
    private void mirror(){
        mirror(this.root);
    }

    private void mirror(BSTNode<T> root) {
    if (root==null){
        return;
    }else{
        BSTNode<T> temp=root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        mirror(root.getLeft());
        mirror(root.getRight());
    }
    }
    /*打印BST树种满足[min，max]区间的元素*/
    public void findAreaDatas(T begin,T end){
        findAreaDatas(this.root,begin,end);
    }

    private void findAreaDatas(BSTNode<T> root, T begin, T end) {

    }
    /*判断一个二叉树是否为BST树*/
    private boolean isBSTree(){
        return isBSTree(this.root);

    }

    private boolean isBSTree(BSTNode<T> root) {
        if (root==null){
            return true;
        }
        T l= (T) root.getLeft().getData();
        T v= (T) root;
        root.getRight().getData();
        return true;
    }
    /*求data1 和 data2 最近的公共祖先节点*/

    private T getLCA(T data1,T data2){
        return getLCA(this.root,data1,data2);
    }

    private T getLCA(BSTNode<T> root, T data1, T data2) {
     //   if ()
        if (root==null){return  null;
        }
        if (root.getData().compareTo(data1)>0 && root.getData().compareTo(data2)<0);
    //        return getLCA(root.getLeft(),data1,data2);
        return null;
    }

    /*返回中序遍历倒数第K个节点的值*/
    private T getOrderKValue(int k){
        int n=number();
        for (int i=n;i==k;i--){
            int value=0;
        //    return  getOrderKValue(this.root,k,value);
        }
        return null;
    }

//    private T getOrderKValue(BSTNode<T> root, int k,int n) {
//        getOrderKValue(root.getLeft())
//    }
    /*判断参数tree是不是BST的 一个子树*/
    private boolean isChildTree(BSTNode<T> tree){
        return true;
    }

    /**
     *
     * @return
     */
    private void rebuild(int[] pre,int[] in){
        this.root=rebuild(pre,0,pre.length-1,in,0,in.length-1);
    }

    private BSTNode<T> rebuild(int[] pre, int i, int i1, int[] in, int i2, int i3) {
         return null;
    }

    public int number(){
        return 0;
    }
    public int level(){
        return 0;
    }

    public static void main(String[] args) {
        BSTree<Integer> bsTree=new BSTree<Integer>();
        int[]arr=new int[]{53, 36, 86, 12, 39, 68, 92, 23, 46, 79, 98};
        for (int var:arr){
            bsTree.non_insert(var);
        }
//        System.out.println((bsTree));
    }
}


//public void non_insert(T data){
//        if(root == null){
//            // 直接生成根节点
//            this.root = new BSTNode<>(data, null, null);
//            return;
//        }
//
//        // 搜索BST树，找到data合适的插入位置
//        BSTNode<T> parent = null;
//        BSTNode<T> cur = this.root;
//        while(cur != null){
//            parent = cur;
//            if(cur.getData().compareTo(data) < 0){
//                cur = cur.getRight();
//            } else if(cur.getData().compareTo(data) > 0){
//                cur = cur.getLeft();
//            } else {
//                return;
//            }
//        }
//
//        // 生成data节点，并把节点写入其父节点相应的地址域当中
//        if(parent.getData().compareTo(data) < 0){
//            parent.setRight(new BSTNode<>(data, null, null));
//        } else {
//            parent.setLeft(new BSTNode<>(data, null, null));
//        }
//    }
//BSTree<Integer> bst = new BSTree<>();
//    int[] ar = {53, 36, 86, 12, 39, 68, 92, 23, 46, 79, 98};
//        for (int val : ar) {
//                bst.non_insert(val);
//                }
//                bst.non_insert(37);
