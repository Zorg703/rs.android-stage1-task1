package subtask1

class HappyArray {
    fun convertToHappy(sadArray: IntArray): IntArray {
        val happyList = sadArray.toMutableList()
        var first: Int
        var second: Int
        var third: Int
        var i = 0
        while (i < happyList.size) {
            first = happyList[i]
            if (i + 1 >= happyList.size) {
                i++
                continue
            }
            second = happyList[i + 1]
            if (i + 2 >= happyList.size) {
                i += 2
                continue
            }
            third = happyList[i + 2];

            if (first + third < second) {
                happyList.removeAt(i + 1)
                if (i > 0) {
                    i--
                }
            } else i++
        }

        return happyList.toIntArray()
    }
}

