/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

import estructuraDeDatos.jerarquico.ABEnteros;
import excepciones.ArbolVacioExcepcion;

/**
 * @author @author MORENO MARTIN, LYDIA Y SANCHEZ GOZALO, JAVIER
 */
public class Interfaz {
    public Interfaz() {
        int opcion = 0;
        boolean flag = true;
        ABEnteros arbol1 = new ABEnteros();
        ABEnteros arbol2 = new ABEnteros();

        do {
            System.out.println("\t\t\t\t MENÚ AB de enteros");
            System.out.println("1.  Crear AB de enteros");
            System.out.println("2.  Listado de claves en InOrden");
            System.out.println("3.  Listado de claves en PreOrden");
            System.out.println("4.  Listado de claves en PostOrden");
            System.out.println("5.  Comprobar sumas");
            System.out.println("6.  Comprobrar clave pequeña");
            System.out.println("7.  Borrar Árbol Modo 1 (sin recorrer el árbol)");
            System.out.println("8.  Borrar Árbol Modo 2 (recorriendo todos sus nodos)");
            System.out.println("9.  Mostrar ascendientes");
            System.out.println("10. Suma total de nodos entre dos niveles");
            System.out.println("11. Número de nodos impares que hay en un nivel");

            System.out.println("0.  Salir");

            System.out.println("\n Introduzca la opción:");
            try {
                opcion = MyInput.readInt();
            } catch (NumberFormatException e) {
                System.out.println("El valor introducido es incorrecto");
            }
            switch (opcion) {
                case 1:
                    arbol1 = arbol1.crearAB1();
                    arbol2 = arbol2.crearAB2();
                    break;
                case 2:
                    if (subMenu() == 1) {
                        try {
                            System.out.println("Recorrido en InOrden: " + arbol1.toStringInOrden());
                        } catch (ArbolVacioExcepcion e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        try {
                            System.out.println("Recorrido en InOrden: " + arbol2.toStringInOrden());
                        } catch (ArbolVacioExcepcion e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 3:
                    if (subMenu() == 1) {
                        try {
                            System.out.println("Recorrido en PreOrden: " + arbol1.toStringPreOrden());
                        } catch (ArbolVacioExcepcion e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        try {
                            System.out.println("Recorrido en PreOrden: " + arbol2.toStringPreOrden());
                        } catch (ArbolVacioExcepcion e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 4:
                    if (subMenu() == 1) {
                        try {
                            System.out.println("Recorrido en PostOrden: " + arbol1.toStringPostOrden());
                        } catch (ArbolVacioExcepcion e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        try {
                            System.out.println("Recorrido en PostOrden: " + arbol2.toStringPostOrden());
                        } catch (ArbolVacioExcepcion e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 5:
                    if (subMenu() == 1) {
                        try {
                            if (arbol1.comprobarSumas() % 2 == 0) {
                                System.out.println("El árbol AB1 si cumple la condición de suma considerada");
                            } else {
                                System.out.println("El árbol AB1 no cumple la condición de suma considerada");
                            }
                        } catch (ArbolVacioExcepcion e) {
                            System.out.println("El árbol AB1 si cumple la condición de suma considerada");
                        }
                    } else {
                        try {
                            if (arbol2.comprobarSumas() % 2 == 0) {
                                System.out.println("El árbol AB2 si cumple la condición de suma considerada");
                            } else {
                                System.out.println("El árbol AB2 no cumple la condición de suma considerada");
                            }
                        } catch (ArbolVacioExcepcion e) {
                            System.out.println("El árbol AB2 si cumple la condición de suma considerada");
                        }
                    }
                    break;
                case 6:
                    if (subMenu() == 1) {
                        try {
                            if (arbol1.ABclavePequeña() == true) {
                                System.out.println("El árbol AB1 si cumple la propiedad de clave pequeña en cada nodo");
                            } else {
                                System.out.println("El árbol AB1 no cumple la propiedad de clave pequeña en cada nodo");
                            }
                        } catch (ArbolVacioExcepcion e) {
                            System.out.println("El árbol AB1 si cumple la propiedad de clave pequeña en cada nodo");
                        }
                    } else {
                        try {
                            if (arbol2.ABclavePequeña() == true) {
                                System.out.println("El árbol AB2 si cumple la propiedad de clave pequeña en cada nodo");
                            } else {
                                System.out.println("El árbol AB2 no cumple la propiedad de clave pequeña en cada nodo");
                            }
                        } catch (ArbolVacioExcepcion e) {
                            System.out.println("El árbol AB2 si cumple la propiedad de clave pequeña en cada nodo");
                        }
                    }
                    break;
                case 7:
                    if (subMenu() == 1) {
                        arbol1.BorrarArbolModo1();
                    } else {
                        arbol2.BorrarArbolModo1();
                    }
                    break;
                case 8:
                    if (subMenu() == 1) {
                        try {
                            arbol1.BorrarArbolModo2();
                        } catch (ArbolVacioExcepcion e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        try {
                            arbol2.BorrarArbolModo2();
                        } catch (ArbolVacioExcepcion e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 9:
                    int clave = 0;

                    System.out.println("Introduzca un número entero (clave entera)");

                    try {
                        clave = MyInput.readInt();
                    } catch (NumberFormatException e) {
                        System.out.println("El valor introducido es incorrecto");
                    }

                    if (subMenu() == 1) {

                        try {
                            if (arbol1.mostrarAscendientes(clave) != null) {
                                System.out.println("Considerando el árbol AB1 y el nodo " + clave + ", sus ascendientes son " + arbol1.mostrarAscendientes(clave));
                            } else {
                                System.out.println("La clave introducida no existe");
                            }
                        } catch (ArbolVacioExcepcion e) {
                            System.out.println(e.getMessage());
                        }
                    } else {

                        try {
                            if (arbol2.mostrarAscendientes(clave) != null) {
                                System.out.println("Considerando el árbol AB2 y el nodo " + clave + ",sus ascendientes son " + arbol2.mostrarAscendientes(clave));
                            } else {
                                System.out.println("La clave introducida no existe");
                            }
                        } catch (ArbolVacioExcepcion e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 10:

                    int PrimNivel = 0;
                    int SegNivel = 0;

                    if (subMenu() == 1) {
                        if (arbol1.nivelesAB() == -1) {
                            System.out.println("Árbol vacío");
                            break;
                        }
                        System.out.println("Introduzca nivel K1: ");
                        try {
                            PrimNivel = MyInput.readInt();
                            if (PrimNivel > arbol1.nivelesAB()) {
                                System.out.println("Nivel introducido no válido");
                                break;
                            }
                            System.out.println("Introduzca nivel K2: ");
                            SegNivel = MyInput.readInt();
                        } catch (NumberFormatException e) {
                            System.out.println("El valor introducido es incorrecto");
                        }

                        if (SegNivel > arbol1.nivelesAB()) {
                            System.out.println("Nivel introducido no válido");
                        }
                        if (PrimNivel <= SegNivel) {
                            System.out.println("La suma de elementos etre estos niveles es :" + arbol1.sumaNodosNiveles(PrimNivel, SegNivel));
                        }

                    } else {
                        if (arbol2.nivelesAB() == -1) {
                            System.out.println("Árbol vacío");
                            break;
                        }
                        System.out.println("Introduzca nivel K1: ");
                        try {
                            PrimNivel = MyInput.readInt();
                            if (PrimNivel > arbol2.nivelesAB()) {
                                System.out.println("Nivel introducido no válido");
                                break;
                            }
                            System.out.println("Introduzca nivel K2: ");
                            SegNivel = MyInput.readInt();
                        } catch (NumberFormatException e) {
                            System.out.println("El valor introducido es incorrecto");
                        }

                        if (SegNivel > arbol2.nivelesAB()) {
                            System.out.println("Nivel introducido no válido");
                        }
                        if (PrimNivel <= SegNivel) {
                            System.out.println("La suma de elementos etre estos niveles es :" + arbol2.sumaNodosNiveles(PrimNivel, SegNivel));
                        }

                    }
                    break;
                case 11:
                    int Nivel = 0;

                    if (subMenu() == 1) {

                        if (arbol1.nivelesAB() == -1) {
                            System.out.println("Árbol vacío");
                            break;
                        }
                        System.out.println("Introduzca un nivel");

                        try {
                            Nivel = MyInput.readInt();
                        } catch (NumberFormatException e) {
                            System.out.println("El valor introducido es incorrecto");
                        }
                        if (Nivel > arbol1.nivelesAB()) {
                            System.out.println("Error: Ese nivel no existe");
                            break;
                        }

                        System.out.println("Considerando el árbol AB1 y el nivel " + Nivel + ", el número de nodos impares que hay en ese nivel es " + arbol1.totalImparesNivel(Nivel));

                    } else {
                        if (arbol2.nivelesAB() == -1) {
                            System.out.println("Árbol vacío");
                            break;
                        }
                        System.out.println("Introduzca un nivel");

                        try {
                            Nivel = MyInput.readInt();
                        } catch (NumberFormatException e) {
                            System.out.println("El valor introducido es incorrecto");
                        }
                        if (Nivel > arbol2.nivelesAB()) {
                            System.out.println("Error: Ese nivel no existe");
                            break;
                        }

                        System.out.println("Considerando el árbol AB2 y el nivel " + Nivel + ", el número de nodos impares que hay en ese nivel es " + arbol2.totalImparesNivel(Nivel));


                    }


                    break;

                case 0:
                    System.out.println("Gracias por utilizar nuestro TAD ABEnteros");

                    flag = false;
                    break;

            }


        } while (opcion < 0 || opcion > 11 || flag == true);
    }

    public static int subMenu() {
        int opcion = 0;

        do {
            System.out.println("INDIQUE CUÁL ES EL ÁRBOL QUE DESEA CONSIDERAR");
            System.out.println("1. AB1");
            System.out.println("2. AB2");

            System.out.println("Introduzca la opción");
            try {
                opcion = MyInput.readInt();
            } catch (NumberFormatException e) {
                System.out.println("El valor introducido es incorrecto");

            }
        } while (opcion < 1 || opcion > 2);

        return opcion;
    }
}
