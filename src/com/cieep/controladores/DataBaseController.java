package com.cieep.controladores;

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
        String query = "create table if not exists animales(\n" +
                "    id_animal int PRIMARY KEY ,\n" +
                "    tipo varchar(40) not null,\n" +
                "    nombre varchar(40) not null,\n" +
                "    color varchar(10),\n" +
                "    edad int not null ,\n" +
                "    num_enfermedades int not null \n" +
                ");";

        Statement stm = connection.createStatement();
        stm.execute(query);
    }

    public int insertaAnimal(Animal animal, Connection connection) throws SQLException {
        String query = "insert into animales values (?,?,?,?,?,?)";
        PreparedStatement pstm = connection.prepareStatement(query);
        pstm.setInt(1,animal.getIdAnimal());
        pstm.setString(2,animal.getTipo());
        pstm.setString(3,animal.getNombre());
        pstm.setString(4,animal.getColor());
        pstm.setInt(5,animal.getEdad());
        pstm.setInt(6,animal.getNumEnfermedades());

        return pstm.executeUpdate();

    }

}
