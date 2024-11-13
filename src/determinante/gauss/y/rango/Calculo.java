
package determinante.gauss.y.rango;

import java.util.ArrayList;
import javax.swing.JTextField;

public class Calculo {

    double matriz[][];
    int signo = 1;

    public double[][] Calcular(int tamaño, ArrayList<JTextField> array) {
       Generarmatriz(tamaño, array);
       while(!verficarcero() ){
           hacerceros();
       }
       return matriz;
    }

    private void imprimirmatriz() {
        for(int i=0;i<matriz.length;i++){
           for(int j=0;j<matriz.length;j++){
               System.out.print(matriz[i][j]+" ");
           }
            System.out.println("");
       }
    }

    private void Generarmatriz(int tamaño, ArrayList<JTextField> array) {
       matriz = new double[tamaño][tamaño];
       int index=0;
       for(int i=0;i<tamaño;i++){
           for(int j=0;j<tamaño;j++){
               matriz[i][j]= Integer.parseInt(array.get(index).getText());
               index++;
           }
       }
    }

    private boolean verficarcero(){
        
        boolean valor = false;
        for(int i=0;i<matriz.length;i++){
          for(int j=i+1; j<matriz.length;j++){
              if (matriz[j][i] ==0){
                  valor = true;
              }
              else{
                  return false;
              }
          }
        }
        return valor;
    }

    /*private boolean Verificardiagonal() {
        for(int i=0;i<matriz.length;i++){
            if(matriz[i][i]==0){
                for(int j=0;j<matriz.length;j++){
                    int temp = matriz [i][j];
                }
            }
        }
    }*/

    private void hacerceros() {
        
        for(int i=0;i<matriz.length-1;i++){
            //matriz[i] = hacerpivote(matriz[i],i);
            for(int j=i+1;j<matriz.length;j++){
                matriz[j] = restarnumero(matriz[j],matriz[i],i);
            }
        }
        
    }

    private double[] hacerpivote(double[] arreglo,int pos) {
        
        double div = arreglo[pos];
        for(int i=0;i<arreglo.length;i++){
            arreglo[i] /= div;
        }
        return arreglo;
    }

    private double[] restarnumero(double[] arreglo, double[] restar,int pos) {
        double factor = (arreglo[pos]*-1)/restar[pos];
        for(int i=0;i<arreglo.length;i++){
            arreglo[i] += (factor*restar[i]);
        }
        return arreglo;
    }

    public double Determinante() {
        double det=1;
        for(int i=0;i<matriz.length;i++){
            det *= matriz[i][i];
        }
        return det;
    }
 
    
}
