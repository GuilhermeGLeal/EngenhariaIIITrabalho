package trabengIII.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import trabengIII.Banco.Conexao;
import trabengIII.Entity.MovimentoCaixa;

public class DALMovimentoCaixa {
    
    public boolean gravar(MovimentoCaixa m) {
        boolean res = false;
        String sql = "insert into movimento(mov_con, mov_cai) values ('#1','#2')";
        sql = sql.replaceAll("#1", ""+m.getMovimento_caixa());
        sql = sql.replaceAll("#2", ""+m.getMovimento_conta());
        Conexao con = Conexao.getConexao();
        res = con.manipular(sql);
        con.desconectar();
        return res;
    }

    public int getMax() {
        int res;
        Conexao con = Conexao.getConexao();
        res = con.getMaxPK("movimento", "mov_con");
        con.desconectar();
        return res;
    }

   public MovimentoCaixa get(int cod) {

        MovimentoCaixa aux = null;
        
        Conexao con = Conexao.getConexao();
        ResultSet rs = con.consultar("select * from movimento where mov_con='"+cod+"'");
        try{
            DALReceberPagar dalRP = new DALReceberPagar();
            DALCaixa dalC = new DALCaixa();
            
            if(rs.next())
                aux = new MovimentoCaixa(dalRP.get(rs.getInt("mov_con")), dalC.get(rs.getInt("mov_cai")));
        }
        catch(SQLException sqlEx){}

        return aux;
   }
}
