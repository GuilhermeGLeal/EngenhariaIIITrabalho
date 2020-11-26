package trabengIII.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabengIII.Banco.Conexao;
import trabengIII.Entity.UnidadeMedida;


public class DALMedida {
    
     public boolean inserir(UnidadeMedida med){
        
        boolean resultado = false;
        
        String sql = "insert into medida values(default, '#2')";
        sql = sql.replaceAll("#2", med.getUni_descricao());
        
        Conexao con = Conexao.getConexao();
        resultado = con.manipular(sql);
        
        con.desconectar();
        
        return resultado;
    }
     
      public boolean atualizar(UnidadeMedida med){
        
        boolean resultado = false;
        String sql = "update medida set med_descricao = '#1' where tip_id = "+med.getUni_id();
         
        sql = sql.replaceAll("#1", med.getUni_descricao());
        
        Conexao con = Conexao.getConexao();
        resultado = con.manipular(sql);
            
        con.desconectar();
        
        return resultado;
    }
      
       public boolean apagar(int id){
        
        boolean res = false;
        Conexao con = Conexao.getConexao();
        con.manipular("delete from medida where med_id="+id);         
        con.desconectar();
        return res;
        
    }
       public UnidadeMedida get(int id){
     
        UnidadeMedida aux = null;
        Conexao con = Conexao.getConexao();
        ResultSet rs = con.consultar("select * from medida where med_id="+id);
        con.desconectar();
        
        try 
        {
            if(rs.next())
            {
                   aux = new UnidadeMedida(rs.getInt("med_id"), rs.getString("med_descricao"));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
    
    public List<UnidadeMedida> get(String filtro){
        
        String sql="select * from medida";
        
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        
        List <UnidadeMedida> unidades = new ArrayList();
        Conexao con = Conexao.getConexao();
        ResultSet rs = con.consultar(sql);
        con.desconectar();
        
        try 
        {
            while(rs.next())
            {
                unidades.add(new UnidadeMedida(rs.getInt("med_id"), rs.getString("med_descricao")));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return unidades;
    }

}
