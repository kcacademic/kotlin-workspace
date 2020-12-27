import kotlinx.css.*
import styled.StyleSheet

object CalculatorStyles : StyleSheet("CalculatorStyles", isStatic = true) {
    val textContainer by css {
        padding(5.px)
        width = 500.px
        backgroundColor = rgb(8, 97, 22)
        color = rgb(56, 246, 137)
    }

    val textInput by css {
        margin(vertical = 5.px)
        width = 500.px
        fontSize = 14.px
    }
} 
