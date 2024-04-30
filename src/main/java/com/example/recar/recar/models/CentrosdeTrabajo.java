package com.example.recar.recar.models;

public class CentrosdeTrabajo {
    
    private String cif;
    private String centroDeTrabajo;
    private String codigo;
    private String isla;

    public CentrosdeTrabajo() {
    	
    }
    
    public CentrosdeTrabajo(String cif, String centroDeTrabajo, String codigo, String isla) {
        this.cif = cif;
        this.centroDeTrabajo = centroDeTrabajo;
        this.codigo = codigo;
        this.isla = isla;
    }

    public String getCif() {
        return this.cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getCentroDeTrabajo() {
        return this.centroDeTrabajo;
    }

    public void setCentroDeTrabajo(String centroDeTrabajo) {
        this.centroDeTrabajo = centroDeTrabajo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIsla() {
        return this.isla;
    }

    public void setIsla(String isla) {
        this.isla = isla;
    }



}
