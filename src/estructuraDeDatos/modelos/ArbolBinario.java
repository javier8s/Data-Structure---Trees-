/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDeDatos.modelos;

import excepciones.ArbolVacioExcepcion;

/**
 * @author MORENO MARTIN, LYDIA Y SANCHEZ GOZALO, JAVIER
 */
public interface ArbolBinario<E> {

    public String toStringInOrden() throws ArbolVacioExcepcion;

    public String toStringPreOrden() throws ArbolVacioExcepcion;

    public String toStringPostOrden() throws ArbolVacioExcepcion;
}
