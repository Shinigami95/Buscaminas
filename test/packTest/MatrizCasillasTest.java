package packTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.MatrizCasillas;
import packModelo.Sesion;

public class MatrizCasillasTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCrearMatriz() {
		//Nivel 1
		int nivel = 1;
		Sesion.getSesion().jugarNivel(nivel);
		MatrizCasillas.getMatrizCasillas().crearMatriz();
		MatrizCasillas.getMatrizCasillas().llenarMatriz();
		System.out.println("Nivel 1");
		System.out.println(MatrizCasillas.getMatrizCasillas().getFilas() + " filas, " + MatrizCasillas.getMatrizCasillas().getColumnas() + " columnas");
		System.out.println("");
		int cont = 0;
		for(int i = 0; i<MatrizCasillas.getMatrizCasillas().getFilas(); i++){
			for(int j = 0; j<MatrizCasillas.getMatrizCasillas().getColumnas(); j++){
				if(MatrizCasillas.getMatrizCasillas().esMina(i, j)){
					cont++;
				}
			}
		}
		System.out.println("Hay " + cont + " minas");
		System.out.println("");
		assertEquals(cont, nivel*MatrizCasillas.getMatrizCasillas().getColumnas());
		//Nivel 2
		nivel = 2;
		Sesion.getSesion().jugarNivel(nivel);
		MatrizCasillas.getMatrizCasillas().crearMatriz();
		MatrizCasillas.getMatrizCasillas().llenarMatriz();
		System.out.println("Nivel 2");
		System.out.println(MatrizCasillas.getMatrizCasillas().getFilas() + " filas, " + MatrizCasillas.getMatrizCasillas().getColumnas() + " columnas");
		System.out.println("");
		cont = 0;
		for(int i = 0; i<MatrizCasillas.getMatrizCasillas().getFilas(); i++){
			for(int j = 0; j<MatrizCasillas.getMatrizCasillas().getColumnas(); j++){
				if(MatrizCasillas.getMatrizCasillas().esMina(i, j)){
					cont++;
				}
			}
		}
		System.out.println("Hay " + cont + " minas");
		System.out.println("");
		assertEquals(cont, nivel*MatrizCasillas.getMatrizCasillas().getColumnas());
		//Nivel 3
		nivel = 3;
		Sesion.getSesion().jugarNivel(nivel);
		MatrizCasillas.getMatrizCasillas().crearMatriz();
		MatrizCasillas.getMatrizCasillas().llenarMatriz();
		System.out.println("Nivel 3");
		System.out.println(MatrizCasillas.getMatrizCasillas().getFilas() + " filas, " + MatrizCasillas.getMatrizCasillas().getColumnas() + " columnas");
		cont = 0;
		for(int i = 0; i<MatrizCasillas.getMatrizCasillas().getFilas(); i++){
			for(int j = 0; j<MatrizCasillas.getMatrizCasillas().getColumnas(); j++){
				if(MatrizCasillas.getMatrizCasillas().esMina(i, j)){
					cont++;
				}
			}
		}
		System.out.println("Hay " + cont + " minas");
		System.out.println("");
		assertEquals(cont, nivel*MatrizCasillas.getMatrizCasillas().getColumnas());
	}
}
