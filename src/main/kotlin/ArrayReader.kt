class ArrayReader(
    val arr: ArrayList<Int>
) {
    fun get(index: Int): Int {
        if(index >= arr.size) return Int.MAX_VALUE
        return arr[index]
    }
}