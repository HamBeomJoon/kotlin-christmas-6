package christmas.model

class MenuList {
    private val menuList = mutableMapOf<String, Int>()

    init {
        menuList["양송이수프"] = 6000
        menuList["타파스"] = 5500
        menuList["시저샐러드"] = 8000
        menuList["티본스테이크"] = 55000
        menuList["바비큐립"] = 54000
        menuList["해산물파스타"] = 35000
        menuList["크리스마스파스타"] = 25000
        menuList["초코케이크"] = 15000
        menuList["아이스크림"] = 5000
        menuList["제로콜라"] = 3000
        menuList["레드와인"] = 60000
        menuList["샴페인"] = 25000
    }

    fun getMenus(): List<String> {
        return menuList.keys.toList()
    }

    fun getDrinks(): List<String> {
        return listOf("제로콜라", "레드와인", "샴페인")
    }
}