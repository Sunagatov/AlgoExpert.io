package com.zufar.algorithm.structures.trees;

import java.util.List;
import java.util.Objects;

public class TreeNode<T> {

    private T value;
    private List<TreeNode<T>> children;

    public TreeNode() {
    }

    public TreeNode(T value, List<TreeNode<T>> children) {
        this.value = value;
        this.children = children;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        TreeNode<?> treeNode = (TreeNode<?>) o;
        return getValue().equals(treeNode.getValue()) &&
                getChildren().equals(treeNode.getChildren());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getChildren());
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                ", children=" + children +
                '}';
    }
}
