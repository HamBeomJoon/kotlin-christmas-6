package christmas.view

import christmas.utils.formatWithCommas

class OutputView {
    fun printStartPlanner() = println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
    fun printEventDay(date: Int) = println("12월 ${date}일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
    fun printMenu(orderList: MutableMap<String, Int>) {
        println("\n<주문 메뉴>")
        for (order in orderList) {
            println("${order.key} ${order.value}개")
        }
    }

    fun printTotalAmount(amount: Int) {
        println("\n<할인 전 총주문 금액>")
        println("${amount.formatWithCommas()}원")
    }

    fun printPresentMenu(amount: Int) {
        println("\n<증정 메뉴>")
        if (amount >= 120000) {
            println("샴페인 1개")
        } else {
            println("없음")
        }
    }
}