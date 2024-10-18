import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class AzureMLModelCaller {

    private static final String ENDPOINT_URL = "http://267bc5f2-bb4e-419e-912b-2d67c4b00593.eastus2.azurecontainer.io/score"; // Endpoint
    private static final String API_KEY = "Fmwc1FIIgUi8tSdk491eR2pWyg2UEOFY"; // Chave de API

    public static void main(String[] args) {
        try {
            // Dados da solicitação
            JSONObject data = new JSONObject(); 
            
    data.put(new JSONObject()
                .put("symboling", 3)
                .put("normalized-losses", "?")
                .put("make", "alfa-romero")
                .put("fuel-type", "gas")
                .put("aspiration", "std")
                .put("num-of-doors", "two")
                .put("body-style", "convertible")
                .put("drive-wheels", "rwd")
                .put("engine-location", "front")
                .put("wheel-base", 88.60)
                .put("length", 168.80)
                .put("width", 64.10)
                .put("height", 48.80)
                .put("curb-weight", 2548)
                .put("engine-type", "dohc")
                .put("num-of-cylinders", "four")
                .put("engine-size", 130)
                .put("fuel-system", "mpfi")
                .put("bore", 3.47)
                .put("stroke", 2.68)
                .put("compression-ratio", 9.00)
                .put("horsepower", 111)
                .put("peak-rpm", 5000)
                .put("city-mpg", 21)
                .put("highway-mpg", 27)
                .put("price", 13495));
            
            data.put(new JSONObject()
                .put("symboling", 3)
                .put("normalized-losses", "?")
                .put("make", "alfa-romero")
                .put("fuel-type", "gas")
                .put("aspiration", "std")
                .put("num-of-doors", "two")
                .put("body-style", "convertible")
                .put("drive-wheels", "rwd")
                .put("engine-location", "front")
                .put("wheel-base", 88.60)
                .put("length", 168.80)
                .put("width", 64.10)
                .put("height", 48.80)
                .put("curb-weight", 2548)
                .put("engine-type", "dohc")
                .put("num-of-cylinders", "four")
                .put("engine-size", 130)
                .put("fuel-system", "mpfi")
                .put("bore", 3.47)
                .put("stroke", 2.68)
                .put("compression-ratio", 9.00)
                .put("horsepower", 111)
                .put("peak-rpm", 5000)
                .put("city-mpg", 21)
                .put("highway-mpg", 27)
                .put("price", 16500));
            
            data.put(new JSONObject()
                .put("symboling", 1)
                .put("normalized-losses", "?")
                .put("make", "alfa-romero")
                .put("fuel-type", "gas")
                .put("aspiration", "std")
                .put("num-of-doors", "two")
                .put("body-style", "hatchback")
                .put("drive-wheels", "rwd")
                .put("engine-location", "front")
                .put("wheel-base", 94.50)
                .put("length", 171.20)
                .put("width", 65.50)
                .put("height", 52.40)
                .put("curb-weight", 2823)
                .put("engine-type", "ohcv")
                .put("num-of-cylinders", "six")
                .put("engine-size", 152)
                .put("fuel-system", "mpfi")
                .put("bore", 2.68)
                .put("stroke", 3.47)
                .put("compression-ratio", 9.00)
                .put("horsepower", 154)
                .put("peak-rpm", 5000)
                .put("city-mpg", 19)
                .put("highway-mpg", 26)
                .put("price", 16500));
            
            data.put(new JSONObject()
                .put("symboling", 2)
                .put("normalized-losses", 164)
                .put("make", "audi")
                .put("fuel-type", "gas")
                .put("aspiration", "std")
                .put("num-of-doors", "four")
                .put("body-style", "sedan")
                .put("drive-wheels", "fwd")
                .put("engine-location", "front")
                .put("wheel-base", 99.80)
                .put("length", 176.60)
                .put("width", 66.20)
                .put("height", 54.30)
                .put("curb-weight", 2337)
                .put("engine-type", "ohc")
                .put("num-of-cylinders", "four")
                .put("engine-size", 109)
                .put("fuel-system", "mpfi")
                .put("bore", 3.19)
                .put("stroke", 3.40)
                .put("compression-ratio", 10.00)
                .put("horsepower", 102)
                .put("peak-rpm", 5500)
                .put("city-mpg", 24)
                .put("highway-mpg", 30)
                .put("price", 13950));
            
            String jsonInputString = data.toString(); // Converta para string JSON

            String jsonInputString = data.toString(); // Converta para string JSON

            // Crie um objeto URL
            URL url = new URL(ENDPOINT_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
            conn.setDoOutput(true); // Habilita a escrita no corpo da solicitação

            // Envia a solicitação
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Recebe a resposta
            int statusCode = conn.getResponseCode();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("Resposta do modelo: " + response.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
