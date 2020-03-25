package subtask2

import java.util.stream.Collector

class MiniMaxSum {

    // TODO: Complete the following function
    fun getResult(input: IntArray): IntArray {
       var result = arrayListOf<Int>()

        for (index in input.indices) {
            var list = input.toMutableList();

            list.removeAt(index);
            result.add(list.sum())
        }

        var res = mutableListOf<Int>(
            result.min()!!
        , result.max()!!
        );


    return res.toIntArray();
    }
}
