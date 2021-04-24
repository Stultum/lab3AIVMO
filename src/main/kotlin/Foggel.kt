class Foggel(
    transportList: MutableList<MutableList<Int>>,
    needList: MutableList<Int>,
    stocksList: MutableList<Int>,
    providersCount: Int,
    consumersCount: Int
) {
    private var providersCount = 0
    private var consumersCount = 0
    private var needList = mutableListOf<Int>()
    private var stocksList = mutableListOf<Int>()
    private var transportList = mutableListOf<MutableList<Int>>()

    companion object {

        const val MAX_IN_COLUMNS = "MAX_IN_COLUMNS"
        const val MAX_IN_ROWS = "MAX_IN_ROWS"
    }

    init {
        this.transportList = transportList
        this.needList = needList
        this.stocksList = stocksList
        this.providersCount = providersCount
        this.consumersCount = consumersCount
        if (this.needList.sum() > this.stocksList.sum()) {
            this.providersCount++
            val tmpList = mutableListOf<Int>()
            repeat(consumersCount) {
                tmpList.add(0)
            }
            this.transportList.add(tmpList)
            this.stocksList.add(this.needList.sum() - this.stocksList.sum())
        } else if (this.stocksList.sum() > this.needList.sum()) {
            this.consumersCount++
            this.transportList.forEachIndexed { _, mutableList ->
                mutableList.add(0)
            }
            this.needList.add(this.stocksList.sum() - this.needList.sum())
        }
        printData()
    }

    private fun printData() {
        println(consumersCount)
        println(providersCount)
        println(needList)
        println(stocksList)
        println(transportList)
    }

    fun countFoggel() {
        val diffs = transportList.getDifferences()
        val maxValue = diffs.getMax()
        println(maxValue)
    }

    private fun MutableList<MutableList<Int>>.getDifferences(): Pair<MutableList<Int>, MutableList<Int>> {
        val columnsDiffs = mutableListOf<Int>()
        val rowsDiffs = mutableListOf<Int>()
        val columnsList = mutableListOf<MutableList<Int>>()
        repeat(consumersCount) {
            columnsList.add(mutableListOf())
        }
        this.forEachIndexed { _, mutableList ->
            val min = mutableList.get2MinValues()
            rowsDiffs.add(min.second - min.first)
            mutableList.forEachIndexed { index, i ->
                columnsList[index].add(i)
            }
        }
        columnsList.forEachIndexed { _, mutableList ->
            val min = mutableList.get2MinValues()
            columnsDiffs.add(min.second - min.first)
        }
        return Pair(columnsDiffs, rowsDiffs)
    }

    private fun MutableList<Int>.get2MinValues(): Pair<Int, Int> {
        val firstMin = this.minOrNull()
        val copyList = mutableListOf<Int>()
        copyList.addAll(this)
        copyList.remove(firstMin)
        val secondMin = copyList.minOrNull()
        return Pair(firstMin!!, secondMin!!)
    }

    private fun Pair<MutableList<Int>, MutableList<Int>>.getMax(): Triple<Int, Int, String> {
        var firstMax = -99999
        var firstMaxIndex = 0
        var secondMax = -99999
        var secondMaxIndex = 0

        first.forEachIndexed { index, i ->
            if (i > firstMax) {
                firstMax = i
                firstMaxIndex = index
            }
        }
        second.forEachIndexed { index, i ->
            if (i > secondMax) {
                secondMax = i
                secondMaxIndex = index
            }
        }
        return if (firstMax >= secondMax)
            Triple(firstMax, firstMaxIndex, MAX_IN_COLUMNS)
        else
            Triple(secondMax, secondMaxIndex, MAX_IN_ROWS)
    }
}