import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Translator {

	public static void getTranslations(String str) {

		String[] s = str.split(" "); // initialize a string array to store each word from user input
		String[] translatedWords = new String[s.length];// initialize a string array to store each translated word

		for (int i = 0; i < s.length; i++) {
			if (isContainSpecialSymbol(s[i]) || isContainDigits(s[i])) { // word contains symbol or digits : @
				translatedWords[i] = s[i];
			} else if (isContainsApostrophe(s[i])) {
				translatedWords[i] = getApostropheTranslated(s[i]);
			} else if (!isContainPunct(s[i])) {
				translatedWords[i] = translateWordWithVowels(s[i]); // has vowels but without punctuation.
			}else {
				translatedWords[i] = getVowelsTranslatedWithPunct(s[i]); // translate word contains vowels and punctuation
			}
		}

		getWholeString(translatedWords);
	}

	private static String getApostropheTranslated(String s) {
		Pattern p = Pattern.compile("[aeiouAEIOU]");
		Matcher m = p.matcher(s);
		
		if(m.find()) {
			if (!isStartsWithVowels(s)) {// not start with vowel
					int index = findIndexOfTheFirstVowel(s);
					return s.substring(index) + s.substring(0, index) + "ay";
				}
				return s + "way";//start with vowel
			}
		return s +"ay"; // do not contain any vowel
		
	}

	private static boolean isContainsApostrophe(String s) {
        if(s.contains("'")) {
        	return true;
        }
		return false;
	}

	private static String getVowelsTranslatedWithPunct(String s) {
		if (!isStartsWithVowels(s)) { // not start with vowel
			int index = findIndexOfTheFirstVowel(s);
			return s.substring(index, s.length()-1) + s.substring(0, index) + "ay" + s.substring(s.length()-1);
		} else { 
			return s.substring(0, s.length() - 1) + "way" + s.substring(s.length()-1);
		}
	}

	private static String translateWordWithVowels(String s) {
		if (isStartsWithVowels(s)) {
			return s + "way";
		} else {
			int index = findIndexOfTheFirstVowel(s);
			return s.substring(index) + s.substring(0, index) + "ay";
		}
	}

	private static int findIndexOfTheFirstVowel(String s) {
		int index = 0;
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (Character.toString(chars[i]).matches("[aeiou]")) {
				index = i;
				break;
			}
		}
		return index;
	}

	public static boolean isContainVowels(String s) {
		if (s.contains("[aeiou]")) {
			return true;
		}
		return false;
	}

	public static boolean isStartsWithVowels(String s) {
		System.out.println();
		if (Character.toString(s.charAt(0)).matches("[aeiouAEIOU]")) {
			return true;
		}
		return false;
	}

	private static void getWholeString(String[] s) {
		System.out.println(String.join(" ", s));
	}

	private static boolean isContainDigits(String string) {
		if (string.contains("[\\p{Digit}]")) {
			return true;
		}
		return false;
	}

	private static boolean isContainSpecialSymbol(String s) {
		if (s.contains("@")) {
			return true;
		}
		return false;
	}

	private static boolean isContainPunct(String s) {
		Pattern p = Pattern.compile("[\\p{Punct}]");
		Matcher m = p.matcher(s);
		return m.find();
	}

}
