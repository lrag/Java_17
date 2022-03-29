package com.modelo.otroPaquete;

import com.modelo.Vehiculo;

//Las clases que heredan de superclase sellada han de ser finales
//La clase Cami�n se encuentra en un paquete diferente
public sealed class Camion extends Vehiculo permits CamionRigido, CamionArticulado{

	@Override
	public void arrancar() {
		System.out.println("Soy el cami�n y arranco");
	}

}
