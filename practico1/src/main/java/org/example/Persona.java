package org.example;

public class Persona {

    private String nombre;
    private int years;

    public Persona(String nombre, int years) {
        this.nombre=nombre;
        this.years=years;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return nombre+", "+years;
    }
}
