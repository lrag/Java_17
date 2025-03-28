package com;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Path;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;

public class Pruebas_SimpleFileServer {
	
	//Solo GET y HEAD
	//Ignora query parameters
	

	public static void main(String[] args) throws IOException {
	    InetSocketAddress address = new InetSocketAddress(80);
	    Path path = Path.of("D:/paginas");
	    HttpServer server = SimpleFileServer.createFileServer(address, path, SimpleFileServer.OutputLevel.VERBOSE);
	    
	    HttpHandler handler = SimpleFileServer.createFileHandler(Path.of("D:/paginas-2"));
	    server.createContext("/cosas", handler);
	    
	    FileOutputStream fos = new FileOutputStream("log.txt");
	    BufferedOutputStream bos = new BufferedOutputStream(fos);
	    Filter filter = SimpleFileServer.createOutputFilter(bos, OutputLevel.INFO);
	    

	    
	    
	    server.start();
	}	
	
}


