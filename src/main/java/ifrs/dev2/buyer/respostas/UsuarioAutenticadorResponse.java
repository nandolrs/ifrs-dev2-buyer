package ifrs.dev2.buyer.respostas;
import ifrs.dev2.buyer.dados.Usuario;
import ifrs.dev2.buyer.dados.UsuarioAutenticador;


import java.util.List;

public class UsuarioAutenticadorResponse {

    private String confirmacao;
    private ifrs.dev2.buyer.dados.UsuarioAutenticador    dados;
    private List<UsuarioAutenticador> dadosLista;
    private ifrs.dev2.buyer.erros.ErroBase  erro;


    public UsuarioAutenticadorResponse(ifrs.dev2.buyer.dados.UsuarioAutenticador _dados, ifrs.dev2.buyer.erros.ErroBase _erro, List<UsuarioAutenticador> _dadosLista)
    {
        setDados(_dados);
        setDadosLista(_dadosLista);
        setErro(_erro);
    }

    public ifrs.dev2.buyer.dados.UsuarioAutenticador getDados() {return dados;}

    public void setDados(ifrs.dev2.buyer.dados.UsuarioAutenticador dados) {
        this.dados = dados;
    }

    public List<ifrs.dev2.buyer.dados.UsuarioAutenticador> getDadosLista() {
        return dadosLista;
    }

    public void setDadosLista(List<ifrs.dev2.buyer.dados.UsuarioAutenticador> dadosLista) {
        this.dadosLista = dadosLista;
    }

    public ifrs.dev2.buyer.erros.ErroBase getErro() {return erro;
    }

    public void setErro(ifrs.dev2.buyer.erros.ErroBase erro) {
        this.erro = erro;
    }

    public String getConfirmacao() {
        return confirmacao;
    }

    public void setConfirmacao(String confirmacao) {
        this.confirmacao = confirmacao;
    }
}
