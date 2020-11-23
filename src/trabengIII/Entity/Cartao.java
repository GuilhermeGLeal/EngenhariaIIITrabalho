package trabengIII.Entity;

import java.time.LocalDate;
import trabengIII.Interface.ReceberPagar;

public class Cartao implements ReceberPagar{
    private int id;
    private Venda venda;
    private char tipo;
    private LocalDate emisao;
    private LocalDate pagamento;
    private double recebimento;
    private char tipo_pagamento;
    private double desconto;

    public Cartao() {
    }

    public Cartao(int id, Venda venda, char tipo, LocalDate emisao, LocalDate pagamento, double recebimento, char tipo_pagamento, double desconto) {
        this.id = id;
        this.venda = venda;
        this.tipo = tipo;
        this.emisao = emisao;
        this.pagamento = pagamento;
        this.recebimento = recebimento;
        this.tipo_pagamento = tipo_pagamento;
        this.desconto = desconto;
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

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
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

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public void efetuarOperacao() {
      
    }
}
