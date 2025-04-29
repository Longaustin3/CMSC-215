import java.math.BigInteger;
import java.math.BigDecimal;

public class BigNumberTest {

	public static void main(String[] args) {
		
		long someNumber = Long.MAX_VALUE;
		
//		System.out.println(someNumber * 2);
		
		BigInteger a = new BigInteger("9223372036854775807");
		BigInteger b = new BigInteger("2");
		BigInteger c = a.multiply(b);
		System.out.println(a + " * " + b + " = " + c);
		
		BigDecimal d = new BigDecimal("1.0");
		BigDecimal e = new BigDecimal("3");
		System.out.println(d.divide(e, 20, BigDecimal.ROUND_UP));
	}
}
