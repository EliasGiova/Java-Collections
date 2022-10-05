/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidad.Perro;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo
 * String. El programa pedirá una raza de perro en un bucle, el mismo se
 * guardará en la lista y después se le preguntará al usuario si quiere guardar
 * otro perro o si quiere salir. Si decide salir, se mostrará todos los perros
 * guardados en el ArrayList.
 *
 * @author elias
 */
public class servicioPerro {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public Perro crearPerro() {
        String condicion;
        Perro cp = new Perro();
        System.out.println("Ingrese la raza de Perro");
        cp.setRaza(leer.next());
        return cp;
    }

    public ArrayList<Perro> agregarPerro() {
        ArrayList<Perro> agregaPerro = new ArrayList();
        String resp;
        do {
            agregaPerro.add(crearPerro());
            System.out.println("Desea Agregar Otro Perro s/n");
            resp = leer.next();
            while (!"si".equalsIgnoreCase(resp) && !"no".equalsIgnoreCase(resp)) {
                System.out.println("No es una opcion Valida");
                System.out.println("Desea Agregar Otro Perro s/n");
                resp = leer.next();
            }
        } while ("si".equalsIgnoreCase(resp));
        return agregaPerro;
    }

    public void mostrarPerro(ArrayList<Perro> razaPerro) {
        System.out.println("Los Perros Ingresados son: ");
        for (Perro perro : razaPerro) {
            System.out.println("Raza: "+ perro.getRaza());
        }

        System.out.println("La cantidad de Perros es: " + razaPerro.size());
    }
}
