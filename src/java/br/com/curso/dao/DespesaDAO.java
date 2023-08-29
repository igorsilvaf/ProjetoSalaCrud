/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;

import br.com.curso.model.Despesa;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author igorf
 */
public class DespesaDAO implements GenericDAO {
    private Connection conexao; 
    
    public DespesaDAO() throws Exception{
        conexao = SingleConnection.getConnection();
    }
    

    @Override
    public boolean cadastrar(Object objeto) {
        Despesa oDespesa = (Despesa) objeto;
        boolean retorno=false;
        if (oDespesa.getIdDespesa()== 0){
            retorno = inserir(oDespesa);
        }else{
            retorno = alterar(oDespesa);
        }
        return retorno;
    }

    @Override
    public boolean inserir(Object objeto) {
              Despesa oDespesa = (Despesa) objeto;
        PreparedStatement stmt = null;
        String sql = "Insert Into Despesa (descricao,valorDespesa,valorPago,"+"datadocumento,imagemdocumento) values  (?,?,?,?,?)";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oDespesa.getDescricao());
            stmt.setDouble(2, oDespesa.getValorDespesa());
            stmt.setDouble(3, oDespesa.getValorPago());
            stmt.setDate(4, new java.sql.Date(oDespesa.getDataDocumento().getTime()));
            stmt.setString(5, oDespesa.getImagemDocumento());

           

            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception e){
            try{
                System.out.println("Problemas ao cadastrar a Despesa! Erro: "+e.getMessage());
                e.printStackTrace();
                conexao.rollback();
            }catch (SQLException ex){
                System.out.println("Problemas ao executar rollback: "+ex.getMessage());
                ex.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public boolean alterar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir(int numero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object carregar(int numero) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
