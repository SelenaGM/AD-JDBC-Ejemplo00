package com.cieep.modelos;

public class Empleado {

    private String dni;
    private String empleo;
    private String nombre;
    private int horas_semanales;

    public Empleado(String dni, String empleo, String nombre, int horas_semanales) {
        this.dni = dni;
        this.empleo = empleo;
        this.nombre = nombre;
        this.horas_semanales = horas_semanales;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmpleo() {
        return empleo;
    }

    public void setEmpleo(String empleo) {
        this.empleo = empleo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHoras_semanales() {
        return horas_semanales;
    }

    public void setHoras_semanales(int horas_semanales) {
        this.horas_semanales = horas_semanales;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "dni='" + dni + '\'' +
                ", empleo='" + empleo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", horas_semanales=" + horas_semanales +
                '}';
    }
}
