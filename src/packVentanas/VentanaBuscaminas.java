package packVentanas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VentanaBuscaminas extends JFrame {

	private JPanel contentPane;
	private JPanel panelRestart;
	private JLabel label;
	private JLabel label_1;
	private JButton button;
	private JLabel lblTiempo;
	private JLabel lblTiempo_1;
	private JPanel panelMatriz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaBuscaminas frame = new VentanaBuscaminas();
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
	public VentanaBuscaminas() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		}
		return panelMatriz;
	}
}
