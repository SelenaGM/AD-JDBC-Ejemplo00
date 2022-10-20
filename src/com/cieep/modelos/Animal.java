package com.cieep.modelos;

public class Animal {

    private int idAnimal;
    private String tipo;
    private String nombre;
    private String color;
    private int edad;
    private int numEnfermedades;


    public Animal(int idAnimal, String tipo, String nombre, String color, int edad, int numEnfermedades) {
        this.idAnimal = idAnimal;
        this.tipo = tipo;
        this.nombre = nombre;
        this.color = color;
        this.edad = edad;
        this.numEnfermedades = numEnfermedades;
    }

    public Animal(int idAnimal, String tipo, String nombre, int edad, int numEnfermedades) {
        this.idAnimal = idAnimal;
        this.tipo = tipo;
        this.nombre = nombre;
        this.edad = edad;
        this.numEnfermedades = numEnfermedades;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getNumEnfermedades() {
        return numEnfermedades;
    }

    public void setNumEnfermedades(int numEnfermedades) {
        this.numEnfermedades = numEnfermedades;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "idAnimal=" + idAnimal +
                ", tipo='" + tipo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", edad=" + edad +
                ", numEnfermedades=" + numEnfermedades +
                '}';
    }
}
