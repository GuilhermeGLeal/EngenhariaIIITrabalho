package trabengIII.Entity;

import trabengIII.Interface.Observador;

public class Cliente implements Observador{
    
    private int cli_id;
    private String cli_nome;
    private String cli_cpf;
    private String cli_email;
    private String cli_cep;
    private String cli_fone;

    public Cliente() {
    }

    public Cliente(int cli_id, String cli_nome, String cli_cpf, String cli_email, String cli_cep, String cli_fone) {
        this.cli_id = cli_id;
        this.cli_nome = cli_nome;
        this.cli_cpf = cli_cpf;
        this.cli_email = cli_email;
        this.cli_cep = cli_cep;
        this.cli_fone = cli_fone;
    }

    public int getCli_id() {
        return cli_id;
    }

    public void setCli_id(int cli_id) {
        this.cli_id = cli_id;
    }

    public String getCli_nome() {
        return cli_nome;
    }

    public void setCli_nome(String cli_nome) {
        this.cli_nome = cli_nome;
    }

    public String getCli_cpf() {
        return cli_cpf;
    }

    public void setCli_cpf(String cli_cpf) {
        this.cli_cpf = cli_cpf;
    }

    public String getCli_email() {
        return cli_email;
    }

    public void setCli_email(String cli_email) {
        this.cli_email = cli_email;
    }

    public String getCli_cep() {
        return cli_cep;
    }

    public void setCli_cep(String cli_cep) {
        this.cli_cep = cli_cep;
    }

    public String getCli_fone() {
        return cli_fone;
    }

    public void setCli_fone(String cli_fone) {
        this.cli_fone = cli_fone;
    }

    @Override
    public String atualizar(TipoProduto tip, double desconto) {
       
        return "Leite do tipo "+tip.getTip_descricao()+"está com desconto de "+desconto+"% !!";
    }

    @Override
    public String toString() {
        return this.cli_nome;
    }
    
    
}
