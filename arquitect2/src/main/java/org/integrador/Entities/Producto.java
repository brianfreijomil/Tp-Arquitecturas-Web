package org.integrador.Entities;

public class Producto {

    private Integer idProducto;
    private String name;
    private Float value;

    public Producto(Integer idProducto, String name, Float value){
        this.idProducto = idProducto;
        this.name = name;
        this.value = value;
    }

    public Producto(){}

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.getIdProducto()+ " " + this.getName() + " " + this.getValue() ;
    }
}
