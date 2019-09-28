package action.home;

import java.time.LocalDateTime;

public class test {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();

		int a = Integer.parseInt(now.toString().substring(11, 19).split(":")[0]);
		int b = Integer.parseInt(now.toString().substring(11, 19).split(":")[1]);
		int c = Integer.parseInt(now.toString().substring(11, 19).split(":")[2]);

		int now2 = (a * 3600) + (b * 60) + (c);

		System.out.println(now2);
	}
}
