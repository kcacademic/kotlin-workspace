import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorTest {

    @Test
    fun testAdd() {
        assertEquals(4.0, add(2.0, 2.0))
    }

    @Test
    fun testSubtract() {
        assertEquals(0.0, subtract(2.0, 2.0))
    }

    @Test
    fun testMultiply() {
        assertEquals(4.0, multiply(2.0, 2.0))
    }

    @Test
    fun testDivide() {
        assertEquals(1.0, divide(2.0, 2.0))
    }

}