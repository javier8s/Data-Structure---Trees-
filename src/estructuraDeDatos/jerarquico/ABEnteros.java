/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuraDeDatos.jerarquico;

import excepciones.ArbolVacioExcepcion;
import practica2.MyInput;

/**
 * @author MORENO MARTIN, LYDIA Y SANCHEZ GOZALO, JAVIER
 */
public class ABEnteros extends AB<Integer> {

    /**
     * Constructor que hereda de la clase AB
     */
    public ABEnteros() {
        super();
    }

    /**
     * Constructor que se le indica sus hios y el dato almacenado
     *
     * @param numero
     * @param izq
     * @param der
     */
    public ABEnteros(Integer numero, ABEnteros izq, ABEnteros der) {
        super(numero, izq, der);
    }

    /**
     * Constructor de una hoja
     *
     * @param numero
     */
    public ABEnteros(Integer numero) {
        super(numero, null, null);
    }

    /**
     * Constructor de un nodo con con un hijo(izquierdo)
     *
     * @param numero
     * @param nodo
     * @param flag
     */
    public ABEnteros(Integer numero, ABEnteros nodo, boolean flag) {
        super(numero, nodo, null);
    }

    /**
     * Constructor de un nodo con con un hijo(derecho)
     *
     * @param numero
     * @param nodo
     */
    public ABEnteros(Integer numero, ABEnteros nodo) {
        super(numero, null, nodo);
    }

    /**
     * Crea un árbol
     *
     * @return arbol
     */
    public ABEnteros crearAB1() {
        // 1º Forma de inicializar el arbol (en varias lineas):
        ABEnteros Arbol6 = new ABEnteros(8);
        ABEnteros Arbol5 = new ABEnteros(7);
        ABEnteros Arbol4 = new ABEnteros(9);
        ABEnteros Arbol3 = new ABEnteros(5, Arbol6);
        ABEnteros Arbol2 = new ABEnteros(6, Arbol4, Arbol5);
        ABEnteros Arbol1 = new ABEnteros(2, Arbol2, Arbol3);

        return Arbol1;
    }

    /**
     * Crea un árbol
     *
     * @return arbol
     */
    public ABEnteros crearAB2() {
        // 2º Forma de inicializar el arbol(en una linea):
        ABEnteros Arbol1 = new ABEnteros(13, new ABEnteros(12, new ABEnteros(8), new ABEnteros(4, new ABEnteros(2), new ABEnteros(2))), new ABEnteros(34, new ABEnteros(-3, new ABEnteros(0), true), new ABEnteros(-3)));

        return Arbol1;
    }

    /**
     * Método lanzadera de ComprobarSumas, verifica que el árbol no está vacío
     *
     * @return int
     * @throws ArbolVacioExcepcion
     */
    public float comprobarSumas() throws ArbolVacioExcepcion {
        if (this.raiz() != null) {
            return comprobarSumas((NodoBinario<Integer>) this.nodoRaiz());
        }

        return -1;

    }

    /**
     * Método recursivo
     *
     * @param actual
     * @return int
     */
    public float comprobarSumas(NodoBinario<Integer> actual) {
        float sumaIzq = 0, sumaDer = 0, suma = 0;

        if (actual.getIzq() != null) {
            sumaIzq += comprobarSumas(actual.getIzq()) + actual.getIzq().getElemento();
        }
        if (actual.getDer() != null) {
            sumaDer += comprobarSumas(actual.getDer()) + actual.getDer().getElemento();
        }

        if (sumaIzq != sumaDer) {
            suma = (float) 0.1;
        } else {
            suma = sumaIzq + sumaDer;
        }

        return suma;

    }

    /**
     * Método lanzadera de ABClavePequeña, verifica que el árbol no está vacío
     *
     * @return boolean
     * @throws ArbolVacioExcepcion
     */
    public boolean ABclavePequeña() throws ArbolVacioExcepcion {
        if (this.raiz() != null) {
            return ABclavePequeña((NodoBinario<Integer>) this.nodoRaiz());
        }
        return true;
    }

    /**
     * Método recursivo
     *
     * @param actual
     * @return boolean
     */
    public boolean ABclavePequeña(NodoBinario<Integer> actual) {
        boolean flag = true, flagIzq = true, flagDer = true;

        if (actual.getIzq() != null) {
            flagIzq = ABclavePequeña(actual.getIzq());
            if (actual.getElemento() > actual.getIzq().getElemento()) {
                flag = false;
            }
        }
        if (actual.getDer() != null) {
            flagDer = ABclavePequeña(actual.getDer());
            if (actual.getElemento() > actual.getDer().getElemento()) {
                flag = false;
            }

        }
        if ((flagIzq == false) || (flagDer == false)) {
            flag = false;
        }

        return flag;
    }

    /**
     * Método lanzadera de mostrarAscendientes, verifica que el árbol no está vacío
     *
     * @param clave
     * @return Sring
     * @throws ArbolVacioExcepcion
     */
    public String mostrarAscendientes(Integer clave) throws ArbolVacioExcepcion {
        if (this.raiz() != null) {
            return " " + mostrarAscendientes(this.nodoRaiz(), clave);
        }
        return null;
    }

    /**
     * M´wtodo recursivo
     *
     * @param actual
     * @param clave
     * @return String
     */
    public String mostrarAscendientes(NodoBinario<Integer> actual, Integer clave) {
        boolean flag = false;
        String res = "";

        if (actual.getIzq() != null && clave != actual.getElemento()) {
            if (mostrarAscendientes(actual.getIzq(), clave) != null) {
                res += mostrarAscendientes(actual.getIzq(), clave) + " ";
                flag = true;
            }

        }
        if (actual.getDer() != null && clave != actual.getElemento()) {
            if (flag != true) {
                if (mostrarAscendientes(actual.getDer(), clave) != null) {
                    res += mostrarAscendientes(actual.getDer(), clave) + " ";
                    flag = true;
                }
            }

        }

        if (clave == actual.getElemento()) {
            flag = true;
        }
        if (flag == true) {
            return res + actual.getElemento();
        }
        return null;

    }

    /**
     * Método lanzadera de SumaNodosNiveles, verifica que el árbol no está vacío
     *
     * @param nivel1
     * @param nivel2
     * @return int
     */
    public Integer sumaNodosNiveles(Integer nivel1, Integer nivel2) {
        return sumaNodosNiveles(this.nodoRaiz(), nivel1, nivel2, 0);
    }

    /**
     * Método recursivo
     *
     * @param actual
     * @param nivel1
     * @param nivel2
     * @param aux
     * @return int
     */
    public Integer sumaNodosNiveles(NodoBinario<Integer> actual, Integer nivel1, Integer nivel2, Integer aux) {
        int suma = 0;
        if (nivel1 <= aux) {
            suma += actual.getElemento();
        }
        aux++;
        if (aux <= nivel2 && actual.getDer() != null) {
            suma += sumaNodosNiveles(actual.getDer(), nivel1, nivel2, aux);
        }
        if (aux <= nivel2 && actual.getIzq() != null) {
            suma += sumaNodosNiveles(actual.getIzq(), nivel1, nivel2, aux);
        }
        return suma;
    }

    /**
     * Método lanzadera de TotalImparesNivel, verifica que el árbol no está vacío
     *
     * @param nivel
     * @return int
     */
    public Integer totalImparesNivel(Integer nivel) {
        return totalImparesNivel(this.nodoRaiz(), nivel, 0);
    }

    /**
     * Método recursivo
     *
     * @param actual
     * @param nivel
     * @param aux
     * @return int
     */
    public Integer totalImparesNivel(NodoBinario<Integer> actual, Integer nivel, Integer aux) {
        int contador = 0;
        if (nivel <= aux) {
            if (actual.getElemento() % 2 != 0) {
                contador++;
            }
        }
        aux++;

        if (aux <= nivel && actual.getDer() != null) {
            contador += totalImparesNivel(actual.getDer(), nivel, aux);

        }
        if (aux <= nivel && actual.getIzq() != null) {
            contador += totalImparesNivel(actual.getIzq(), nivel, aux);
        }

        return contador;
    }
}
