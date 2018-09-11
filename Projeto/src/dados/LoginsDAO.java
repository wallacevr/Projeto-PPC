/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import Entidades.Logins;
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
public class LoginsDAO implements DAO<Logins> {

    @Override
    public void inserir(Logins entidade) throws DadosException {
        Connection  conexao=ConexaoBD.getConexao();
        String sql="INSERT INTO logins(usuario,senha,nivel) VALUES(?,?,?)";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
           comando.setString(1, entidade.getUsuario());
           comando.setString(2, entidade.getSenha());
            comando.setInt(3, entidade.getNivel());
            //comando.execute();
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Usuário Incluido com sucesso!");
        } catch (SQLException ex){
            ex.printStackTrace();
                throw new  DadosException("Erro ao inserir.", ex);        }
        }

    @Override
    public void alterar(Logins entidade) throws DadosException {
        Connection  conexao=ConexaoBD.getConexao();
        String sql="UPDATE logins SET senha=? ,nivel=? WHERE usuario=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
             comando.setString(1, entidade.getSenha());
           comando.setInt(2, entidade.getNivel());
            
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Usuario Alterado com sucesso!");
        } catch (SQLException ex){
            ex.printStackTrace();
                throw new  DadosException("Erro ao alterar.", ex);        }
    }

    @Override
    public void excluir(Logins entidade) throws DadosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Logins consultar(int id) throws DadosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Logins consultar(String usuario, String senha) throws DadosException {
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM usuarios where usuario=? and senha=? ";
        Logins conta =new Logins();
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            comando.setString(1, usuario);
            comando.setString(2, senha);
            ResultSet resultado=comando.executeQuery();
            
            if(resultado.next()){
                
               conta.setUsuario(resultado.getString(1));
               conta.setNivel(resultado.getInt(3)); 
            }
            conexao.close();
            
        } catch(SQLException ex){
            throw new DadosException("Erro ao listar",ex);
        }   
        return conta;
    }    
    

    @Override
   
    public List<Logins> listar() throws DadosException {
        List<Logins> lista= new ArrayList<>();
        
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM usuarios ";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                Logins login =new Logins();
               login.setUsuario(resultado.getString(1));
               lista.add(login);
            }
            conexao.close();
           return lista; 
        } catch(SQLException ex){
            throw new DadosException("Erro ao listar",ex);
        }
    
    }
    
   
}
///