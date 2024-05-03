package MyGame;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APILoaderController {
	private static final String GET_URL = "https://marcconrad.com/uob/smile/api.php";
	private static final String USER_AGENT = "Mozilla/5.0";

	public static JSONObject callAPI() throws IOException, JSONException {
		URL object = new URL(GET_URL);
		HttpURLConnection urlConnection = (HttpURLConnection) object.openConnection();
		urlConnection.setRequestMethod("GET");
		urlConnection.setRequestProperty("User_Agent", USER_AGENT);
		int responseCode = getResponseCode(urlConnection);
		System.out.println("GET Response code is: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader input = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String inputLine;
			StringBuffer responseString = new StringBuffer();

			while ((inputLine = input.readLine()) != null) {
				responseString.append(inputLine);
			}
			input.close();

			JSONObject responseJson = new JSONObject(responseString.toString());
			System.out.println(responseJson);
			return responseJson;
		} else {
			System.out.println("GET response not worked.");
		}
		return null;
	}

	private static int getResponseCode(HttpURLConnection con) throws IOException {
		return con.getResponseCode();
	}

/*	public static myGame randomQuestion(int solution) throws JSONException, IOException {
		String dataRaw = String.valueOf(callAPI());
		String[] dataFromAPI = dataRaw.split(",");

		solution = Integer.parseInt(dataFromAPI[1]);


		return new myGame( solution);
	}*/

}




