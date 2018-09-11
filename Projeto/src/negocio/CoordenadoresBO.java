/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;



import Entidades.Coordenadores;
import dados.DadosException;
import dados.CoordenadoresDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import meuprograma.ValidaCNPJ;

/**
 *
 * @author Wallace
 */
public class CoordenadoresBO implements BO<Coordenadores> {

    @Override
    public void validar(Coordenadores entidade) throws NegocioException {
       
    }

    @Override
    public void inserir(Coordenadores entidade) throws NegocioException {
       validar(entidade);
       CoordenadoresDAO dao= new CoordenadoresDAO();
       try{
           
           dao.inserir(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao inserir Curso",ex);
       }
    }

    @Override
    public void alterar(Coordenadores entidade) throws NegocioException {
        validar(entidade);
       CoordenadoresDAO dao= new CoordenadoresDAO();
       try{
           
           dao.alterar(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao Alterar cargo",ex);
       }
    }

    @Override
    public void excluir(Coordenadores entidade) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Coordenadores consultar(int id) throws NegocioException {
        CoordenadoresDAO dao= new CoordenadoresDAO();
        try {
            Coordenadores coordenador=dao.consultar(id);
            if(coordenador.getCpfcoord()==0){
                JOptionPane.showMessageDialog(null, "Unidade não encontrada");
                throw new NegocioException("Unidade não encontrada");
            }
            return coordenador;
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao consultar cargo", ex);
        }
    }
 public Coordenadores consultar(String nome) throws NegocioException {
        CoordenadoresDAO dao= new CoordenadoresDAO();
        try {
            Coordenadores coordenador=dao.consultar(nome);
            if(coordenador.getCpfcoord()==0){
                JOptionPane.showMessageDialog(null, "Unidade não encontrada");
                throw new NegocioException("Unidade não encontrada");
            }
            return coordenador;
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao consultar cargo", ex);
        }
    }
    @Override
    public List<Coordenadores> listar() throws NegocioException {
        List<Coordenadores> lista= new ArrayList<>();
        CoordenadoresDAO dao= new CoordenadoresDAO();
        try {
            lista=dao.listar();
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao lista Empresa", ex);
        }
        return lista;
    }
    public List<Coordenadores> listar(String ordem) throws NegocioException {
        List<Coordenadores> lista= new ArrayList<>();
        CoordenadoresDAO dao= new CoordenadoresDAO();
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
