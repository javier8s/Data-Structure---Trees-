/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDeDatos.jerarquico;

/**
 * @param <E>
 * @author MORENO MARTIN, LYDIA Y SANCHEZ GOZALO, JAVIER
 */
public class NodoBinario<E> {
    private E dato;
    private NodoBinario<E> izq;
    private NodoBinario<E> der;
    int tamanyo;

    /**
     * Constructor del nodo indicando el dato y sus nodos izquierdo y derecho
     *
     * @param dato
     * @param izq
     * @param der
     */
    public NodoBinario(E dato, NodoBinario<E> izq, NodoBinario<E> der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
        this.tamanyo = 1;
        if (izq != null) {
            this.tamanyo += izq.tamanyo;
        }
        if (der != null) {
            this.tamanyo += der.tamanyo;
        }
    }

    /**
     * Constructor de una hoja
     *
     * @param dato
     */
    public NodoBinario(E dato) {
        this(dato, null, null);
    }

    /**
     * Devuelve el objeto almacenado
     *
     * @return E
     */
    public E getElemento() {
        return dato;
    }

    /**
     * Devuelve el nodo izquierdo
     *
     * @return NodoBinario<E>
     */
    public NodoBinario<E> getIzq() {
        return izq;
    }

    /**
     * Devuelve el nodo derecho
     *
     * @return
     */
    public NodoBinario<E> getDer() {
        return der;
    }
}
