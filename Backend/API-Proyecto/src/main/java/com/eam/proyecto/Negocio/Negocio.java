/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.Negocio;

/**
 *
 * @author Daryl Ospina
 * @param <T>
 */
public abstract class Negocio<T> extends EstructuraRestFulNegocio<T> {
    
    protected String urlApi = "http://localhost:8080/API-Proyecto/Recursos/";

    public Negocio(Class<T> entityClass) {
        super(entityClass);
    }
    
}
