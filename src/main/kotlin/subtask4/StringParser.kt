package subtask4

class StringParser {

    fun getResult(inputString: String): Array<String> {
        return getParsedString(inputString).toTypedArray()

    }

    private fun getParsedString(inputString: String): Set<String> {
        val sqBrOpen = '['
        val sqBrClose = ']'
        val crclBrOpen = '('
        val  crclBrClose = ')'
        val trBrOpen = '<'
        val trBrClose = '>'
        val res = linkedSetOf<String>()
        var parsedString = ""
        val array = inputString.toCharArray()
        var endedSymbol:Char
        var startedSymbol:Char
        var index = 0;
        while (index <array.size) {
            startedSymbol = array[index];
            if ( startedSymbol == sqBrOpen) {
                endedSymbol = sqBrClose
                index = getParsedStringIndex(endedSymbol,  parsedString, index, array, startedSymbol, inputString, res)
            }
            if (startedSymbol == crclBrOpen) {
                endedSymbol = crclBrClose
                index = getParsedStringIndex(endedSymbol, parsedString, index, array, startedSymbol, inputString, res)
            }
            if (startedSymbol == trBrOpen) {
                startedSymbol = trBrOpen
                endedSymbol = trBrClose
                index = getParsedStringIndex(endedSymbol, parsedString, index, array, startedSymbol, inputString, res)
            }
            index++
        }
        return res
    }

    private fun getParsedStringIndex(
        endedSymbol: Char,
        parsedString: String,
        index: Int,
        array: CharArray,
        startedSymbol: Char,
        inputString: String,
        res: LinkedHashSet<String>
    ): Int{
        var endedSymbol1 = endedSymbol
        var parsedString1 = parsedString
        var index1 = index
        var counter = 0

        while (index1 < array.size) {
            index1++
            if (index1 == array.size) break
            if (array[index1] == startedSymbol) {
                counter++
                val ar = getParsedString(inputString.substring(index1 - 1, inputString.length));
                if (ar.isNotEmpty()) {
                    res.addAll(ar)
                }

            }
            if (array[index1] == endedSymbol1) {
                if (counter == 0) {
                    res.add(parsedString1)
                    val ar = getParsedString(parsedString1);
                    if (ar.isNotEmpty()) {
                        res.addAll(ar)
                    }
                    break
                }
                counter--
            }
            parsedString1 = parsedString1.plus(array[index1])
        }
        return index1
    }

}
