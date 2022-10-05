package collectionej4;

import entidad.Pelicula;
import java.util.ArrayList;
import servicio.servicioPelicula;

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
 * 22
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
public class CollectionEj4 {

    public static void main(String[] args) {
        
        servicioPelicula servPeli = new servicioPelicula();
        
        ArrayList<Pelicula> nombrePeli = servPeli.agregarPelicula();
        System.out.println("--------------------");
        servPeli.mostrarPelicula(nombrePeli);
        System.out.println("--------------------");
        servPeli.mostrarPelisMasDeUnaHora(nombrePeli);
        System.out.println("--------------------");
        System.out.println("Peliculas de Menor a Mayor duracion");
        nombrePeli.sort(servPeli.menorAMayorDuracion);
        servPeli.mostrarPelicula(nombrePeli);
        System.out.println("--------------------");
        System.out.println("Peliculas de Mayor a Menor duracion");
        nombrePeli.sort(servPeli.mayorAMenorDuracion);
        servPeli.mostrarPelicula(nombrePeli);
        System.out.println("--------------------");
        System.out.println("Peliculas Alfabeticamente Por Titulo");
        nombrePeli.sort(servPeli.porTitulo);
        servPeli.mostrarPelicula(nombrePeli);
        System.out.println("--------------------");
        System.out.println("Peliculas Alfabeticamente Por Director");
        nombrePeli.sort(servPeli.porDirector);
        servPeli.mostrarPelicula(nombrePeli);
        
    }
}
