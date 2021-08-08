package ifrs.dev2.buyer.dados;
import ifrs.dev2.buyer.dados.Usuario;


import javax.persistence.*;
import java.util.Date;

@Entity // This tells Hibernate to make a table out of this class
public class UsuarioAutenticador {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;

    private Date dataLogin;

    private String sessao;

    private Date tempoSessao;

    @OneToOne
    private Usuario usuario;


    public Long getId()
    {
        return this.id;
    }
    public void setId(Long valor)
    {
        this.id=valor;
    }

    public Date getDatalogin() { return this.dataLogin; }
    public void setDatalogin(Date valor)
    {
        this.dataLogin=valor;
    }

    public String getSessao() { return this.sessao; }
    public void setSessao(String valor)
    {
        this.sessao=valor;
    }

    public Date getTempoSessao() { return this.tempoSessao; }
    public void setTempoSessao(Date valor)
    {
        this.tempoSessao=valor;
    }


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
