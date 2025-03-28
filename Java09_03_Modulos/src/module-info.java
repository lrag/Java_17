
module java09_03_Modulos {

	//requires y exports no son palabras reservadas
	requires java.base; //Incluida por defecto
	requires java.sql;
	requires java.desktop; //Para aplicaciones de escritorio con swing
	requires java.naming; //Para el directorio JNDI
	
	exports com;
	
}