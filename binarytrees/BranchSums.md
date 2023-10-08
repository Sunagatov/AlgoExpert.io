# Binary Tree Branch Sums

In this Python code, we calculate the branch sums of a binary tree using a depth-first traversal approach. The time complexity is O(n), where n is the number of nodes in the binary tree, and the space complexity is O(n1), where n1 is the number of leaf nodes in the binary tree.

```python
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def branchSums(root):
    resultArray = []
    sum = 0
    branchSumsHelper(root, resultArray, sum)
    return resultArray

def branchSumsHelper(root, resultArray, sum):
    newSum = sum + root.value

    if root.left is not None:
        branchSumsHelper(root.left, resultArray, newSum)

    if root.right is not None:
        branchSumsHelper(root.right, resultArray, newSum)

    if root.left is None and root.right is None:
        resultArray.append(newSum)
        return
