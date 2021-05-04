/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softver.erp.configuracion.empresa.puestos.datainterface;

import com.softver.comunes.datainterface.SimpleBaseData;
import com.softver.erp.configuracion.empresa.puestos.entity.Puesto;
import com.softver.erp.configuracion.empresa.puestos.entity.PuestoListado;
import java.util.List;

/**
 *
 * @author ivelazquex
 */
public interface PuestoData extends SimpleBaseData<Puesto> {

    /**
     * obtiene todos los registros de acuerdo a los filtros enviados
     * @param idEmpresa
     * @param filtro
     * @return
     * @throws Exception
     */
    public List<PuestoListado> obtener(int idEmpresa, Puesto filtro) throws Exception;
    
    /**
     * valida si existe la clave
     * @param idEmpresa
     * @param clave
     * @return
     * @throws Exception 
     */
    public boolean verificarClave(int idEmpresa, String clave) throws Exception;
}
