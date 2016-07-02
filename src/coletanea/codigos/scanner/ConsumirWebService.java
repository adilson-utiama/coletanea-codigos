package coletanea.codigos.scanner;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ConsumirWebService {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ParseException {
		try {

			URL url = new URL("http://wsloterias.azurewebsites.net/api/sorteio/getresultado/3/1150");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			int code = con.getResponseCode();
			System.out.println("Status Code: " + code);
			String type = con.getContentType();
			System.out.println(type);
			
			InputStream stream = con.getInputStream();
			Scanner scanner = new Scanner(stream);
			StringBuilder s = new StringBuilder();
			while(scanner.hasNext()){
				s.append(scanner.nextLine());
			}
			//System.out.println(s);
			
			String jogo = s.toString();
						
			JSONObject json;
			JSONParser parser = new JSONParser();
			json = (JSONObject) parser.parse(jogo);
			JSONArray array = (JSONArray) json.get("Sorteios");
			
			String d = array.toJSONString();
			String replace = d.substring(1, d.length() - 1);
						
			json = (JSONObject) parser.parse(replace);
			String var = (String) json.get("Numeros").toString();
			String resultado = var.substring(1, var.length() - 1);
			String[] split = resultado.split(",");
			List<Integer> result = new ArrayList<>();
			for (String num : split) {
				result.add(Integer.parseInt(num));
			}
			Collections.sort(result);
			System.out.println(result);
			
			con.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
