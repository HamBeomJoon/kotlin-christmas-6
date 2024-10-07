package christmas.view

import camp.nextstep.edu.missionutils.Console
import christmas.model.MenuList
import christmas.utils.Validator

class InputView {
    fun inputDate(): Int {
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
        val input = Console.readLine()
        Validator.isValidNotNull(input)
        Validator.isValidNumber(input)
        Validator.isValidRange(input)

        return input.toInt()
    }

    fun inputMenu(menuList: MenuList): MutableMap<String, Int> {
        println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
        val orderList = mutableMapOf<String, Int>()
        var menuSum = 0
        var drinkCount = 0
        val menus = Console.readLine().split(",")

        for (menu in menus) {
            Validator.isValidMenuType(menu)
            val (name, count) = menu.split("-")
            Validator.isValidMenuName(name, menuList)
            Validator.isValidMenuCount(count)

            orderList[name] = count.toInt()
            menuSum += count.toInt()
            if (name in menuList.getDrinks()) drinkCount++
        }
        Validator.isValidUniqueMenu(orderList)
        Validator.isValidMenuSum(menuSum)
        Validator.isNotOnlyDrink(drinkCount == menus.size)

        return orderList
    }

}