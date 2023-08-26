package org.integrador.Entities;

public class Cliente {

    private Integer idCliente;
    private String name;
    private String email;

    public Cliente(Integer id, String name, String email) {
        this.idCliente = id;
        this.name = name;
        this.email = email;
    }

    public Cliente(){}

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return this.getIdCliente() + " " + this.getName() + " " + this.getEmail();
    }
}
