import java.io.*;

public class ArchivosBinarios {

    public static void main(String[] args) {

        try {

            // Matriz del archivo A
            FileInputStream matA = new FileInputStream("src/a.mat");
            int renglonesA = matA.read();
            int columnasA = matA.read();
            double[][] matrizA = new double[renglonesA][columnasA];

            for (int i = 0; i < renglonesA; i++) {
                for (int j = 0; j < columnasA; j++) {
                    DataInputStream datosMatriz = new DataInputStream(matA);
                    matrizA[i][j] = datosMatriz.readDouble();
                }
            }
            matA.close();

            // Matriz del archivo B
            FileInputStream matB = new FileInputStream("src/b.mat");
            int renglonesB = matB.read();
            int columnasB = matB.read();
            double[][] matrizB = new double[renglonesB][columnasB];

            for (int i = 0; i < renglonesB; i++) {
                for (int j = 0; j < columnasB; j++) {
                    DataInputStream datosMatriz = new DataInputStream(matB);
                    matrizB[i][j] = datosMatriz.readDouble();
                }
            }
            matB.close();

            // Comprobar si es posible multiplicar las matrices
            if (columnasA != renglonesB){
                System.out.println("No puede hacerse la multiplicación de las matrices");
                return;
            }

            // Hacer las multiplicaciones
            double[][] matrizC = new double[renglonesA][columnasB];

            for (int i = 0; i < renglonesA; i++) {
                for (int j = 0; j < columnasB; j++) {
                    for (int k = 0; k < columnasA; k++) {
                        matrizC[i][j] += matrizA[i][k] * matrizB[k][j];
                    }
                }
            }

            // Escribir matrizC en el archivo c.mat
            FileOutputStream matC = new FileOutputStream("c.mat");
            matC.write(renglonesA);
            matC.write(columnasB);

            for (int i = 0; i < renglonesA; i++) {
                for (int j = 0; j < matrizC[0].length; j++) {
                    DataOutputStream datosMatrizC = new DataOutputStream(matC);
                    datosMatrizC.writeDouble(matrizC[i][j]);
                }
            }
            matC.close();

            // Imprimir las matrices
            System.out.println("Matriz del archivo a.mat: \n");
            for (int i = 0; i < renglonesA; i++) {
                for (int j = 0; j < columnasA; j++) {
                    System.out.print(matrizA[i][j] + "\t");
                }
                System.out.println();
            }

            System.out.println("Matriz del archivo b.mat: \n");
            for (int i = 0; i < renglonesB; i++) {
                for (int j = 0; j < columnasB; j++) {
                    System.out.print(matrizB[i][j] + "\t");
                }
                System.out.println();
            }

            System.out.println("Matriz del archivo c.mat: \n");
            for (int i = 0; i < renglonesA; i++) {
                for (int j = 0; j < columnasB; j++) {
                    System.out.print(matrizC[i][j] + "\t");
                }
                System.out.println();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

