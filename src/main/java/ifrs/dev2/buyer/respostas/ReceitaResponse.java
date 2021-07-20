package ifrs.dev2.buyer.respostas;

import ifrs.dev2.buyer.dados.Receita;

import java.util.List;

public class ReceitaResponse {
    private ifrs.dev2.buyer.dados.Receita dados;
    private List<Receita> dadosLista;
    private ifrs.dev2.buyer.erros.ErroBase erro;

    public ReceitaResponse(ifrs.dev2.buyer.dados.Receita _dados, ifrs.dev2.buyer.erros.ErroBase _erro, List<ifrs.dev2.buyer.dados.Receita> _dadosLista) {
        setDados(_dados);
        setDadosLista(_dadosLista);
        setErro(_erro);
    }

    public ifrs.dev2.buyer.dados.Receita getDados() {
        return dados;
    }

    public void setDados(ifrs.dev2.buyer.dados.Receita dados) {
        this.dados = dados;
    }

    public List<ifrs.dev2.buyer.dados.Receita> getDadosLista() {
        return dadosLista;
    }

    public void setDadosLista(List<ifrs.dev2.buyer.dados.Receita> dadosLista) {
        this.dadosLista = dadosLista;
    }

    public ifrs.dev2.buyer.erros.ErroBase getErro() {
        return erro;
    }

    public void setErro(ifrs.dev2.buyer.erros.ErroBase erro) {
        this.erro = erro;
    }
}


