package trabengIII.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabengIII.Banco.Conexao;
import trabengIII.Entity.Cliente;
import trabengIII.Entity.Produto;

public class DALProduto {
         
        public boolean gravar(Produto p)
    {
        boolean res = false;
        
        String sql = "insert into produto(pro_id,pro_nome,pro_preco,pro_quantidade,pro_medida,pro_recipiente,pro_marca,pro_tipo) "
                + "values (#1,'#2',#3,#4,#5,#6,#7,#8)";
        
        sql = sql.replaceAll("#1", ""+p.getPro_id());
        sql = sql.replaceAll("#2", ""+p.getPro_nome());
        sql = sql.replaceAll("#3", ""+p.getPro_preco());
        sql = sql.replaceAll("#4", ""+p.getPro_qtd());
        sql = sql.replaceAll("#5", ""+p.getUni_pro().getUni_id());
        sql = sql.replaceAll("#6", ""+p.getRec_pro().getRec_id());
        sql = sql.replaceAll("#7", ""+p.getMar_pro().getMar_id());
        sql = sql.replaceAll("#8", ""+p.getTip_pro().getTip_id());
        
        Conexao con = Conexao.getConexao();
        res = con.manipular(sql);
        con.desconectar();
        return res;        
    }
    
    public boolean alterar(Produto p)
    {
        boolean res = false;
        
        String sql = "update produto set pro_nome='#1',pro_preco=#2,pro_quantidade=#3,"
                + "pro_medida=#4,pro_recipiente=#5,pro_marca=#6,pro_tipo=#7 where cli_id="+p.getPro_id();
        
        sql = sql.replaceAll("#1", ""+p.getPro_nome());
        sql = sql.replaceAll("#2", ""+p.getPro_preco());
        sql = sql.replaceAll("#3", ""+p.getPro_qtd());
        sql = sql.replaceAll("#4", ""+p.getUni_pro().getUni_id());
        sql = sql.replaceAll("#5", ""+p.getRec_pro().getRec_id());
        sql = sql.replaceAll("#6", ""+p.getMar_pro().getMar_id());
        sql = sql.replaceAll("#7", ""+p.getTip_pro().getTip_id());
        
        Conexao con = Conexao.getConexao();
        res = con.manipular(sql);
        con.desconectar();
        return res;
    }
    
    public boolean apagar(Produto p)
    {
        boolean res = false;
        Conexao con = Conexao.getConexao();
        res = con.manipular("delete from produto where pro_id="+p.getPro_id());
        con.desconectar();
        return res;
    }
    
    public Produto get(int cod)
    {
        Produto aux = null;
        
        Conexao con = Conexao.getConexao();
        ResultSet rs = con.consultar("select * from produto where pro_id="+cod);
        con.desconectar();
        try 
        {
//            DALTipo dalT = new DALTipo();
//            DALRecipiente dalR = new DALRecipiente();
//            DALMedida dalMe = new DALMedida();
//            DALMarca dalMa = new DALMarca();
            
            if(rs.next())
            {
//                aux = new Produto(rs.getInt("pro_id"),rs.getString("pro_nome"), rs.getDouble("pro_preco"), rs.getInt("pro_quantidade"),
//                         dalT.get(rs.getInt("pro_tipo")), dalMa.get(rs.getInt("pro_marca")), dalR.get(rs.getInt("pro_recipiente")), 
//                            dalMe.get(rs.getInt("pro_medida")));
                
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        return aux;
    }
    
    public List<Produto> get(String filtro)
    {
        String sql="select * from produto";
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        List <Produto> aux = new ArrayList();
        Conexao con = Conexao.getConexao();
        ResultSet rs = con.consultar(sql);
        con.desconectar();;
        try 
        {
//            DALTipo dalT = new DALTipo();
//            DALRecipiente dalR = new DALRecipiente();
//            DALMedida dalMe = new DALMedida();
//            DALMarca dalMa = new DALMarca();
            
            while(rs.next())
            {
//                aux.add(new Produto(rs.getInt("pro_id"),rs.getString("pro_nome"), rs.getDouble("pro_preco"), rs.getInt("pro_quantidade"),
//                         dalT.get(rs.getInt("pro_tipo")), dalMa.get(rs.getInt("pro_marca")), dalR.get(rs.getInt("pro_recipiente")), 
//                            dalMe.get(rs.getInt("pro_medida")));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
    
    
}
