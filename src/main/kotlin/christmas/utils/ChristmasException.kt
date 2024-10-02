package christmas.utils

enum class ChristmasException(private val message: String) {
    INVALID_NOT_NULL("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_INTEGER("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_RANGE("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INVALID_MENU("유효하지 않은 주문입니다. 다시 입력해 주세요.");

    fun getMessage(): String = "[ERROR] $message"
}