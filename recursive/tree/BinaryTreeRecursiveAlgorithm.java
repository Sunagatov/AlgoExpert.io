package com.zufar.algorithm.recursive.tree;

import com.zufar.algorithm.structures.trees.BinaryTreeNode;

public class BinaryTreeRecursiveAlgorithm {

    public static Integer getMaxValue(BinaryTreeNode<Integer> root) {
        Integer currentValue = root.getValue();

        if (root.getLeft() != null) {
            currentValue = Math.max(getMaxValue(root.getLeft()), currentValue);
        }

        if (root.getRight() != null) {
            currentValue = Math.max(getMaxValue(root.getRight()), currentValue);
        }
        return currentValue;
    }


}
