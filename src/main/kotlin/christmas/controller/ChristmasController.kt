package christmas.controller

import christmas.model.MenuList
import christmas.view.InputView
import christmas.view.OutputView

class ChristmasController {
    private val inputView = InputView()
    private val outputView = OutputView()

    private val menuList = MenuList()

    fun run() {
        outputView.printStartPlanner()
        val date = inputView.inputDate()

        val orderList = inputView.inputMenu(menuList)

        outputView.printEventDay(date)

        outputView.printMenu(orderList)

    }
}