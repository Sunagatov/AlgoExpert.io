package com.zufar.algorithm.structures.trees;

import java.util.Objects;

public class DoublyLinkedListNode<T> {

    private DoublyLinkedListNode<T> prev;
    private DoublyLinkedListNode<T> next;
    private T value;

    public DoublyLinkedListNode() {
    }

    public DoublyLinkedListNode(DoublyLinkedListNode<T> prev, DoublyLinkedListNode<T> next, T value) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }

    public DoublyLinkedListNode<T> getPrev() {
        return prev;
    }

    public void setPrev(DoublyLinkedListNode<T> prev) {
        this.prev = prev;
    }

    public DoublyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
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
        return getPrev().equals(that.getLeft()) &&
                getNext().equals(that.getRight()) &&
                getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrev(), getNext(), getValue());
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "left=" + prev +
                ", right=" + next +
                ", value=" + value +
                '}';
    }
}
