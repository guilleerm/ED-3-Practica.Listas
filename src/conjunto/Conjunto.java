package conjunto;

public class Conjunto {

    private Nodo inicio;
    private int numElementos;

    public Conjunto() {
        inicio = null;
        numElementos = 0;
    }

    public boolean vacio() {
        return inicio == null;
    }

    /**
     * Inserta el dato en la posición que le corresponde
     */
    public boolean insertar(int dato) {
        if (dato >= 0) {
            Nodo anterior = null;
            Nodo actual = inicio;
            while ((actual != null) && (actual.getDato() < dato)) {  // Buscar posición de inserción
                anterior = actual;
                actual = actual.getSiguiente();
            }
            if ((actual == null) || (actual.getDato() > dato)) {  // Insertar antes de actual
                Nodo nuevo = new Nodo(dato, actual);
                if (actual == inicio) {  // insertar al principio de la lista
                    inicio = nuevo;
                } else {
                    anterior.setSiguiente(nuevo);
                }
                numElementos++;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    /**
     * Determina si la clave recibida como parámetro existe en la lista.
     */
    public boolean contiene(int dato) {
        Nodo actual = inicio;
        while ((actual != null) && (actual.getDato() < dato)) {  // Buscar dato
            actual = actual.getSiguiente();
        }
        return (actual != null) && (actual.getDato() == dato);
    }

    /**
     * Elimina de la lista el alumno con número de matrícula clave,
     * en caso de existir.
     */
    public boolean borrar(int dato) {
        Nodo actual = inicio;
        Nodo anterior = null;
        while ((actual != null) && (actual.getDato() < dato)) {  // Buscar dato
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if ((actual == null) || (actual.getDato() > dato)) {  // No existe clave
            return false;
        } else {  // Clave encontrada
            if (actual == inicio) {    // eliminar el primero de la lista
                inicio = actual.getSiguiente();
            } else {
                anterior.setSiguiente(actual.getSiguiente());
            }
            numElementos--;
            return true;
        }
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void mostrar() {
        if (this.vacio()) {
            System.out.println ("Conjunto vacío");
        } else {
            System.out.print("[ " + inicio.getDato());
            Nodo actual = inicio.getSiguiente();
            while (actual != null) {
                System.out.print(", " + actual.getDato());
                actual = actual.getSiguiente();
            }
            System.out.println(" ]");
        }
    }



    public int[] toArray() {
        int[] array= new int[numElementos];
        Nodo actual = inicio;
        int i= 0;
        while (actual!= null){
            array[i]= actual.getDato();
            actual=actual.getSiguiente();
            i++;
        }
        return array;
    }


    public int mayor() {
        Nodo actual = inicio;
        int mayor=0;
        if(!vacio()){
            while(actual!=null){
                if(mayor<actual.getDato())
                    mayor= actual.getDato();
                actual=actual.getSiguiente();
            }
        }else return -1;

        return mayor;
    }

    public Conjunto subconjunto(int inferior, int superior) {
        Conjunto subconjunto = new Conjunto();
        Nodo actual = inicio;
        while (actual != null && actual.getDato() <= superior) {
            if (actual.getDato() >= inferior) {
                subconjunto.insertar(actual.getDato());
            }
            actual = actual.getSiguiente();
        }
        return subconjunto;
    }

    public boolean equals(Conjunto conjunto) {
        if (this.numElementos != conjunto.getNumElementos()) {
            return false;
        }
        Nodo actual1 = this.inicio;
        Nodo actual2 = conjunto.inicio;
        while (actual1 != null) {
            if (actual1.getDato() != actual2.getDato()) {
                return false;
            }
            actual1 = actual1.getSiguiente();
            actual2 = actual2.getSiguiente();
        }
        return true;
    }
}
