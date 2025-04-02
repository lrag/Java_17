package com;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;
import java.util.SequencedSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinPool;

public class Pruebas 
{
    public static void main(String[] args) throws IOException {
    	
    	//addFirst
    	//addLast
    	//
    	//removeFirst
    	//removeLast
    	//
    	//getFirst
    	//getLast
    	
    	System.out.println("================================");
    	
    	List<String> lista = new ArrayList<>();
    	
    	lista.add(0,"cinco");
    	lista.add(0,"cuatro");
    	
    	lista.addFirst("tres");
    	lista.addFirst("dos");
    	lista.addFirst("uno");
    	
    	lista.add("seis");
    	lista.add("siete");
    	
    	lista.addLast("ocho");
    	lista.addLast("nueve");
    	lista.addLast("diez");
    	
    	lista.forEach(System.out::println);
    	
    	System.out.println("================================");
    	
    	List<String> lista2 = new ArrayList<>();
    	lista2.add("aaa");
    	lista2.add("bbb");
    	lista2.add("ccc");
    	lista2.add("ddd");
    	lista2.add("eee");
    	lista2.add("fff");
    	lista2.add("ggg");
    	lista2.add("hhh");
    	lista2.add("iii");
    	
    	lista2.remove(0);
    	lista2.remove(0);
    	
    	lista2.removeFirst();
    	lista2.removeFirst();

    	lista2.remove(lista2.size()-1);
    	lista2.remove(lista2.size()-1);
    	
    	lista2.removeLast();
    	lista2.removeLast();

    	System.out.println(lista2);
    	
    	System.out.println("================================");

    	SequencedSet<String> palabras = new TreeSet<>();
    	palabras.add("HELLO");
    	palabras.add("DOCTOR");
    	palabras.add("NAME");
    	palabras.add("CONTINUE");
    	palabras.add("YESTERDAY");
    	palabras.add("TOMORROW");
    	
    	System.out.println(palabras);
    	
    	//palabras.addFirst("ZAMBOMBAZO"); UnsupportedOperationException
    	//palabras.addLast("CATAPUN"); UnsupportedOperationException
    	
    	palabras.removeFirst();
    	palabras.removeLast();
    	
    	System.out.println(palabras);
    	
    	
    	SequencedCollection<Object> x;
    	
    	
    }

}