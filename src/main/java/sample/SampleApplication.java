package sample;

import java.util.function.Function;

/**
 * An example application that can be used to manually test the Maven Plugin and IDE
 * integration.
 * <p>
 * (This is a modified copy of
 * https://github.com/spring-io/spring-javaformat/tree/main/samples/spring-javaformat-maven-sample
 * by Phillip Webb)
 *
 * @author Josef Reichardt
 */
public class SampleApplication {

	/**
	 * Says hello.
	 * @param args the args
	 */
	private void sayHello(String[] args) {
		Function<Integer, String> getText = (cnt) -> "Number of args: " + cnt;

		String message = switch (args.length) {
		case 0 -> "No arg";
		case 1 -> "One arg";
		default -> getText.apply(args.length);
		};

		System.out.println(message);
	}

	public static void main(String[] args) {
		new SampleApplication().sayHello(args);
	}

}
