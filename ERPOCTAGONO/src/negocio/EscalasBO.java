/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import Entidades.Escalas;
import dados.DadosException;
import dados.EscalasDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import meuprograma.ValidaCNPJ;

/**
 *
 * @author Wallace
 */
public class EscalasBO implements BO<Escalas> {

    @Override
    public void validar(Escalas entidade) throws NegocioException {
        if (entidade.getEscala().isEmpty()){
            throw new NegocioException("Preencha o campo Escala!") ; 
        }
    }

    @Override
    public void inserir(Escalas entidade) throws NegocioException {
       validar(entidade);
       EscalasDAO dao= new EscalasDAO();
       try{
           
           dao.inserir(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao inserir escala",ex);
       }
    }

    @Override
    public void alterar(Escalas entidade) throws NegocioException {
        validar(entidade);
       EscalasDAO dao= new EscalasDAO();
       try{
           
           dao.alterar(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao Alterar escala",ex);
       }
    }

    @Override
    public void excluir(Escalas entidade) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Escalas consultar(int id) throws NegocioException {
        EscalasDAO dao= new EscalasDAO();
        try {
            Escalas escala=dao.consultar(id);
            if(escala.getIdescala()==0){
                JOptionPane.showMessageDialog(null, "Unidade não encontrada");
                throw new NegocioException("Unidade não encontrada");
            }
            return escala;
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao consultar escala", ex);
        }
    }

    @Override
    public List<Escalas> listar() throws NegocioException {
        List<Escalas> lista= new ArrayList<>();
        EscalasDAO dao= new EscalasDAO();
        try {
            lista=dao.listar();
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao lista Empresa", ex);
        }
        return lista;
    }
    public List<Escalas> listar(String ordem) throws NegocioException {
        List<Escalas> lista= new ArrayList<>();
        EscalasDAO dao= new EscalasDAO();
        try {
            lista=dao.listar(ordem);
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao lista Empresa", ex);
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
