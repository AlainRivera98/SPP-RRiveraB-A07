//Nombre: Roberto Alain Rivera Bravo
//Matrícula: A01411516
//Carrera: IMT11

package spp.rriverab.a07;
import java.util.Scanner;
public class SPPRRiveraBA07 {

    public static void main(String[] args) {
        menu();
    }
    
    //Método menu: 
    public static void menu(){
        System.out.println("<<Agenda telefónica>>");
        long[]x=asignarTel();
        consultarDato(x);
        salir();
    }
    
    //Método asignar tel: permite introducir los datos de los números
    public static long[] asignarTel(){
        //Declaración de array de variables long.
        long[] agenda = new long [10];
        //Ciclo para guardar valores en el array
        for (int i = 0; i < agenda.length; i++) {
            System.out.println("\nIntroduce el número telefónico "+i);
            //Invocación de método para verificar datos
            agenda[i] = solicitarDatos();
        }
        return agenda; //regresa el array de valores long
    }
    
    //Método solicitar datos: permite verificar que los datos sean correctos y los captura
    public static long solicitarDatos(){
        Scanner teclado = new Scanner (System.in);
        boolean flag;
        long x=0;
        //Ciclo do while: ejecuta al menos una vez las instrucciones en do, y evalúa si es cierto en while
        do{      
            try{ //Intenta realizar las instrucciones 
                x = teclado.nextLong(); 
                flag = true;
            }catch (Exception ex) { //Evita que el programa falle en caso de error y muestra el error
                flag = false;
                System.out.println("\nEl valor insertado es inválido. Introduzca un entero válido.\n" +ex+ "\n");
                teclado.nextLine(); //Limpia el buffer del teclado  
            }
            
            if(flag==true && x<=0){
               System.out.println("\nEl valor insertado es inválido. Introduzca un entero positivo válido.\n\n");
               flag=false;
            }
            
        }while(flag==false); //Evalua si la condición es verdadera o falsa, para volver a hacer las operaciones o no

        return x; //regresa el valor long verificado
    }
    
    //Método consultar dato: Método que permite consultar un dato guardado en el array
    public static void consultarDato(long[] agenda){
        Scanner teclado = new Scanner (System.in);
        long x;
        boolean flag;
        String letra;
        //Ciclo para volver a consultar un dato
        do{
           System.out.println("\nIntroduzca la posición del número que desea consultar");
            //Ciclo para pedir un valor y verificar que el número pedido de posición esté entre 0 y 9
            do{
                x=solicitarDatos();
                flag=true;
                if(x<0 || x>=agenda.length){
                    System.out.println("Valor fuera de rango. Introduzca una posición del 0 al 9");
                    flag=false;
                }   
            }while(flag==false);
            
            //Convierte el entero long a entero int
            int i=(int)x;
            System.out.println("El teléfono en la posición "+i+" es "+agenda[i]);
            System.out.println("\n¿Desea obtener otro valor?.\nSí: Presione 1\nNo. Presione cualquier otra tecla");
            letra=teclado.nextLine();
            flag=true;
            //verifica si el String es igual a "1"
            if(letra.equals("1")){
                flag=false;
            } 
        }while(flag==false);
        
    }
    
    //Método salir: da opción de terminar o reiniciar los cálculos
    public static void salir(){
        Scanner teclado = new Scanner (System.in);
        String letra;
    
        System.out.println("\n¿Desea continuar?");
        System.out.println("No: Presione E");
        System.out.println("Sí: Presione cualquier otra tecla");
        letra = teclado.nextLine(); 
        
        //verifica si el String es igual a "E"
        if(!letra.equals("E")){
            //Se invoca a método menu para volver a ejecutar el programa
            menu();
        }     
    }        
    
}
