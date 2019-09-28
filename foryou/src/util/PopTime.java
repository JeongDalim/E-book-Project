package util;

import java.time.LocalDateTime;

public class PopTime {
	public static int popTime() {
		LocalDateTime now = LocalDateTime.now();

		int a = Integer.parseInt(now.toString().substring(11, 19).split(":")[0]);
		int b = Integer.parseInt(now.toString().substring(11, 19).split(":")[1]);
		int c = Integer.parseInt(now.toString().substring(11, 19).split(":")[2]);

		int now2 = (a * 3600) + (b * 60) + (c);

		return now2;
	}
}
