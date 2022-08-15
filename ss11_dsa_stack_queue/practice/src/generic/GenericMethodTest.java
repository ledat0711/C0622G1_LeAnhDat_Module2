package generic;

public class GenericMethodTest {
    // generic method printArrayGeneric
    public static < E > void printArrayGeneric( E[] inputArrayGeneric ) {
        // Display array elements
        for(E elementGeneric : inputArrayGeneric) {
            System.out.print(elementGeneric + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        // Create arrays of Integer, Double and Character
        Integer[] intArrayGeneric = { 2,4,6,8,10 };
        Double[] doubleArrayGeneric = { 2.1, 3.2, 4.3, 5.4 };
        Character[] charArrayGeneric = { 'L', 'E', 'V', 'U', 'O' };

        System.out.println("Array intArrayGeneric contains:");
        printArrayGeneric(intArrayGeneric);   // pass an Integer array

        System.out.println("\nArray doubleArray contains:");
        printArrayGeneric(doubleArrayGeneric);   // pass a Double array

        System.out.println("\nArray characterArray contains:");
        printArrayGeneric(charArrayGeneric);   // pass a Character array
    }
}
   