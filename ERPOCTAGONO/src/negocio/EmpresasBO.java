/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import Entidades.Empresas;
import dados.DadosException;
import dados.EmpresasDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Wallace
 */
public class EmpresasBO implements BO<Empresas> {

    @Override
    public void validar(Empresas entidade) throws NegocioException {

        if (entidade.getRazao().isEmpty()){
        throw new NegocioException("Preencha o campo Razao Social!") ; 
        }
        if (entidade.getNmfantasia().isEmpty()){
        throw new NegocioException("Preencha o campo Nome Fantasia!") ; 
        }
    }

    @Override
    public void inserir(Empresas entidade) throws NegocioException {
       validar(entidade);
       EmpresasDAO dao= new EmpresasDAO();
       try{
           
           dao.inserir(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao inserir empresa",ex);
       }
    }

    @Override
    public void alterar(Empresas entidade) throws NegocioException {
     validar(entidade);
       EmpresasDAO dao= new EmpresasDAO();
       try{
           
           dao.alterar(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao Alterar empresa",ex);
       }
    }
    @Override
    public void excluir(Empresas entidade) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empresas consultar(int id) throws NegocioException {
        EmpresasDAO dao= new EmpresasDAO();
        try {
            Empresas empresa=dao.consultar(id);
            
            if(empresa.getIdempresa()==0){
                  JOptionPane.showMessageDialog(null,"Empresa não encontrada");
                throw new NegocioException("Empresa não encontrada");
              
            }
            return empresa;
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao consultar Empresa", ex);
        }
    }

    @Override
    public List<Empresas> listar() throws NegocioException {
        List<Empresas> lista= new ArrayList<>();
        EmpresasDAO dao= new EmpresasDAO();
        try {
            lista=dao.listar();
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao lista Empresa", ex);
        }
        return lista;
    }


    
}
