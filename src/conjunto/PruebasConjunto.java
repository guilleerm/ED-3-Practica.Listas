package conjunto;

public class PruebasConjunto {

    public static void main(String[] args) {
        // Introducir aquí las pruebas pedidas en la práctica

        //5.1
        Conjunto conjunto = new Conjunto();
        conjunto.insertar(4);
        conjunto.insertar(6);
        conjunto.insertar(2);
        conjunto.insertar(4);
        conjunto.insertar(-2);
        System.out.println("Conjunto de trabajo:");
        conjunto.mostrar();

        //5.2
       int[] array= conjunto.toArray();
       System.out.print("El array contiene: ");
       for(int i =0; i< array.length; i++){
           System.out.print(array[i]+ " ");
       }

       //5.3
        System.out.println("\nEl mayor elemento es: "+ conjunto.mayor());

       //5.4
        int inferior=3;
        int superior=6;
        System.out.print("El subconjunto entre "+ inferior +" y " + superior + " es: ");
        conjunto.subconjunto(inferior, superior).mostrar();

        //5.5
        Conjunto conjunto2 = new Conjunto();
        conjunto2.insertar(2);
        conjunto2.insertar(4);

        System.out.print("Un conjunto es:");
        conjunto2.mostrar();
        System.out.println("Es igual que el conjunto de trabajo? " + conjunto.equals(conjunto2));

        conjunto2.insertar(6);

        System.out.print("Un conjunto es:");
        conjunto2.mostrar();
        System.out.println("Es igual que el conjunto de trabajo? " + conjunto.equals(conjunto2));





    }

}
