package practica2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author MORENO MARTIN, LYDIA Y SANCHEZ GOZALO, JAVIER
 */
public class MyInput {
//Lee una cadena de caracteres desde el teclado

    /**
     * @return
     */
    public static String readString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1);
        String string = "";
        try {
            string = br.readLine();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return string;
    }
//Lee un dato tipo int desde el teclado

    /**
     * @return
     * @throws NumberFormatException
     */
    public static int readInt() throws NumberFormatException {

        return Integer.parseInt(readString());

    }

}