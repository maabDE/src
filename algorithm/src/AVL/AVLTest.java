package AVL;

public class AVLTest {
}
class AVLNode<T extends Comparable<T>>{
    private T data;
    private AVLNode<T> left;
    private AVLNode<T> right;
    private int height; // 保存当前节点的高度值

    public AVLNode(T data, AVLNode<T> left, AVLNode<T> right, int height) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.height = height;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AVLNode<T> getLeft() {
        return left;
    }

    public void setLeft(AVLNode<T> left) {
        this.left = left;
    }

    public AVLNode<T> getRight() {
        return right;
    }

    public void setRight(AVLNode<T> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class AVL<T extends Comparable<T>>{
    private AVLNode<T> root;

    public AVL() {
        this.root = null;
    }

    /**
     * 以参数node为根节点进行左旋转操作，并把旋转后的子树的根节点返回
     * @param node
     * @return
     */
    private AVLNode<T> leftRotate(AVLNode<T> node){
        return null;
    }

    /**
     * 以参数node为根节点进行右旋转操作，并把旋转后的子树的根节点返回
     * @param node
     * @return
     */
    private AVLNode<T> rightRotate(AVLNode<T> node){
        return null;
    }

    /**
     * 以参数node为根节点进行左平衡操作，并把平衡后的子树的根节点返回
     * @param node
     * @return
     */
    private AVLNode<T> leftBalance(AVLNode<T> node){
        return null;
    }

    /**
     * 以参数node为根节点进行右平衡操作，并把平衡后的子树的根节点返回
     * @param node
     * @return
     */
    private AVLNode<T> rightBalance(AVLNode<T> node){
        return null;
    }
    private int maxHeight(AVLNode<T> node1,AVLNode<T> node2){
        int h1=height(node1);
        int h2=height(node2);
        return h1 > h2? h1:h2;
    }
    private int height(AVLNode<T> node){
        return node == null? 0:node.getHeight();
    }
}
