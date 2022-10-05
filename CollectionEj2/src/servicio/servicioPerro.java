/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidad.Perro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Continuando el ejercicio anterior, después de mostrar los perros, al usuario
 * se le pedirá un perro y se recorrerá la lista con un Iterator, se buscará el
 * perro en la lista. Si el perro está en la lista, se eliminará el perro que
 * ingresó el usuario y se mostrará la lista ordenada. Si el perro no se
 * encuentra en la lista, se le informará al usuario y se mostrará la lista
 * ordenada.
 *
 * @author elias
 */
public class servicioPerro {
    private Scanner leer;
    private ArrayList <String> perros;
    Perro cp;
    
    
    public servicioPerro(){
        leer = new Scanner(System.in).useDelimiter("\n");
        perros = new ArrayList();
        cp =  new Perro();
    }
    
    public void crearPerro(){
        String condicion;
        do{
            System.out.println("Ingrese la raza de Perro");
            cp.setRaza(leer.next());
            perros.add(cp.getRaza());
            System.out.println("Desea Ingresar otra Raza si/no?");
            condicion = leer.next();
        }while ("si".equalsIgnoreCase(condicion));
    }
    
    public void mostrarPerro(){
        System.out.println("Los Perros Ingresados son: ");
        for (String aux : perros) {
            System.out.println(aux);
        }
        
        System.out.println("La cantidad de Perros es: " + perros.size());
    }
    
    public void buscarPerro(){
        System.out.println("Ingrese La raza que quiere buscar");
        String raza1 = leer.next();
        Iterator <String> perrosit = perros.iterator();//Se hace dentro del metodo que se va a utilizar.
        while(perrosit.hasNext()){
            if(perrosit.next().equals(raza1)){
                perrosit.remove();
            }
        }
        System.out.println("Se ha eliminado " + raza1);
    }
}
