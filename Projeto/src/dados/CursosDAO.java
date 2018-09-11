/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;
import Entidades.Cursos;
import Entidades.Cursos;
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
public class CursosDAO implements DAO<Cursos> {

    @Override
    public void inserir(Cursos entidade) throws DadosException {
        Connection  conexao=ConexaoBD.getConexao();
        String sql="INSERT INTO cursos(tpcurso, modalidade,denominacao, habilitacao, localoferta, turnos, vagasturno, cargahoraria, regime, periodos, coordenador, cpfcord, titulacao, tempodedicacao) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            comando.setString(1, entidade.getTpcurso());
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
            //comando.execute();
            comando.executeUpdate();
            conexao.close();
            JOptionPane.showMessageDialog(null, "Curso Incluido com sucesso!");
        } catch (SQLException ex){
                throw new  DadosException("Erro ao inserir.", ex);        }
        }

    @Override
    public void alterar(Cursos entidade) throws DadosException {
        Connection  conexao=ConexaoBD.getConexao();
        String sql="UPDATE cursos SET tpcurso=?, modalidade=?,denominacao=?, habilitacao=?, localoferta=?, turnos=?, vagasturno=?, cargahoraria=?, regime=?, periodos=?, coordenador=?, cpfcord=?, titulacao=?, tempodedicacao=? WHERE idcurso=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            comando.setString(1, entidade.getTpcurso());
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
            comando.setInt(15, entidade.getIdcurso());
            comando.executeUpdate();
            conexao.close();
           
        } catch (SQLException ex){
          
                throw new  DadosException("Erro ao Alterar.", ex);        }
    }

    @Override
    public void excluir(Cursos entidade) throws DadosException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cursos consultar(int id) throws DadosException {
        Cursos curso =new Cursos();
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM cursos WHERE idcurso=?";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            comando.setInt(1,id);
            
            ResultSet resultado=comando.executeQuery();
            
            if(resultado.next()){
                curso.setIdcurso(resultado.getInt(1));
               curso.setTpcurso(resultado.getString(2));
               curso.setModalidade(resultado.getString(3));
               curso.setDenomincacao(resultado.getString(4));
               curso.setHabilitacao(resultado.getString(5));
             
                curso.setLocaloferta(resultado.getString(6));
               curso.setTurnos(resultado.getInt(7));
               curso.setVagas(resultado.getInt(8));
               curso.setCargahoraria(resultado.getInt(9));
               curso.setRegine(resultado.getString(10));
               curso.setPeriodos(resultado.getInt(11));
               curso.setCoordenador(resultado.getString(12));
               curso.setCpfcoord(resultado.getString(13));
            curso.setTitulacao(resultado.getString(14));
            curso.setTempodedicacao(Integer.parseInt(resultado.getString(15)));
            }
            conexao.close();
            return curso;
        } catch(SQLException ex){
            throw new DadosException("Erro ao consultar",ex);
        }
    }
        
    

    @Override
   
    public List<Cursos> listar() throws DadosException {
        List<Cursos> lista= new ArrayList<>();
        
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM cursos ";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
            
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                Cursos curso =new Cursos();
                curso.setIdcurso(resultado.getInt(1));
               curso.setTpcurso(resultado.getString(2));
               curso.setModalidade(resultado.getString(3));
               curso.setDenomincacao(resultado.getString(4));
               curso.setHabilitacao(resultado.getString(5));
             
                curso.setLocaloferta(resultado.getString(6));
               curso.setTurnos(resultado.getInt(7));
               curso.setVagas(resultado.getInt(8));
               curso.setCargahoraria(resultado.getInt(9));
               curso.setRegine(resultado.getString(10));
               curso.setPeriodos(resultado.getInt(11));
               curso.setCoordenador(resultado.getString(12));
               curso.setCpfcoord(resultado.getString(13));
            curso.setTitulacao(resultado.getString(14));
            curso.setTempodedicacao(Integer.parseInt(resultado.getString(15)));
               lista.add(curso);
            }
            conexao.close();
           return lista; 
        } catch(SQLException ex){
            throw new DadosException("Erro ao listar",ex);
        }
    
    }
    
    public List<Cursos> listar(String ordem) throws DadosException {
        List<Cursos> lista= new ArrayList<>();
        
        Connection  conexao=ConexaoBD.getConexao();
        String sql="SELECT * FROM cargos ORDER BY "+ ordem +"";
        try{
            PreparedStatement comando=conexao.prepareStatement(sql);
           
            ResultSet resultado=comando.executeQuery();
            while(resultado.next()){
                Cursos cargo =new Cursos();
               //cargo.setIdcargo(resultado.getInt(1));
               //cargo.setCargo(resultado.getString(2));
               //cargo.setCbo(resultado.getInt(3));

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