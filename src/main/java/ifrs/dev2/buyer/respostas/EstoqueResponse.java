package ifrs.dev2.buyer.respostas;

import java.util.List;

public class EstoqueResponse {

    private ifrs.dev2.buyer.dados.Estoque     dados;
    private List<ifrs.dev2.buyer.dados.Estoque>   dadosLista;
    private ifrs.dev2.buyer.erros.ErroBase  erro;

    public EstoqueResponse(ifrs.dev2.buyer.dados.Estoque _dados, ifrs.dev2.buyer.erros.ErroBase _erro, List<ifrs.dev2.buyer.dados.Estoque> _dadosLista)
    {
        setDados(_dados);
        setDadosLista(_dadosLista);
        setErro(_erro);
    }

    public ifrs.dev2.buyer.dados.Estoque getDados() {
        return dados;
    }

    public void setDados(ifrs.dev2.buyer.dados.Estoque dados) {
        this.dados = dados;
    }

    public List<ifrs.dev2.buyer.dados.Estoque> getDadosLista() {
        return dadosLista;
    }

    public void setDadosLista(List<ifrs.dev2.buyer.dados.Estoque> dadosLista) {
        this.dadosLista = dadosLista;
    }

    public ifrs.dev2.buyer.erros.ErroBase getErro() {
        return erro;
    }

    public void setErro(ifrs.dev2.buyer.erros.ErroBase erro) {
        this.erro = erro;
    }
}
