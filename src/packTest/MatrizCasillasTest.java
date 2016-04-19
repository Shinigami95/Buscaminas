package packTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.Sesion;
import packModelo.Tablero;

public class MatrizCasillasTest {
	
	Tablero m;

	@Before
	public void setUp() throws Exception {
		m = new Tablero();
	}

	@After
	public void tearDown() throws Exception {
		m = null;
	}

	@Test
	public void testCrearMatriz() {
		//Nivel 1
		int nivel = 1;
		Sesion.getSesion().jugarNivel(nivel);
		m.crearMatrizTablero();
		System.out.println("Nivel 1");
		System.out.println(m.getFilas() + " filas, " + m.getColumnas() + " columnas");
		System.out.println("");
		int contM = 0;
		int contB = 0;
		int contN = 0;
		for(int i = 0; i<m.getFilas(); i++){
			for(int j = 0; j<m.getColumnas(); j++){
				if(m.mostrar(i, j).equals("mina")){
					contM++;
				}else if(m.mostrar(i, j).equals("blanca")){
					contB++;
				}else if(m.mostrar(i, j).equals("num")){
					contN++;
				}
			}
		}
		System.out.println("Hay " + contM + " minas");
		System.out.println("");
		int casillas = contM+contB+contN;
		assertEquals(contM, nivel*m.getColumnas());
		assertEquals(casillas, m.getColumnas()*m.getFilas());
		System.out.println("Hay " + casillas + " casillas");
		System.out.println("");
		//Nivel 2
		nivel = 2;
		Sesion.getSesion().jugarNivel(nivel);
		m.crearMatrizTablero();
		System.out.println("Nivel 2");
		System.out.println(m.getFilas() + " filas, " + m.getColumnas() + " columnas");
		System.out.println("");
		contM = 0;
		contB = 0;
		contN = 0;
		for(int i = 0; i<m.getFilas(); i++){
			for(int j = 0; j<m.getColumnas(); j++){
				if(m.mostrar(i, j).equals("mina")){
					contM++;
				}else if(m.mostrar(i, j).equals("blanca")){
					contB++;
				}else if(m.mostrar(i, j).equals("num")){
					contN++;
				}
			}
		}
		System.out.println("Hay " + contM + " minas");
		System.out.println("");
		casillas = contM+contB+contN;
		assertEquals(contM, nivel*m.getColumnas());
		assertEquals(casillas, m.getColumnas()*m.getFilas());
		System.out.println("Hay " + casillas + " casillas");
		System.out.println("");
		//Nivel 3
		nivel = 3;
		Sesion.getSesion().jugarNivel(nivel);
		m.crearMatrizTablero();
		System.out.println("Nivel 3");
		System.out.println(m.getFilas() + " filas, " + m.getColumnas() + " columnas");
		System.out.println("");
		contM = 0;
		contB = 0;
		contN = 0;
		for(int i = 0; i<m.getFilas(); i++){
			for(int j = 0; j<m.getColumnas(); j++){
				if(m.mostrar(i, j).equals("mina")){
					contM++;
				}else if(m.mostrar(i, j).equals("blanca")){
					contB++;
				}else if(m.mostrar(i, j).equals("num")){
					contN++;
				}
			}
		}
		System.out.println("Hay " + contM + " minas");
		System.out.println("");
		casillas = contM+contB+contN;
		assertEquals(contM, nivel*m.getColumnas());
		assertEquals(casillas, m.getColumnas()*m.getFilas());
		System.out.println("Hay " + casillas + " casillas");
	}
}
