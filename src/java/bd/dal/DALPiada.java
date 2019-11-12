package bd.dal;

import bd.entidades.Piada;
import bd.util.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DALPiada {

    public boolean salvar(Piada p) {
        String sql = "insert into piada (pia_cod,pia_titulo,pia_texto,pia_pontuacao,pia_palchave,usu_cod,cat_cod) values ('$1','$2','$3','$4','$5','$6','$7')";
        sql = sql.replace("$1", p.getCod() + "");
        sql = sql.replace("$2", p.getTitulo());
        sql = sql.replace("$3", p.getTexto());
        sql = sql.replace("$4", p.getPontucao() + "");
        sql = sql.replace("$5", p.getPalchave());
        sql = sql.replace("$6", p.getUsu_cod() + "");
        sql = sql.replace("$7", p.getCat_cod() + "");
        Conexao con = new Conexao();
        if (con.manipular(sql)) {
           return true;
        }
        return false;
    }
    public int pegacodigo()
    {
        Conexao con = new Conexao();
        return con.getMaxPK("piada", "pia_cod");
    }

    public boolean apagar(int id) {
        return new Conexao().manipular("delete from categoria where id=" + id);
    }

    public ArrayList<Piada> carregaP() {
        ArrayList<Piada> lista = new ArrayList();
        String sql = "select * from piada";
        ResultSet rs = new Conexao().consultar(sql);
        //int cod, int pontucao, String titulo, String texto, String palchave, byte[] foto
        try {
            while (rs.next()) {
                lista.add(
                        new Piada(rs.getInt("pia_cod"), rs.getInt("pia_pontuacao"),rs.getString("pia_titulo"), rs.getString("pia_texto"), rs.getString("pia_palchave"), rs.getBytes("pia_foto")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
}
