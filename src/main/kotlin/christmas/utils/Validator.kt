package christmas.utils

import christmas.model.MenuList

object Validator {
    fun isValidNotNull(input: String) {
        require(input.isNotEmpty()) { ChristmasException.INVALID_NOT_NULL.getMessage() }
    }

    fun isValidNumber(input: String) {
        require(input.toIntOrNull() != null) { ChristmasException.INVALID_INTEGER.getMessage() }
    }

    fun isValidRange(input: String) {
        require(input.toInt() in 1..31) { ChristmasException.INVALID_RANGE.getMessage() }
    }

    fun isValidMenuType(menu: String) {
        require("-" in menu) { ChristmasException.INVALID_MENU.getMessage() }
    }

    fun isValidMenuName(name: String, menuList: MenuList) {
        require(name in menuList.getMenus()) { ChristmasException.INVALID_MENU.getMessage() }
    }
}