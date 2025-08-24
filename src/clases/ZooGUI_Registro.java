package clases;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class ZooGUI_Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_id;
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

	// DECLARACIÓN DE ATRIBUTOS PARA LA CONEXIÓN A LA BASE DE DATOS
	public Connection con;
	public PreparedStatement pstmt;
	public ResultSet rs;

	/**
	 * Create the frame.
	 */
	public ZooGUI_Registro() {
		setTitle("FORMULARIO REGISTRO");
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
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Registro Animal");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 38));
		lblNewLabel.setBounds(229, 10, 294, 61);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(23, 92, 54, 18);
		panel.add(lblNewLabel_1);

		JLabel lbl_nombre = new JLabel("Especie");
		lbl_nombre.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbl_nombre.setBounds(23, 138, 79, 18);
		panel.add(lbl_nombre);

		textField_id = new JTextField();
		textField_id.setBounds(174, 92, 96, 19);
		panel.add(textField_id);
		textField_id.setColumns(10);

		textField_nombre = new JTextField();
		textField_nombre.setBounds(174, 138, 96, 19);
		panel.add(textField_nombre);
		textField_nombre.setColumns(10);

		JLabel lbl_especie = new JLabel("Clase Animal");
		lbl_especie.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_especie.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbl_especie.setBounds(23, 188, 120, 20);
		panel.add(lbl_especie);

		// DESPLEGABLE ESPECIE
		comboBox_especie = new JComboBox<String>();
		comboBox_especie.addItem("");
		comboBox_especie.addItem("Mamíferos");
		comboBox_especie.addItem("Aves");
		comboBox_especie.addItem("Reptiles");
		comboBox_especie.addItem("Anfibios");
		comboBox_especie.addItem("Peces");

		comboBox_especie.setBounds(174, 187, 96, 21);
		panel.add(comboBox_especie);

		JLabel lbl_sexo = new JLabel("Sexo");
		lbl_sexo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sexo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbl_sexo.setBounds(23, 248, 79, 18);
		panel.add(lbl_sexo);

		// DESPLEGABLE SEXO
		comboBox_sexo = new JComboBox<String>();
		comboBox_sexo.addItem("");
		comboBox_sexo.addItem("Macho");
		comboBox_sexo.addItem("Hembra");
		comboBox_sexo.addItem("Aun No Definido");

		comboBox_sexo.setBounds(174, 247, 96, 21);
		panel.add(comboBox_sexo);

		JLabel lbl_nacimiento = new JLabel("Nacimiento");
		lbl_nacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_nacimiento.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbl_nacimiento.setBounds(23, 315, 120, 18);
		panel.add(lbl_nacimiento);

		textField_nacimiento = new JTextField();
		textField_nacimiento.setColumns(10);
		textField_nacimiento.setBounds(174, 315, 96, 19);
		panel.add(textField_nacimiento);

		JLabel lbl_peso = new JLabel("Peso");
		lbl_peso.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_peso.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbl_peso.setBounds(373, 92, 120, 18);
		panel.add(lbl_peso);

		textField_peso = new JTextField();
		textField_peso.setColumns(10);
		textField_peso.setBounds(527, 92, 96, 19);
		panel.add(textField_peso);

		JLabel lbl_talla = new JLabel("Talla");
		lbl_talla.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_talla.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbl_talla.setBounds(373, 138, 120, 18);
		panel.add(lbl_talla);

		textField_talla = new JTextField();
		textField_talla.setColumns(10);
		textField_talla.setBounds(527, 137, 96, 19);
		panel.add(textField_talla);

		JLabel lbl_vacuna = new JLabel("¿Tiene vacunas?");
		lbl_vacuna.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_vacuna.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbl_vacuna.setBounds(398, 182, 210, 24);
		panel.add(lbl_vacuna);

		// RADIO BOTONES VACUNA
		rdbtn_Si_vacuna = new JRadioButton("Si"); 
		rdbtn_Si_vacuna.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtn_Si_vacuna.setBounds(382, 224, 103, 21);
		panel.add(rdbtn_Si_vacuna);

		rdbtn_No_vacuna = new JRadioButton("No"); 
		rdbtn_No_vacuna.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtn_No_vacuna.setBounds(516, 224, 103, 21);
		panel.add(rdbtn_No_vacuna);

		grupoRadioButton_vacuna = new ButtonGroup(); // UTILIZAMOS LA VARIABLE MIEMBRO
		grupoRadioButton_vacuna.add(rdbtn_Si_vacuna);
		grupoRadioButton_vacuna.add(rdbtn_No_vacuna);

		// ETIQUETA
		JLabel lbl_enfermedad = new JLabel("¿Enfermedad existente?");
		lbl_enfermedad.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_enfermedad.setFont(new Font("SansSerif", Font.PLAIN, 18));
		lbl_enfermedad.setBounds(382, 269, 241, 32);
		panel.add(lbl_enfermedad);

		// RADIO BOTONES ENFERMEDAD
		rdbtn_Si_enfermedad = new JRadioButton("Si"); 
		rdbtn_Si_enfermedad.setFont(new Font("SansSerif", Font.BOLD, 13));
		
		rdbtn_Si_enfermedad.setBounds(382, 315, 103, 21);
		panel.add(rdbtn_Si_enfermedad);

		rdbtn_No_enfermedad = new JRadioButton("No");
		rdbtn_No_enfermedad.setFont(new Font("SansSerif", Font.BOLD, 13));
		rdbtn_No_enfermedad.setBounds(512, 315, 103, 21);
		panel.add(rdbtn_No_enfermedad);
		grupoRadioButton_enfermedad = new ButtonGroup(); // SELECCIONAR SOLO UN RADIOBUTTON
		grupoRadioButton_enfermedad.add(rdbtn_Si_enfermedad);
		grupoRadioButton_enfermedad.add(rdbtn_No_enfermedad);

		// BOTON REGISTRAR ANIMAL
		JButton btnNewButton = new JButton("Registar Animal");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (validarCampos()) {
						agregarAnimal(); // LLAMADA AL METODO PARA AGREGAR EL ANIMAL CON LOS DATOS INGRESADOS

						// LIMPIAR CAMPOS DEL FORMULARIO
						textField_id.setText("");
						textField_nombre.setText("");
						comboBox_especie.setSelectedIndex(0);
						comboBox_sexo.setSelectedIndex(0);
						textField_nacimiento.setText("");
						textField_peso.setText("");
						textField_talla.setText("");
						grupoRadioButton_vacuna.clearSelection();
						grupoRadioButton_enfermedad.clearSelection();
					}

				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error al registrar el animal: " + e1.getMessage());
				}

			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btnNewButton.setBounds(398, 443, 180, 51);
		panel.add(btnNewButton);

		// BOTON VOLVER ATRAS
		JButton btn_volver = new JButton("Volver atrás");
		btn_volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // CERRAR LA VENTANA
			}
		});
		btn_volver.setFont(new Font("SansSerif", Font.PLAIN, 16));
		btn_volver.setBackground(Color.blue);
		btn_volver.setForeground(Color.white);
		btn_volver.setBounds(650, 443, 180, 51);
		panel.add(btn_volver);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(326, 92, 23, 294);
		panel.add(separator);

	}

	public void conectarBaseDatos() {
		try {
			// NOS CONECTAMOS A LA BASE DE DATOS PARA ESTABLECER LA CONEXION
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zoologico", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void agregarAnimal() throws IOException {

		String id = textField_id.getText();
		String nombre = textField_nombre.getText();
		String especie = (String) comboBox_especie.getSelectedItem();
		String sexo = (String) comboBox_sexo.getSelectedItem();
		String nacimiento = textField_nacimiento.getText();
		String peso = textField_peso.getText();
		String talla = textField_talla.getText();
		boolean tieneVacunas = rdbtn_Si_vacuna.isSelected();
		boolean tieneEnfermedad = rdbtn_Si_enfermedad.isSelected();

		// VALIDACIONES BASICAS
		if (id.isEmpty() || nombre.isEmpty() || especie.isEmpty() || sexo.isEmpty() || nacimiento.isEmpty()
				|| peso.isEmpty() || talla.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.");
			return;
		}

		// IMPRIMIR REGISTRO
		System.out.println("Animal registrado: " + id + ", " + nombre + ", " + especie + ", " + sexo + ", " + nacimiento
				+ ", " + peso + ", " + talla + ", Vacunas: " + tieneVacunas + ", Enfermedad: " + tieneEnfermedad);
		JOptionPane.showMessageDialog(null, "Animal registrado correctamente.");

		// LLAMADA AL METODO PARA CONECTAR CON LA BASE DE DATOS
		conectarBaseDatos();

		try {
			// SENTENCIA SQL PARA INSERTAR UN NUEVO REGISTRO EN LA TABLA DE ANIMALES
			String sql = "INSERT INTO animales(id, nombre, especie, sexo, nacimiento, peso, talla, vacunas, enfermedad) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, nombre);
			pstmt.setString(3, especie);
			pstmt.setString(4, sexo);
			pstmt.setString(5, nacimiento);
			pstmt.setDouble(6, Double.parseDouble(peso));
			pstmt.setDouble(7, Double.parseDouble(talla));
			pstmt.setBoolean(8, tieneVacunas);
			pstmt.setBoolean(9, tieneEnfermedad);
			pstmt.executeUpdate();
			System.out.println("Animal registrado en la base de datos");
			JOptionPane.showMessageDialog(null, "Animal registrado correctamente.");
		} catch (SQLException e) {
			System.out.println("Error al insertar el animal en la base de datos: " + e.getMessage());
			JOptionPane.showMessageDialog(null, "Error al registrar el animal en la base de datos.");
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// METODO PARA VALIDAR LOS CAMPOS ANTES DE AGREGAR EL ANIMAL
	private boolean validarCampos() {
		String id = textField_id.getText();
		String peso = textField_peso.getText();
		String talla = textField_talla.getText();
		String nacimiento = textField_nacimiento.getText();

		// VALIDAR ID, PESO Y TALLA PARA ASEGURARSE DE QUE SOLO CONTIENEN NUMEROS
		if (!esNumero(id) || !esNumero(peso) || !esNumero(talla)) {
			JOptionPane.showMessageDialog(null, "ID, peso y talla deben contener solo números.");
			return false;
		}

		// VALIDAR EL FORMATO DE NACIMIENTO, ej: "12-12-2024")
		if (!nacimiento.matches("\\d{2}-\\d{2}-\\d{4}")) {
			JOptionPane.showMessageDialog(null, "El formato de nacimiento debe ser dd-mm-aaaa");
			return false;
		}

		// SI CUMPLE, RETORNAR TRUE
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
