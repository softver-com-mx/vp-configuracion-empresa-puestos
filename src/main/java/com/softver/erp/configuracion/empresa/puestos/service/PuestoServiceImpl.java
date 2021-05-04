/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softver.erp.configuracion.empresa.puestos.service;

import com.softver.comunes.entity.IdClaveDescripcion;
import com.softver.comunes.entity.InfoAuditoria;
import com.softver.comunes.exception.OperationNotPermittedSoftverException;
import com.softver.erp.configuracion.empresa.puestos.entity.Puesto;
import java.util.List;
import com.softver.erp.configuracion.empresa.puestos.serviceinterface.PuestoService;
import com.softver.erp.configuracion.empresa.puestos.datainterface.PuestoData;
import com.softver.erp.configuracion.empresa.puestos.datainterface.PuestoDepartamentoData;
import com.softver.erp.configuracion.empresa.puestos.entity.PuestoListado;

/**
 *
 * @author ivelazquex
 */
public class PuestoServiceImpl implements PuestoService {
    private final PuestoData puestoData;
    private final PuestoDepartamentoData puestoDepartamentoData;
    
    /**
     * constructor
     * @param puestoData
     */
    public PuestoServiceImpl(PuestoData puestoData) {
        this.puestoData = puestoData;
        this.puestoDepartamentoData = null;
    }
    
        /**
     * constructor
     * @param puestoDepartamentoData
     */
    public PuestoServiceImpl(PuestoDepartamentoData puestoDepartamentoData) {
        this.puestoData = null;
        this.puestoDepartamentoData = puestoDepartamentoData;
    }
    
    /**
     * constructor
     * @param puestoData
     * @param puestoDepartamentoData 
     */
    public PuestoServiceImpl(
        PuestoData puestoData, PuestoDepartamentoData puestoDepartamentoData
    ) {
        this.puestoData = puestoData;
        this.puestoDepartamentoData = puestoDepartamentoData;
    }

    @Override
    public void crear(InfoAuditoria info, Puesto entidad) throws Exception {
        validarInfoAuditoria(info);
        validarEntidad(entidad);
        
        if (puestoData.verificarClave(info.getIdEmpresa(), entidad.getClave())) {
            throw new OperationNotPermittedSoftverException(
                "la clave ya existe"
            );
        }
        if (!puestoDepartamentoData.verificarDepartamento(
            info.getIdEmpresa(), entidad.getIdDepartamento()
        )) {
            throw new OperationNotPermittedSoftverException(
                "el departamento no existe o esta inactivo"
            );
        }
        
        puestoData.crear(info.getIdEmpresa(), entidad, info.getIdUsuario());
    }

    @Override
    public void actualizar(InfoAuditoria info, Puesto entidad) throws Exception {
        validarInfoAuditoria(info);
        validarEntidad(entidad);
        
        Puesto entidadTmp = puestoData.obtenerPorId(info.getIdEmpresa(), entidad);
        if (entidadTmp == null) {
            throw new OperationNotPermittedSoftverException(
                "el registro no existe"
            );
        }
        if (!entidadTmp.getClave().equals(entidad.getClave())) {
            if (puestoData.verificarClave(info.getIdEmpresa(), entidad.getClave())) {
                throw new OperationNotPermittedSoftverException(
                    "la clave ya existe"
                );
            }
        }
        if (!puestoDepartamentoData.verificarDepartamento(
            info.getIdEmpresa(), entidad.getIdDepartamento()
        )) {
            throw new OperationNotPermittedSoftverException(
                "el departamento no existe o esta inactivo"
            );
        }
        
        puestoData.actualizar(info.getIdEmpresa(), entidad, info.getIdUsuario());
    }

    @Override
    public List<PuestoListado> obtener(InfoAuditoria info, Puesto filtro) throws Exception {
        validarInfoAuditoria(info);
        if (filtro == null) {
            throw new OperationNotPermittedSoftverException(
                "los filtros son requeridos"
            );
        }
        
        return puestoData.obtener(info.getIdEmpresa(), filtro);
    }

    @Override
    public Puesto obtenerPorId(InfoAuditoria info, Puesto filtro) throws Exception {
        validarInfoAuditoria(info);
        if (filtro == null || filtro.getId() < 1) {
            throw new OperationNotPermittedSoftverException(
                "los filtros son requeridos"
            );
        }
        
        return puestoData.obtenerPorId(info.getIdEmpresa(), filtro);
    }

    @Override
    public List<IdClaveDescripcion> obtenerDepartamento(InfoAuditoria info) throws Exception {
        validarInfoAuditoria(info);
        
        return puestoDepartamentoData.obtenerDepartamento(info.getIdEmpresa());
    }

    
    /**
     * verifica que la información de auditoria tenga datos
     * @param info
     * @throws Exception 
     */
    private void validarInfoAuditoria(InfoAuditoria info) throws Exception {
        if (info == null || info.getIdEmpresa() < 1 || info.getIdUsuario() < 1) {
            throw new OperationNotPermittedSoftverException(
                "la información de auditoria es requerida"
            );
        }
    }
    
    /**
     * verifica que la informacion necesaria de la entidad tenga datos
     * @param puesto
     * @throws Exception 
     */
    private void validarEntidad(Puesto entidad) throws Exception {
        if (entidad == null) {
            throw new OperationNotPermittedSoftverException(
                "la entidad con información es requerida"
            );
        }
        if (entidad.getClave() == null) {
            throw new OperationNotPermittedSoftverException(
                "la clave es requerida"
            );
        }
        if (entidad.getDescripcion()== null) {
            throw new OperationNotPermittedSoftverException(
                "la descripción es requerida"
            );
        }
    }


}
