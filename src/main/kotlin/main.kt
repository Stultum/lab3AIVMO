fun main() {

    val providersCount = 4
    val consumersCount = 5
    val needList = mutableListOf(49, 60, 78, 50, 50)
    val stocksList = mutableListOf(78, 94, 29, 86)
    val transportList = mutableListOf(
        mutableListOf(9, 5, 7, 10, 18),
        mutableListOf(36, 29, 6, 38, 40),
        mutableListOf(41, 20, 11, 25, 19),
        mutableListOf(30, 28, 13, 39, 50)
    )
    val foggel = Foggel(transportList, needList, stocksList, providersCount, consumersCount)

    foggel.countFoggel()
}