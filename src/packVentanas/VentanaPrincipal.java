package packVentanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JLabel label;
	private JTextField textField;
	private JLabel label_1;
	private JLabel label_2;
	private JButton btnRanking;
	private JButton buttonJugar;
	private Controlador controlador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(112)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(getLabel_1(), GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(getLabel())
									.addGap(29)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(getComboBox(), GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
											.addGap(10)
											.addComponent(getButtonJugar(), GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
											.addComponent(getBtnRanking(), GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(139)
							.addComponent(getLabel_2(), GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addComponent(getLabel_2())
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(getLabel_1(), GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(3)
							.addComponent(getLabel()))
						.addComponent(getComboBox(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(getBtnRanking())
						.addComponent(getButtonJugar()))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			Vector<Integer> vec = new Vector<Integer>();
			for(int i=1;i<4;i++){
			vec.addElement(i);}
			comboBox = new JComboBox<Integer>(vec);
		}
		return comboBox;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Nivel: ");
		}
		return label;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Usuario: ");
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Buscaminas");
			label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		}
		return label_2;
	}
	private JButton getBtnRanking() {
		if (btnRanking == null) {
			btnRanking = new JButton("Ranking");
			btnRanking.addActionListener(getControlador());
			btnRanking.setActionCommand("PressRanking");
		}
		return btnRanking;
	}
	
	private JButton getButtonJugar() {
		if (buttonJugar == null) {
			buttonJugar = new JButton("Jugar");
			buttonJugar.addActionListener(getControlador());
			buttonJugar.setActionCommand("PressJugar");
		}
		return buttonJugar;
	}
	
	private Controlador getControlador(){
		if (controlador==null){
			controlador=new Controlador();
		}
		return controlador;
	}
	
	private class Controlador extends WindowAdapter implements ActionListener{
	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("PressJugar")){
				
			}
			else if (e.getActionCommand().equals("PressRanking")){
				
			}
		}
		
	}
	
	
}
