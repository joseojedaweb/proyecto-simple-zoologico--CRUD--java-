package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ZooDatabase {

	// INSTANCIA UNICA DE ZOODATABASE
	public static ZooDatabase instance;

	// LISTA PARA ALMACENAR LOS ANIMALES EN LA BASE DE DATOS
	private List<Animal> animales;

	// CAMPOS DE CONEXION A LA BASE DE DATOS
	private Connection con;
	private Statement st;

	// CONSTRUCTOR PRIVADO PARA EVITAR LA CREACION DE INSTANCIAS FUERA DE LA CLASE
	private ZooDatabase() {
		this.animales = new ArrayList<>(); // INICIAR ARRAYLIST
		conectarBaseDatos(); // ESTABLECER CONEXION AL CREAR LA INSTANCIA
	}

	// METODO PARA OBTENER LA INSTANCIA UNICA DE ZOODATABASE
	public static ZooDatabase getInstance() {
		if (instance == null) {
			instance = new ZooDatabase();
		}
		return instance;
	}

	// METODO PARA CONECTAR A LA BASE DE DATOS
	private void conectarBaseDatos() {
		try {
			// AQUI NOS CONECTAMOS A LA BASE DE DATOS
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Zoologico", "root", "");
			// PARA ESTABLECER LA CONEXION
			st = (Statement) con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// METODO AGREGAR ANIMAL A LA BASE DE DATOS
	public void agregarAnimal(Animal animal) {
		try {
			// CREAMOS LA SENTENCIA SQL PARA INSERTAR EL ANIMAL EN LA BASE DE DATOS
			String sql = "INSERT INTO animales (id, nombre, especie, sexo, fecha_nacimiento, peso, talla, vacunas, enfermedades) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

			// CREAMOS UNA SENTENCIA PREPARADA PARA EJECUTAR LA INSERCION
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, animal.getId());
			pstmt.setString(2, animal.getNombre());
			pstmt.setString(3, animal.getEspecie());
			pstmt.setString(4, animal.getSexo());
			pstmt.setString(5, animal.getFechaNacimiento());
			pstmt.setDouble(6, animal.getPeso());
			pstmt.setDouble(7, animal.getTalla());
			pstmt.setBoolean(8, animal.isVacunas());
			pstmt.setBoolean(9, animal.isEnfermedadesExistente());

			// EJECUTAMOS LA SENTENCIA PREPARADA
			pstmt.executeUpdate();

			// CERRAMOS LA SENTENCIA PREPARADA
			pstmt.close();

			// AGREGAMOS EL ANIMAL A LA LISTA EN MEMORIA
			animales.add(animal);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// METODO PARA OBTENER ANIMALES POR TIPO DE LA BASE DE DATOS
	public List<Animal> obtenerAnimalesPorClaseAnimal(String especie) {
		List<Animal> animalesPorEspecie = new ArrayList<>();
		try {
			String query = "SELECT * FROM animales WHERE especie = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, especie);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Animal animal = new Animal();
				animal.setId(rs.getString("id"));
				animal.setNombre(rs.getString("nombre"));
				animal.setEspecie(rs.getString("especie"));
				animal.setSexo(rs.getString("sexo"));
				animal.setFechaNacimiento(rs.getString("nacimiento"));
				animal.setPeso(rs.getDouble("peso"));
				animal.setTalla(rs.getDouble("talla"));
				animal.setVacunas(rs.getBoolean("vacunas"));
				animal.setEnfermedadesExistente(rs.getBoolean("enfermedad"));

				animalesPorEspecie.add(animal);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return animalesPorEspecie;
	}

	// METODO PARA ACTUALIZAR LA INFO DE UN ANIMAL EN LA BASE DE DATOS
	public boolean actualizarAnimal(String id, Animal animalActualizado) {
		try {
			String sql = "UPDATE animales SET nombre = ?, especie = ?, sexo = ?, nacimiento = ?, peso = ?, talla = ?, vacunas = ?, enfermedad = ? WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, animalActualizado.getNombre());
			pstmt.setString(2, animalActualizado.getEspecie());
			pstmt.setString(3, animalActualizado.getSexo());
			pstmt.setString(4, animalActualizado.getFechaNacimiento());
			pstmt.setDouble(5, animalActualizado.getPeso());
			pstmt.setDouble(6, animalActualizado.getTalla());
			pstmt.setBoolean(7, animalActualizado.isVacunas());
			pstmt.setBoolean(8, animalActualizado.isEnfermedadesExistente());
			pstmt.setString(9, id);

			int rowsUpdated = pstmt.executeUpdate();
			pstmt.close();

			// ACTUALIZAR EN LA LISTA EN MEMORIA
			if (rowsUpdated > 0) {
				for (int i = 0; i < animales.size(); i++) {
					if (animales.get(i).getId().equals(id)) {
						animales.set(i, animalActualizado);
						return true;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// METODO PARA ELIMINAR UN ANIMAL DE LA BASE DE DATOS POR SU ID
	public boolean eliminarAnimal(String id) {
		 try {
		        // VERIFICAR SI EL ID EXISTE EN LA BASE DE DATOS
		        String checkSql = "SELECT * FROM animales WHERE id = ?";
		        PreparedStatement checkStmt = con.prepareStatement(checkSql);
		        checkStmt.setString(1, id);
		        ResultSet resultSet = checkStmt.executeQuery();

		        // SI NO HAY RESULTADOS, SIGNIFICA QUE EL ID NO EXISTE EN LA BASE DE DATOS
		        if (!resultSet.next()) {
		            JOptionPane.showMessageDialog(null, "El ID no existe en la base de datos");
		            return false;
		        }

		        // SI EL ID EXISTE, PROCEDEMOS A ELIMINARLO
		        String deleteSql = "DELETE FROM animales WHERE id = ?";
		        PreparedStatement deleteStmt = con.prepareStatement(deleteSql);
		        deleteStmt.setString(1, id);

		        int rowsDeleted = deleteStmt.executeUpdate();
		        deleteStmt.close();

		        // VERIFICAR SI SE ELIMINO CORRECTAMENTE EN LA BASE DE DATOS
		        if (rowsDeleted > 0) {
		            // ELIMINAR DE LA LISTA EN MEMORIA
		            for (int i = 0; i < animales.size(); i++) {
		                if (animales.get(i).getId().equals(id)) {
		                    animales.remove(i);
		                    return true;
		                }
		            }
		        } else {
		            // SI NO SE ELIMINO EN LA BASE DE DATOS, RETORNAR FALSE
		            return false;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return false;
	}
	
	
}
