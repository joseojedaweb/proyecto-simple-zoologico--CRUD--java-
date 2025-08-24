package clases;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ZooGUI_Actualizar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_nombre;
	public JTextField textField_nacimiento;
	public JTextField textField_peso;
	public JTextField textField_talla;
	public JComboBox<String> comboBox_especie;
	public JComboBox<String> comboBox_sexo;
	public JRadioButton rdbtn_Si_vacuna;
	public JRadioButton rdbtn_No_vacuna;
	public JRadioButton rdbtn_Si_enfermedad;
	public JRadioButton rdbtn_No_enfermedad;
	public ButtonGroup grupoRadioButton_vacuna;
	public ButtonGroup grupoRadioButton_enfermedad;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ZooGUI_Actualizar() {
		setTitle("FORMULARIO ACTUALIZAR ANIMAL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 871, 571);
		setResizable(false); // BLOQUEAR LA MAXIMIZACIÓN DE LA VENTANA
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 255));
		panel.setOpaque(true);
		panel.setBounds(0, 0, 857, 534);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Actualizar Animal");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setBounds(229, 10, 330, 61);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 38));
		panel.add(lblNewLabel);

		JLabel lbl_nombre = new JLabel("Especie");
		lbl_nombre.setForeground(new Color(255, 255, 255));
		lbl_nombre.setBounds(24, 92, 79, 18);
		lbl_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panel.add(lbl_nombre);

		textField_nombre = new JTextField();
		textField_nombre.setBackground(new Color(255, 255, 0));
		textField_nombre.setBounds(175, 92, 96, 19);
		panel.add(textField_nombre);
		textField_nombre.setColumns(10);

		JLabel lbl_especie = new JLabel("Clase Animal");
		lbl_especie.setForeground(new Color(255, 255, 255));
		lbl_especie.setBounds(24, 142, 120, 20);
		lbl_especie.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_especie.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panel.add(lbl_especie);

		// DESPLEGABLE ESPECIE
		comboBox_especie = new JComboBox<String>();
		comboBox_especie.setBackground(new Color(255, 255, 0));
		comboBox_especie.setBounds(175, 141, 96, 21);
		comboBox_especie.addItem("");
		comboBox_especie.addItem("Mamíferos");
		comboBox_especie.addItem("Aves");
		comboBox_especie.addItem("Reptiles");
		comboBox_especie.addItem("Anfibios");
		comboBox_especie.addItem("Peces");
		panel.add(comboBox_especie);

		JLabel lbl_sexo = new JLabel("Sexo");
		lbl_sexo.setForeground(new Color(255, 255, 255));
		lbl_sexo.setBounds(24, 202, 79, 18);
		lbl_sexo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sexo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panel.add(lbl_sexo);

		// DESPLEGABLE SEXO
		comboBox_sexo = new JComboBox<String>();
		comboBox_sexo.setBackground(new Color(255, 255, 0));
		comboBox_sexo.setBounds(175, 201, 96, 21);
		comboBox_sexo.addItem("");
		comboBox_sexo.addItem("Macho");
		comboBox_sexo.addItem("Hembra");
		comboBox_sexo.addItem("Aun No Definido");
		panel.add(comboBox_sexo);

		JLabel lbl_nacimiento = new JLabel("Nacimiento");
		lbl_nacimiento.setForeground(new Color(255, 255, 255));
		lbl_nacimiento.setBounds(24, 269, 120, 18);
		lbl_nacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nacimiento.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panel.add(lbl_nacimiento);

		textField_nacimiento = new JTextField();
		textField_nacimiento.setBackground(new Color(255, 255, 0));
		textField_nacimiento.setBounds(175, 269, 96, 19);
		textField_nacimiento.setColumns(10);
		panel.add(textField_nacimiento);

		JLabel lbl_peso = new JLabel("Peso");
		lbl_peso.setForeground(new Color(255, 255, 255));
		lbl_peso.setBounds(373, 92, 120, 18);
		lbl_peso.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_peso.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panel.add(lbl_peso);

		textField_peso = new JTextField();
		textField_peso.setBackground(new Color(255, 255, 0));
		textField_peso.setBounds(527, 92, 96, 19);
		textField_peso.setColumns(10);
		panel.add(textField_peso);

		JLabel lbl_talla = new JLabel("Talla");
		lbl_talla.setForeground(new Color(255, 255, 255));
		lbl_talla.setBounds(373, 138, 120, 18);
		lbl_talla.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_talla.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panel.add(lbl_talla);

		textField_talla = new JTextField();
		textField_talla.setBackground(new Color(255, 255, 0));
		textField_talla.setBounds(527, 137, 96, 19);
		textField_talla.setColumns(10);
		panel.add(textField_talla);

		JLabel lbl_vacuna = new JLabel("¿Tiene vacunas?");
		lbl_vacuna.setForeground(new Color(255, 255, 255));
		lbl_vacuna.setBounds(393, 178, 210, 24);
		lbl_vacuna.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_vacuna.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panel.add(lbl_vacuna);

		// RADIO BOTONES VACUNA
		rdbtn_Si_vacuna = new JRadioButton("Si"); // ELIMINAMOS "JRADIOBUTTON" DELANTE PARA UTILIZAR LA VARIABLE MIEMBRO
		rdbtn_Si_vacuna.setBackground(new Color(102, 255, 204));
		rdbtn_Si_vacuna.setBounds(373, 202, 103, 21);
		rdbtn_Si_vacuna.setFont(new Font("SansSerif", Font.BOLD, 13));
		panel.add(rdbtn_Si_vacuna);

		rdbtn_No_vacuna = new JRadioButton("No"); // ELIMINAMOS "JRADIOBUTTON" DELANTE PARA UTILIZAR LA VARIABLE MIEMBRO
		rdbtn_No_vacuna.setBackground(new Color(102, 255, 204));
		rdbtn_No_vacuna.setBounds(507, 202, 103, 21);
		rdbtn_No_vacuna.setFont(new Font("SansSerif", Font.BOLD, 13));
		panel.add(rdbtn_No_vacuna);

		grupoRadioButton_vacuna = new ButtonGroup(); // UTILIZAMOS LA VARIABLE MIEMBRO
		grupoRadioButton_vacuna.add(rdbtn_Si_vacuna);
		grupoRadioButton_vacuna.add(rdbtn_No_vacuna);

		// ETIQUETA
		JLabel lbl_enfermedad = new JLabel("¿Enfermedad existente?");
		lbl_enfermedad.setForeground(new Color(255, 255, 255));
		lbl_enfermedad.setBounds(393, 236, 241, 32);
		lbl_enfermedad.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_enfermedad.setFont(new Font("SansSerif", Font.PLAIN, 18));
		panel.add(lbl_enfermedad);

		// RADIO BOTONES ENFERMEDAD
		rdbtn_Si_enfermedad = new JRadioButton("Si"); // ELIMINAMOS "JRADIOBUTTON" DELANTE PARA UTILIZAR LA VARIABLE
		rdbtn_Si_enfermedad.setBackground(new Color(102, 255, 255));
		rdbtn_Si_enfermedad.setBounds(373, 286, 103, 21);
		rdbtn_Si_enfermedad.setFont(new Font("SansSerif", Font.BOLD, 13));
		panel.add(rdbtn_Si_enfermedad);

		rdbtn_No_enfermedad = new JRadioButton("No");
		rdbtn_No_enfermedad.setBackground(new Color(102, 255, 255));
		rdbtn_No_enfermedad.setBounds(503, 286, 103, 21);
		rdbtn_No_enfermedad.setFont(new Font("SansSerif", Font.BOLD, 13));
		panel.add(rdbtn_No_enfermedad);
		grupoRadioButton_enfermedad = new ButtonGroup(); // SELECCIONAR SOLO UN RADIOBUTTON
		grupoRadioButton_enfermedad.add(rdbtn_Si_enfermedad);
		grupoRadioButton_enfermedad.add(rdbtn_No_enfermedad);

		// BOTON ACTUALIZAR ANIMAL
		JButton btn_Act_Animal = new JButton("Actualizar Animal");
		btn_Act_Animal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Introduce el ID del animal a actualizar:");
				if (id != null && !id.isEmpty()) {
					try {
						if (validarCampos()) {
							// RECOLECTAR LOS DATOS INGRESADOS POR EL USUARIO
							String nombre = textField_nombre.getText();
							String especie = comboBox_especie.getSelectedItem().toString();
							String sexo = comboBox_sexo.getSelectedItem().toString();
							String fechaNacimiento = textField_nacimiento.getText();
							double peso = Double.parseDouble(textField_peso.getText());
							double talla = Double.parseDouble(textField_talla.getText());
							boolean vacunas = rdbtn_Si_vacuna.isSelected();
							boolean enfermedades = rdbtn_Si_enfermedad.isSelected();

							// CREAR UN OBJETO ANIMAL CON LOS DATOS RECOLECTADOS
							Animal animalActualizado = new Animal();
							animalActualizado.setNombre(nombre);
							animalActualizado.setEspecie(especie);
							animalActualizado.setSexo(sexo);
							animalActualizado.setFechaNacimiento(fechaNacimiento);
							animalActualizado.setPeso(peso);
							animalActualizado.setTalla(talla);
							animalActualizado.setVacunas(vacunas);
							animalActualizado.setEnfermedadesExistente(enfermedades);

							// REALIZA LA ACTUALIZACION DEL ANIMAL EN LA BASE DE DATOS
							if (ZooDatabase.getInstance().actualizarAnimal(id, animalActualizado)) {
								JOptionPane.showMessageDialog(null, "Error al actualizar el animal");
							} else {
								JOptionPane.showMessageDialog(null, "Animal actualizado correctamente");

								// LIMPIAR CAMPOS DEL FORMULARIO
								textField_nombre.setText("");
								comboBox_especie.setSelectedIndex(0);
								comboBox_sexo.setSelectedIndex(0);
								textField_nacimiento.setText("");
								textField_peso.setText("");
								textField_talla.setText("");
								grupoRadioButton_vacuna.clearSelection();
								grupoRadioButton_enfermedad.clearSelection();
							}
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Peso y talla deben ser números válidos.");
					}
				} else {
					JOptionPane.showMessageDialog(null, "ID no válido");
				}
			}
		});
		btn_Act_Animal.setBackground(Color.GREEN);
		btn_Act_Animal.setBounds(468, 372, 180, 51);
		panel.setOpaque(true);
		btn_Act_Animal.setFont(new Font("SansSerif", Font.PLAIN, 16));
		panel.add(btn_Act_Animal);

		// BOTON VOLVER ATRAS
		JButton btn_volver = new JButton("Volver atrás");
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // CERRAR LA VENTANA
			}
		});
		btn_volver.setFont(new Font("SansSerif", Font.PLAIN, 16));
		panel.setOpaque(true);
		btn_volver.setBackground(new Color(255, 153, 0));
		btn_volver.setForeground(Color.BLACK);
		btn_volver.setBounds(140, 372, 180, 51);
		panel.add(btn_volver);

		JSeparator separator = new JSeparator();
		separator.setBounds(326, 92, 23, 244);
		separator.setOrientation(SwingConstants.VERTICAL);
		panel.add(separator);
	}

	// ---------------------------------------------------------------

	private boolean validarCampos() {
		String peso = textField_peso.getText();
		String talla = textField_talla.getText();
		String nacimiento = textField_nacimiento.getText();

		// VALIDAR PESO Y TALLA PARA ASEGURARSE DE QUE SOLO CONTIENEN NUMEROS
		if (!esNumero(peso) || !esNumero(talla)) {
			JOptionPane.showMessageDialog(null, "El peso y talla deben contener solo números.");
			return false;
		}

		// VALIDAR EL FORMATO DE NACIMIENTO (POR EJEMPLO, "12-12-2024")
		if (!nacimiento.matches("\\d{2}-\\d{2}-\\d{4}")) {
			JOptionPane.showMessageDialog(null, "El formato de nacimiento debe ser dd-mm-aaaa.");
			return false;
		}
		return true;
	}

	// METODO PARA VERIFICAR SI UNA CADENA CONTIENE SOLO NUMEROS
	private boolean esNumero(String cadena) {
		try {
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
