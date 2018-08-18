/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;
import Entidades.Empresas;
import Entidades.Cargos;
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
public class CargosDAO implements DAO<Cargos> {

    @Override
    public void inserir(Cargos entidade) throws DadosException {
        Connection  conexao=ConexaoBD.getConexao();
        String sql="INSERT INTO cargos(cargo,cbo) VALUES(?,?)";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
           comando.setString(1, entidade.getCargo());
           comando.setInt(2, entidade.getCbo());
            
            //comando.execute();
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Cargo Incluido com sucesso!");
        } catch (SQLException ex){
            ex.printStackTrace();
                throw new  DadosException("Erro ao inserir.", ex);        }
        }

    @Override
    public void alterar(Cargos entidade) throws DadosException {
        Connection  conexao=ConexaoBD.getConexao();
        String sql="UPDATE cargos SET cargo=?,cbo=? WHERE idcargo=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
             comando.setString(1, entidade.getCargo());
           comando.setInt(2, entidade.getCbo());
            comando.setInt(3, entidade.getIdcargo());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Cargo Alterado com sucesso!");
        } catch (SQLException ex){
            ex.printStackTrace();
                throw new  DadosException("Erro ao inserir.", ex);        }
    }

    @Override
    public void excluir(Cargos entidade) throws DadosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cargos consultar(int id) throws DadosException {
        Cargos cargo =new Cargos();
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM cargos WHERE idcargo=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            comando.setInt(1,id);
            ResultSet resultado=comando.executeQuery();
            if(resultado.next()){
               cargo.setIdcargo(resultado.getInt(1));
               cargo.setCargo(resultado.getString(2));
               cargo.setCbo(resultado.getInt(3));
               
               
            }
            conexao.close();
           return cargo; 
        } catch(SQLException ex){
            throw new DadosException("Erro ao consultar",ex);
        }
    }
        
    

    @Override
   
    public List<Cargos> listar() throws DadosException {
        List<Cargos> lista= new ArrayList<>();
        
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM cargos ";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                Cargos cargo =new Cargos();
               cargo.setIdcargo(resultado.getInt(1));
               cargo.setCargo(resultado.getString(2));
               cargo.setCbo(resultado.getInt(3));

               lista.add(cargo);
            }
            conexao.close();
           return lista; 
        } catch(SQLException ex){
            throw new DadosException("Erro ao listar",ex);
        }
    
    }
    
    public List<Cargos> listar(String ordem) throws DadosException {
        List<Cargos> lista= new ArrayList<>();
        
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM cargos ORDER BY "+ ordem +"";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
           
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                Cargos cargo =new Cargos();
               cargo.setIdcargo(resultado.getInt(1));
               cargo.setCargo(resultado.getString(2));
               cargo.setCbo(resultado.getInt(3));

               lista.add(cargo);
            }
            conexao.close();
           return lista; 
        } catch(SQLException ex){
            throw new DadosException("Erro ao listar",ex);
        }
    
    }
}
///