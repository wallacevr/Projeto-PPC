/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import Entidades.PCCs;
import dados.DadosException;
import dados.PCCsDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import meuprograma.ValidaCNPJ;

/**
 *
 * @author Wallace
 */
public class PCCsBO implements BO<PCCs> {

    @Override
    public void validar(PCCs entidade) throws NegocioException {
    /*    if (entidade.getTppcc().isEmpty()){
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
        }*/
    }

    @Override
    public void inserir(PCCs entidade) throws NegocioException {
       validar(entidade);
       PCCsDAO dao= new PCCsDAO();
       try{
           
           dao.inserir(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao inserir Curso",ex);
       }
    }

    @Override
    public void alterar(PCCs entidade) throws NegocioException {
        validar(entidade);
       PCCsDAO dao= new PCCsDAO();
       try{
           
           dao.alterar(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao Alterar pcc",ex);
       }
    }

    @Override
    public void excluir(PCCs entidade) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PCCs consultar(int id) throws NegocioException {
        PCCsDAO dao= new PCCsDAO();
        try {
            PCCs pcc=dao.consultar(id);
            if(pcc.getIdpcc()==0){
                
                throw new NegocioException("Curso não encontradO");
            }
            return pcc;
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao consultar pcc", ex);
        }
    }

    @Override
    public List<PCCs> listar() throws NegocioException {
        List<PCCs> lista= new ArrayList<>();
        PCCsDAO dao= new PCCsDAO();
        try {
            lista=dao.listar();
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao listar Curso", ex);
        }
        return lista;
    }
    public List<PCCs> listar(String ordem) throws NegocioException {
        List<PCCs> lista= new ArrayList<>();
        PCCsDAO dao= new PCCsDAO();
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
