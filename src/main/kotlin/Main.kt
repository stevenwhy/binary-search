fun main() {

    println("Binary search unknown order: ${binarySearch(listOf(4,6,10),10)}")
    println("Binary search unknown order: ${binarySearch(listOf(1,2,3,4,5,6,7),5)}")
    println("Binary search unknown order: ${binarySearch(listOf(10,6,4),10)}")
    println("Binary search unknown order: ${binarySearch(listOf(10,6,4),4)}")
    println("Binary search unknown order: ${binarySearch(listOf(10,6,4),3)}")

    println("Find ceiling: ${findCeiling(listOf(4,6,10),6)}")
    println("Find ceiling: ${findCeiling(listOf(1,3,8,10,14),12)}")
    println("Find ceiling: ${findCeiling(listOf(4,6,10),17)}")
    println("Find ceiling: ${findCeiling(listOf(4,6,10),-1)}")

    println("Find Next Smallest Letter: ${nextSmallestLetter(listOf('a', 'c', 'f', 'h'),'f')}")
    println("Find Next Smallest Letter: ${nextSmallestLetter(listOf('a', 'c', 'f', 'h'),'b')}")
    println("Find Next Smallest Letter: ${nextSmallestLetter(listOf('a', 'c', 'f', 'h'),'m')}")
    println("Find Next Smallest Letter: ${nextSmallestLetter(listOf('a', 'c', 'f', 'h'),'h')}")

    println("Find range: ${findRange(listOf(4, 6, 6, 6, 9),6)}")
    println("Find range: ${findRange(listOf(1, 3, 8, 10, 15),10)}")
    println("Find range: ${findRange(listOf(1, 3, 8, 10, 15),12)}")
}

fun findRange(list: List<Int>, target: Int): Pair<Int,Int> {
    if(target > list.last() || target < list.first()) return Pair(-1,-1)

    return Pair(findLowerRange(list,target), findUpperRange(list,target))

}
private fun findLowerRange(list: List<Int>, target: Int): Int {
    var start = 0
    var end = list.size - 1
    while(start <= end) {
        val middle = start + (end-start)/2

        if(target <= list[middle]) {
            end = middle - 1
        } else start = middle + 1
    }
    if(list[start] != target) return -1
    return start
}
private fun findUpperRange(list: List<Int>, target: Int): Int {
    var start = 0
    var end = list.size - 1
    while(start <= end) {
        val middle = start + (end-start)/2
        if(target >= list[middle]) {
            start = middle + 1
        } else end = middle - 1

    }
    if(list[end] != target) return -1
    return end
}
fun nextSmallestLetter(list: List<Char>, target: Char): Char {
    if(target >= list.last() || target < list.first()) return list.first()

    var start = 0
    var end = list.size - 1
    while(start <= end) {
        val middle = start + (end-start)/2

        if(target >= list[middle]) {
            start = middle + 1
        } else if (target < list[middle]) {
            end = middle - 1
        }
    }
    return list[start]
}
// given asc list, find smallest number >= target, return index
fun findCeiling(list: List<Int>, target: Int): Int {
    var start = 0
    var end = list.size-1
    var middle = start + (end-start)/2

    while(start <= end) {
        if(list[middle] >= target && ( middle == 0 || list[middle-1] < target)) return middle

        if(list[middle] >= target) {
            end = middle - 1
        } else if (list[middle] < target) {
            start = middle + 1
        }
        middle = start + (end-start)/2
    }
    return -1
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