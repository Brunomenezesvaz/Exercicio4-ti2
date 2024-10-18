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
            
          [
    {
        "symboling": 3,
        "normalized-losses": "?",
        "make": "alfa-romero",
        "fuel-type": "gas",
        "aspiration": "std",
        "num-of-doors": "two",
        "body-style": "convertible",
        "drive-wheels": "rwd",
        "engine-location": "front",
        "wheel-base": 88.60,
        "length": 168.80,
        "width": 64.10,
        "height": 48.80,
        "curb-weight": 2548,
        "engine-type": "dohc",
        "num-of-cylinders": "four",
        "engine-size": 130,
        "fuel-system": "mpfi",
        "bore": 3.47,
        "stroke": 2.68,
        "compression-ratio": 9.00,
        "horsepower": 111,
        "peak-rpm": 5000,
        "city-mpg": 21,
        "highway-mpg": 27,
        "price": 13495
    },
    {
        "symboling": 3,
        "normalized-losses": "?",
        "make": "alfa-romero",
        "fuel-type": "gas",
        "aspiration": "std",
        "num-of-doors": "two",
        "body-style": "convertible",
        "drive-wheels": "rwd",
        "engine-location": "front",
        "wheel-base": 88.60,
        "length": 168.80,
        "width": 64.10,
        "height": 48.80,
        "curb-weight": 2548,
        "engine-type": "dohc",
        "num-of-cylinders": "four",
        "engine-size": 130,
        "fuel-system": "mpfi",
        "bore": 3.47,
        "stroke": 2.68,
        "compression-ratio": 9.00,
        "horsepower": 111,
        "peak-rpm": 5000,
        "city-mpg": 21,
        "highway-mpg": 27,
        "price": 16500
    },
    {
        "symboling": 1,
        "normalized-losses": "?",
        "make": "alfa-romero",
        "fuel-type": "gas",
        "aspiration": "std",
        "num-of-doors": "two",
        "body-style": "hatchback",
        "drive-wheels": "rwd",
        "engine-location": "front",
        "wheel-base": 94.50,
        "length": 171.20,
        "width": 65.50,
        "height": 52.40,
        "curb-weight": 2823,
        "engine-type": "ohcv",
        "num-of-cylinders": "six",
        "engine-size": 152,
        "fuel-system": "mpfi",
        "bore": 2.68,
        "stroke": 3.47,
        "compression-ratio": 9.00,
        "horsepower": 154,
        "peak-rpm": 5000,
        "city-mpg": 19,
        "highway-mpg": 26,
        "price": 16500
    },
    {
        "symboling": 2,
        "normalized-losses": 164,
        "make": "audi",
        "fuel-type": "gas",
        "aspiration": "std",
        "num-of-doors": "four",
        "body-style": "sedan",
        "drive-wheels": "fwd",
        "engine-location": "front",
        "wheel-base": 99.80,
        "length": 176.60,
        "width": 66.20,
        "height": 54.30,
        "curb-weight": 2337,
        "engine-type": "ohc",
        "num-of-cylinders": "four",
        "engine-size": 109,
        "fuel-system": "mpfi",
        "bore": 3.19,
        "stroke": 3.40,
        "compression-ratio": 10.00,
        "horsepower": 102,
        "peak-rpm": 5500,
        "city-mpg": 24,
        "highway-mpg": 30,
        "price": 13950
    }
]

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
