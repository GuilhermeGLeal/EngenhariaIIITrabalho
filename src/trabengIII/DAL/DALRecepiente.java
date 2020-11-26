package trabengIII.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabengIII.Banco.Conexao;
import trabengIII.Entity.RecipienteProduto;


public class DALRecepiente {
    
     public boolean inserir(RecipienteProduto recp){
        
        boolean resultado = false;
        
        String sql = "insert into recipiente values(default, '#2')";
        sql = sql.replaceAll("#2", recp.getRec_descricao());
        
        Conexao con = Conexao.getConexao();
        resultado = con.manipular(sql);
        
        con.desconectar();
        
        return resultado;
    }
     
      public boolean atualizar(RecipienteProduto recp){
        
        boolean resultado = false;
        String sql = "update recipiente set rec_descricao = '#1' where rec_id = "+recp.getRec_id();
         
        sql = sql.replaceAll("#1", recp.getRec_descricao());
        
        Conexao con = Conexao.getConexao();
        resultado = con.manipular(sql);
            
        con.desconectar();
        
        return resultado;
    }
      
       public boolean apagar(int id){
        
        boolean res = false;
        Conexao con = Conexao.getConexao();
        con.manipular("delete from recipiente where rec_id="+id);         
        con.desconectar();
        return res;
        
    }
       
    public RecipienteProduto get(int id){
     
        RecipienteProduto aux = null;
        Conexao con = Conexao.getConexao();
        ResultSet rs = con.consultar("select * from recipiente where rec_id="+id);
        con.desconectar();
        
        try 
        {
            if(rs.next())
            {
                   aux = new RecipienteProduto(rs.getInt("rec_id"), rs.getString("rec_descricao"));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
    
    public List<RecipienteProduto> get(String filtro){
        
        String sql="select * from recipiente";
        
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        
        List <RecipienteProduto> recipientes = new ArrayList();
        Conexao con = Conexao.getConexao();
        ResultSet rs = con.consultar(sql);
        con.desconectar();
        
        try 
        {
            while(rs.next())
            {
                recipientes.add(new RecipienteProduto(rs.getInt("rec_id"), rs.getString("rec_descricao")));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return recipientes;
    }
}
