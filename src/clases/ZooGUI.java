package clases;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ZooGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZooGUI frame = new ZooGUI();
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
	public ZooGUI() {
		setTitle("ZOOLÓGICO");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 571); // TAMAÑO VENTANA
		setResizable(false); // BLOQUEAR LA MAXIMIZACIÓN DE LA VENTANA
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 797, 497);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Zoologico");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 76));
		lblNewLabel.setBounds(229, 10, 352, 81);
		panel.add(lblNewLabel);

		// MENU PRINCIPAL --- OPCION 2 MOSTRAR ANIMALES
		JButton btn_mostrarAnimales = new JButton("Mostrar Animales");
		btn_mostrarAnimales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ---- INSTANCIAR CLASE ZooGUI_Mostrar PARA MOSTRAR REGISTRO DE UN ANIMAL -----
				ZooGUI_Mostrar ventanaMostrar = new ZooGUI_Mostrar();
				ventanaMostrar.setVisible(true); // MOSTRAR LA VENTANA DE REGISTRO

			}
		});
		btn_mostrarAnimales.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btn_mostrarAnimales.setBounds(300, 222, 182, 81);
		panel.add(btn_mostrarAnimales);

		// MENU PRINCIPAL --- OPCION 3 ACTUALIZAR Y ELIMINAR
		JButton btn_act_eli_animales = new JButton("Actualizar / Eliminar Animales");
		btn_act_eli_animales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ---- INSTANCIAR CLASE ZooGUI_Act_eliminar PARA ACTUALIZAR O ELIMINAR UN REGISTRO -----
				ZooGUI_Act_eliminar ventanaActualizar_eliminar = new ZooGUI_Act_eliminar();
				ventanaActualizar_eliminar.setVisible(true); // MOSTRAR VENTANA DE REGISTRO
			}
		});
		btn_act_eli_animales.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btn_act_eli_animales.setBounds(543, 222, 274, 81);
		panel.add(btn_act_eli_animales);

		// MENU PRINCIPAL --- OPCION 1
		JButton btn_registrarAnimales = new JButton("Registrar Animales");
		btn_registrarAnimales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ---- INSTANCIAR CLASE ZooGUI_Registro PARA EL REGISTRO DE UN ANIMAL -----
				ZooGUI_Registro ventanaRegistro = new ZooGUI_Registro();
				ventanaRegistro.setVisible(true); // MOSTRAR LA VENTANA DE REGISTRO
			}
		});
		btn_registrarAnimales.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btn_registrarAnimales.setBounds(37, 222, 198, 81);
		panel.add(btn_registrarAnimales);

		// MENU PRINCIPAL --- BOTON SALIR
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// CERRAR EL PROGRAMA
				System.exit(0);
			}
		});
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 34));
		btnNewButton_2.setBounds(215, 387, 352, 62);
		panel.add(btnNewButton_2);
	}
}
