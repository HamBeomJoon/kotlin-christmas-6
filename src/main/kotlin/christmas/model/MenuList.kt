package christmas.model

class MenuList {
    private val menuList = mutableListOf<Pair<String, Int>>()

    init {
        menuList.add(Pair("양송이수프", 6000))
        menuList.add(Pair("타파스", 5500))
        menuList.add(Pair("시저샐러드", 8000))
        menuList.add(Pair("티본스테이크", 55000))
        menuList.add(Pair("바비큐립", 54000))
        menuList.add(Pair("해산물파스타", 35000))
        menuList.add(Pair("크리스마스파스타", 25000))
        menuList.add(Pair("초코케이크", 15000))
        menuList.add(Pair("아이스크림", 5000))
        menuList.add(Pair("제로콜라", 3000))
        menuList.add(Pair("레드와인", 60000))
        menuList.add(Pair("샴페인", 25000))
    }

    fun getMenus(): List<String> {
        return menuList.map { it.first }
    }
}