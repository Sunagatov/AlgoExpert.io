# Time - O(n), Space - O(n1)
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

    if root.left != None:
        branchSumsHelper(root.left, resultArray, newSum)

    if root.right != None:
        branchSumsHelper(root.right, resultArray, newSum)

    if root.left == None and root.right == None:
        resultArray.append(newSum)
        return
