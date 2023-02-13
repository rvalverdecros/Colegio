import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class TestConex {
	
	private Conexion conexion =new Conexion();
	private Connection cn = null;
	
	public void insertCurso(String curso) {
		
		try {
		
		cn = conexion.conectar();
		
		PreparedStatement stmt = cn.prepareStatement("INSERT INTO Curso (Nombre,Estado,Alumnos) VALUES (?,?,?)");
		  // Introducimos los valores en los campos
		    
		  
		  // asociamos los valores introducidos a los campos de la tabla
		  stmt.setString(1, curso);
		  stmt.setString(2, "Clase");
		  stmt.setInt(3, 30);

		  
		//Ejecutamos la acción y cerramos
		  
		  stmt.executeUpdate();		
		  stmt.close();	
		  
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
     public void insertAula(String aula, boolean pizarra, int sillas, int mesas, String estado) {
		
		try {
		
		cn = conexion.conectar();
		
		PreparedStatement stmt = cn.prepareStatement("INSERT INTO Aula (Nombre,Pizarra,Sillas,Mesas,Estado) VALUES (?,?,?,?,?)");
		  // Introducimos los valores en los campos
		    
		  
		  // asociamos los valores introducidos a los campos de la tabla
		  stmt.setString(1, aula);
		  stmt.setBoolean(2, pizarra);
		  stmt.setInt(3, sillas);
		  stmt.setInt(4, mesas);
		  stmt.setString(5, estado);
		  
		  
		//Ejecutamos la acción y cerramos
		  
		  stmt.executeUpdate();		
		  stmt.close();	
		  
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
     
     public void insertProfesor(String nombre, String dni, int edad, String sexo, String estado) {
 		
 		try {
 		
 		cn = conexion.conectar();
 		
 		PreparedStatement stmt = cn.prepareStatement("INSERT INTO Profesores (Nombre,DNI,Edad,Sexo,Estado) VALUES (?, ?, ?, ?, ?)");	
 		  // Introducimos los valores en los campos
 		    
 		  
 		  // asociamos los valores introducidos a los campos de la tabla
 		  stmt.setString(1, nombre);
 		  stmt.setString(2, dni);
 		  stmt.setInt(3, edad);
 		  stmt.setString(4, sexo);
 		  stmt.setString(5, estado);
 		  
 		  
 		  
 		//Ejecutamos la acción y cerramos
 		  
 		  stmt.executeUpdate();		
 		  stmt.close();	
 		  
 		}catch (SQLException e) {
 			e.printStackTrace();
 			
 		}
 	}
     
     public void insertAlumno(String nombre, String dni, int edad, String sexo, String estado) {
  		
  		try {
  		
  		cn = conexion.conectar();
  		
  		PreparedStatement stmt = cn.prepareStatement("INSERT INTO Alumnos (Nombre,DNI,Edad,Sexo,Estado) VALUES (?, ?, ?, ?, ?)");	
  		  // Introducimos los valores en los campos
  		    
  		  
  		  // asociamos los valores introducidos a los campos de la tabla
  		  stmt.setString(1, nombre);
  		  stmt.setString(2, dni);
  		  stmt.setInt(3, edad);
  		  stmt.setString(4, sexo);
  		  stmt.setString(5, estado);
  		  
  		  
  		  
  		//Ejecutamos la acción y cerramos
  		  
  		  stmt.executeUpdate();		
  		  stmt.close();	
  		  
  		}catch (SQLException e) {
  			e.printStackTrace();
  			
  		}
  	}
     
     public ArrayList<Aula> selectAulas(){
    	 ArrayList<Aula> lisaula  = new ArrayList<>();
    	 try {
    		 cn = conexion.conectar();
    		 
    		 PreparedStatement stmt = cn.prepareStatement("SELECT * FROM Aula");
    		 
    		 ResultSet reset = stmt.executeQuery();
    		 
    		 
    		 while(reset.next()) {
    			int ID = reset.getInt(1);
 				String nombre = reset.getString(2);
 				boolean pizarra = reset.getBoolean(3);
 				int sillas = reset.getInt(4);
 				int mesas = reset.getInt(5);
 				String estado = reset.getString(6);
 				int IDCurso = reset.getInt(7);
 				
 				if(IDCurso != -1) {
 					ArrayList<Curso> liscurso  = selectCursos();
 					Curso curso = null;
 					for(Curso newcurso:liscurso) {
 						if(newcurso.getID() == IDCurso) {
 							curso = newcurso;
 						}
 					}
 					Aula aula = new Aula (ID,nombre,pizarra,sillas,mesas,estado,curso);
 					lisaula.add(aula);
 				}else {
 					Aula aula = new Aula (ID,nombre,pizarra,sillas,mesas,estado,null);
 					lisaula.add(aula);
 				}
    		 }
    		 
    	 }catch (SQLException e) {
   			e.printStackTrace();
   		}
    	 return lisaula;
     }
     
     public ArrayList<Curso> selectCursos(){
    	 ArrayList<Curso> liscurso  = new ArrayList<>();
    	 try {
    		 cn = conexion.conectar();
    		 
    		 PreparedStatement stmt = cn.prepareStatement("SELECT * FROM Curso");
    		 
    		 ResultSet reset = stmt.executeQuery();
    		 
    		 
    		 while(reset.next()) {
    			int ID = reset.getInt(1);
 				String nombre = reset.getString(2);
 				String estado = reset.getString(3);
 				int alumnos = reset.getInt(4);
 				Curso curso = new Curso(ID,nombre,estado,alumnos);
 				liscurso.add(curso);
    		 }
    	 }catch (SQLException e) {
   			e.printStackTrace();
   		}
    	 return liscurso;
     }
     
     public ArrayList<Alumno> selectAlumnos(){
    	 ArrayList<Alumno> lisalumnos  = new ArrayList<>();
    	 try {
    		 cn = conexion.conectar();
    		 
    		 PreparedStatement stmt = cn.prepareStatement("SELECT * FROM Alumnos");
    		 
    		 ResultSet reset = stmt.executeQuery();
    		 
    		 
    		 while(reset.next()) {
    			int ID = reset.getInt(1);
 				String nombre = reset.getString(2);
 				String DNI = reset.getString(3);
 				int edad = reset.getInt(4);
 				String sexo = reset.getString(5);
 				String estado = reset.getString(6);

 				if(reset.getObject(7) != null) {
					int IDCurso = reset.getInt(7);
 					ArrayList<Curso> liscurso  = selectCursos();
 					Curso curso = null;
 					for(Curso newcurso:liscurso) {
 						if(newcurso.getID() == IDCurso) {
 							curso = newcurso;
 						}
 					}
 					Alumno alumno = new Alumno (ID,nombre,DNI,edad,sexo,estado,curso);
 					lisalumnos.add(alumno);
 				}else {
 					Alumno alumno = new Alumno (ID,nombre,DNI,edad,sexo,estado,null);
 					lisalumnos.add(alumno);
 				}
    		 }
    		 
    	 }catch (SQLException e) {
   			e.printStackTrace();
   		}
    	 return lisalumnos;
     }

	public ArrayList<Alumno> selectAlumnosByIDCurso(int idCurso){
		ArrayList<Alumno> lisalumnos  = new ArrayList<>();
		try {
			cn = conexion.conectar();

			PreparedStatement stmt = cn.prepareStatement("SELECT * FROM Alumnos WHERE IDCurso = ?");

			stmt.setInt(1,idCurso);

			ResultSet reset = stmt.executeQuery();


			while(reset.next()) {
				int ID = reset.getInt(1);
				String nombre = reset.getString(2);
				String DNI = reset.getString(3);
				int edad = reset.getInt(4);
				String sexo = reset.getString(5);
				String estado = reset.getString(6);

				if(reset.getObject(7) != null) {
					int IDCurso = reset.getInt(7);
					ArrayList<Curso> liscurso  = selectCursos();
					Curso curso = null;
					for(Curso newcurso:liscurso) {
						if(newcurso.getID() == IDCurso) {
							curso = newcurso;
						}
					}
					Alumno alumno = new Alumno (ID,nombre,DNI,edad,sexo,estado,curso);
					lisalumnos.add(alumno);
				}else {
					Alumno alumno = new Alumno (ID,nombre,DNI,edad,sexo,estado,null);
					lisalumnos.add(alumno);
				}
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lisalumnos;
	}
     
     public ArrayList<Profesor> selectProfesores(){
    	 ArrayList<Profesor> lisprofesores  = new ArrayList<>();
    	 try {
    		 cn = conexion.conectar();
    		 
    		 PreparedStatement stmt = cn.prepareStatement("SELECT * FROM Profesores");
    		 
    		 ResultSet reset = stmt.executeQuery();
    		 
    		 
    		 while(reset.next()) {
    			int ID = reset.getInt(1);
 				String nombre = reset.getString(2);
 				String DNI = reset.getString(3);
 				int edad = reset.getInt(4);
 				String sexo = reset.getString(5);
 				String estado = reset.getString(6);
 				int IDCurso = reset.getInt(7);
 				
 				if(IDCurso != -1) {
 					ArrayList<Curso> liscurso  = selectCursos();
 					Curso curso = null;
 					for(Curso newcurso:liscurso) {
 						if(newcurso.getID() == IDCurso) {
 							curso = newcurso;
 						}
 					}
 					Profesor profesor = new Profesor (ID,nombre,DNI,edad,sexo,estado,curso);
 					lisprofesores.add(profesor);
 				}else {
 					Profesor profesor = new Profesor (ID,nombre,DNI,edad,sexo,estado,null);
 					lisprofesores.add(profesor);
 				}
    		 }
    		 
    	 }catch (SQLException e) {
   			e.printStackTrace();
   		}
    	 return lisprofesores;
     }

	public ArrayList<Profesor> selectProfesoresByIDCurso(int idCurso){
		ArrayList<Profesor> lisprofesores  = new ArrayList<>();
		try {
			cn = conexion.conectar();

			PreparedStatement stmt = cn.prepareStatement("SELECT * FROM Profesores WHERE IDCurso = ?");

			stmt.setInt(1,idCurso);

			ResultSet reset = stmt.executeQuery();


			while(reset.next()) {
				int ID = reset.getInt(1);
				String nombre = reset.getString(2);
				String DNI = reset.getString(3);
				int edad = reset.getInt(4);
				String sexo = reset.getString(5);
				String estado = reset.getString(6);
				int IDCurso = reset.getInt(7);

				if(IDCurso != -1) {
					ArrayList<Curso> liscurso  = selectCursos();
					Curso curso = null;
					for(Curso newcurso:liscurso) {
						if(newcurso.getID() == IDCurso) {
							curso = newcurso;
						}
					}
					Profesor profesor = new Profesor (ID,nombre,DNI,edad,sexo,estado,curso);
					lisprofesores.add(profesor);
				}else {
					Profesor profesor = new Profesor (ID,nombre,DNI,edad,sexo,estado,null);
					lisprofesores.add(profesor);
				}
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lisprofesores;
	}
     
     public void deleteAula(int numero) {
    	 try {
    		 cn = conexion.conectar();
    		 
    		 PreparedStatement stmt = cn.prepareStatement("DELETE FROM Aula WHERE ID = ?");

			 stmt.setInt(1,numero);
    		 
    		 stmt.executeUpdate();
    	 }catch (SQLException e) {
    			e.printStackTrace();
    		}
     }
     
     public void deleteCurso(int numero) {
    	 try {
    		 cn = conexion.conectar();
    		 
    		 PreparedStatement stmt = cn.prepareStatement("DELETE FROM Curso WHERE ID = ?");

			 stmt.setInt(1,numero);
    		 
    		 stmt.executeUpdate();
    	 }catch (SQLException e) {
    			e.printStackTrace();
    		}
     }
     
     public void deleteAlumno(int numero) {
    	 try {
    		 cn = conexion.conectar();
    		 
    		 PreparedStatement stmt = cn.prepareStatement("DELETE FROM Alumnos WHERE ID = ?");

			 stmt.setInt(1,numero);
    		 
    		 stmt.executeUpdate();
    	 }catch (SQLException e) {
    			e.printStackTrace();
    		}
     }
     
     public void deleteProfesor(int numero) {
    	 try {
    		 cn = conexion.conectar();
    		 
    		 PreparedStatement stmt = cn.prepareStatement("DELETE FROM Profesores WHERE ID = ?");

			 stmt.setInt(1,numero);
    		 
    		 stmt.executeUpdate();
    	 }catch (SQLException e) {
    			e.printStackTrace();
    		}
     }
     
     public void setNombreAula(int id, String nombreAula) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Aula SET Nombre = ? WHERE ID = ?");
    		 
    		 stmt.setString(1, nombreAula);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setPizarra(int id, boolean pizarra) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Aula SET Pizarra = ? WHERE ID = ?");
    		 
    		 stmt.setBoolean(1, pizarra);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setSillas(int id, int sillas) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Aula SET Sillas = ? WHERE ID = ?");
    		 
    		 stmt.setInt(1, sillas);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setMesas(int id, int mesas) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Aula SET Mesas = ? WHERE ID = ?");
    		 
    		 stmt.setInt(1, mesas);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setEstado(int id, String estado) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Aula SET Estado = ? WHERE ID = ?");
    		 
    		 stmt.setString(1, estado);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setCurso(int id, int curso) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Aula SET IDCurso = ? WHERE ID = ?");
    		 
    		 stmt.setInt(1, curso);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setNombreCurso(int id, String nombre) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Curso SET Nombre = ? WHERE ID = ?");
    		 
    		 stmt.setString(1, nombre);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setEstadoCurso(int id, String estado) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Curso SET Estado = ? WHERE ID = ?");
    		 
    		 stmt.setString(1, estado);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setAlumnosCurso(int id, int alumnos) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Curso SET Alumnos = ? WHERE ID = ?");
    		 
    		 stmt.setInt(1, alumnos);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setNombreAlumno(int id, String nombre) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Alumnos SET Nombre = ? WHERE ID = ?");
    		 
    		 stmt.setString(1, nombre);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setDNIAlumno(int id, String dni) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Alumnos SET DNI = ? WHERE ID = ?");
    		 
    		 stmt.setString(1, dni);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setEdadAlumno(int id, int edad) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Alumnos SET Edad = ? WHERE ID = ?");
    		 
    		 stmt.setInt(1, edad);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setSexoAlumno(int id, String sexo) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Alumnos SET Sexo = ? WHERE ID = ?");
    		 
    		 stmt.setString(1, sexo);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setEstadoAlumno(int id, String estado) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Alumnos SET Estado = ? WHERE ID = ?");
    		 
    		 stmt.setString(1, estado);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setCursoAlumno(int id, int curso) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Alumnos SET IDCurso = ? WHERE ID = ?");
    		 
    		 stmt.setInt(1, curso);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }

	public void setCursoAlumnoNull(int id) {
		try {
			cn = conexion.conectar();
			PreparedStatement stmt = cn.prepareStatement("UPDATE Alumnos SET IDCurso = null WHERE ID = ?");

			stmt.setInt(1, id);

			stmt.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

     public void setNombreProfesor(int id, String nombre) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Profesores SET Nombre = ? WHERE ID = ?");
    		 
    		 stmt.setString(1, nombre);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setDNIProfesor(int id, String dni) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Profesores SET DNI = ? WHERE ID = ?");
    		 
    		 stmt.setString(1, dni);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setEdadProfesor(int id, int edad) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Profesores SET Edad = ? WHERE ID = ?");
    		 
    		 stmt.setInt(1, edad);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setSexoProfesor(int id, String sexo) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Profesores SET Sexo = ? WHERE ID = ?");
    		 
    		 stmt.setString(1, sexo);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setEstadoProfesor(int id, String estado) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Profesores SET Estado = ? WHERE ID = ?");
    		 
    		 stmt.setString(1, estado);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void setCursoProfesor(int id, int curso) {
    	 try {
    		 cn = conexion.conectar();
    		 PreparedStatement stmt = cn.prepareStatement("UPDATE Profesores SET IDCurso = ? WHERE ID = ?");
    		 
    		 stmt.setInt(1, curso);
    		 stmt.setInt(2, id);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }

	public void setCursoProfesorNull(int id) {
		try {
			cn = conexion.conectar();
			PreparedStatement stmt = cn.prepareStatement("UPDATE Profesores SET IDCurso = null WHERE ID = ?");

			stmt.setInt(1, id);

			stmt.executeUpdate();

		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
     
     public void añadirMaterialProfesor(int id, String material) {
    	 try {
    	 		
    	 		cn = conexion.conectar();
    	 		
    	 		PreparedStatement stmt = cn.prepareStatement("INSERT INTO Materiales_Profesores (Nombre,IDProfesor,Estado) VALUES (?, ?, ?)");	
    	 		  
    	 		  stmt.setString(1, material);
    	 		  stmt.setInt(2, id);
    	 		  stmt.setString(3, "Nuevo");
    	 		  
    	 		  
    	 		  stmt.executeUpdate();		
    	 		  stmt.close();	
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void añadirMaterialAlumno(int id, String material) {
    	 try {
    	 		
    	 		cn = conexion.conectar();
    	 		
    	 		PreparedStatement stmt = cn.prepareStatement("INSERT INTO Materiales_Alumno (Nombre,IDAlumno,Estado) VALUES (?, ?, ?)");	
    	 		  
    	 		  stmt.setString(1, material);
    	 		  stmt.setInt(2, id);
    	 		  stmt.setString(3, "Nuevo");
    	 		  
    	 		  
    	 		  stmt.executeUpdate();		
    	 		  stmt.close();	
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void borrarMaterialProfesor(int id, String material) {
    	 try {
    		 cn = conexion.conectar();
    		 
    		 PreparedStatement stmt = cn.prepareStatement("DELETE FROM Materiales_Profesores WHERE IDProfesor = ? AND NOMBRE = ?");

			 stmt.setInt(1,id);
			 stmt.setString(2,material);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public void borrarMaterialAlumno(int id, String material) {
    	 try {
    		 cn = conexion.conectar();
    		 
    		 PreparedStatement stmt = cn.prepareStatement("DELETE FROM Materiales_Alumno WHERE IDAlumno = ? AND NOMBRE = ?");

			 stmt.setInt(1,id);
			 stmt.setString(2,material);
    		 
    		 stmt.executeUpdate();
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
     }
     
     public boolean existeMaterialAlumno(int id, String material) {
    	 int rowcount = 0;
    	 try {
    		 cn = conexion.conectar();
    		 
    		 PreparedStatement stmt = cn.prepareStatement("SELECT * FROM Materiales_Alumno WHERE IDAlumno = ? AND NOMBRE = ?");

			 stmt.setInt(1,id);
			 stmt.setString(2,material);
    		 
    		ResultSet res = stmt.executeQuery();
    		
    		
    		while(res.next()) {
    			rowcount++;
    		}
    		
    		
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
    	 return rowcount >0;
     }
     
     public boolean existeMaterialProfesor(int id, String material) {
    	 int rowcount = 0;
    	 try {
    		 cn = conexion.conectar();
    		 
    		 PreparedStatement stmt = cn.prepareStatement("SELECT * FROM Materiales_Profesores WHERE IDProfesor = ? AND NOMBRE = ?");

			 stmt.setInt(1,id);
			 stmt.setString(2,material);
    		 
    		ResultSet res = stmt.executeQuery();
    		
    		
    		while(res.next()) {
    			rowcount++;
    		}
    		
    		
    		 
    	 }catch (SQLException e) {
 			e.printStackTrace();
 		}
    	 return rowcount >0;
     }
}