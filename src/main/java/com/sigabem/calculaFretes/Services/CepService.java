package com.sigabem.calculaFretes.Services;

import com.google.gson.Gson;
import com.sigabem.calculaFretes.Model.Endereco;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.format.DateTimeFormatter;

public class CepService {

    private static CepService instance;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private CepService() {

    }

    public static CepService getInstance() {
        if (instance == null) {
            instance = new CepService();
        }
        return instance;
    }

    public DateTimeFormatter getDtf() {
        return dtf;
    }

    public Endereco buscaCep(String cep) {
        Endereco end = null;

        try {
            String url = "https://viacep.com.br/ws/" + cep + "/json";

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
            } else {

                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

                String output = "";
                String line;
                while ((line = br.readLine()) != null) {
                    output += line;
                }

                conn.disconnect();

                Gson gson = new Gson();
                end = gson.fromJson(new String(output.getBytes()), Endereco.class);
            }

            return end;

        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }
}
