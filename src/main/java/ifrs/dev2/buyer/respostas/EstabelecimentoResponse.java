package ifrs.dev2.buyer.respostas;

import java.util.List;

public class EstabelecimentoResponse {

    private ifrs.dev2.buyer.dados.Estabelecimento     dados;
    private List<ifrs.dev2.buyer.dados.Estabelecimento>   dadosLista;
    private ifrs.dev2.buyer.erros.ErroBase  erro;

    public EstabelecimentoResponse(ifrs.dev2.buyer.dados.Estabelecimento _dados, ifrs.dev2.buyer.erros.ErroBase _erro, List<ifrs.dev2.buyer.dados.Estabelecimento> _dadosLista)
    {
        setDados(_dados);
        setDadosLista(_dadosLista);
        setErro(_erro);
    }

    public ifrs.dev2.buyer.dados.Estabelecimento getDados() {
        return dados;
    }

    public void setDados(ifrs.dev2.buyer.dados.Estabelecimento dados) {
        this.dados = dados;
    }

    public List<ifrs.dev2.buyer.dados.Estabelecimento> getDadosLista() {
        return dadosLista;
    }

    public void setDadosLista(List<ifrs.dev2.buyer.dados.Estabelecimento> dadosLista) {
        this.dadosLista = dadosLista;
    }

    public ifrs.dev2.buyer.erros.ErroBase getErro() {
        return erro;
    }

    public void setErro(ifrs.dev2.buyer.erros.ErroBase erro) {
        this.erro = erro;
    }
}
