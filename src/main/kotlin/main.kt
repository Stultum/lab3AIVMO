fun main() {

//    val providersCount = 4
//    val consumersCount = 5
//    val needList = mutableListOf(49, 60, 78, 50, 50)
//    val stocksList = mutableListOf(78, 94, 29, 86)
//    val transportList = mutableListOf(
//        mutableListOf(9, 5, 7, 10, 18),
//        mutableListOf(36, 29, 6, 38, 40),
//        mutableListOf(41, 20, 11, 25, 19),
//        mutableListOf(30, 28, 13, 39, 50)
//    )

    val providersCount = 3
    val consumersCount = 5
    val needList = mutableListOf(32, 62, 54, 10, 78)
    val stocksList = mutableListOf(88, 6, 92)
    val transportList = mutableListOf(
        mutableListOf(12, 13, 11, 8, 10),
        mutableListOf(9, 10, 7, 5, 8),
        mutableListOf(10, 8, 7, 7, 8),
    )

//    val providersCount = 3
//    val consumersCount = 5
//    val needList = mutableListOf(74, 23, 90, 49, 34)
//    val stocksList = mutableListOf(51, 46, 99)
//    val transportList = mutableListOf(
//        mutableListOf(13, 14, 12, 9, 11),
//        mutableListOf(16, 17, 14, 12, 15),
//        mutableListOf(18, 16, 15, 15, 16),
//    )

    val foggel = Foggel(transportList, needList, stocksList, providersCount, consumersCount)

    foggel.countFoggel()
}