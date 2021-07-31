package ifrs.dev2.buyer.dados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    String nomeFantasia;
    private float latitude;
    private float longitude;

    // id

    public Long getId()
    {
        return this.id;
    }
    public void setId(Long valor)
    {
        this.id=valor;
    }

    // nome fantasia

    public String getNomeFantasia(){return this.nomeFantasia;}
    public void setNomeFantasia(String valor)
    {
        this.nomeFantasia=valor;
    }
    // latitude

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    // longitude

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
