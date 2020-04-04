package com.zufar.algorithm.recursive.list;

import com.zufar.algorithm.structures.trees.DoublyLinkedListNode;

public class ListRecursiveAlgorithm {

    public Integer getListCount(DoublyLinkedListNode<Integer> node) {
        if (node.getNext() == null) {
            return 0;
        } else return 1 + getListCount(node.getNext());
    }
}
