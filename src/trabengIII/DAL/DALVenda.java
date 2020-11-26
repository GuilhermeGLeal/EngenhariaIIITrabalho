package trabengIII.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import trabengIII.Banco.Conexao;
import trabengIII.Entity.Atacado;
import trabengIII.Entity.ItensVenda;
import trabengIII.Entity.Operacao;
import trabengIII.Entity.Varejo;

public class DALVenda {
    public boolean gravar(Operacao o)
    {
        boolean res = false;
        
        String sql = "insert into venda(ven_id,ven_cli,ven_valor,ven_data,ven_tipo) values (#1,#2,#3,'#4',#5)";
        sql = sql.replaceAll("#1", ""+o.getVen_id());
        sql = sql.replaceAll("#2", ""+o.getVen_cli().getCli_id());
        sql = sql.replaceAll("#3", ""+o.getVen_total());
        sql = sql.replaceAll("#4", ""+o.getVen_data());
        sql = sql.replaceAll("#5", ""+o.getVen_tipo());
        
        Conexao con = Conexao.getConexao();
        res = con.manipular(sql);
        
        
        res = gravarItens(o.getItens(),'I',o.getVen_id());
        con.desconectar();
        
        return res;        
    }
    
    public boolean inserir(ItensVenda i)
    {
        boolean res = false;
        
        String sql = "insert into itens(ite_ven, ite_pro, ite_quantidade) values (#1,#2,#3)";
        sql = sql.replaceAll("#1", ""+i.getVend().getVen_id());
        sql = sql.replaceAll("#2", ""+i.getProd().getPro_id());
        sql = sql.replaceAll("#3", ""+i.getQtd());
        
        Conexao con = Conexao.getConexao();
        res = con.manipular(sql);
            
        
        return res;        
    }
    
    public boolean gravarItens(List<ItensVenda> itens, char op, int id) {

        boolean ok = true;

        try {
            
            Conexao con = Conexao.getConexao();
            
            con.getConnect().setAutoCommit(false);
           
            if(op == 'A')
            {
                ok = con.manipular("delete * from itens where ite_ven="+id);
            }            
            if (ok) {

                for (int i = 0; i < itens.size() && ok; i++) {

                    ok = inserir(itens.get(i));
                }
            }

            if (ok) {
                con.getConnect().commit();
            } else {
                con.getConnect().rollback();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            ok = false;
        }

        return ok;
    }
    
    
    
    
    public boolean alterar(Operacao o)
    {
        boolean res = false;
        
        String sql = "update venda set ven_cli=#1,ven_valor=#2,ven_data='#3',ven_tipo=#4 where ven_id="+o.getVen_id();
        sql = sql.replaceAll("#1", ""+o.getVen_cli().getCli_id());
        sql = sql.replaceAll("#2", ""+o.getVen_total());
        sql = sql.replaceAll("#3", ""+o.getVen_data());
        sql = sql.replaceAll("#4", ""+o.getVen_tipo());
        
        Conexao con = Conexao.getConexao();
        res = con.manipular(sql);
        res = gravarItens(o.getItens(),'A',o.getVen_id());
        
        con.desconectar();
        return res;
    }
    
    public boolean apagar(Operacao o)
    {
        boolean res = false;
        Conexao con = Conexao.getConexao();
        res = con.manipular("delete * from venda where cli_id="+o.getVen_id());
        res = con.manipular("delete * from itens where ite_ven="+o.getVen_id());
        con.desconectar();
        return res;
    }
    
    public Operacao get(int cod)
    {
        Operacao aux = null;
        
        Conexao con = Conexao.getConexao();
        ResultSet rs = con.consultar("select * from venda where ven_id="+cod);
        con.desconectar();
        try 
        {
            DALCliente dal = new DALCliente();
            if(rs.next())
            {
                if(rs.getString("ven_tipo").charAt(0) == 'A')
                {
                    aux = new Atacado(rs.getInt("ven_id"),dal.get(rs.getInt("ven_cli")),rs.getDouble("ven_valor"),
                                rs.getDate("ven_data").toLocalDate(), rs.getString("ven_tipo").charAt(0));
                }
                else
                {
                    aux = new Varejo(rs.getInt("ven_id"),dal.get(rs.getInt("ven_cli")),rs.getDouble("ven_valor"),
                                rs.getDate("ven_data").toLocalDate(), rs.getString("ven_tipo").charAt(0));
                }
                
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        return aux;
    }
    
    public List<ItensVenda> getItens(int cod)
    {
        String sql="select * from itens";
        if(cod>-1)
            sql+=" where ite_ven="+cod;
        List <ItensVenda> aux = new ArrayList();
        Conexao con = Conexao.getConexao();
        ResultSet rs = con.consultar(sql);
        con.desconectar();
        try 
        {
            DALProduto dal = new DALProduto();
            while(rs.next())
            {
                aux.add(new ItensVenda(dal.get(rs.getInt("ite_pro")), rs.getInt("ite_quantidade")));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
}
