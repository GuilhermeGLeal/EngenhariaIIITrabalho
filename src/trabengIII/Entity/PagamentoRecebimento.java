package trabengIII.Entity;

import java.time.LocalDate;


public class PagamentoRecebimento {
    private int id;
    private Operacao venda;
    private char tipo;
    private LocalDate emissao;
    private LocalDate pagamento;
    private double recebimento;
    private char tipo_pagamento;

    public PagamentoRecebimento() {
    }

    public PagamentoRecebimento(int id, Operacao venda, char tipo, LocalDate emissao, LocalDate pagamento, double recebimento, char tipo_pagamento) {
        this.id = id;
        this.venda = venda;
        this.tipo = tipo;
        this.emissao = emissao;
        this.pagamento = pagamento;
        this.recebimento = recebimento;
        this.tipo_pagamento = tipo_pagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Operacao getVenda() {
        return venda;
    }

    public void setVenda(Operacao venda) {
        this.venda = venda;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public LocalDate getEmissao() {
        return emissao;
    }

    public void setEmissao(LocalDate emissao) {
        this.emissao = emissao;
    }

    public LocalDate getPagamento() {
        return pagamento;
    }

    public void setPagamento(LocalDate pagamento) {
        this.pagamento = pagamento;
    }

    public double getRecebimento() {
        return recebimento;
    }

    public void setRecebimento(double recebimento) {
        this.recebimento = recebimento;
    }

    public char getTipo_pagamento() {
        return tipo_pagamento;
    }

    public void setTipo_pagamento(char tipo_pagamento) {
        this.tipo_pagamento = tipo_pagamento;
    }
}
