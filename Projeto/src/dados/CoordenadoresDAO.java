/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import Entidades.Coordenadores;
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
public class CoordenadoresDAO implements DAO<Coordenadores> {

    @Override
    public void inserir(Coordenadores entidade) throws DadosException {
        Connection  conexao=ConexaoBD.getConexao();
        String sql="INSERT INTO coordenadores(tpcoordenador, modalidade,denominacao, habilitacao, localoferta, turnos, vagasturno, cargahoraria, regime, periodos, coordenador, cpfcord, titulacao, tempodedicacao) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            /*comando.setString(1, entidade.getTpcoordenador());
            comando.setString(2, entidade.getModalidade());
            comando.setString(3, entidade.getDenomincacao());
            comando.setString(4, entidade.getHabilitacao());
            comando.setString(5, entidade.getLocaloferta());
            comando.setString(6, String.valueOf(entidade.getTurnos()));
            comando.setInt(7, entidade.getVagas());
            comando.setInt(8, entidade.getCargahoraria());
            comando.setString(9, entidade.getRegime());
            comando.setInt(10, entidade.getPeriodos());
            comando.setString(11, entidade.getCoordenador());
            comando.setString(12, entidade.getCpfcoord());
            comando.setString(13, entidade.getTitulacao());
            comando.setInt(14, entidade.getTempodedicacao());
            //comando.execute();*/
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Cargo Incluido com sucesso!");
        } catch (SQLException ex){
            ex.printStackTrace();
                throw new  DadosException("Erro ao inserir.", ex);        }
        }

    @Override
    public void alterar(Coordenadores entidade) throws DadosException {
        Connection  conexao=ConexaoBD.getConexao();
        String sql="UPDATE coordenadores SET coordenador=?,cbo=? WHERE idcoordenador=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
             //comando.setString(1, entidade.getCargo());
           //comando.setInt(2, entidade.getCbo());
            //comando.setInt(3, entidade.getIdcoordenador());
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Cargo Alterado com sucesso!");
        } catch (SQLException ex){
            ex.printStackTrace();
                throw new  DadosException("Erro ao inserir.", ex);        }
    }

    @Override
    public void excluir(Coordenadores entidade) throws DadosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Coordenadores consultar(int id) throws DadosException {
        Coordenadores coordenador =new Coordenadores();
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM coordenadores WHERE idcoordenador=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            comando.setInt(1,id);
            
            ResultSet resultado=comando.executeQuery();
            
            if(resultado.next()){
              
               coordenador.setCpfcoord(resultado.getInt(1));
               coordenador.setNomecord(resultado.getString(2));
               coordenador.setTitulacao(resultado.getString(3));
                coordenador.setDedicacao(resultado.getInt(4));
            }
            conexao.close();
            return coordenador;
        } catch(SQLException ex){
            throw new DadosException("Erro ao consultar",ex);
        }
    }
  public Coordenadores consultar(String nome) throws DadosException {
        Coordenadores coordenador =new Coordenadores();
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM coordenadores WHERE nomecoord=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            comando.setString(1,nome);
            
            ResultSet resultado=comando.executeQuery();
            
            if(resultado.next()){
              
               coordenador.setCpfcoord(resultado.getInt(1));
               coordenador.setNomecord(resultado.getString(2));
               coordenador.setTitulacao(resultado.getString(3));
                coordenador.setDedicacao(resultado.getInt(4));
            }
            conexao.close();
            return coordenador;
        } catch(SQLException ex){
            throw new DadosException("Erro ao consultar",ex);
        }
    }      
    

    @Override
   
    public List<Coordenadores> listar() throws DadosException {
        List<Coordenadores> lista= new ArrayList<>();
        
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM coordenadores ";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                Coordenadores coordenador =new Coordenadores();
               coordenador.setCpfcoord(resultado.getInt(1));
               coordenador.setNomecord(resultado.getString(2));
               coordenador.setTitulacao(resultado.getString(3));
                coordenador.setDedicacao(resultado.getInt(4));
               lista.add(coordenador);
            }
            conexao.close();
           return lista; 
        } catch(SQLException ex){
            throw new DadosException("Erro ao listar",ex);
        }
    
    }
    
    public List<Coordenadores> listar(String ordem) throws DadosException {
        List<Coordenadores> lista= new ArrayList<>();
        
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM coordenadores ORDER BY "+ ordem +"";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
           
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                
               Coordenadores coordenador =new Coordenadores();
               coordenador.setCpfcoord(resultado.getInt(1));
               coordenador.setNomecord(resultado.getString(2));
               coordenador.setTitulacao(resultado.getString(3));
                coordenador.setDedicacao(resultado.getInt(4));

               lista.add(coordenador);
            }
            conexao.close();
           return lista; 
        } catch(SQLException ex){
            throw new DadosException("Erro ao listar",ex);
        }
    
    }
}
///