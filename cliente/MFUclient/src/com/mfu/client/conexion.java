package com.mfu.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class conexion {
	
	
	public static respuesta conectar (String urls){
		
	respuesta respuesta;
	String result = "";
    URL url;
    HttpURLConnection urlConnection = null;

    try {
        url = new URL(urls);

        urlConnection = (HttpURLConnection) url.openConnection();

        InputStream in = urlConnection.getInputStream();

        InputStreamReader reader = new InputStreamReader(in);

        int data = reader.read();

        while (data != -1) {

            char current = (char) data;

            result += current;

            data = reader.read();

        }

        System.out.println(result);
        String[] resultados = result.split("-");
        return respuesta = new respuesta (resultados[0],resultados[1],resultados[2],resultados[3],resultados[4]);

    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    return null;
}



}
