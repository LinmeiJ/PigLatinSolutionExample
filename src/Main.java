import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char translateAgain = 'y';
		while (translateAgain == 'y') {

			System.out.println("enter your msg: ");
			String str = sc.nextLine();

			if (str.isEmpty()) {
				System.out.println("try again: ");
				str = sc.nextLine();
			} else {
				Translator.getTranslations(str);
			}
			System.out.println("continue(y/n): ");
			translateAgain = sc.nextLine().charAt(0);
		}
		System.out.println("Good bye!");
	}

}
