
package listaordinal;
import java.util.Iterator;
import java.util.LinkedList;

public class FacturaBib {
    private String dni;
    private String fecha;
    private LinkedList<Producto> listaProductos;
    private boolean cobrada;

    public FacturaBib(String dni, String fecha) {
        this.dni = dni;
        this.fecha = fecha;
        listaProductos = new LinkedList<>();
        cobrada = false;
    }

    public String getDNI() {
        return dni;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean estaCobrada() {
        return cobrada;
    }

    public void cobrada() {
        cobrada = true;
    }

    public void añadirProducto(Producto producto) {
        Iterator<Producto> iter = listaProductos.iterator();
        while (iter.hasNext()) {
            Producto siguiente = iter.next();
            if (siguiente.equals(producto)) {
                siguiente.setUnidades(siguiente.getUnidades()+producto.getUnidades());
                return;
            }
        }
        listaProductos.add(producto);
    }

    public void mostrar() {
        System.out.println("FACTURA de: " + dni + ". Fecha: " + fecha);
        Iterator<Producto> iter = listaProductos.iterator();
        while (iter.hasNext()) {
            Producto siguiente = iter.next();
            float importe = siguiente.getUnidades() * siguiente.getPrecio();
            System.out.println(siguiente.getDescripcion() + " (" + siguiente.getUnidades() + " unidades) a " + siguiente.getPrecio() + " € c/u. Importe: " + importe + " €");
        }
    }

    public float importeTotal() {
        Iterator<Producto> iter = listaProductos.iterator();
        float importe=0.0F;
        while (iter.hasNext()) {
            Producto siguiente = iter.next();
            importe += siguiente.getUnidades() * siguiente.getPrecio();
        }
        return importe;
    }

    public int eliminarProducto(Producto producto) {
        Iterator<Producto> iter = listaProductos.iterator();
        int unidadesEliminadas = 0;
        while (iter.hasNext()) {
            Producto siguiente = iter.next();
            if (siguiente.equals(producto)) {
                int unidadesEnLista = siguiente.getUnidades();
                int unidadesAEliminar = producto.getUnidades();
                if (unidadesAEliminar >= unidadesEnLista) {
                    unidadesEliminadas = unidadesEnLista;
                    listaProductos.remove(siguiente);
                } else {
                    int nuevasUnidades = unidadesEnLista - unidadesAEliminar;
                    siguiente.setUnidades(nuevasUnidades);
                    unidadesEliminadas = unidadesAEliminar;
                }
                break;
            }
        }
        return unidadesEliminadas;
    }

    public ListaOrdinal mayoresPrecios(float precio) {
        ListaOrdinal listaMayorPrecio = new ListaOrdinal();
        Iterator<Producto> iter = listaProductos.iterator();
        while(iter.hasNext()){
            Producto siguiente = iter.next();
            float precioProducto = siguiente.getPrecio();
            if(precioProducto > precio){
                listaMayorPrecio.insertar(siguiente);
            }
        }
        return listaMayorPrecio;
    }
}
