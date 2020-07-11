/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDeDatos.jerarquico;

import estructuraDeDatos.modelos.ArbolBinario;
import excepciones.ArbolVacioExcepcion;

/**
 * @param <E>
 * @author MORENO MARTIN, LYDIA Y SANCHEZ GOZALO, JAVIER
 */
public class AB<E> implements ArbolBinario {
    private NodoBinario<E> nodoRaiz;

    /**
     * Constructor
     */
    public AB() {
        nodoRaiz = null;
    }

    /**
     * Constructor que se indica el dato a almacenar y sus respectivos hijos
     *
     * @param dato
     * @param izq
     * @param der
     */
    public AB(E dato, AB<E> izq, AB<E> der) {

        if ((der == null) && (izq == null))
            nodoRaiz = new NodoBinario<E>(dato, null, null);
        else if (izq == null)
            nodoRaiz = new NodoBinario<E>(dato, null, der.nodoRaiz);
        else if (der == null)
            nodoRaiz = new NodoBinario<E>(dato, izq.nodoRaiz, null);
        else
            nodoRaiz = new NodoBinario<E>(dato, izq.nodoRaiz, der.nodoRaiz);
    }

    /**
     * Devuelve el nodo raíz
     *
     * @return NodoBiranio<E>
     */
    public NodoBinario<E> nodoRaiz() {
        return nodoRaiz;
    }

    /**
     * Devuelve el objeto raiz
     *
     * @return E
     * @throws ArbolVacioExcepcion
     */
    public E raiz() throws ArbolVacioExcepcion {
        if (nodoRaiz == null) {
            throw new ArbolVacioExcepcion("Arbol Vacio");
        }
        return nodoRaiz.getElemento();
    }

    /**
     * Método lanzadera de toStringInOrden, verifica que el árbol no está vacío
     *
     * @return String
     * @throws ArbolVacioExcepcion
     */
    @Override
    public String toStringInOrden() throws ArbolVacioExcepcion {
        if (this.nodoRaiz != null) {
            return toStringInOrden(this.nodoRaiz);
        } else {
            throw new ArbolVacioExcepcion("Arbol Vacio");
        }
    }

    /**
     * Método recursivo
     *
     * @param actual
     * @return String
     */
    private String toStringInOrden(NodoBinario<E> actual) {
        String res = "";

        if (actual.getIzq() != null) {
            res += toStringInOrden(actual.getIzq());
        }
        res += actual.getElemento().toString() + " ";
        if (actual.getDer() != null) {
            res += toStringInOrden(actual.getDer());
        }

        return res;
    }

    /**
     * Método lanzadera de toStringPreOrden, verifica que el árbol no está vacío
     *
     * @return String
     * @throws ArbolVacioExcepcion
     */
    @Override
    public String toStringPreOrden() throws ArbolVacioExcepcion {
        if (this.nodoRaiz != null) {
            return toStringPreOrden(this.nodoRaiz);
        } else {
            throw new ArbolVacioExcepcion("Arbol Vacio");
        }
    }

    /**
     * Método recursivo
     *
     * @param actual
     * @return String
     */
    private String toStringPreOrden(NodoBinario<E> actual) {
        String res = "";

        res += actual.getElemento().toString() + " ";
        if (actual.getIzq() != null) {
            res += toStringPreOrden(actual.getIzq());
        }
        if (actual.getDer() != null) {
            res += toStringPreOrden(actual.getDer());
        }

        return res;
    }

    /**
     * Método lanzadera de toStringPostOrden, verifica que el árbol no está vacío
     *
     * @return String
     * @throws ArbolVacioExcepcion
     */
    @Override
    public String toStringPostOrden() throws ArbolVacioExcepcion {
        if (this.nodoRaiz != null) {
            return toStringPostOrden(this.nodoRaiz);
        } else {
            throw new ArbolVacioExcepcion("Árbol Vacío");
        }
    }

    /**
     * Método recursivo
     *
     * @param actual
     * @return String
     */
    private String toStringPostOrden(NodoBinario<E> actual) {
        String res = "";

        if (actual.getIzq() != null) {
            res += toStringPostOrden(actual.getIzq());
        }
        if (actual.getDer() != null) {
            res += toStringPostOrden(actual.getDer());
        }
        res += actual.getElemento().toString() + " ";

        return res;
    }

    /**
     * Borrar todo el árbol
     */
    public void BorrarArbolModo1() {
        this.nodoRaiz = null;
    }

    /**
     * Borrar nodo a nodo, hoja por hoja.
     * Método lanzadera de BorrarArbolModo2, verifica que el árbol no está vacío
     *
     * @throws ArbolVacioExcepcion
     */
    public void BorrarArbolModo2() throws ArbolVacioExcepcion {
        if (this.raiz() != null) {
            BorrarArbolModo2(nodoRaiz);
        }
        this.nodoRaiz = null;
    }

    /**
     * Método recursivo
     *
     * @param actual
     */
    public void BorrarArbolModo2(NodoBinario<E> actual) {
        if (actual.getIzq() != null) {
            BorrarArbolModo2(actual.getIzq());
        }
        if (actual.getDer() != null) {
            BorrarArbolModo2(actual.getDer());
        }
        actual = null;
    }

    /**
     * Calcular cuánts niveles tiene el árbol
     * Método lanzadera de NivelesAB, verifica que el árbol no está vacío
     *
     * @return int
     */
    public Integer nivelesAB() {
        if (this.nodoRaiz != null) {
            return nivelesAB(0, nodoRaiz);
        } else {
            return -1;
        }
    }

    /**
     * Método recursivo
     *
     * @param nivel
     * @param actual
     * @return int
     */
    private Integer nivelesAB(int nivel, NodoBinario<E> actual) {
        int a = nivel;
        int b = nivel;

        if (actual.getDer() != null) {
            a = nivelesAB(nivel + 1, actual.getDer());
        }
        if (actual.getIzq() != null) {
            b = nivelesAB(nivel + 1, actual.getIzq());
        }

        if (b < a) {
            return a;
        } else {
            return b;
        }
    }

}
