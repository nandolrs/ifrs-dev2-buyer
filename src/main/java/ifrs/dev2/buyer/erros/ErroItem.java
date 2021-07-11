package ifrs.dev2.buyer.erros;

public class ErroItem {

    private String atributo;
    private String mensagem;
    private long codigo;

    public ErroItem()
    {

    }

    public ErroItem(String atributo, String mensagem, Long codigo)
    {
        this.atributo = atributo;
        this.mensagem = mensagem;
        this.codigo =codigo;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }
}
