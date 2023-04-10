package conjunto;

public class Algoritmos {
    public Conjunto interseccion(Conjunto conjunto1, Conjunto conjunto2) {
        Conjunto interseccion = new Conjunto();
        int[] array1 = conjunto1.toArray();
        int[] array2 = conjunto2.toArray();
        for (int i=0;i<array1.length;i++)
            for(int j=0;j<array2.length;j++)
                if(array1[i]==array2[j])
                    interseccion.insertar(array1[i]);
        return interseccion;
    }


}
