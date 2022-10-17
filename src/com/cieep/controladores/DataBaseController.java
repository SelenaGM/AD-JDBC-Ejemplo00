package com.cieep.controladores;

import com.cieep.bd.Constantes;
import com.cieep.modelos.Animal;

import java.sql.*;

public class DataBaseController {
    //Da las herramientas para la gestión de la base de datos

    private final String SERVER = "jdbc:mysql://localhost/granja";
    private final String USER = "root";
    private final String PASSWORD = "toor";

    public DataBaseController() throws SQLException {
        inicializaTablas();

    }

    public Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(SERVER,USER,PASSWORD);
    }

    private void inicializaTablas() throws SQLException {
        Connection connection = obtenerConexion();
        //ESTO HAY QUE CORREGIRLO
        String query = "create table if not exists "+Constantes.TABLA_ANIMALES +
                "    "+Constantes.ID_ANIMAL+" int PRIMARY KEY ,\n" +
                "    "+Constantes.TIPO+" varchar(40) not null,\n" +
                "    "+Constantes.NOMBRE+" varchar(40) not null,\n" +
                "    "+Constantes.COLOR+" varchar(10),\n" +
                "    "+Constantes.EDAD+" int not null ,\n" +
                "    "+Constantes.NUM_ENFERMEDADES+" int not null \n" +
                ");";

        Statement stm = connection.createStatement();
        stm.execute(query);
    }

    public int insertaAnimal(Animal animal, Connection connection) throws SQLException {
        String query = "insert into "+Constantes.TABLA_ANIMALES+" values (?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(query);
        pstm.setInt(1,animal.getIdAnimal());
        pstm.setString(2,animal.getTipo());
        pstm.setString(3,animal.getNombre());
        pstm.setString(4,animal.getColor());
        pstm.setInt(5,animal.getEdad());
        pstm.setInt(6,animal.getNumEnfermedades());

        return pstm.executeUpdate();

    }

    public Animal getAnimal(int idAnimal, Connection connection) throws SQLException {

        String query = "Select * from "+Constantes.TABLA_ANIMALES+" where "+Constantes.ID_ANIMAL+" = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,idAnimal);

        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()){
            return new Animal(
                    rs.getInt(Constantes.ID_ANIMAL),
                    rs.getString(Constantes.TIPO),
                    rs.getString(Constantes.NOMBRE),
                    rs.getString(Constantes.COLOR),
                    rs.getInt(Constantes.EDAD),
                    rs.getInt(Constantes.NUM_ENFERMEDADES)
            );

        }
        return null;


    }

}
