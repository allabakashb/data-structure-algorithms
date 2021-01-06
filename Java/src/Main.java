import java.text.MessageFormat;

public class Main {
	
	public static void main(String[] args) {

		String template = "hello {0} how are you {0} ok {0}";
		System.out.println(MessageFormat.format(template, "ab"));
	}
}
