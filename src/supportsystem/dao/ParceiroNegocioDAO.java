package supportsystem.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import supportsystem.database.DataBase;
import supportsystem.logging.LogController;
import supportsystem.models.Cliente;
import supportsystem.models.ParceiroNegocio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author joao.vmr
 */
public class ParceiroNegocioDAO {

    public List<ParceiroNegocio> listarParceiros() throws SQLException {
        DataBase db = new DataBase();
        Statement stmt = null;
        ResultSet rs = null;
        List<ParceiroNegocio> parceiros = new ArrayList<>();

        try {
            stmt = db.getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM PARCEIRO_NEGOCIO");

            while (rs.next()) {
                ParceiroNegocio parceiro = new ParceiroNegocio();

                parceiro.setId_pn(rs.getInt("id_pn"));
                parceiro.setNome_pn(rs.getString("nome_pn"));
                parceiro.setId_tipo_pn(rs.getInt("id_tipo_pn"));
                parceiros.add(parceiro);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
        return parceiros;

    }

    public String validaInsercao(ParceiroNegocio parceiro) {
        String mensagem = "";
       
        if (parceiro.getId_tipo_pn()!=1 && parceiro.getId_tipo_pn()!=2) {
           
           mensagem = "É NECESSÁRIO MARCAR UM TIPO, PF OU PJ";
           return mensagem;
       
       }
        System.out.println(parceiro.getNome_pn());
        if (parceiro.getNome_pn().isEmpty()) {
           
           mensagem = "É NECESSÁRIO INSERIR UM NOME";
           return mensagem;
       
       }
       return mensagem; 
    }

    public void inserirParceiro(ParceiroNegocio parceiro) throws SQLException {
        
            DataBase db = new DataBase();
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            try {
                pstmt = db.getConnection().prepareStatement("INSERT INTO parceiro_negocio (nome_pn, id_tipo_pn) VALUES (?, ?)");
                pstmt.setString(1, parceiro.getNome_pn());
                pstmt.setInt(2, parceiro.getId_tipo_pn());
                System.out.println(parceiro.getId_tipo_pn());
                pstmt.execute();

            } catch (SQLException ex) {
                System.out.println(ex);
                LogController.createLog("Erro ao conectar-se na tabela PARCEIRO_NEGOCIO do banco de dados. " + ex.getMessage(), "S");
            } finally {
                db.close();
            }
        }
        
    

    public ArrayList<ParceiroNegocioDTO> deleteParceiro(ParceiroNegocioDTO parceirodto) throws SQLException {
        DataBase db = new DataBase();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = db.getConnection().prepareStatement("delete from parceiro_negocio where id_pn = ?");
            pstmt.setInt(1, parceirodto.getId_pn());
            pstmt.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            db.close();
        }
        return null;
    }

}
