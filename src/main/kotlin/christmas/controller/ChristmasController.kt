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

        val totalAmount = calculateTotalAmount(orderList)
        outputView.printTotalPrice(totalAmount)

        outputView.printPresentMenu(totalAmount)

        val benefitList = checkBenefit(date, orderList, totalAmount)
        outputView.printBenefitList(benefitList)

        val benefitSum = benefitList.sum()
        outputView.printBenefitPrice(benefitSum)

        if (benefitList[4] == 0) outputView.printFinalPrice(totalAmount - benefitSum)
        else outputView.printFinalPrice(totalAmount - benefitSum + 25000)
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
        val weekendDay = listOf(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)
        val starDay = listOf(3, 10, 17, 24, 25, 31)

        if (date > 25) benefitList.add(0)
        else benefitList.add(1000 + (date - 1) * 100)

        if (date in weekendDay) {
            benefitList.add(0)
            benefitList.add(countDessert(orderList) * 2023)
        } else {
            benefitList.add(countMainMenu(orderList) * 2023)
            benefitList.add(0)
        }

        if (date in starDay) benefitList.add(1000)
        else benefitList.add(0)

        if (totalAmount > 120000) benefitList.add(25000)
        else benefitList.add(0)

        return benefitList
    }

    private fun countDessert(orderList: MutableMap<String, Int>): Int {
        var count = 0
        for (order in orderList) {
            if (order.key in menuList.getDesserts()) {
                count += order.value
            }
        }

        return count
    }

    private fun countMainMenu(orderList: MutableMap<String, Int>): Int {
        var count = 0
        for (order in orderList) {
            if (order.key in menuList.getMainMenus()) {
                count += order.value
            }
        }

        return count
    }
}