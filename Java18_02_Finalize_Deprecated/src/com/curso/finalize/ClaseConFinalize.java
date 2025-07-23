package com.curso.finalize;

import java.io.FileWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClaseConFinalize {

	private List<Integer> lista = new ArrayList<>(100_000);
	
	private FileWriter fw;
	private Socket sk;

	@Override
	public void finalize() {
		
		System.out.println("Adios mundo cruel");
		try {
			//fw.close();
			//sk.close();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
}
