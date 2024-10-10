package Controllers;

import Models.CashModel;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CheckExchange {
    public CashModel searchFeesExchange() {

        Scanner read = new Scanner(System.in);
        System.out.println("Diga a SEGUNDA moeda que vc quer converter: ");
        String coinBase = read.nextLine();

        URI apiUri = URI.create("https://v6.exchangerate-api.com/v6/d5f02a67d1cffe56f08a96b8/latest/" + coinBase);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(apiUri)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), CashModel.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao tentar acessar a API de taxas de câmbio.");
        }
    }
}
