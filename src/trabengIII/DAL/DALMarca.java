package trabengIII.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabengIII.Banco.Conexao;
import trabengIII.Entity.MarcaProduto;


public class DALMarca {
    
      public boolean inserir(MarcaProduto marca){
        
        boolean resultado = false;
        
        String sql = "insert into marca values(default, '#2')";
        sql = sql.replaceAll("#2", marca.getMar_descricao());
        
        Conexao con = Conexao.getConexao();
        resultado = con.manipular(sql);
        
        con.desconectar();
        
        return resultado;
    }
     
      public boolean atualizar(MarcaProduto marca){
        
        boolean resultado = false;
        String sql = "update marca set mar_descricao = '#1' where mar_id = "+marca.getMar_id();
         
        sql = sql.replaceAll("#1", marca.getMar_descricao());
        
        Conexao con = Conexao.getConexao();
        resultado = con.manipular(sql);
            
        con.desconectar();
        
        return resultado;
    }
      
       public boolean apagar(int id){
        
        boolean res = false;
        Conexao con = Conexao.getConexao();
        con.manipular("delete from marca where mar_id="+id);         
        con.desconectar();
        return res;
        
    }
       
    public MarcaProduto get(int id){
     
        MarcaProduto aux = null;
        Conexao con = Conexao.getConexao();
        ResultSet rs = con.consultar("select * from marca where mar_id="+id);
        con.desconectar();
        
        try 
        {
            if(rs.next())
            {
                   aux = new MarcaProduto(rs.getInt("mar_id"), rs.getString("mar_descricao"));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
    
    public List<MarcaProduto> get(String filtro){
        
        String sql="select * from marca";
        
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        
        List <MarcaProduto> marcas = new ArrayList();
        Conexao con = Conexao.getConexao();
        ResultSet rs = con.consultar(sql);
        con.desconectar();
        
        try 
        {
            while(rs.next())
            {
                marcas.add(new MarcaProduto(rs.getInt("mar_id"), rs.getString("mar_descricao")));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return marcas;
    }
}
