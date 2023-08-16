# Time - O(n * n), where n is the array's length
# Space - O(1)
def two_number_sum(array, target_sum):
    for i in range(len(array) - 1):
        number1 = array[i]
        for j in range(i + 1, len(array)):
            number2 = array[j]

            if target_sum == number1 + number2:
                return [number1, number2]
    return []
