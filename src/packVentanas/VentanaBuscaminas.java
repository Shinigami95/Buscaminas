package packVentanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packModelo.Buscaminas;
import packModelo.Casilla;
import packModelo.CasillaBlanca;
import packModelo.CatalogoUsuarios;
import packModelo.Reloj;
import packModelo.Sesion;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;

import java.awt.GridLayout;
import java.awt.Point;

public class VentanaBuscaminas extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelRestart;
	private JLabel label;
	private JLabel label_1;
	private JButton button;
	private JLabel lblTiempo;
	private JLabel lblTiempo_1;
	private JPanel panelMatriz;
	private Controlador controlador;
	private JButton[][] botonMatriz;
	private static VentanaBuscaminas ventana;
	
	public static VentanaBuscaminas getVentana(){
		if(ventana==null){
			ventana=new VentanaBuscaminas();
			ventana.cargarBuscaminas();
		}
		return ventana;
	}
	
	private void cargarBuscaminas(){
		Reloj.getGestor().addObserver(this);
		Reloj.getGestor().setTiempo(0);
		Reloj.getGestor().reanudar();
	}

	private VentanaBuscaminas() {
		initialize();
	}
	private void initialize() {
		if(Sesion.getSesion().getNivel()==1){
			setBounds(100, 100, 450, 300);
		}else if(Sesion.getSesion().getNivel()==2){
			setBounds(100, 100, 650, 450);
		}else{
			setExtendedState(MAXIMIZED_BOTH);
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelRestart(), BorderLayout.NORTH);
		contentPane.add(getPanelMatriz(), BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(getControlador());
	}
	private JPanel getPanelRestart() {
		if (panelRestart == null) {
			panelRestart = new JPanel();
			panelRestart.setPreferredSize(new Dimension(100, 65));
			GroupLayout gl_panelRestart = new GroupLayout(panelRestart);
			gl_panelRestart.setHorizontalGroup(
				gl_panelRestart.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panelRestart.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(getLabel())
						.addGap(6)
						.addComponent(getLabel_1())
						.addGap(10)
						.addComponent(getButton(), GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(getLblTiempo(), GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(getLblTiempo_1(), GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
						.addGap(76))
			);
			gl_panelRestart.setVerticalGroup(
				gl_panelRestart.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panelRestart.createSequentialGroup()
						.addContainerGap(22, Short.MAX_VALUE)
						.addGroup(gl_panelRestart.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelRestart.createSequentialGroup()
								.addGap(4)
								.addComponent(getLabel()))
							.addGroup(gl_panelRestart.createSequentialGroup()
								.addGap(4)
								.addComponent(getLabel_1()))
							.addComponent(getButton())
							.addGroup(gl_panelRestart.createSequentialGroup()
								.addGap(4)
								.addGroup(gl_panelRestart.createParallelGroup(Alignment.BASELINE)
									.addComponent(getLblTiempo())
									.addComponent(getLblTiempo_1()))))
						.addGap(20))
			);
			panelRestart.setBackground(Color.WHITE);
			panelRestart.setLayout(gl_panelRestart);
		}
		return panelRestart;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Bombas:");
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel(""+Buscaminas.getBuscaminas().getMinas());
		}
		return label_1;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Restart");
			button.addActionListener(getControlador());
			button.setActionCommand("PressRestart");
		}
		return button;
	}
	private JLabel getLblTiempo() {
		if (lblTiempo == null) {
			lblTiempo = new JLabel("Tiempo: ");
		}
		return lblTiempo;
	}
	private JLabel getLblTiempo_1() {
		if (lblTiempo_1 == null) {
			lblTiempo_1 = new JLabel("Tiempo");
		}
		return lblTiempo_1;
	}
	private JPanel getPanelMatriz() {
		if (panelMatriz == null) {
			panelMatriz = new JPanel();
			if(Sesion.getSesion().getNivel()==1){panelMatriz.setLayout(new GridLayout(7, 10, 0, 0));}
			else if(Sesion.getSesion().getNivel()==2){panelMatriz.setLayout(new GridLayout(10, 15, 0, 0));}
			else{panelMatriz.setLayout(new GridLayout(12, 25, 0, 0));}
			panelMatriz.setBackground(Color.WHITE);
			getBotonesMatriz();
			for(int i=0;i<Buscaminas.getBuscaminas().getFilas();i++){
				for(int j=0;j<Buscaminas.getBuscaminas().getColumnas();j++){
					panelMatriz.add(getCasilla(i, j));
				}
			}
			
		}
		return panelMatriz;
	}
	private JButton[][] getBotonesMatriz() {
		if (botonMatriz == null) {
			botonMatriz = new JButton[Buscaminas.getBuscaminas().getFilas()][Buscaminas.getBuscaminas().getColumnas()];
			for(int i=0;i<Buscaminas.getBuscaminas().getFilas();i++){
				for(int j=0;j<Buscaminas.getBuscaminas().getColumnas();j++){
					getCasilla(i, j);
				}
			}
		}
		return botonMatriz;
	}
	private JButton getCasilla(int fil,int col){
		if(getBotonesMatriz()[fil][col]==null){
			final int fila=fil;
			final int colu=col;
			getBotonesMatriz()[fil][col]=new JButton();
			getBotonesMatriz()[fil][col].addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
				}
				
				@Override
				public void mousePressed(MouseEvent e) {			
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {			
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					controlMouse(e,fila,colu);
					
				}
			});
			
		}
		return getBotonesMatriz()[fil][col];
	}
	
	private Controlador getControlador(){
		if (controlador==null){
			controlador=new Controlador();
		}
		return controlador;
	}
	
	private class Controlador extends WindowAdapter implements ActionListener{
		
		@Override
		public void windowClosing(WindowEvent e) {
			salir();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("PressRestart")){
				reinicio();
			}
		}
		
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Reloj){
			//tiempo
			String tiempo = Reloj.getGestor().tiempoAString();
			getLblTiempo_1().setText("     "+tiempo);
		}	
		if (o instanceof Casilla){
			Point p=(Point) arg;
			cambiarMarca((int) p.getX(), (int) p.getY());
			;
		}
	}
	
	private void bloquearBotones(){
		for(int i=0;i<Buscaminas.getBuscaminas().getFilas();i++){
			for(int j=0;j<Buscaminas.getBuscaminas().getColumnas();j++){
				getCasilla(i, j).setEnabled(false);;
			}
		}
	}
	
	private void mostrarMina(){
		for(int i=0;i<Buscaminas.getBuscaminas().getFilas();i++){
			for(int j=0;j<Buscaminas.getBuscaminas().getColumnas();j++){
				if(Buscaminas.getBuscaminas().esMina(i, j)){
					getCasilla(i, j).setFont(new Font("Tahoma", Font.BOLD, 11));
					getCasilla(i, j).setBackground(Color.WHITE);
					getCasilla(i, j).setText("X");
				}
			}
		}
	}
	
	private boolean terminado(){
		boolean terminado=false;
		int cont=0;
		for(int i=0;i<Buscaminas.getBuscaminas().getFilas();i++){
			for(int j=0;j<Buscaminas.getBuscaminas().getColumnas();j++){
				if(!Buscaminas.getBuscaminas().casillaVista(i, j)){
					cont++;
				}
			}
		}
		if(cont==Buscaminas.getBuscaminas().getColumnas()*Sesion.getSesion().getNivel()){
			terminado=true;
		}
		return terminado;
	}
	
	private void mostrarBoton(int pFil,int pCol){
		Buscaminas.getBuscaminas().cambiarVistaCasilla(pFil, pCol);
		getCasilla(pFil, pCol).setText(""+Buscaminas.getBuscaminas().numCasilla(pFil, pCol));
		getCasilla(pFil, pCol).setEnabled(false);
		getCasilla(pFil, pCol).setBackground(Color.WHITE);
		getCasilla(pFil, pCol).setForeground(Color.BLACK);
	}
	
	private void reinicio(){

		Buscaminas.getBuscaminas().reinicio();
		Buscaminas.getBuscaminas().crearMatriz();
		VentanaBuscaminas.getVentana().setVisible(false);
		VentanaBuscaminas.getVentana().ventana=null;
		VentanaBuscaminas.getVentana().setVisible(true);}
	
	private void finalizar(){
		Sesion.getSesion().calcularPuntuacion();
		int seleccion1=JOptionPane.showOptionDialog(null, "¿Quiere volver a jugar?", "Buscaminas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, Icono.getIcono().getMina(), new Object[]{"SI","NO","CANCELAR"}, "SI");
		if(seleccion1==0){
			int seleccion2=JOptionPane.showOptionDialog(null, "Escoge un nivel:", "Buscaminas", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, Icono.getIcono().getMina(), new Object[]{"1","2","3"}, "1");
			Sesion.getSesion().jugarNivel(seleccion2+1);
			Buscaminas.getBuscaminas().reinicio();
			Buscaminas.getBuscaminas().crearMatriz();
			VentanaBuscaminas.getVentana().setVisible(false);
			VentanaBuscaminas.getVentana().ventana=null;
			VentanaBuscaminas.getVentana().setVisible(true);
		}else if(seleccion1==1){
			salir();
		}
	}
	
	private void salir(){
		CatalogoUsuarios.getCatalogo().addUsuario(Sesion.getSesion().getJugador());
		CatalogoUsuarios.getCatalogo().guardarFichero();
		Sesion.getSesion().reinicio();
		VentanaPrincipal.getVentana().setVisible(true);
		VentanaBuscaminas.getVentana().setVisible(false);
		VentanaBuscaminas.getVentana().ventana=null;
	}
	
	private void mostrarBlancas(int fil, int col){
		ArrayList<Casilla> devol=Buscaminas.getBuscaminas().mostrarBlancas(fil, col);
		Iterator<Casilla> itr=devol.iterator();
		Casilla cas;
		while(itr.hasNext()){
			cas=itr.next();
			if(cas instanceof CasillaBlanca){
				mostrarBlanca(cas.getFila(), cas.getColumna());}
			else{
				mostrarBoton(cas.getFila(), cas.getColumna());
			}
		}
	}
	
	private void mostrarBlanca(int fila,int colu){
		getCasilla(fila, colu).setEnabled(false);
		getCasilla(fila, colu).setBackground(Color.WHITE);
		getCasilla(fila, colu).setText("");
	}
	
	private void cambiarMarca(int pFil,int pCol){
		if(getCasilla(pFil, pCol).getText().equals("")){
			getCasilla(pFil, pCol).setFont(new Font("Tahoma", Font.BOLD, 11));
			getCasilla(pFil, pCol).setText("B");
			getLabel_1().setText(""+Buscaminas.getBuscaminas().menosMinas());
		}else if(getCasilla(pFil, pCol).getText().equals("B")){
			getCasilla(pFil, pCol).setText("");
			getLabel_1().setText(""+Buscaminas.getBuscaminas().masMinas());
		}
	}
	
	private void estaMarcada(int pFil,int pCol){
		if(getCasilla(pFil, pCol).getText().equals("B")){
			getLabel_1().setText(""+Buscaminas.getBuscaminas().masMinas());
		}
	}
	
	
	private void controlMouse(MouseEvent e,int pFil,int pCol){
		if(!Buscaminas.getBuscaminas().getGameOver()){
			if(SwingUtilities.isLeftMouseButton(e)){
					esClicDerecho(pFil, pCol);
				}
				else if(SwingUtilities.isRightMouseButton(e)){
					esClicIzquierdo(pFil, pCol);
				}}}
	
	private void esClicDerecho(int pFil, int pCol){
		if(Buscaminas.getBuscaminas().esMina(pFil, pCol)){
			Reloj.getGestor().pausar();
			mostrarMina();
			bloquearBotones();
			JOptionPane.showMessageDialog(null, "GAME OVER");
		}
		else if(Buscaminas.getBuscaminas().esNumero(pFil, pCol)){
			estaMarcada(pFil, pCol);
			mostrarBoton(pFil,pCol);
			Buscaminas.getBuscaminas().cambiarVistaCasilla(pFil, pCol);;
		}
		else if(Buscaminas.getBuscaminas().esBlanca(pFil, pCol)){
			estaMarcada(pFil, pCol);
			mostrarBlancas(pFil,pCol);
		}
		if(terminado()){
			Reloj.getGestor().pausar();
			finalizar();
		}}
	
	private void esClicIzquierdo(int pFil, int pCol){
		if(!Buscaminas.getBuscaminas().casillaVista(pFil, pCol))
			cambiarMarca(pFil,pCol);
	}
	}
	
	

	
