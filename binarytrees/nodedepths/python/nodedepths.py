# Time - O(n), Space - O(h)
def nodeDepths(root):
    resultSum = 0
    return calculateNodeDepths(root, resultSum)

def calculateNodeDepths(node, resultSum):
    if node == None:
        return 0
    return resultSum + calculateNodeDepths(node.left, resultSum + 1) + calculateNodeDepths(node.right, resultSum + 1)

# This is the class of the input binary tree.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None