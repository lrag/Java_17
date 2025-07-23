package com.modelo.otroPaquete;

import com.modelo.Vehiculo;

//Las clases que heredan de superclase sellada han de ser finales
//La clase Camión se encuentra en un paquete diferente
public abstract sealed class Camion extends Vehiculo permits CamionRigido, CamionArticulado{

	@Override
	public void arrancar() {
		System.out.println("Soy el camión y arranco");
	}

}
