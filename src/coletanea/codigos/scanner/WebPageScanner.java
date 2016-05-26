package coletanea.codigos.scanner;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WebPageScanner {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		try {
			URLConnection connection = new URL("http://www.google.com")
					.openConnection();

			Scanner sc = new Scanner(connection.getInputStream());
			sc.useDelimiter("\\z");
			while (sc.hasNext()) {
				System.out.println(sc.nextLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
