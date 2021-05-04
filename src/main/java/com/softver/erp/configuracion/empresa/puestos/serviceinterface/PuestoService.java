/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softver.erp.configuracion.empresa.puestos.serviceinterface;

import com.softver.comunes.entity.IdClaveDescripcion;
import com.softver.comunes.entity.InfoAuditoria;
import com.softver.comunes.serviceinterface.SimpleBaseService;
import com.softver.erp.configuracion.empresa.puestos.entity.Puesto;
import com.softver.erp.configuracion.empresa.puestos.entity.PuestoListado;
import java.util.List;

/**
 *
 * @author ivelazquex
 */
public interface PuestoService extends SimpleBaseService<Puesto> {

    /**
     * obtiene todos los registros de acuerdo a los filtros enviados
     * @param info
     * @param filtro
     * @return
     * @throws Exception
     */
    public List<PuestoListado> obtener(InfoAuditoria info, Puesto filtro) throws Exception;

    /**
     * obtiene un registro por id
     *
     * @param info
     * @param filtro
     * @return
     * @throws Exception
     */
    public Puesto obtenerPorId(InfoAuditoria info, Puesto filtro) throws Exception;
    
    /**
     * catalogo de departamentos activos
     * @param info
     * @return
     * @throws Exception 
     */
    public List<IdClaveDescripcion> obtenerDepartamento(InfoAuditoria info) throws Exception;
}
