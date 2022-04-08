package com;

//
//RECORDS. Nueva palabra reservada!
//

//Heredan de java.lang.Record
//Pueden declararse dentro de una clase. Ser�n impl�citamente est�ticos
//Pueden utilizar generics
//Pueden implementar interfaces

//Se instancian con new
//Pueden tener 
//	M�todos est�ticos
//	Campos est�ticos
//  Inicializadores est�ticos
//	Constructores
//	M�todos din�micos
//	Clases anidadas/internas
//	Anotaciones

//No pueden heredar de una clase
//No permiten definir campos din�micos
//No pueden ser abstractos

//Record mondo y lirondo
public record Cliente(Integer id, String nombre, String direccion, String telefono) {
}

//
//Equivalente a:
//
final class Cliente_  {
    private final Integer id;
    private final String nombre;
    private final String direccion;
    private final String telefono;
    
    public Cliente_(Integer id, String nombre, String direccion, String telefono) {
    	this.id = id;
    	this.nombre = nombre;
    	this.direccion = direccion;
    	this.telefono = telefono;
    }
    
    public Integer id() {
    	return id;
    }
    
    public String nombre() {
    	return nombre;
    }
    
    public String direccion() {
    	return direccion;
    }
    
    public String telefono() {
    	return telefono;
    }    
}