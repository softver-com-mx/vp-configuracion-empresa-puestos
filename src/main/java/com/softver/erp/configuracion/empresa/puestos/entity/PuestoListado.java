/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softver.erp.configuracion.empresa.puestos.entity;

/**
 *
 * @author ivelazquex
 */
public class PuestoListado extends Puesto {
    private String claveDepartamento;
    private String descripcionDepartamento;
    
    /**
     * constructor
     */
    public PuestoListado() {
        super();
    }
    
    /**
     * constructor
     * @param id
     * @param clave
     * @param descripcion
     * @param nivelJerarquico
     * @param estado
     * @param idDepartamento
     * @param claveDepartamento
     * @param descripcionDepartamento
     * @param operativo
     * @throws Exception 
     */
    public PuestoListado(
        int id, String clave, String descripcion, int nivelJerarquico, 
        boolean  estado, int idDepartamento, String claveDepartamento, 
        String descripcionDepartamento, int operativo
    ) throws Exception {
        super(id, clave, descripcion, nivelJerarquico, estado, idDepartamento, operativo);
        setClaveDepartamento(claveDepartamento);
        setDescripcionDepartamento(descripcionDepartamento);
    }
    
    /**
     * @return the claveDepartamento
     */
    public String getClaveDepartamento() {
        return claveDepartamento;
    }

    /**
     * @param claveDepartamento the claveDepartamento to set
     */
    public void setClaveDepartamento(String claveDepartamento) {
        this.claveDepartamento = claveDepartamento;
    }

    /**
     * @return the descripcionDepartamento
     */
    public String getDescripcionDepartamento() {
        return descripcionDepartamento;
    }

    /**
     * @param descripcionDepartamento the descripcionDepartamento to set
     */
    public void setDescripcionDepartamento(String descripcionDepartamento) {
        this.descripcionDepartamento = descripcionDepartamento;
    }
}
