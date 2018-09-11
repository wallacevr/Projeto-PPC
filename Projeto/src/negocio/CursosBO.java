/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import Entidades.Cursos;
import dados.DadosException;
import dados.CursosDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import meuprograma.ValidaCNPJ;

/**
 *
 * @author Wallace
 */
public class CursosBO implements BO<Cursos> {

    @Override
    public void validar(Cursos entidade) throws NegocioException {
        if (entidade.getTpcurso().isEmpty()){
            throw new NegocioException("Preencha o campo Tipo de Curso") ; 
        }
        if (entidade.getModalidade().isEmpty()){
            throw new NegocioException("Preencha o campo Modalidade") ; 
        }
             if (entidade.getDenomincacao().isEmpty()){
            throw new NegocioException("Preencha o campo Denominação") ; 
        }
        if (entidade.getHabilitacao().isEmpty()){
            throw new NegocioException("Preencha o campo Habilitacao") ; 
        } 
        if (entidade.getTurnos()==0){
            throw new NegocioException("Preencha o Turnos") ; 
        }
        if (entidade.getVagas()==0){
            throw new NegocioException("Preencha o campo vagas") ; 
        }
    }

    @Override
    public void inserir(Cursos entidade) throws NegocioException {
       validar(entidade);
       CursosDAO dao= new CursosDAO();
       try{
           
           dao.inserir(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao inserir Curso",ex);
       }
    }

    @Override
    public void alterar(Cursos entidade) throws NegocioException {
        validar(entidade);
       CursosDAO dao= new CursosDAO();
       try{
           
           dao.alterar(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao Alterar curso",ex);
       }
    }

    @Override
    public void excluir(Cursos entidade) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cursos consultar(int id) throws NegocioException {
        CursosDAO dao= new CursosDAO();
        try {
            Cursos curso=dao.consultar(id);
            if(curso.getIdcurso()==0){
                
                throw new NegocioException("Curso não encontradO");
            }
            return curso;
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao consultar curso", ex);
        }
    }

    @Override
    public List<Cursos> listar() throws NegocioException {
        List<Cursos> lista= new ArrayList<>();
        CursosDAO dao= new CursosDAO();
        try {
            lista=dao.listar();
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao listar Curso", ex);
        }
        return lista;
    }
    public List<Cursos> listar(String ordem) throws NegocioException {
        List<Cursos> lista= new ArrayList<>();
        CursosDAO dao= new CursosDAO();
        try {
            lista=dao.listar(ordem);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao listar Curso", ex);
        }
        return lista;
    }
 
    /**
     *
     * @return
     * @throws NegocioException
     * @throws DadosException
     */
   
 
 
    

    
}
