package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Ciudad {
    @Id
    private int codigo_postal;
    @Column(nullable = false)
    private String name;

    public Ciudad() {
    }

    public Ciudad(int codigo_postal, String name) {
        this.codigo_postal = codigo_postal;
        this.name = name;
    }

    public int getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(int codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ciudad{" +
                "codigo_postal=" + codigo_postal +
                ", name='" + name + '\'' +
                '}';
    }
}

