package trabengIII.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import trabengIII.Banco.Conexao;
import trabengIII.Entity.PagamentoRecebimento;

public class DALReceberPagar {
    public boolean gravar(PagamentoRecebimento c)
    {
        boolean res = false;
        
        String sql = "insert into conta(con_tipo,con_emissao,con_pagamento,con_valor,con_tpagamento,con_ven) "
                        + "values ('#2','#3','#4',#5,'#6',#7)";
        sql = sql.replaceAll("#2", ""+c.getTipo());
        sql = sql.replaceAll("#3", ""+c.getEmissao());
        sql = sql.replaceAll("#4", ""+c.getPagamento());
        sql = sql.replaceAll("#5", ""+c.getRecebimento());
        sql = sql.replaceAll("#6", ""+c.getTipo_pagamento());
        
        
        Conexao con = Conexao.getConexao();
        sql = sql.replaceAll("#7", ""+con.getMaxPK("venda","ven_id"));
        res = con.manipular(sql);
        con.desconectar();
        return res;        
    }
    
    public boolean alterar(PagamentoRecebimento c)
    {
        boolean res = false;
        
        String sql = "update conta set con_tipo=#1,con_emissao='#2',con_pagamento='#3',con_valor=#4,con_tpagamento=#5,con_ven=#6 where con_id="+c.getId();
        sql = sql.replaceAll("#1", ""+c.getTipo());
        sql = sql.replaceAll("#2", ""+c.getEmissao());
        sql = sql.replaceAll("#3", ""+c.getPagamento());
        sql = sql.replaceAll("#4", ""+c.getRecebimento());
        sql = sql.replaceAll("#5", ""+c.getTipo_pagamento());
        sql = sql.replaceAll("#6", ""+c.getVenda().getVen_id());
        
        Conexao con = Conexao.getConexao();
        res = con.manipular(sql);
        con.desconectar();
        return res;
    }
    
    public boolean apagar(PagamentoRecebimento c)
    {
        boolean res = false;
        Conexao con = Conexao.getConexao();
        res = con.manipular("delete from conta where con_id="+c.getId());
        con.desconectar();
        return res;
    }
    
    public PagamentoRecebimento get(int cod)
    {
        PagamentoRecebimento aux = null;
        
        Conexao con = Conexao.getConexao();
        ResultSet rs = con.consultar("select * from conta where con_id="+cod);
        con.desconectar();
        try 
        {
            DALVenda dalV = new DALVenda();
            if(rs.next())
            {
                aux = new PagamentoRecebimento( rs.getInt("con_id"), dalV.get(rs.getInt("con_venda")), rs.getString("con_tipo").charAt(0), 
                                                rs.getDate("con_emissao").toLocalDate(), rs.getDate("con_pagamento").toLocalDate(), 
                                                rs.getDouble("con_valor"), rs.getString("con_tpagamento").charAt(0));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        return aux;
    }
    
}
