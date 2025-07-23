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

public class Pruebas_SimpleFileServer_2 {

	public static void main(String[] args) throws IOException {

	    HttpHandler handler = SimpleFileServer.createFileHandler(Path.of("D:/paginas-2"));
	    
	    FileOutputStream fos = new FileOutputStream("log.txt");
	    BufferedOutputStream bos = new BufferedOutputStream(fos);
	    Filter filter = SimpleFileServer.createOutputFilter(bos, OutputLevel.INFO);
	    
	    HttpServer server = HttpServer.create(new InetSocketAddress(1880), 10, "/test", handler, filter);
	    
	    server.start();
	}	
	
}


