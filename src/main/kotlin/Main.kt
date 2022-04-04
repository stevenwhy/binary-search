fun main() {

    println("Binary search unknown order: ${binarySearch(listOf(4,6,10),10)}")
    println("Binary search unknown order: ${binarySearch(listOf(1,2,3,4,5,6,7),5)}")
    println("Binary search unknown order: ${binarySearch(listOf(10,6,4),10)}")
    println("Binary search unknown order: ${binarySearch(listOf(10,6,4),4)}")

    println("Binary search unknown order: ${binarySearch(listOf(10,6,4),3)}")
}

// given a sorted list, asc or desc, find index of target
fun binarySearch(list: List<Int>, target: Int): Int {
    var start = 0
    var end = list.size - 1
    var middle = start + (end-start)/2
    val isAscending = list[end] > list[start]
    while(start <= end) {
        if(list[middle] == target) return middle

        if(target > list[middle] && isAscending) {
            start = middle+1
        } else if(target < list[middle] && isAscending) {
            end = middle - 1
        } else if(target < list[middle] && !isAscending) {
            start = middle + 1
        } else {
            end = middle - 1
        }
        middle = start + (end-start)/2
    }
    return -1
}