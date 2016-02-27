package packVentanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import packModelo.Buscaminas;
import packModelo.CasillaBlanca;
import packModelo.CasillaMina;
import packModelo.CasillaNumero;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;

public class VentanaBuscaminas extends JFrame {

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
	private int f=Buscaminas.getBuscaminas().getMatriz().getFilas();
	private int c=Buscaminas.getBuscaminas().getMatriz().getColumnas();
	private int niv=Buscaminas.getBuscaminas().getNivel();
	private static VentanaBuscaminas ventana;
	
	public static VentanaBuscaminas getVentana(){
		if(ventana==null){
			ventana=new VentanaBuscaminas();
		}
		return ventana;
	}

	private VentanaBuscaminas() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(niv==1){
			setBounds(100, 100, 450, 300);
		}else if(niv==2){
			setBounds(100, 100, 650, 450);
		}else{
			setBounds(100, 100, 450, 300);
		}
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelRestart(), BorderLayout.NORTH);
		contentPane.add(getPanelMatriz(), BorderLayout.CENTER);
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
			label_1 = new JLabel("Bombas Puestas: ");
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
			if(niv==1){panelMatriz.setLayout(new GridLayout(7, 10, 0, 0));}
			else if(niv==2){panelMatriz.setLayout(new GridLayout(10, 15, 0, 0));}
			else{panelMatriz.setLayout(new GridLayout(12, 25, 0, 0));}
			panelMatriz.setBackground(Color.WHITE);
			getBotonesMatriz();
			for(int i=0;i<f;i++){
				for(int j=0;j<c;j++){
					panelMatriz.add(getCasilla(i, j));
				}
			}
			
		}
		return panelMatriz;
	}
	private JButton[][] getBotonesMatriz() {
		if (botonMatriz == null) {
			botonMatriz = new JButton[f][c];
			for(int i=0;i<f;i++){
				for(int j=0;j<c;j++){
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
			getBotonesMatriz()[fil][col].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(Buscaminas.getBuscaminas().getMatriz().getCasilla(fila, colu) instanceof CasillaMina){
						mostrarMina();
						bloquearBotones();
						Buscaminas.getBuscaminas().gameOver();
					}
					else if(Buscaminas.getBuscaminas().getMatriz().getCasilla(fila, colu) instanceof CasillaNumero){
						mostrarBoton(fila,colu);
					}
					else if(Buscaminas.getBuscaminas().getMatriz().getCasilla(fila, colu) instanceof CasillaBlanca){
						//TODO
					}
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
			System.exit(0);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("PressRestart")){
				
			}
		}
	}
	
	private void bloquearBotones(){
		for(int i=0;i<f;i++){
			for(int j=0;j<c;j++){
				getCasilla(i, j).setEnabled(false);;
			}
		}
	}
	
	private void mostrarMina(){
		for(int i=0;i<f;i++){
			for(int j=0;j<c;j++){
				if(Buscaminas.getBuscaminas().getMatriz().getCasilla(i, j) instanceof CasillaMina){
					getCasilla(i, j).setFont(new Font("Tahoma", Font.BOLD, 11));
					getCasilla(i, j).setBackground(Color.WHITE);
					getCasilla(i, j).setText("X");
				}
			}
		}
		
		
	}
	
	private void mostrarBoton(int fila,int colu){
		CasillaNumero cas=(CasillaNumero) Buscaminas.getBuscaminas().getMatriz().getCasilla(fila, colu);
		getCasilla(fila, colu).setText(""+cas.getNumero());
		getCasilla(fila, colu).setEnabled(false);
		getCasilla(fila, colu).setBackground(Color.WHITE);
		getCasilla(fila, colu).setForeground(Color.BLACK);
	}
	
}
