# Time - O(n), where n is the array's length
# Space - O(n), where n is the array's length
def two_number_sum(array, target_sum):
    hash_set = set()

    for number in array:
        potential_match = target_sum - number
        if potential_match in hash_set:
            return [number, potential_match]
        else:
            hash_set.add(potential_match)
    return []
