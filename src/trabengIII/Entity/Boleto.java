package trabengIII.Entity;

import java.time.LocalDate;

public class Boleto {
    private int id;
    private Venda venda;
    private String tipo;
    private LocalDate emisao;
    private LocalDate pagamento;
    private double recebimento;
    private char tipo_pagamento;
    private double juros;

    public Boleto() {
    }

    public Boleto(int id, Venda venda, String tipo, LocalDate emisao, LocalDate pagamento, double recebimento, char tipo_pagamento, double juros) {
        this.id = id;
        this.venda = venda;
        this.tipo = tipo;
        this.emisao = emisao;
        this.pagamento = pagamento;
        this.recebimento = recebimento;
        this.tipo_pagamento = tipo_pagamento;
        this.juros = juros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getEmisao() {
        return emisao;
    }

    public void setEmisao(LocalDate emisao) {
        this.emisao = emisao;
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

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }
}
