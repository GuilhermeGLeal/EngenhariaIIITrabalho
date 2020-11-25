package trabengIII.DAL;

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

//   public MovimentoCaixa get(int cod) {
//
//        MovimentoCaixa aux = null;
//        ReceberPagar rp;
//        Caixa cx;
//
//        Conexao con = Conexao.getConexao();
//        ResultSet rs = con.consultar("select * from movimento where mov_con='"+cod+"'");
//        try{
//            if(rs.next())
//                aux = new MovimentoCaixa(rs.getInt("mov_con"),rs.getString("mov_cai"));
//        }
//        catch(SQLException sqlEx){}
//
//        return aux;
//   }
}
