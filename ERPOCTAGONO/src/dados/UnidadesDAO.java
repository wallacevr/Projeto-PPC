/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;
import Entidades.Empresas;
import Entidades.Unidades;
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
public class UnidadesDAO implements DAO<Unidades> {

    @Override
    public void inserir(Unidades entidade) throws DadosException {
        Connection  conexao=ConexaoBD.getConexao();
        String sql="INSERT INTO unidades(CNPJ,Nome,Matriz,Ativa,idempresa) VALUES(?,?,?,?,?)";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
           comando.setString(1, entidade.getCNPJ());
            comando.setString(2, entidade.getNomeUnidade());
            comando.setBoolean(3,entidade.isMatriz());
            comando.setBoolean(4,entidade.isAtiva());
            comando.setInt(5, entidade.getIdempresa());
            
            //comando.execute();
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Unidade Incluida com sucesso!");
        } catch (SQLException ex){
            ex.printStackTrace();
                throw new  DadosException("Erro ao inserir.", ex);        }
        }

    @Override
    public void alterar(Unidades entidade) throws DadosException {
        Connection  conexao=ConexaoBD.getConexao();
        String sql="UPDATE unidades SET CNPJ=?,Nome=?,Matriz=?,Ativa=?,idempresa=? WHERE idunidade=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
           comando.setString(1, entidade.getCNPJ());
            comando.setString(2, entidade.getNomeUnidade());
            comando.setBoolean(3,entidade.isMatriz());
            comando.setBoolean(4,entidade.isAtiva());
            comando.setInt(5, entidade.getIdempresa());
            comando.setInt(6, entidade.getId());
            //comando.execute();
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Unidade Alterada com sucesso!");
        } catch (SQLException ex){
            ex.printStackTrace();
                throw new  DadosException("Erro ao inserir.", ex);        }
    }

    @Override
    public void excluir(Unidades entidade) throws DadosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Unidades consultar(int id) throws DadosException {
        Unidades unidade =new Unidades();
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM unidades WHERE idunidade=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            comando.setInt(1,id);
            ResultSet resultado=comando.executeQuery();
            if(resultado.next()){
               unidade.setCNPJ(resultado.getString(1));
               unidade.setNomeUnidade(resultado.getString(2));
               unidade.setMatriz(resultado.getBoolean(3));
               unidade.setAtiva(resultado.getBoolean(4));
               unidade.setIdempresa(resultado.getInt(5));
               unidade.setId(resultado.getInt(6));
               
            }
            conexao.close();
           return unidade; 
        } catch(SQLException ex){
            throw new DadosException("Erro ao consultar",ex);
        }
    }
    public Unidades consultar(int idemp,int idun) throws DadosException {
        Unidades unidade =new Unidades();
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM unidades WHERE idunidade=? and idempresa=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            comando.setInt(1,idun);
            comando.setInt(2, idemp);
            ResultSet resultado=comando.executeQuery();
            if(resultado.next()){
               unidade.setCNPJ(resultado.getString(1));
               unidade.setNomeUnidade(resultado.getString(2));
               unidade.setMatriz(resultado.getBoolean(3));
               unidade.setAtiva(resultado.getBoolean(4));
               unidade.setIdempresa(resultado.getInt(5));
               unidade.setId(resultado.getInt(6));
               
            }
            conexao.close();
           return unidade; 
        } catch(SQLException ex){
            throw new DadosException("Erro ao consultar",ex);
        }
    }
        
    

    @Override
    public List<Unidades> listar() throws DadosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Unidades> listar(int idemp) throws DadosException {
        List<Unidades> lista= new ArrayList<>();
        
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM unidades WHERE  idempresa=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            comando.setInt(1, idemp);
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                Unidades unidade =new Unidades();
               unidade.setCNPJ(resultado.getString(1));
               unidade.setNomeUnidade(resultado.getString(2));
               unidade.setMatriz(resultado.getBoolean(3));
               unidade.setAtiva(resultado.getBoolean(4));
               unidade.setIdempresa(resultado.getInt(5));
               unidade.setId(resultado.getInt(6));
               lista.add(unidade);
            }
            conexao.close();
           return lista; 
        } catch(SQLException ex){
            throw new DadosException("Erro ao listar",ex);
        }
    
    } 
}
///