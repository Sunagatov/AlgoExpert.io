package com.zufar.algorithm.structures.trees;

import java.util.Objects;

public class BinaryTreeNode<T> {

    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;
    private T value;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(BinaryTreeNode<T> left, BinaryTreeNode<T> right, T value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BinaryTreeNode)) return false;
        BinaryTreeNode<?> that = (BinaryTreeNode<?>) o;
        return getLeft().equals(that.getLeft()) &&
                getRight().equals(that.getRight()) &&
                getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeft(), getRight(), getValue());
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "left=" + left +
                ", right=" + right +
                ", value=" + value +
                '}';
    }
}
