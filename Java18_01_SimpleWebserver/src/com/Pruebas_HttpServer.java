package com;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Pruebas_HttpServer 
{
    public static void main(String[] args) throws IOException 
    {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new MyHandler());

        server.setExecutor(null); //Las peticiones las procesará todas el hilo que arranca el servidor
        server.start();

        System.out.println("Esperando peticiones en el puerto 8000");
    }

    static class MyHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException 
        {
        	System.out.println("Petición recibida: "+exchange.getRequestMethod()+" "+exchange.getRequestURI());
        	
            String response = "<html><head></head><body><marquee><h1><font color=\"lightGreen\">Respuesta enlatada</font></h1></marquee></body></html>";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}