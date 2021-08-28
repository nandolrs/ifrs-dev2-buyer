package ifrs.dev2.buyer.respostas;

import java.util.List;

public class EstoquePorClasseResponse {

    private ifrs.dev2.buyer.info.EstoquePorClasse     dados;
    private List<ifrs.dev2.buyer.info.EstoquePorClasse>   dadosLista;
    private ifrs.dev2.buyer.erros.ErroBase  erro;

    public EstoquePorClasseResponse(ifrs.dev2.buyer.info.EstoquePorClasse _dados, ifrs.dev2.buyer.erros.ErroBase _erro, List<ifrs.dev2.buyer.info.EstoquePorClasse> _dadosLista)
    {
        setDados(_dados);
        setDadosLista(_dadosLista);
        setErro(_erro);
    }

    public ifrs.dev2.buyer.info.EstoquePorClasse getDados() {
        return dados;
    }

    public void setDados(ifrs.dev2.buyer.info.EstoquePorClasse dados) {
        this.dados = dados;
    }

    public List<ifrs.dev2.buyer.info.EstoquePorClasse> getDadosLista() {
        return dadosLista;
    }

    public void setDadosLista(List<ifrs.dev2.buyer.info.EstoquePorClasse> dadosLista) {
        this.dadosLista = dadosLista;
    }

    public ifrs.dev2.buyer.erros.ErroBase getErro() {
        return erro;
    }

    public void setErro(ifrs.dev2.buyer.erros.ErroBase erro) {
        this.erro = erro;
    }
}
