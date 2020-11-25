package trabengIII.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabengIII.Banco.Conexao;
import trabengIII.Entity.Cliente;

public class DALCliente {
    
    public boolean gravar(Cliente c)
    {
        boolean res = false;
        
        String sql = "insert into cliente(cli_id,cli_nome,cli_cpf,cli_email,cli_cep,cli_fone) values (#1,'#2','#3','#4','#5','#6')";
        sql = sql.replaceAll("#1", ""+c.getCli_id());
        sql = sql.replaceAll("#2", ""+c.getCli_nome());
        sql = sql.replaceAll("#3", ""+c.getCli_cpf());
        sql = sql.replaceAll("#4", ""+c.getCli_email());
        sql = sql.replaceAll("#5", ""+c.getCli_cep());
        sql = sql.replaceAll("#6", ""+c.getCli_fone());
        
        Conexao con = Conexao.getConexao();
        res = con.manipular(sql);
        con.desconectar();
        return res;        
    }
    
    public boolean alterar(Cliente c)
    {
        boolean res = false;
        
        String sql = "update cliente set cli_nome='#1',cli_cpf='#2',cli_email='#3',cli_cep='#4',cli_fone='#5' where cli_id="+c.getCli_id();
        sql = sql.replaceAll("#1", ""+c.getCli_nome());
        sql = sql.replaceAll("#2", ""+c.getCli_cpf());
        sql = sql.replaceAll("#3", ""+c.getCli_email());
        sql = sql.replaceAll("#4", ""+c.getCli_cep());
        sql = sql.replaceAll("#5", ""+c.getCli_fone());
        
        Conexao con = Conexao.getConexao();
        res = con.manipular(sql);
        con.desconectar();
        return res;
    }
    
    public boolean apagar(Cliente c)
    {
        boolean res = false;
        Conexao con = Conexao.getConexao();
        res = con.manipular("delete from cliente where cli_id="+c.getCli_id());
        con.desconectar();
        return res;
    }
    
    public Cliente get(int cod)
    {
        Cliente aux = null;
        
        Conexao con = Conexao.getConexao();
        ResultSet rs = con.consultar("select * from cliente where cli_id="+cod);
        con.desconectar();
        try 
        {
            if(rs.next())
            {
                aux = new Cliente(rs.getInt("cli_id"),rs.getString("cli_nome"),rs.getString("cli_cpf"), rs.getString("cli_email"),
                            rs.getString("cli_cep"), rs.getString("cli_fone"));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        return aux;
    }
    
    public List<Cliente> get(String filtro)
    {
        String sql="select * from cliente";
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        List <Cliente> aux = new ArrayList();
        Conexao con = Conexao.getConexao();
        ResultSet rs = con.consultar(sql);
        con.desconectar();;
        try 
        {
            while(rs.next())
            {
                aux.add(new Cliente(rs.getInt("cli_id"),rs.getString("cli_nome"),rs.getString("cli_cpf"), rs.getString("cli_email"),
                            rs.getString("cli_cep"), rs.getString("cli_fone")));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
    
}
