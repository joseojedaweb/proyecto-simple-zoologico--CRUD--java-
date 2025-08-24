package clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ZooGUI_Act_eliminar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public ZooGUI_Act_eliminar() {
		setTitle("ACTUALIZAR O ELIMINAR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 571);
		setResizable(false); // BLOQUEAR LA MAXIMIZACIÓN DE LA VENTANA
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 857, 534);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 3, 10, 10)); // DISTRIBUCION BOTONES

		// BOTON ACTUALIZAR
		JButton btn_Actualizar = new JButton("Actualizar");
		btn_Actualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// INSTANCIAR LA CLASE ZOOGUI_ACTUALIZACION Y PASARLE EL ID COMO ARGUMENTO
				ZooGUI_Actualizar ventanaActualizacion = new ZooGUI_Actualizar();
				ventanaActualizacion.setVisible(true);
				dispose(); // CERRAR LA VENTANA ACTUAL
			}
		});
		btn_Actualizar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btn_Actualizar.setBounds(0, 0, 150, 50);
		panel.add(btn_Actualizar);

		// BOTON ELIMINAR
		JButton btn_Borrar = new JButton("Eliminar");
		btn_Borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Introduce el ID del animal a eliminar:");
				if (id != null && !id.isEmpty()) { // VERIFICA QUE EL ID NO SEA NULO O ESTE VACIO
					if (ZooDatabase.getInstance().eliminarAnimal(id)) {
						JOptionPane.showMessageDialog(null, "Error al eliminar el animal");
					} else {
						 JOptionPane.showMessageDialog(null, "Animal eliminado correctamente");
					}
				} else {
					JOptionPane.showMessageDialog(null, "ID no válido");
				}
			}
		});
		btn_Borrar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btn_Borrar.setBounds(0, 0, 150, 50);
		panel.add(btn_Borrar);

		// BOTON VOLVER ATRAS
		JButton btn_volver = new JButton("Volver atrás");
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // CERRAR LA VENTANA
			}
		});
		btn_volver.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btn_volver.setBackground(Color.blue);
		btn_volver.setForeground(Color.white);
		btn_volver.setBounds(0, 0, 150, 50);
		panel.add(btn_volver);
	}
}
