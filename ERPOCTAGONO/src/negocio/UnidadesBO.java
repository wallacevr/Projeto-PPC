/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import Entidades.Unidades;
import dados.DadosException;
import dados.UnidadesDAO;
import java.util.ArrayList;
import java.util.List;
import meuprograma.ValidaCNPJ;

/**
 *
 * @author Wallace
 */
public class UnidadesBO implements BO<Unidades> {

    @Override
    public void validar(Unidades entidade) throws NegocioException {
        if (entidade.getCNPJ().isEmpty()){
            throw new NegocioException("Preencha o campo CNPJ!") ; 
        }
        if(!ValidaCNPJ.isCNPJ(entidade.getCNPJ())){
            throw new NegocioException("Preencha o campo CNPJ com valor válido!") ;
        }
        if (entidade.getNomeUnidade().isEmpty()){
            throw new NegocioException("Preencha o campo Nome Fantasia!") ; 
        }
    }

    @Override
    public void inserir(Unidades entidade) throws NegocioException {
       validar(entidade);
       UnidadesDAO dao= new UnidadesDAO();
       try{
           
           dao.inserir(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao inserir unidade",ex);
       }
    }

    @Override
    public void alterar(Unidades entidade) throws NegocioException {
        validar(entidade);
       UnidadesDAO dao= new UnidadesDAO();
       try{
           
           dao.alterar(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao Alterar unidade",ex);
       }
    }

    @Override
    public void excluir(Unidades entidade) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Unidades consultar(int id) throws NegocioException {
        UnidadesDAO dao= new UnidadesDAO();
        try {
            Unidades unidade=dao.consultar(id);
            if(unidade.getCNPJ().isEmpty()){
                throw new NegocioException("Unidade não encontrada");
            }
            return unidade;
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao consultar unidade", ex);
        }
    }
 public Unidades consultar(int id,int idemp) throws NegocioException {
        UnidadesDAO dao= new UnidadesDAO();
        try {
            Unidades unidade=dao.consultar(idemp,id);
            if(unidade.getId()==0){
                throw new NegocioException("Unidade não encontrada");
            }
            return unidade;
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao consultar unidade", ex);
        }
    }
    @Override
    public List<Unidades> listar() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  public List<Unidades> listar(int idemp) throws NegocioException, DadosException {
      List<Unidades> lista= new ArrayList<>();
        UnidadesDAO dao= new UnidadesDAO();
        lista=dao.listar(idemp);
        return lista;
    }
    

    
}
