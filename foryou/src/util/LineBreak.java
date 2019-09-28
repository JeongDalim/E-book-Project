package util;

public class LineBreak {
	public static String lineBreak(String str) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '\n')
				sb.append("<br>");
			else
				sb.append(str.charAt(i));
		}
		return sb.toString();
	}
}
