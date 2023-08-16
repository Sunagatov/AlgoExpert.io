# Time - O(n), where n is the array's length
# Space - O(1)
def two_number_sum(array, target_sum):
    array.sort()
    left_pointer = 0
    right_pointer = len(array) - 1
    while left_pointer < right_pointer:
        potential_number1 = array[left_pointer]
        potential_number2 = array[right_pointer]
        current_sum = potential_number1 + potential_number2
        if current_sum == target_sum:
            return [potential_number1, potential_number2]
        elif current_sum < target_sum:
            left_pointer += 1
        else:
            right_pointer -= 1
    return []


