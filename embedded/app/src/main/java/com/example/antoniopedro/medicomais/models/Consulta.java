package com.example.antoniopedro.medicomais.models;

/**
 * Created by Antonio Pedro on 15/03/2018.
 */

public class Consulta {


    private String nomeMedico;
    private String tipoConsulta;
    private String dataConsulta;
    private String sintomas;


    public Consulta(String nomeMedico, String tipoConsulta, String dataConsulta, String sintomas) {
        this.nomeMedico = nomeMedico;
        this.tipoConsulta = tipoConsulta;
        this.dataConsulta = dataConsulta;
        this.sintomas = sintomas;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }
}
