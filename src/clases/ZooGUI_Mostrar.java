package clases;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ZooGUI_Mostrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
//	private ZooDatabase zooDatabase; // CREAR UNA INSTANCIA ÚNICA DE ZOODATABASE
	ZooDatabase zooDatabase;

	/**
	 * Create the frame.
	 */
	public ZooGUI_Mostrar() {
		setTitle("MOSTRAR ANIMALES POR TIPO");
		// OBTENER LA INSTANCIA ÚNICA DE ZOODATABASE
		zooDatabase = ZooDatabase.getInstance();

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
		panel.setLayout(new GridLayout(1, 6, 10, 10));

		// BOTON MAMIFERO
		JButton btn_mamiferos = new JButton("Mamíferos");
		btn_mamiferos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// OBTENER LISTA DE ZooDataBase
				List<Animal> mamiferos = zooDatabase.obtenerAnimalesPorClaseAnimal("Mamíferos");

				// VERIFICAR SI LA LISTA MAMIFEROS ESTA VACIA
				if (mamiferos.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay mamíferos registrados.");
				} else {
					// CREAR UN STRINGBUILDER PARA CONSTRUIR EL MENSAJE CON LOS DETALLES DE LOS
					// MAMIFEROS
					StringBuilder message = new StringBuilder();

					// RECORRER CADA MAMIFERO EN LA LISTA DE MAMÍFEROS
					for (Animal mamifero : mamiferos) {
						message.append(mamifero.toString()).append("\n");
					}

					// MOSTRAR DETALLES DE LOS MAMIFEROS REGISTRADOS
					JOptionPane.showMessageDialog(null, message.toString(), "Mamíferos Registrados",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btn_mamiferos.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btn_mamiferos.setBounds(0, 0, 150, 50);
		panel.add(btn_mamiferos);

		// BOTON AVE
		JButton btn_Aves = new JButton("Aves");
		btn_Aves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// OBTENER LISTA DE AVES DE ZOODATABASE
				List<Animal> aves = zooDatabase.obtenerAnimalesPorClaseAnimal("Aves");

				// VERIFICAR SI ESTA VACIA
				if (aves.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay Aves registradas.");
				} else {
					StringBuilder message = new StringBuilder();

					// RECORRER LISTA
					for (Animal ave : aves) {
						// AÑADIR LOS DETALLES DEL AVE AL MENSAJE SIN MODIFICAR LA ESPECIE
						message.append(ave.toString()).append("\n");
					}

					// MOSTRAR DETALLES DE LAS AVES REGISTRADAS
					JOptionPane.showMessageDialog(null, message.toString(), "Aves Registradas",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btn_Aves.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btn_Aves.setBounds(0, 0, 150, 50);
		panel.add(btn_Aves);

		// BOTON REPTIL
		JButton btn_Reptil = new JButton("Reptiles");
		btn_Reptil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Animal> reptiles = zooDatabase.obtenerAnimalesPorClaseAnimal("Reptiles");

				// VERIFICAR SI LA LISTA REPTILES ESTA VACIA
				if (reptiles.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay Reptiles registrados.");
				} else {
					StringBuilder message = new StringBuilder();

					// RECORRER CADA REPTIL EN LA LISTA DE REPTILES
					for (Animal reptil : reptiles) {
						// AÑADIR LOS DETALLES DEL REPTIL AL MENSAJE SIN MODIFICAR LA ESPECIE
						message.append(reptil.toString()).append("\n");
					}

					// MOSTRAR LOS DETALLES DE LOS REPTILES REGISTRADOS
					JOptionPane.showMessageDialog(null, message.toString(), "Reptiles Registrados",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btn_Reptil.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btn_Reptil.setBounds(0, 0, 150, 50);
		panel.add(btn_Reptil);

		// BOTON ANFIBIO
		JButton btn_Anfibios = new JButton("Anfibios");
		btn_Anfibios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// OBTENER LA LISTA DE ANFIBIOS DESDE LA BASE DE DATOS DEL ZOOLÓGICO
				List<Animal> anfibios = zooDatabase.obtenerAnimalesPorClaseAnimal("Anfibios");

				// VERIFICAR SI LA LISTA DE ANFIBIOS ESTA VACIA
				if (anfibios.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay Anfibios registrados.");
				} else {
					StringBuilder message = new StringBuilder();

					// RECORRER CADA ANFIBIO EN LA LISTA DE ANFIBIOS
					for (Animal anfi : anfibios) {
						// AÑADIR LOS DETALLES DEL ANFIBIO AL MENSAJE SIN MODIFICAR LA ESPECIE
						message.append(anfi.toString()).append("\n");
					}

					// MOSTRAR LOS DETALLES DE LOS ANFIBIOS REGISTRADOS
					JOptionPane.showMessageDialog(null, message.toString(), "Anfibios Registrados",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btn_Anfibios.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btn_Anfibios.setBounds(0, 0, 150, 50);
		panel.add(btn_Anfibios);

		// BOTON PECES
		JButton btn_Peces = new JButton("Peces");
		btn_Peces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// OBTENER LA LISTA DE PECES DESDE LA BASE DE DATOS DEL ZOOLÓGICO
				List<Animal> peces = zooDatabase.obtenerAnimalesPorClaseAnimal("Peces");

				// VERIFICAR SI LA LISTA DE PECES ESTÁ VACÍA
				if (peces.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay Peces registrados.");
				} else {
					StringBuilder message = new StringBuilder();

					// RECORRER CADA PEZ EN LA LISTA DE PECES
					for (Animal pez : peces) {
						// AÑADIR LOS DETALLES DEL PEZ AL MENSAJE SIN MODIFICAR LA ESPECIE
						message.append(pez.toString()).append("\n");
					}

					// MOSTRAR LOS DETALLES DE LOS PECES REGISTRADOS
					JOptionPane.showMessageDialog(null, message.toString(), "Peces Registrados",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btn_Peces.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btn_Peces.setBounds(0, 0, 150, 50);
		panel.add(btn_Peces);

		// BOTON VOLVER
		JButton btn_volver = new JButton("Volver atrás");
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // CERRAR LA VENTANA
			}
		});
		btn_volver.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btn_volver.setBounds(0, 0, 150, 50);
		btn_volver.setBackground(Color.blue);
		btn_volver.setForeground(Color.white);
		;
		panel.add(btn_volver);
	}

	// -----------------------------------------------------------------------

	// METODO MOSTRAR ANIMALES POR TIPO
	public void mostrarAnimalesPorTipo(List<Animal> animales) {
		JFrame ventanaAnimalesPorTipo = new JFrame("Animales por tipo");
		ventanaAnimalesPorTipo.setSize(400, 300);
		ventanaAnimalesPorTipo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel(new GridLayout(animales.size(), 1));

		for (Animal animal : animales) {
			JLabel label = new JLabel(animal.toString());
			panel.add(label);
		}

		JScrollPane scrollPane = new JScrollPane(panel);
		ventanaAnimalesPorTipo.getContentPane().add(scrollPane);

		ventanaAnimalesPorTipo.setVisible(true);
	}
}
