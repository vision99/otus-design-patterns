import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.otus.alex.QuadraticEqualsCalculatorImpl;

public class QuadraticTest {

    /*
    x^2+1 = 0
     */
    @ParameterizedTest
    @CsvSource({"1.0, 1.0", "-1.0,-1.0"})
    public void sqrtFromNegativeShouldNotHaveAnswers( double a, double c ) {
        //given
        var calculator = new QuadraticEqualsCalculatorImpl( a, 0.0, c );
        //when
        calculator.calculate( );
        //then
        Assertions.assertArrayEquals( new double[]{}, calculator.getResult( ) );
    }

    /*
    a==0
     */
    @Test
    public void sqrtFromNegativeShouldThrowsException( ) {
        //given
        var calculator = new QuadraticEqualsCalculatorImpl( 0.0 );
        //when
        //then
        Assertions.assertThrows( RuntimeException.class, calculator::calculate );
    }

    /*
    D==0
     */
    @Test
    public void sqrtWithDiscriminantIsZeroShouldHaveOneAnswer( ) {
        //given
        var calculator = new QuadraticEqualsCalculatorImpl( 1.0, 2.0, 1.0 );
        //when
        calculator.calculate( );
        //then
        Assertions.assertArrayEquals( new double[]{-1.0}, calculator.getResult( ) );
    }

}
