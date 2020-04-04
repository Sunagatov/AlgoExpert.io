package com.zufar.algorithm.recursive.tree;

import com.zufar.algorithm.structures.trees.BinaryTreeNode;
import com.zufar.algorithm.structures.trees.TreeNode;

public class TreeRecursiveAlgorithm {

    public static Integer getMaxValue(TreeNode<Integer> root) {
        Integer currentValue = root.getValue();
        for (TreeNode<Integer> currentChild : root.getChildren()) {
            if (currentChild != null) {
                currentValue = Math.max(getMaxValue(currentChild), currentValue);
            }
        }
        return currentValue;
    }


}
