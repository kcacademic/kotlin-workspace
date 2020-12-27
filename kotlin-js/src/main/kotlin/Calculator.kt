import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLInputElement
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.css
import styled.styledDiv
import styled.styledInput
import kotlin.math.sqrt

external interface CalculatorProps : RProps {
    var value: String
}

data class CalculatorState(val value: String) : RState

@JsExport
class Welcome(props: CalculatorProps) : RComponent<CalculatorProps, CalculatorState>(props) {

    init {
        state = CalculatorState(props.value)
    }

    override fun RBuilder.render() {
        styledInput {
            css {
                +CalculatorStyles.textInput
            }
            attrs {
                type = InputType.number
                value = state.value
                onChangeFunction = { event ->
                    setState(
                            CalculatorState(value = (event.target as HTMLInputElement).value)
                    )
                }
            }
        }

        styledDiv {
            css {
                +CalculatorStyles.textContainer
            }
            +"Square Root: ${
                sqrt(state.value.toDouble())}"
        }
    }
}
