package servicio;

import entidad.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Crear una clase llamada Alumno que mantenga información sobre las notas de
 * distintos alumnos. La clase Alumno tendrá como atributos, su nombre y una
 * lista de tipo Integer con sus 3 notas. En el servicio de Alumno deberemos
 * tener un bucle que crea un objeto Alumno. Se pide toda la información al
 * usuario y ese Alumno se guarda en una lista de tipo Alumno y se le pregunta
 * al usuario si quiere crear otro Alumno o no. Después de ese bucle tendremos
 * el siguiente método en el servicio de Alumno: Método notaFinal(): El usuario
 * ingresa el nombre del alumno que quiere calcular su nota final y se lo busca
 * en la lista de Alumnos. Si está en la lista, se llama al método. Dentro del
 * método se usará la lista notas para calcular el promedio final de alumno.
 * Siendo este promedio final, devuelto por el método y mostrado en el main.
 *
 * @author elias
 */
public class servicioAlumno {

    Scanner leer;
    Alumno ingresoAlumno;
    ArrayList<Integer> notasAlumno;
    ArrayList<String> nombreAlumno;

    public servicioAlumno() {
        leer = new Scanner(System.in).useDelimiter("\n");
        ingresoAlumno = new Alumno();
        notasAlumno = new ArrayList();
        nombreAlumno = new ArrayList();
    }

    public void cargaAlumno() {
        String resp;
        do {
            System.out.print("Ingrese el nombre del alumno: ");
            ingresoAlumno.setNombre(leer.next());
            nombreAlumno.add(ingresoAlumno.getNombre());
            System.out.print("Quiere Ingresar Otro Alumno s/n: ");
            resp = leer.next();
        } while ("s".equalsIgnoreCase(resp));
    }

    public void notaAlumno() {
        int prom;
        for (int i = 0; i < nombreAlumno.size(); i++) {
            System.out.println("Alumno: " + nombreAlumno.get(i));
            System.out.print("Ingrese Nota 1: ");
            ingresoAlumno.setNota1(leer.nextInt());
            System.out.print("Ingrese Nota 2: ");
            ingresoAlumno.setNota2(leer.nextInt());
            System.out.print("Ingrese Nota 3: ");
            ingresoAlumno.setNota3(leer.nextInt());
            prom = (ingresoAlumno.getNota1() + ingresoAlumno.getNota2() + ingresoAlumno.getNota3()) / 3;
            notasAlumno.add(i, prom);
        }
    }
    
    public void notaFinal() {
        System.out.println("Ingrese el nombre del Alumno que quiere buscar y sacar su promedio");
        String resp = leer.next();
        int cont=0;
        for (int i = 0; i < nombreAlumno.size(); i++) {
            if (resp.equalsIgnoreCase(nombreAlumno.get(i))) {
                System.out.println("El promedio es: " + notasAlumno.get(i));
            }else{
                cont++;
            }
        }
        if(cont==nombreAlumno.size()){
            System.out.println("El alumno no esta Registrado");
        }
    }
}
