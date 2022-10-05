/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidad.Pais;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Se requiere un programa que lea y guarde países, y para evitar que se
 * ingresen repetidos usaremos un conjunto. El programa pedirá un país en un
 * bucle, se guardará el país en el conjunto y después se le preguntará al
 * usuario si quiere guardar otro país o si quiere salir, si decide salir, se
 * mostrará todos los países guardados en el conjunto. (Recordemos hacer los
 * servicios en la clase correspondiente) Después deberemos mostrar el conjunto
 * ordenado alfabéticamente: para esto recordar cómo se ordena un conjunto. Por
 * último, al usuario se le pedirá un país y se recorrerá el conjunto con un
 * Iterator, se buscará el país en el conjunto y si está en el conjunto se
 * eliminará el país que ingresó el usuario y se mostrará el conjunto. Si el
 * país no se encuentra en el conjunto se le informará al usuario.
 *
 * @author elias
 */
public class servicioPais {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Pais cargarPais() {
        Pais namePais = new Pais();
        System.out.println("Ingrese un Pais");
        namePais.setNombrePais(leer.next());
        return namePais;
    }

    public HashSet<Pais> conjuntoPais() {
        HashSet<Pais> listaPais = new HashSet();
        String resp;

        do {
            listaPais.add(cargarPais());
            System.out.println("Desea agregar otro pais? si/no");
            resp = leer.next();
            while (!"si".equalsIgnoreCase(resp) && !"no".equalsIgnoreCase(resp)) {
                System.out.println("No es una opcion Valida");
                System.out.println("Desea Agregar Otro Pais");
                resp = leer.next();
            }
        } while ("si".equalsIgnoreCase(resp));
        return listaPais;
    }
    
    public void mostrarPais(HashSet <Pais> lista){
        for (Pais pais : lista) {
            System.out.println(pais.getNombrePais());
        }
    }
    
     public void mostrarPais(ArrayList <Pais> lista){
        for (Pais pais : lista) {
            System.out.println(pais.getNombrePais());
        }
    }
    
    public static Comparator <Pais> ordenAlfabetico = new Comparator <Pais> () {
        @Override
        public int compare(Pais t1, Pais t2) {
            return t1.getNombrePais().compareTo(t2.getNombrePais());
        }
    };
    
    public void eliminarPais(ArrayList <Pais> pais){
        System.out.println("Que pais quiere eliminar");
        String resp = leer.next();
        Iterator <Pais> eliminado = pais.iterator();
        while (eliminado.hasNext()) {
            if(eliminado.next().getNombrePais().equalsIgnoreCase(resp)){
                eliminado.remove();
            }
        }
    }
}
