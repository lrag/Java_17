package com.curso.opcionalchungo;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class OptionalChungo {

	private Object value;
	private Object defaultValue;	
	private List<Object> funcionesSalvajes = new ArrayList<>();
	
	private OptionalChungo(Object valor){
		this.value = valor;
	}
	
	public static OptionalChungo of(Object value){
		return new OptionalChungo(value);
	}
	
	public static OptionalChungo empty(){
		return new OptionalChungo(null);
	}
	
	public boolean isPresent() {
		return fin() != null;
	}
	
	public Object get() {
		Object val = fin();
		if(val == null) {
			throw new NoSuchElementException("Nada en el opcional :(");
		}
		return val;
	}

	public OptionalChungo flatMap(Flatmap funcion) {
		funcionesSalvajes.add(funcion);
		return this;
	}
	
	public OptionalChungo map(Function funcion) {
		funcionesSalvajes.add(funcion);
		return this;
	}
	
	public Object orElse(Object defaultValue) {
		this.defaultValue = defaultValue;
		return fin();
	}
	
	private Object fin() {
		
		if(value == null) {
			return defaultValue;
		}
		
		Object currentValue = value;
		
		for(Object f : funcionesSalvajes) {			
			if(f instanceof Function) {
				System.out.println("map");
				currentValue = ((Function)f).apply(currentValue);
			} else if(f instanceof Flatmap) {
				System.out.println("flatmap");
				OptionalChungo op = ((Flatmap)f).apply(currentValue);
				if(op.isPresent()) {
					currentValue = op.get();
				} else {
					currentValue = null;
				}
			}
			
			if(currentValue == null) {
				return defaultValue;
			}
		}		
		
		return currentValue;
	}
	
}
