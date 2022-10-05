/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collectionej5;

import entidad.Pais;
import java.util.ArrayList;
import java.util.HashSet;
import servicio.servicioPais;

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
public class CollectionEj5 {

    public static void main(String[] args) {
        
        servicioPais servPais = new servicioPais();
        
        HashSet <Pais> paises = servPais.conjuntoPais();
        System.out.println("------------------");
        servPais.mostrarPais(paises);
        System.out.println("------------------");
        ArrayList <Pais> conjuntoPais = new ArrayList(paises);
        conjuntoPais.sort(servPais.ordenAlfabetico);
        servPais.mostrarPais(conjuntoPais);
        System.out.println("------------------");
        servPais.eliminarPais(conjuntoPais);
        System.out.println("------------------");
        servPais.mostrarPais(conjuntoPais);    
    }
}
