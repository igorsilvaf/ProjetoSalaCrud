/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.dao;

import br.com.curso.model.Veiculo;
import br.com.curso.utils.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igorf
 */
public class VeiculoDAO implements GenericDAO {

        private Connection conexao;
        
        public VeiculoDAO() throws Exception{
            conexao = SingleConnection.getConnection();
        }
    
    @Override
    public boolean cadastrar(Object objeto) {
         Veiculo oVeiculo = (Veiculo) objeto;
        boolean retorno=false;
        if (oVeiculo.getIdVeiculo()== 0){
            retorno = this.inserir(oVeiculo);
        }else{
            retorno = this.alterar(oVeiculo);
        }
        return retorno;
    }

    @Override
    public boolean inserir(Object objeto) {
        Veiculo oVeiculo = (Veiculo) objeto;
        PreparedStatement stmt = null;
        String sql = "insert into veiculo (marca,modelo) values  (?,?)";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oVeiculo.getMarca());
            stmt.setString(2, oVeiculo.getModelo());
            stmt.execute();
            conexao.commit();
            return true;
        }catch (Exception ex){
            try{
                System.out.println("Problemas ao cadastrar o Veiculo! Erro: "+ex.getMessage());
                ex.printStackTrace();
                conexao.rollback();
            }catch (SQLException e){
                System.out.println("Erro: "+e.getMessage());
                e.printStackTrace();
            }
            return false;
        }
    }

    @Override
    public boolean alterar(Object objeto) {
         Veiculo oVeiculo = (Veiculo) objeto;
       PreparedStatement stmt = null;
       String sql = "update veiculo set marca=?,modelo=? where idVeiculo=?";
       try{
            stmt = conexao.prepareStatement(sql);
            stmt.setString(1, oVeiculo.getMarca());
            stmt.setString(2, oVeiculo.getModelo());
            stmt.setInt(3, oVeiculo.getIdVeiculo());
            stmt.execute();
            conexao.commit();
            return true;
           
       }catch(Exception ex){
           try{
               System.out.println("Problemas ao alterar Veiculo! ERRO: "+ex.getMessage());
               ex.printStackTrace();
               conexao.rollback();
               
           }catch(Exception e){
               System.out.println("ERRO:"+e.getMessage());
               e.printStackTrace();
               
               
           }
           return false;
       }
    }

    @Override
    public boolean excluir(int numero) {
           int idVeiculo= numero;
        PreparedStatement stmt = null;
  
        String sql = "delete  from veiculo where idVeiculo=?";
      try{
          stmt = conexao.prepareStatement(sql);
          stmt.setInt(1, idVeiculo);
          stmt.execute();
          conexao.commit();
          return true;
          
          
      }catch (Exception ex){
          System.out.println("Problemas ao excluir Veiculo! Erro:"+ex.getMessage());  
          try{
              conexao.rollback();
          }catch(SQLException e ){
              System.out.println("Erro roolback"+e.getMessage());
              e.printStackTrace();
          }
          return false;
          
      }
    }

    @Override
    public Object carregar(int numero) {
            int idVeiculo= numero;
        PreparedStatement stmt = null;
        ResultSet rs = null; 
        Veiculo oVeiculo = null;
        String sql = "select * from veiculo where idVeiculo=?";
        try{
            stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, idVeiculo);
            rs=stmt.executeQuery();
            while(rs.next()){
                oVeiculo = new Veiculo();
                oVeiculo.setIdVeiculo(rs.getInt("idVeiculo"));
               oVeiculo.setMarca(rs.getString("marca"));
               oVeiculo.setModelo(rs.getString("modelo"));

            }
           return oVeiculo; 
        }   catch(Exception ex){
                System.out.println("Problemas ao carregar veiculo! ERRO:"+ex.getMessage());
                return false;
                
                }
    }

    @Override
    public List<Object> listar() {
        List<Object> resultado = new ArrayList<>();
        PreparedStatement stmt = null;  
        ResultSet rs = null;
        String sql = "Select * from veiculo order by idVeiculo";
        try {
            stmt = conexao.prepareStatement(sql);
            rs=stmt.executeQuery();
            while (rs.next()){
                Veiculo oVeiculo= new Veiculo();
                oVeiculo.setIdVeiculo(rs.getInt("idVeiculo"));
                oVeiculo.setMarca(rs.getString("marca"));
                oVeiculo.setModelo(rs.getString("modelo"));
                resultado.add(oVeiculo);
            }
        }catch (SQLException ex){
            System.out.println("Problemas ao listar veiculo! erro:" + ex.getMessage());
        }        
    return resultado;
    }
    
}
