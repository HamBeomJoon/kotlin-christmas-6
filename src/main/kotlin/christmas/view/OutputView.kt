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

    fun printTotalPrice(amount: Int) {
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

    fun printBenefitList(benefitList: List<Int>) {
        println("\n<혜택 내역>")
        if (benefitList[0] != 0) println("크리스마스 디데이 할인: -${benefitList[0].formatWithCommas()}원")
        if (benefitList[1] != 0) println("평일 할인: -${benefitList[1].formatWithCommas()}원")
        if (benefitList[2] != 0) println("주말 할인: -${benefitList[2].formatWithCommas()}원")
        if (benefitList[3] != 0) println("특별 할인: -${benefitList[3].formatWithCommas()}원")
        if (benefitList[4] != 0) println("증정 이벤트: -${benefitList[4].formatWithCommas()}원")
    }

}