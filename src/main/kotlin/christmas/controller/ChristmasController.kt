package christmas.controller

import christmas.model.MenuList
import christmas.view.InputView
import christmas.view.OutputView

class ChristmasController {
    private val inputView = InputView()
    private val outputView = OutputView()

    private val menuList = MenuList()
    private val benefitList = listOf<Int>()

    fun run() {
        outputView.printStartPlanner()
        val date = inputView.inputDate()

        val orderList = inputView.inputMenu(menuList)

        outputView.printEventDay(date)

        outputView.printMenu(orderList)

        val totalAmount = calculateTotalAmount(orderList)
        outputView.printTotalPrice(totalAmount)

        outputView.printPresentMenu(totalAmount)

        checkBenefit(date, orderList, totalAmount)
    }

    private fun calculateTotalAmount(orderList: MutableMap<String, Int>): Int {
        var amount = 0
        for (order in orderList) {
            val price = menuList.getMenuPrice(order.key)
            amount += price!! * order.value
        }

        return amount
    }

    private fun checkBenefit(date: Int, orderList: MutableMap<String, Int>, totalAmount: Int): List<Int> {
        val benefitList = mutableListOf<Int>()
        if (date > 25) benefitList.add(0)
        else benefitList.add(1000 + (date - 1) * 100)
    }
}