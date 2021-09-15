import java.util.StringTokenizer;

public class Tokenizer {

	public static void main(String[] args) {
		String strDatos= "6.3 \\ n6.2 \\ n6.4 \\ n6.2";
		StringTokenizer strT = new StringTokenizer(strDatos, " \\ n");
		int count = strT.countTokens();
		double sum = 0;
		
		System.out.printf("Números: %d \n", count);
		
		while(strT.hasMoreTokens()) sum = Double.parseDouble(strT.nextToken()) + sum;
		System.out.printf("Suma: %.2f \n", sum);
		System.out.printf("Media: %.2f", sum / count);
	}

}
