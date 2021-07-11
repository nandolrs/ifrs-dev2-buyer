package ifrs.dev2.buyer.respostas;

import java.util.List;

public class ClasseResponse {

    private ifrs.dev2.buyer.dados.Classe     dados;
    private List<ifrs.dev2.buyer.dados.Classe>   dadosLista;
    private ifrs.dev2.buyer.erros.ErroBase  erro;

    public ClasseResponse(ifrs.dev2.buyer.dados.Classe _dados, ifrs.dev2.buyer.erros.ErroBase _erro, List<ifrs.dev2.buyer.dados.Classe> _dadosLista)
    {
        setDados(_dados);
        setDadosLista(_dadosLista);
        setErro(_erro);
    }

    public ifrs.dev2.buyer.dados.Classe getDados() {
        return dados;
    }

    public void setDados(ifrs.dev2.buyer.dados.Classe dados) {
        this.dados = dados;
    }

    public List<ifrs.dev2.buyer.dados.Classe> getDadosLista() {
        return dadosLista;
    }

    public void setDadosLista(List<ifrs.dev2.buyer.dados.Classe> dadosLista) {
        this.dadosLista = dadosLista;
    }

    public ifrs.dev2.buyer.erros.ErroBase getErro() {
        return erro;
    }

    public void setErro(ifrs.dev2.buyer.erros.ErroBase erro) {
        this.erro = erro;
    }
}
