package ifrs.dev2.buyer.respostas;

import java.util.List;
import java.util.Optional;

public class LocalResponse {

    private ifrs.dev2.buyer.dados.Local     dados;
    private List<ifrs.dev2.buyer.dados.Local>   dadosLista;
    private ifrs.dev2.buyer.erros.ErroBase  erro;

    public LocalResponse(ifrs.dev2.buyer.dados.Local _dados, ifrs.dev2.buyer.erros.ErroBase _erro, List<ifrs.dev2.buyer.dados.Local> _dadosLista)
    {
        setDados(_dados);
        setDadosLista(_dadosLista);
        setErro(_erro);
    }

    public ifrs.dev2.buyer.dados.Local getDados() {
        return dados;
    }

    public void setDados(ifrs.dev2.buyer.dados.Local dados) {
        this.dados = dados;
    }

    public List<ifrs.dev2.buyer.dados.Local> getDadosLista() {
        return dadosLista;
    }

    public void setDadosLista(List<ifrs.dev2.buyer.dados.Local> dadosLista) {
        this.dadosLista = dadosLista;
    }

    public ifrs.dev2.buyer.erros.ErroBase getErro() {
        return erro;
    }

    public void setErro(ifrs.dev2.buyer.erros.ErroBase erro) {
        this.erro = erro;
    }
}
