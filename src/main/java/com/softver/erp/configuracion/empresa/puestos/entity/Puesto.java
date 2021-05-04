/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softver.erp.configuracion.empresa.puestos.entity;

import com.softver.comunes.exception.InvalidFormatSoftverException;
import com.softver.comunes.exception.MaxLimitExceededSoftverException;
import com.softver.comunes.exception.RequiredFieldSoftverException;
import java.util.regex.Pattern;

/**
 *
 * @author ivelazquex
 */
public class Puesto {
    private int id;
    private String clave;
    private String descripcion;
    private int nivelJerarquico;
    private boolean estado;
    private int idDepartamento;
    private int operativo;

    /**
     * constructor
     */
    public Puesto() {}

    /**
     * constructor
     *
     * @param clave
     * @param descripcion
     * @throws Exception
     */
    public Puesto(String clave, String descripcion) throws Exception {
        setClave(clave);
        setDescripcion(descripcion);
    }

    /**
     * constructor
     *
     * @param id
     * @param clave
     * @param descripcion
     * @param nivelJerarquico
     * @param estado
     * @param idDepartamento
     * @throws Exception
     */
    public Puesto(
        int id, String clave, String descripcion, int nivelJerarquico,
        boolean  estado, int idDepartamento, int operativo
    ) throws Exception {
        setId(id);
        setClave(clave);
        setDescripcion(descripcion);
        setNivelJerarquico(nivelJerarquico);
        setEstado(estado);
        setIdDepartamento(idDepartamento);
        setOperativo(operativo);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     * @throws java.lang.Exception
     */
    public void setClave(String clave) throws Exception {
        if (clave == null) {
            throw new RequiredFieldSoftverException("la clave es requerida");
        }
        clave = clave.trim().toUpperCase();
        if (clave.isEmpty()) {
            throw new RequiredFieldSoftverException("la clave es requerida");
        }
        if (clave.length() > 5) {
            throw new MaxLimitExceededSoftverException("la clave supera la longitud maxima de 5");
        }
        if (!Pattern.matches("[A-Z0-9]+", clave)) {
            throw new InvalidFormatSoftverException("formato incorrecto de la clave");
        }

        this.clave = clave;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     * @throws java.lang.Exception
     */
    public void setDescripcion(String descripcion) throws Exception {
        if (descripcion == null) {
            throw new RequiredFieldSoftverException("la descripcion es requerida");
        }
        descripcion = descripcion.trim().toUpperCase();
        if (descripcion.isEmpty()) {
            throw new RequiredFieldSoftverException("la descripcion es requerida");
        }
        if (descripcion.length() > 65) {
            throw new MaxLimitExceededSoftverException("la descripcion supera la longitud maxima de 100");
        }

        this.descripcion = descripcion;
    }

    /**
     * @return the nivelJerarquico
     */
    public int getNivelJerarquico() {
        return nivelJerarquico;
    }

    /**
     * @param nivelJerarquico the nivelJerarquico to set
     * @throws java.lang.Exception
     */
    public void setNivelJerarquico(int nivelJerarquico) throws Exception {
        if (nivelJerarquico < 1) {
            throw new RequiredFieldSoftverException(
                "el nivel jerarquico es requerido"
            );
        }
        
        this.nivelJerarquico = nivelJerarquico;
    }

    /**
     * @return the estado
     */
    public boolean getEstado() {
        return isEstado();
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) throws Exception {
        this.estado = estado;
    }

    /**
     * @return the idDepartamento
     */
    public int getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     * @throws java.lang.Exception
     */
    public void setIdDepartamento(int idDepartamento) throws Exception {
        if (idDepartamento < 1) {
            throw new RequiredFieldSoftverException(
                "el departamento es requerido"
            );
        }
        this.idDepartamento = idDepartamento;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @return the operativo
     */
    public int getOperativo() {
        return operativo;
    }

    /**
     * @param operativo the operativo to set
     */
    public void setOperativo(int operativo) {
        this.operativo = operativo;
    }
    
    

}
