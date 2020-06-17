package kr.yapp.teamplay

import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val matchDate = "06월 12일"
        val matchTime = "09:24 - 11:24"
        val formatterOfDate = DateTimeFormatter.ofPattern("yyyy MM월 dd일")
        val formatterOfDateTime = DateTimeFormatter.ofPattern("HH:mm")

        val itemDateTime = LocalDateTime.of(
            LocalDate.parse(LocalDate.now().year.toString() + " " + matchDate, formatterOfDate),
            LocalTime.parse(matchTime!!.split("-")[1].trim(), formatterOfDateTime)
        )
        println(itemDateTime)
        assertTrue(itemDateTime.isBefore(LocalDateTime.now()))
    }
}
