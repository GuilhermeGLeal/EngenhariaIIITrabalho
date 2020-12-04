package trabengIII.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabengIII.Banco.Conexao;
import trabengIII.Entity.Caixa;
import trabengIII.Entity.Cliente;

public class DALCaixa {
    public boolean gravar(Caixa c)
    {
        boolean res = false;
        
        String sql = "insert into caixa(cai_abertura,cai_fechamento,"
                + "cai_inicial,cai_final) values ('#2',#3,#4,#5)";
        sql = sql.replaceAll("#2", ""+c.getAbertura());
        sql = sql.replaceAll("#3", ""+c.getFechamento());
        sql = sql.replaceAll("#4", ""+c.getInicial());
        sql = sql.replaceAll("#5", ""+c.getVfinal());
        
        Conexao con = Conexao.getConexao();
        res = con.manipular(sql);
        con.desconectar();
        return res;        
    }
    
    public boolean alterar(Caixa c)
    {
        boolean res = false;
        
        String sql = "update caixa set cai_abertura='#1',cai_fechamento=#2,cai_inicial=#3,cai_final=#4 where cai_id="+c.getId();
        
        sql = sql.replaceAll("#1", ""+c.getAbertura());
        sql = sql.replaceAll("#2", ""+c.getFechamento());
        sql = sql.replaceAll("#3", ""+c.getInicial());
        sql = sql.replaceAll("#4", ""+c.getVfinal());
        
        Conexao con = Conexao.getConexao();
        res = con.manipular(sql);
        con.desconectar();
        return res;
    }
    
    public boolean apagar(Caixa c)
    {
        boolean res = false;
        Conexao con = Conexao.getConexao();
        res = con.manipular("delete from caixa where cai_id="+c.getId());
        con.desconectar();
        return res;
    }
    
    public Caixa get(int cod)
    {
        Caixa aux = null;
        
        Conexao con = Conexao.getConexao();
        ResultSet rs = con.consultar("select * from caixa where cai_id="+cod);
        con.desconectar();
        try 
        {
            if(rs.next())
            {
                aux = new Caixa(rs.getInt("cai_id"), rs.getDate("cai_abertura").toLocalDate(), rs.getDate("cai_fechamento").toLocalDate(),
                                    rs.getDouble("cai_inicial"), rs.getDouble("cai_final"));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        return aux;
    }
}
