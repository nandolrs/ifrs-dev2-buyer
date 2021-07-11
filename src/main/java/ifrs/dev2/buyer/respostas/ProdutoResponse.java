package ifrs.dev2.buyer.respostas;

import java.util.List;

public class ProdutoResponse {

    private ifrs.dev2.buyer.dados.Produto     dados;
    private List<ifrs.dev2.buyer.dados.Produto>   dadosLista;
    private ifrs.dev2.buyer.erros.ErroBase  erro;

    public ProdutoResponse(ifrs.dev2.buyer.dados.Produto _dados, ifrs.dev2.buyer.erros.ErroBase _erro, List<ifrs.dev2.buyer.dados.Produto> _dadosLista)
    {
        setDados(_dados);
        setDadosLista(_dadosLista);
        setErro(_erro);
    }

    public ifrs.dev2.buyer.dados.Produto getDados() {
        return dados;
    }

    public void setDados(ifrs.dev2.buyer.dados.Produto dados) {
        this.dados = dados;
    }

    public List<ifrs.dev2.buyer.dados.Produto> getDadosLista() {
        return dadosLista;
    }

    public void setDadosLista(List<ifrs.dev2.buyer.dados.Produto> dadosLista) {
        this.dadosLista = dadosLista;
    }

    public ifrs.dev2.buyer.erros.ErroBase getErro() {
        return erro;
    }

    public void setErro(ifrs.dev2.buyer.erros.ErroBase erro) {
        this.erro = erro;
    }
}
