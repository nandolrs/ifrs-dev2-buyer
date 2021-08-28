package ifrs.dev2.buyer.info;

public class EstoquePorClasse {

    private Long classeId;
    private String classeNome;
    private Float estoqueQuantidade;

    // classe

    public Long getClasseId() {
        return classeId;
    }

    public void setClasseId(Long classeId) {
        this.classeId = classeId;
    }

    public String getClasseNome() {
        return classeNome;
    }

    public void setClasseNome(String classeNome) {
        this.classeNome = classeNome;
    }

    // estoque

    public Float getEstoqueQuantidade() {
        return estoqueQuantidade;
    }

    public void setEstoqueQuantidade(Float estoqueQuantidade) {
        this.estoqueQuantidade = estoqueQuantidade;
    }
}
