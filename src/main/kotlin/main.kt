fun main(){
    val minute = 60
    val hour = 60 * 60
    val day = 24 * 60 * 60

    fun pluralForm(minutes: Int):Int {
    return when{
        (minutes % 10 == 1 && minutes % 100 != 11) -> 1
        (minutes % 10 == 2 && minutes % 100 != 12 ||
                minutes % 10 == 3 && minutes % 100 != 13 ||
                minutes % 10 == 4 && minutes % 100 != 14) -> 2
        else -> 3
        }
    }

    fun minutesWordForm(secondsAgo: Int):String {
        val minutesAgo = secondsAgo / minute
        return when{
            (pluralForm(minutesAgo) == 1) -> "$minutesAgo минуту"
            (pluralForm(minutesAgo) == 2) -> "$minutesAgo минуты"
            else -> "$minutesAgo минут"
        }
    }

    fun hoursWordForm(secondsAgo: Int):String {
        val hoursAgo = secondsAgo / hour
        return when{
            (pluralForm(hoursAgo) == 1) -> "$hoursAgo час"
            (pluralForm(hoursAgo) == 2) -> "$hoursAgo часа"
            else -> "$hoursAgo часов"
        }
    }

    fun agoToText(secondAgo: Int):String {
        return when{
            secondAgo <= minute -> "был(а) только что"
            secondAgo <= hour -> "был(а) ${minutesWordForm(secondAgo)} назад"
            secondAgo <= day -> "был(а) в сети ${hoursWordForm(secondAgo)} назад"
            secondAgo <=2 * day -> "был(а) в сети сегодня"
            secondAgo > 2* day && secondAgo <=3 * day -> "был(а) в сети вчера"
            else -> "был(а) в сети давно"
        }
    }

    println(agoToText(3* hour))
}
