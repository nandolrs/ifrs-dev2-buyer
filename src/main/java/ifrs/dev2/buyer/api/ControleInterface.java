package ifrs.dev2.buyer.api;

import ifrs.dev2.buyer.dados.DadoInterface;

public interface ControleInterface {
    public <List> DadoInterface Pesquisar(DadoInterface entidade);
    public DadoInterface Consultar(Long id);
    public DadoInterface Salvar(DadoInterface entidade);
    public DadoInterface Excluir(Long id);
}
