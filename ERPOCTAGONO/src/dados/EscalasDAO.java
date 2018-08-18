/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;
import Entidades.Empresas;
import Entidades.Escalas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Wallace
 */
public class EscalasDAO implements DAO<Escalas> {

    @Override
    public void inserir(Escalas entidade) throws DadosException {
        Connection  conexao=ConexaoBD.getConexao();
        String sql="INSERT INTO escalas(escala) VALUES(?)";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
           comando.setString(1, entidade.getEscala());
           
            
            //comando.execute();
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Escala Incluida com sucesso!");
        } catch (SQLException ex){
            ex.printStackTrace();
                throw new  DadosException("Erro ao inserir.", ex);        }
        }

    @Override
    public void alterar(Escalas entidade) throws DadosException {
        Connection  conexao=ConexaoBD.getConexao();
        String sql="UPDATE escalas SET escala=? WHERE idescala=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
             comando.setString(1, entidade.getEscala());
           comando.setInt(2, entidade.getIdescala());
            
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Escala Alterada com sucesso!");
        } catch (SQLException ex){
            ex.printStackTrace();
                throw new  DadosException("Erro ao inserir.", ex);        }
    }

    @Override
    public void excluir(Escalas entidade) throws DadosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Escalas consultar(int id) throws DadosException {
        Escalas escala =new Escalas();
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM escalas WHERE idescala=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            comando.setInt(1,id);
            ResultSet resultado=comando.executeQuery();
            if(resultado.next()){
               escala.setIdescala(resultado.getInt(1));
               escala.setEscala(resultado.getString(2));
               
               
               
            }
            conexao.close();
           return escala; 
        } catch(SQLException ex){
            throw new DadosException("Erro ao consultar",ex);
        }
    }
        
    

    @Override
   
    public List<Escalas> listar() throws DadosException {
        List<Escalas> lista= new ArrayList<>();
        
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM escalas ";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                Escalas escala =new Escalas();
               escala.setIdescala(resultado.getInt(1));
               escala.setEscala(resultado.getString(2));
               

               lista.add(escala);
            }
            conexao.close();
           return lista; 
        } catch(SQLException ex){
            throw new DadosException("Erro ao listar",ex);
        }
    
    }
    
    public List<Escalas> listar(String ordem) throws DadosException {
        List<Escalas> lista= new ArrayList<>();
        
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM escalas ORDER BY "+ ordem +"";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
           
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                Escalas escala =new Escalas();
               escala.setIdescala(resultado.getInt(1));
               escala.setEscala(resultado.getString(2));
               
               lista.add(escala);
            }
            conexao.close();
           return lista; 
        } catch(SQLException ex){
            throw new DadosException("Erro ao listar",ex);
        }
    
    }
}
///