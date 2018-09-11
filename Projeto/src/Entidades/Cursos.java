/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Wallace
 */
public class Cursos {
    private int idcurso;
    private String denomincacao;
    private String tpcurso;
    private String modalidade;
    private String habilitacao;
    private String localoferta;
    private int turnos;
    private int vagas;
    private int cargahoraria;
    private String Regime;
    private int periodos;
    private String coordenador;
    private String cpfcoord;
    private String titulacao;
    private int tempodedicacao;

    public int getIdcurso() {
        return idcurso;
    }

    public String getDenomincacao() {
        return denomincacao;
    }

    public void setDenomincacao(String denomincacao) {
        this.denomincacao = denomincacao;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public String getTpcurso() {
        return tpcurso;
    }

    public void setTpcurso(String tpcurso) {
        this.tpcurso = tpcurso;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getHabilitacao() {
        return habilitacao;
    }

    public void setHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
    }

    public String getLocaloferta() {
        return localoferta;
    }

    public void setLocaloferta(String localoferta) {
        this.localoferta = localoferta;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public int getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(int cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public String getRegime() {
        return Regime;
    }

    public void setRegine(String Regime) {
        this.Regime = Regime;
    }

    public int getPeriodos() {
        return periodos;
    }

    public void setPeriodos(int periodos) {
        this.periodos = periodos;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    public String getCpfcoord() {
        return cpfcoord;
    }

    public void setCpfcoord(String cpfcoord) {
        this.cpfcoord = cpfcoord;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public int getTempodedicacao() {
        return tempodedicacao;
    }

    public void setTempodedicacao(int tempodedicacao) {
        this.tempodedicacao = tempodedicacao;
    }

    public void setString(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
