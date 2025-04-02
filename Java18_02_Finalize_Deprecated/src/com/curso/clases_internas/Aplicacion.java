package com.curso.clases_internas;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Aplicacion {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("=======================================");
		System.out.println("Iniciando test 'clases internas anónimas'...");
		Thread.sleep(8_000);	
		System.out.println("Creando objetos...");			
		
		//Hay que tener en cuenta que los objetos de clases internas anónimas 
		//tienen una referencia al objeto que las ha creado
		List<Comparator> lista = new ArrayList<>();
		for(int a=0; a<10_000_000; a++) {
			GeneradorComparadores e = new GeneradorComparadores();
			Comparator c = e.crearComparador(1);
			lista.add(c);
		}	
		
		System.out.println("=======================================");
		Thread.sleep(160_000);
		System.out.println("FIN");	
	}
	
}

/*
class Ventana extends JFrame {

	public Ventana() throws HeadlessException {
		super();

		JButton btnInsertar = new JButton("Insertar");
		
		ActionListener al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//insertarCliente()
			}
		};		
		btnInsertar.addActionListener(al);
	
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//modificarCliente();				
			}
		});
	
	}	
}
*/

/*
class OyenteBotonInsertar implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Botón insertar pulsado");
		//insertarCliente();		
	}	
}
*/












