package com;

//
//RECORDS. Nueva palabra reservada!
//

//Heredan de java.lang.Record
//Pueden declararse dentro de una clase. Serán implícitamente estáticos
//Pueden utilizar generics
//Pueden implementar interfaces
//Por defecto inmutables
//Métodos accesores llamados como los atributos (sin 'get')

//Se instancian con new
//Pueden tener 
//	Métodos estáticos
//	Campos estáticos
//  Inicializadores estáticos
//	Constructores
//	Métodos dinámicos
//	Clases anidadas/internas
//	Anotaciones

//No pueden heredar de una clase
//No permiten definir campos dinámicos
//No pueden ser abstractos

//Record mondo y lirondo
//Incluye de regalo un toString
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



