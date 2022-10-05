package servicio;

import entidad.Pelicula;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Un cine necesita implementar un sistema en el que se puedan cargar peliculas.
 * Para esto, tendremos una clase Pelicula con el título, director y duración de
 * la película (en horas). Implemente las clases y métodos necesarios para esta
 * situación, teniendo en cuenta lo que se pide a continuación: En el servicio
 * deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
 * todos sus datos y guardándolos en el objeto Pelicula. Después, esa Pelicula
 * se guarda una lista de Peliculas y se le pregunta al usuario si quiere crear
 * otra Pelicula o no. Después de ese bucle realizaremos las siguientes
 * acciones:
 *
 * 22
 *
 * • Mostrar en pantalla todas las películas. • Mostrar en pantalla todas las
 * películas con una duración mayor a 1 hora. • Ordenar las películas de acuerdo
 * a su duración (de mayor a menor) y mostrarlo en pantalla. • Ordenar las
 * películas de acuerdo a su duración (de menor a mayor) y mostrarlo en
 * pantalla. • Ordenar las películas por título, alfabéticamente y mostrarlo en
 * pantalla. • Ordenar las películas por director, alfabéticamente y mostrarlo
 * en pantalla.
 *
 * @author elias
 */
public class servicioPelicula {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public Pelicula cargarPelicula() {
        Pelicula peli = new Pelicula();//Objeto de tipo Pelicula
        System.out.println("Ingrese el nombre de la Pelicula");
        peli.setTitulo(leer.next());
        System.out.println("Ingrese el nombre del autor");
        peli.setDirector(leer.next());
        System.out.println("Ingrese la duracción en minutos");
        peli.setDuracion(leer.nextInt());
        return peli;
    }

    public ArrayList<Pelicula> agregarPelicula() {
        ArrayList<Pelicula> detallePeli = new ArrayList();
        String resp;
        do {
            detallePeli.add(cargarPelicula());
            System.out.println("Desea Agregar Otra Pelicula s/n");
            resp = leer.next();
            while(!"s".equalsIgnoreCase(resp)&& !"n".equalsIgnoreCase(resp)){
                System.out.println("No es una opcion Valida");
                System.out.println("Desea Agregar Otra Pelicula s/n");
                resp = leer.next();
            }
        } while ("s".equalsIgnoreCase(resp));
        return detallePeli;
    }

    public void mostrarPelicula(ArrayList<Pelicula> lista) {
        for (Pelicula pelicula : lista) {
            System.out.println(pelicula.toString());
        }
    }

    public void mostrarPelisMasDeUnaHora(ArrayList<Pelicula> lista) {
        System.out.println("Peliculas Mayores de 1 Hora");
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getDuracion() > 60) {
                System.out.println(lista.get(i).toString());
            }
        }
    }

    public static Comparator<Pelicula> menorAMayorDuracion = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula P1, Pelicula P2) {
            Integer temp1 = P1.getDuracion();
            Integer temp2 = P2.getDuracion();
            return temp1.compareTo(temp2);
        }
    };

    public static Comparator<Pelicula> mayorAMenorDuracion = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula P1, Pelicula P2) {
            Integer temp1 = P1.getDuracion();
            Integer temp2 = P2.getDuracion();
            return temp2.compareTo(temp1);
        }
    };
    
    public static Comparator<Pelicula> porTitulo = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula P1, Pelicula P2) {
            return P1.getTitulo().toUpperCase().compareTo(P2.getTitulo().toUpperCase());
        }    
    };
    
    public static Comparator<Pelicula> porDirector = new Comparator<Pelicula>() {
        @Override
        public int compare(Pelicula P1, Pelicula P2) {
            return P1.getDirector().toUpperCase().compareTo(P2.getDirector().toUpperCase());
        }    
    };
}
