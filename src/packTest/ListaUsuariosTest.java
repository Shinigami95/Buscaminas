package packTest;


import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import packModelo.ListaUsuarios;
import packModelo.Usuario;

public class ListaUsuariosTest {
	
	Usuario u1;
	Usuario u2;
	Usuario u3;
	Usuario u4;
	Usuario u5;
	Usuario u6;
	Usuario u7;
	Usuario u8;
	Usuario u9;
	Usuario u10;
	Usuario u11;
	ListaUsuarios l1;

	@Before
	public void setUp() throws Exception {
		u1 = new Usuario("Ruben", 7500);
		u2 = new Usuario("Rubenz", 500);
		u3 = new Usuario("Rubz", 6500);
		u4 = new Usuario("Nub", 1000);
		u5 = new Usuario("Neb", 2000);
		u6 = new Usuario("Nebu", 3000);
		u7 = new Usuario("Nebur", 4500);
		u8 = new Usuario("Rubn", 5000);
		u9 = new Usuario("Rub", 5500);
		u10 = new Usuario("Rufo", 0);
		u11 = new Usuario("Rube", 1750);
		l1 = new ListaUsuarios();
	}

	@After
	public void tearDown() throws Exception {
		u1 = null;
		u2 = null;
		u3 = null;
		u4 = null;
		u5 = null;
		u6 = null;
		u7 = null;
		u8 = null;
		u9 = null;
		u10 = null;
		u11 = null;
		l1 = null;
	}

	@Test
	public void testAddUsuario() {
		l1.addUsuario(u1);
		l1.addUsuario(u2);
		l1.addUsuario(u3);
		Iterator<Usuario> itr = l1.getUsuarios();
		Usuario u = null;
		while(itr.hasNext()){
			u = itr.next();
			System.out.println(u.getNombre() + ": " + u.getPuntos().getPuntuacion());
		}
	}

	@Test
	public void testMejores() {
		l1.addUsuario(u6);
		l1.addUsuario(u9);
		l1.addUsuario(u8);
		l1.addUsuario(u7);
		l1.addUsuario(u4);
		l1.addUsuario(u3);
		l1.addUsuario(u2);
		l1.addUsuario(u1);
		l1.addUsuario(u5);
		l1.addUsuario(u10);
		l1.addUsuario(u11);
		System.out.println(l1.mejores());
	}

}
