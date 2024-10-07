package christmas.utils

// 숫자 뒤에서부터 3자리마다 쉼표를 추가하는 확장함수

fun Int.formatWithCommas(): String {
    val str = this.toString()
    val sb = StringBuilder()

    for (i in str.indices) {
        if (i > 0 && (str.length - i) % 3 == 0) {
            sb.append(',')
        }
        sb.append(str[i])
    }

    return sb.toString()
}