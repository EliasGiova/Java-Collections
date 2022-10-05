package servicio;

import entidad.Tienda;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * Se necesita una aplicación para una tienda en la cual queremos almacenar los
 * distintos productos que venderemos y el precio que tendrán. Además, se
 * necesita que la aplicación cuente con las funciones básicas. Estas las
 * realizaremos en el servicio. Como, introducir un elemento, modificar su
 * precio, eliminar un producto y mostrar los productos que tenemos con su
 * precio (Utilizar Hashmap). El HashMap tendrá de llave el nombre del producto
 * y de valor el precio. Realizar un menú para lograr todas las acciones
 * previamente mencionadas.
 *
 * @author elias
 */
public class servicioTienda {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    public HashMap<String, Integer> productos() {
        Tienda cp = new Tienda();
        HashMap<String, Integer> listaProductos = new HashMap();
        String resp;
        System.out.println("Bienvenido A La Tienda");
        do {
            System.out.println("Ingrese El Producto");
            cp.setProducto(leer.next().toLowerCase());
            System.out.println("Ingrese El Precio");
            cp.setPrecio(leer.nextInt());
            System.out.println("Desea agregar otro producto? si/no");
            resp = leer.next().toLowerCase();
            while (!"si".equalsIgnoreCase(resp) && !"no".equalsIgnoreCase(resp)) {
                System.out.println("No es una opcion Valida");
                System.out.println("Desea Agregar Otro Producto");
                resp = leer.next();
            }
            listaProductos.put(cp.getProducto(), cp.getPrecio());
        } while ("si".equalsIgnoreCase(resp));
        return listaProductos;
    }

    public void mostrarProductos(HashMap<String, Integer> productos) {
        for (Map.Entry<String, Integer> entry : productos.entrySet()) {
            System.out.println("Producto: " + entry.getKey() + "\nPrecio: " + entry.getValue() + "\n");
        }
    }

    public void eliminarProductos(HashMap<String, Integer> productos) {
        System.out.println("Que producto desea eliminar");
        String resp = leer.next().toLowerCase();
        Iterator<Entry<String, Integer>> iterator = productos.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getKey().equalsIgnoreCase(resp)) {
                iterator.remove();
            }
        }
//        if(productos.containsKey(resp)){
//            productos.remove(resp);
//        }
    }

    public void modificarPrecio(HashMap<String, Integer> productos) {
        System.out.println("Que producto desea modificar su precio");
        String resp = leer.next().toLowerCase();
        Iterator<Entry<String, Integer>> iterator = productos.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getKey().equalsIgnoreCase(resp)) {
                System.out.println("Ingrese el nuevo precio");
                productos.replace(resp, leer.nextInt());
            }
        }
    }

    public void agregarProducto(HashMap<String, Integer> productos) {
        String resp = "";
        String prod;
        int precio;
        while (!"no".equalsIgnoreCase(resp)) {
            System.out.println("Desea Agregar un Producto nuevo");
            resp = leer.next().toLowerCase();
            if (resp.equalsIgnoreCase("si")) {
                System.out.println("Agregue Un Producto");
                prod = leer.next();
                System.out.println("Su Precio es: ");
                precio = leer.nextInt();
                productos.put(prod, precio);
            } else {
                System.out.println("Respuesta no Valida");
            }
        }
    }

    public void menu(HashMap<String, Integer> productos) {
        int resp;
        do {
            System.out.println("1-Agregar Productos");
            System.out.println("2-Eliminar Productos");
            System.out.println("3-Modificar Precio Del Producto");
            System.out.println("4-Mostrar Lista");
            System.out.println("5-Salir");
            resp = leer.nextInt();
            switch (resp) {
                case 1:
                    agregarProducto(productos);
                    break;
                case 2:
                    eliminarProductos(productos);
                    break;
                case 3:
                    modificarPrecio(productos);
                    break;
                case 4:
                    mostrarProductos(productos);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (resp != 5);
        System.out.println("\nHa Salido De La Tienda");
    }
}
