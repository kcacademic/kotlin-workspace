import kotlin.test.Test
import kotlin.test.assertEquals

class ExtendedCalculatorJVMTest {

    @Test
    fun testAddAndDouble() {
        assertEquals(2.0, ExtendedCalculatorJVM.addAndSquareRoot(2.0, 2.0))
    }

    @Test
    fun testAddAndDoubleKotlin() {
        assertEquals(2.0, addAndSquareRoot(2.0, 2.0))
    }

}