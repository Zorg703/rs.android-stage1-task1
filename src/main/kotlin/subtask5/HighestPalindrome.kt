package subtask5

import java.util.*
import java.util.stream.Collector
import kotlin.streams.toList

class HighestPalindrome {
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
    var arr = digitString.toCharArray();
    var minChangesCounter = 0;
    for (index in arr.indices) {
        var backIndex = n-1-index

        if (index == backIndex || backIndex < index) break

         if (arr[index] != arr[backIndex]) {
             minChangesCounter++
         }
    }
        if (k < minChangesCounter) return "-1"

    var counter = 0;
        for (i in 0 until n) {
                    val backIndex = n-1-i
                    if (i == backIndex || backIndex < i) break
                    if (arr[i] != arr[backIndex]) {
                        if (arr[i].toString().toInt() > arr[backIndex].toString().toInt()) {
                            arr[backIndex] = arr[i]
                        } else {
                            arr[i] = arr[backIndex]
                        }
                        counter++
                    }
        }

    if (counter < k) {
        arr = digitString.toCharArray()
        var changeTo9Counter= k - counter
        for (i in 0 until n) {
            val backIndex = n-1-i
            if (i == backIndex || backIndex < i) break

            if (arr[i] != arr[backIndex]) {
                if(changeTo9Counter!=0) {
                    changeTo9Counter--
                    arr[backIndex] = '9'
                    arr[i] = '9'
                }
                else {
                    if (arr[i].toString().toInt() > arr[backIndex].toString().toInt()) {
                        arr[backIndex] = arr[i]
                    } else {
                        arr[i] = arr[backIndex]
                    }
                }

            }
        }
    }

    return  String(arr)
}



}
