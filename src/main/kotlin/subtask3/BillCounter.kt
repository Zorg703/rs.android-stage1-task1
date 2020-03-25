package subtask3

class BillCounter {
     val bonAppetet = "Bon Appetit"
    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        var mealCostThatAnnaNotEat = bill[k]
        var billAmount = bill.sum()
        var annasBill = (billAmount - mealCostThatAnnaNotEat)/2

        if (annasBill == b) {
            return bonAppetet
        }
        return (b - annasBill).toString()
    }
}
