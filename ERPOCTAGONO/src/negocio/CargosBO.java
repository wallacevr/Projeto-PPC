/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import Entidades.Cargos;
import dados.DadosException;
import dados.CargosDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import meuprograma.ValidaCNPJ;

/**
 *
 * @author Wallace
 */
public class CargosBO implements BO<Cargos> {

    @Override
    public void validar(Cargos entidade) throws NegocioException {
        if (entidade.getCargo().isEmpty()){
            throw new NegocioException("Preencha o campo Cargo!") ; 
        }
    }

    @Override
    public void inserir(Cargos entidade) throws NegocioException {
       validar(entidade);
       CargosDAO dao= new CargosDAO();
       try{
           
           dao.inserir(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao inserir cargo",ex);
       }
    }

    @Override
    public void alterar(Cargos entidade) throws NegocioException {
        validar(entidade);
       CargosDAO dao= new CargosDAO();
       try{
           
           dao.alterar(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao Alterar cargo",ex);
       }
    }

    @Override
    public void excluir(Cargos entidade) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cargos consultar(int id) throws NegocioException {
        CargosDAO dao= new CargosDAO();
        try {
            Cargos cargo=dao.consultar(id);
            if(cargo.getIdcargo()==0){
                JOptionPane.showMessageDialog(null, "Unidade não encontrada");
                throw new NegocioException("Unidade não encontrada");
            }
            return cargo;
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao consultar cargo", ex);
        }
    }

    @Override
    public List<Cargos> listar() throws NegocioException {
        List<Cargos> lista= new ArrayList<>();
        CargosDAO dao= new CargosDAO();
        try {
            lista=dao.listar();
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao lista Empresa", ex);
        }
        return lista;
    }
    public List<Cargos> listar(String ordem) throws NegocioException {
        List<Cargos> lista= new ArrayList<>();
        CargosDAO dao= new CargosDAO();
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
