package listaordinal;

import java.sql.SQLOutput;

public class PruebasLista {
    public static void main(String[] args) {
        // Introducir aquí las pruebas pedidas en la práctica
        ListaOrdinal lista =new ListaOrdinal();
        System.out.println("---------- PRODUCTOS EN LA LISTA -----------");
        Producto producto1 = new Producto("Mesa escritorio",185,2);
        Producto producto2 = new Producto("Silla oficina", 95.9F, 3);
        Producto producto3 = new Producto("Mesa cocina",125F, 1);
        Producto producto4 = new Producto("Sillón reclinable",230, 2);

        lista.insertar(producto1);
        lista.insertar(producto2);
        lista.insertar(producto3);
        lista.insertar(producto4);
        lista.mostrar();
        lista.borrar(producto2);
        System.out.println("Después de borrar las sillas de oficina:");
        lista.mostrar();

        //3.2
        Factura factura = new Factura("12345678B", "17/03/2021");

        factura.añadirProducto(producto1);
        factura.añadirProducto(producto2);
        factura.añadirProducto(producto3);
        factura.añadirProducto(producto4);
        Producto producto5 = new Producto("Silla oficina", 95.9F, 1);
        factura.añadirProducto(producto5);
        factura.mostrar();

        //3.3
        System.out.println("IMPORTE TOTAL: "+ factura.importeTotal() + "€\n");

        //3.4
        Producto producto6 = new Producto("Silla oficina", 95.9F, 2);
        Producto producto7 = new Producto("Sillón reclinable",230, 3);

        int eliminadas=0;
        eliminadas+= factura.eliminarProducto(producto6);
        eliminadas+= factura.eliminarProducto(producto7);
        System.out.println("Se han eliminado "+ eliminadas + " unidades");
        factura.mostrar();
        System.out.println("IMPORTE TOTAL: "+ factura.importeTotal() + "€");

        //3.5
        int cantidad=100;
        System.out.println("\n Se han obtenido "+ factura.mayoresPrecios(cantidad).getNumElementos() + " productos con precio mayor a " + cantidad + " € por unidad" );
        factura.mayoresPrecios(cantidad).mostrar();


        //4
        FacturaBib factura2 = new FacturaBib("88888888A", "08/08/2008");

        Producto producto8 = new Producto("Armario",385, 5);
        Producto producto9 = new Producto("Cama",255, 3);
        Producto producto10 = new Producto("Cama",255, 2);
        Producto producto11 = new Producto("Armario",385, 1);

        factura2.añadirProducto(producto8);
        factura2.añadirProducto(producto9);
        factura2.añadirProducto(producto10);
        factura2.eliminarProducto(producto11);
        factura2.mostrar();
        System.out.println("IMPORTE TOTAL: "+ factura2.importeTotal() + "€");

        int cantidad2=250;
        System.out.println("\n Se han obtenido "+ factura2.mayoresPrecios(cantidad).getNumElementos() + " productos con precio mayor a " + cantidad2 + " € por unidad" );
        factura2.mayoresPrecios(cantidad).mostrar();







    }
}
