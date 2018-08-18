/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;
import Entidades.Empresas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Wallace
 */
public class EmpresasDAO implements DAO<Empresas> {

    @Override
    public void inserir(Empresas entidade) throws DadosException {
        Connection  conexao=ConexaoBD.getConexao();
        String sql="INSERT INTO empresas(RazaoSocial,NomeFantasia,Logo,Ativa) VALUES(?,?,?,?)";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
           comando.setString(1, entidade.getRazao());
            comando.setString(2, entidade.getNmfantasia());
            comando.setString(3,entidade.getLogo());
            comando.setBoolean(4,entidade.isAtiva());
             comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Empresa incluida com sucesso!");
        } catch (SQLException ex){
            ex.printStackTrace();
                throw new  DadosException("Erro ao inserir.", ex);        }
        }

    @Override
    public void alterar(Empresas entidade) throws DadosException {
               Connection  conexao=ConexaoBD.getConexao();
        String sql="UPDATE empresas SET RazaoSocial=?,NomeFantasia=?,Logo=?,Ativa=? WHERE idempresa=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
           comando.setString(1, entidade.getRazao());
            comando.setString(2, entidade.getNmfantasia());
            comando.setString(3,entidade.getLogo());
            comando.setBoolean(4,entidade.isAtiva());
            comando.setInt(5,entidade.getIdempresa());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Empresa Alterada com sucesso!");
        } catch (SQLException ex){
            ex.printStackTrace();
                throw new  DadosException("Erro ao Alterar.", ex);        }
    }

    @Override
    public void excluir(Empresas entidade) throws DadosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empresas consultar(int id) throws DadosException {
        Empresas empresa =new Empresas();
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM empresas WHERE idempresa=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            comando.setInt(1,id);
            JOptionPane.showMessageDialog(null,comando.toString());
            ResultSet resultado=comando.executeQuery();
            if(resultado.next()){
               empresa.setIdempresa(resultado.getInt(1));
               empresa.setRazao(resultado.getString(2));
               empresa.setNmfantasia(resultado.getString(3));
               empresa.setLogo(resultado.getString(4));
               empresa.setAtiva(resultado.getBoolean(5));
            }
            conexao.close();
            return empresa;
        } catch(SQLException ex){
            throw new DadosException("Erro ao consultar",ex);
        }
    }

    @Override
    public List<Empresas> listar() throws DadosException {
        List<Empresas> lista= new ArrayList<>();
        
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM empresas";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                Empresas empresa =new Empresas();
               empresa.setIdempresa(resultado.getInt(1));
               empresa.setRazao(resultado.getString(2));
               empresa.setNmfantasia(resultado.getString(3));
               empresa.setLogo(resultado.getString(4));
               empresa.setAtiva(resultado.getBoolean(5));
              lista.add(empresa);
            }
            conexao.close();
           return lista; 
        } catch(SQLException ex){
            throw new DadosException("Erro ao listar",ex);
        }
    
    } 
    }

 
    
    

