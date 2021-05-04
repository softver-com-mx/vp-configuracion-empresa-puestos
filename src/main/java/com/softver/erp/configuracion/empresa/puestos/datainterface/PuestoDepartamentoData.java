/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.softver.erp.configuracion.empresa.puestos.datainterface;

import com.softver.comunes.entity.IdClaveDescripcion;
import java.util.List;

/**
 *
 * @author ivelazquex
 */
public interface PuestoDepartamentoData {
    /**
     * catalogo de departamentos activos
     * @param idEmpresa
     * @return
     * @throws Exception 
     */
    public List<IdClaveDescripcion> obtenerDepartamento(int idEmpresa) throws Exception;
    
    /**
     * validar que el departamento exista y este activo
     * @param idEmpresa
     * @param idDepartamento
     * @return
     * @throws Exception 
     */
    public boolean verificarDepartamento(int idEmpresa, int idDepartamento) throws Exception;
    
}
