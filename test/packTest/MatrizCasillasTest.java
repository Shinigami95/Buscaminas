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
		int contM = 0;
		int contB = 0;
		int contN = 0;
		for(int i = 0; i<MatrizCasillas.getMatrizCasillas().getFilas(); i++){
			for(int j = 0; j<MatrizCasillas.getMatrizCasillas().getColumnas(); j++){
				if(MatrizCasillas.getMatrizCasillas().esMina(i, j)){
					contM++;
				}else if(MatrizCasillas.getMatrizCasillas().esBlanca(i, j)){
					contB++;
				}else if(MatrizCasillas.getMatrizCasillas().esNumero(i, j)){
					contN++;
				}
			}
		}
		System.out.println("Hay " + contM + " minas");
		System.out.println("");
		int casillas = contM+contB+contN;
		assertEquals(contM, nivel*MatrizCasillas.getMatrizCasillas().getColumnas());
		assertEquals(casillas, MatrizCasillas.getMatrizCasillas().getColumnas()*MatrizCasillas.getMatrizCasillas().getFilas());
		System.out.println("Hay " + casillas + " casillas");
		System.out.println("");
		//Nivel 2
		nivel = 2;
		Sesion.getSesion().jugarNivel(nivel);
		MatrizCasillas.getMatrizCasillas().crearMatriz();
		MatrizCasillas.getMatrizCasillas().llenarMatriz();
		System.out.println("Nivel 2");
		System.out.println(MatrizCasillas.getMatrizCasillas().getFilas() + " filas, " + MatrizCasillas.getMatrizCasillas().getColumnas() + " columnas");
		System.out.println("");
		contM = 0;
		contB = 0;
		contN = 0;
		for(int i = 0; i<MatrizCasillas.getMatrizCasillas().getFilas(); i++){
			for(int j = 0; j<MatrizCasillas.getMatrizCasillas().getColumnas(); j++){
				if(MatrizCasillas.getMatrizCasillas().esMina(i, j)){
					contM++;
				}else if(MatrizCasillas.getMatrizCasillas().esBlanca(i, j)){
					contB++;
				}else if(MatrizCasillas.getMatrizCasillas().esNumero(i, j)){
					contN++;
				}
			}
		}
		System.out.println("Hay " + contM + " minas");
		System.out.println("");
		casillas = contM+contB+contN;
		assertEquals(contM, nivel*MatrizCasillas.getMatrizCasillas().getColumnas());
		assertEquals(casillas, MatrizCasillas.getMatrizCasillas().getColumnas()*MatrizCasillas.getMatrizCasillas().getFilas());
		System.out.println("Hay " + casillas + " casillas");
		System.out.println("");
		//Nivel 3
		nivel = 3;
		Sesion.getSesion().jugarNivel(nivel);
		MatrizCasillas.getMatrizCasillas().crearMatriz();
		MatrizCasillas.getMatrizCasillas().llenarMatriz();
		System.out.println("Nivel 3");
		System.out.println(MatrizCasillas.getMatrizCasillas().getFilas() + " filas, " + MatrizCasillas.getMatrizCasillas().getColumnas() + " columnas");
		System.out.println("");
		contM = 0;
		contB = 0;
		contN = 0;
		for(int i = 0; i<MatrizCasillas.getMatrizCasillas().getFilas(); i++){
			for(int j = 0; j<MatrizCasillas.getMatrizCasillas().getColumnas(); j++){
				if(MatrizCasillas.getMatrizCasillas().esMina(i, j)){
					contM++;
				}else if(MatrizCasillas.getMatrizCasillas().esBlanca(i, j)){
					contB++;
				}else if(MatrizCasillas.getMatrizCasillas().esNumero(i, j)){
					contN++;
				}
			}
		}
		System.out.println("Hay " + contM + " minas");
		System.out.println("");
		casillas = contM+contB+contN;
		assertEquals(contM, nivel*MatrizCasillas.getMatrizCasillas().getColumnas());
		assertEquals(casillas, MatrizCasillas.getMatrizCasillas().getColumnas()*MatrizCasillas.getMatrizCasillas().getFilas());
		System.out.println("Hay " + casillas + " casillas");
	}
}
