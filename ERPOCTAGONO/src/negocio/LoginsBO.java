/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


import Entidades.Logins;
import dados.DadosException;
import dados.LoginsDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import meuprograma.ValidaCNPJ;

/**
 *
 * @author Wallace
 */
public class LoginsBO implements BO<Logins> {

    @Override
    public void validar(Logins entidade) throws NegocioException {
        if (entidade.getUsuario().isEmpty()){
            throw new NegocioException("Preencha o campo Usuário!") ; 
        }
        if (entidade.getSenha().isEmpty()){
            throw new NegocioException("Preencha o campo Usuário!") ; 
        }
        if (entidade.getNivel()==0){
            throw new NegocioException("Selecione Nível de usuário") ; 
        }
    }

    @Override
    public void inserir(Logins entidade) throws NegocioException {
       validar(entidade);
       LoginsDAO dao= new LoginsDAO();
       try{
           
           dao.inserir(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao inserir login",ex);
       }
    }

    @Override
    public void alterar(Logins entidade) throws NegocioException {
        validar(entidade);
       LoginsDAO dao= new LoginsDAO();
       try{
           
           dao.alterar(entidade);
       }catch(DadosException ex){
           throw new NegocioException("Erro ao Alterar login",ex);
       }
    }

    @Override
    public void excluir(Logins entidade) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Logins consultar(int id) throws NegocioException {
        return null;
       
    }

     public Logins consultar(String usuario, String senha) throws NegocioException {
        LoginsDAO dao= new LoginsDAO();
        try {
            
            Logins login=dao.consultar(usuario,senha);
            
            if(login.getNivel()==0){
                  JOptionPane.showMessageDialog(null,"Usuários ou senha não incorretos");
                throw new NegocioException("Usuário ou senha não inválidos");
              
            }
            return login;
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao consultar usuário", ex);
        }
    }
    public List<Logins> listar() throws NegocioException {
        List<Logins> lista= new ArrayList<>();
        LoginsDAO dao= new LoginsDAO();
        try {
            lista=dao.listar();
        } catch (DadosException ex) {
            throw new NegocioException("Erro ao lista usuário", ex);
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
