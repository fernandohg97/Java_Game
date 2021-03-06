// Juego mastermind
// Instrucciones:
// El juego consiste en adivinar una cifra numerica, ya sea de 3, 4 o 5 numeros de acuerdo al nivel que elijas.
// El numero a adivinar es dado aleatoriamente por el programa.
// El mismo programa te ira dando ciertos aciertos y coincidencias del numero que ingresaste.
/* Los aciertos indican que uno de los numeros que ingresaste estan en la misma posicion que el numero escondido,
y las coincidencias indican que los numeros ingresados forman parte de la cifra pero en distinta posicion. */
// Puede haber numeros repetidos y necesitaras ingresar un numero a la vez.

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
class mastermind
{
  public static void main(String[] args)
  {
    System.out.println("\t\t-----Bienvenido a MASTERMIND------\n");
    System.out.println("Instrucciones:");
    System.out.println("El Master Mind es un juego en el que has de deducir la secuencia\nde ciertos numeros (dependiendo el nivel que elijas) que esconde tu rival mediante distintas combinaciones.\nAl final de cada turno, el rival te dirá cuántos\nnumeros has acertado y cuantas coincidencias, es decir, \nnumeros que existen en la cifra pero en diferente posicion.\n");
    System.out.println("RECUERDA: Puede haber numeros repetidos e ingresa un numero a la vez.\n");
    dificultad();
  }

    // Usuario elige nivel de dificultad
    public static void dificultad()
    {
      boolean seguir=true;
      System.out.println();
      Scanner input = new Scanner(System.in);
      int nivel=0;
      System.out.println("Nivel 1: 3 digitos");
      System.out.println("Nivel 2: 4 digitos");
      System.out.println("Nivel 3: 5 digitos\n");
      System.out.print("Que nivel deseas jugar: ");

        do {
        try
        {
          seguir = true;
          nivel = input.nextInt();
        }
        catch (Exception e)
        {
          seguir = false;
          System.out.print("No existe este nivel, ingresa un nivel correcto: ");
          input.nextLine();
        }
      } while (seguir==false);

      while (nivel!=1 && nivel!=2 && nivel!=3)
      {
        System.out.print("No existe este nivel, ingresa un nivel correcto: ");
        do {
        try
        {
          seguir = true;
          nivel = input.nextInt();
        }
        catch (Exception e)
        {
          seguir = false;
          System.out.print("No existe este nivel, ingresa un nivel correcto: ");
          input.nextLine();
        }
      } while (seguir==false);
      }
      if (nivel==1)
      {
        numAleatorio1();
      }
      else if (nivel==2)
      {
        numAleatorio2();
      }
      else
      {
        numAleatorio3();
      }
    }

    // Numero aleatorio con 5 digitos
    public static void numAleatorio1()
    {
      int cant=3;
      int num_random[] = new int[cant];
      Random randomNumber = new Random();
      System.out.println("Numero aleatorio: ***");
      // Genera numeros aleatorios al arreglo
      for (int i=0;i<num_random.length;i++)
      {
        num_random[i] = randomNumber.nextInt(10);
      }
      //Impresion del arreglo aleatorio
      // for (int z=0;z<num_random.length;z++)
      // {
      //   System.out.print(num_random[z]);
      // }
      // System.out.println();
      comparacion(num_random,cant);
    }

    // Numero aleatorio con 4 digitos
    public static void numAleatorio2()
    {
      int cant=4;
      int num_random[] = new int[cant];
      Random randomNumber = new Random();
      System.out.println("Numero aleatorio: ****");
      // Genera numeros aleatorios al arreglo
      for (int i=0;i<num_random.length;i++)
      {
        num_random[i] = randomNumber.nextInt(10);
      }
      //Impresion del arreglo aleatorio
      // for (int z=0;z<num_random.length;z++)
      // {
      //   System.out.print(num_random[z]);
      // }
      // System.out.println();
      comparacion(num_random,cant);
    }
    // Numero aleatorio con 5 digitos
    public static void numAleatorio3()
    {
      int cant=5;
      int num_random[] = new int[cant];
      Random randomNumber = new Random();
      System.out.println("Numero aleatorio: *****");
      // Genera numeros aleatorios al arreglo
      for (int i=0;i<num_random.length;i++)
      {
        num_random[i] = randomNumber.nextInt(10);
      }
      //Impresion del arreglo aleatorio
      // for (int z=0;z<num_random.length;z++)
      // {
      //   System.out.print(num_random[z]);
      // }
      // System.out.println();
      comparacion(num_random,cant);
    }

    // Se le piden numeros al usuario y compara los dos arreglos
    public static void comparacion(int cifra[],int cantidad)
    {
      boolean seguir=true;
      int nuevaCifra[] = new int[cantidad],num=0;
      int aciertos=0,coincidencias=0,intentos=0;
      Scanner input = new Scanner(System.in);
      while (!Arrays.equals(cifra,nuevaCifra))
      {
          // Pedir los numeros al usuario
          for (int m=0;m<nuevaCifra.length;m++)
          {
            System.out.print("Ingresa un numero: ");
            do
            {
              try{
                seguir=true;
                num=input.nextInt();
              }
              catch (Exception e)
              {
                seguir = false;
                System.out.print("Caracter no valido.\nIngresa un numero: ");
                input.nextLine();
              }
            } while(seguir==false);

            if(num>=0 && num<=9)
            {
              nuevaCifra[m] = num;
            }
            else
            {
              System.out.print("No te hagas el listo es solo una cifra");
              System.out.println();
              m--;
            }
          }
          System.out.println();
          // Imprime el numero del usuario
          for (int n=0;n<nuevaCifra.length;n++)
          {
            System.out.print(nuevaCifra[n]);
          }
          System.out.println();

          // Compara el arreglo e indica el numero de aciertos y coincidencias
          for (int a=0;a<cifra.length;a++)
          {
            for (int b=0;b<nuevaCifra.length;b++)
            {
              if (cifra[a] == nuevaCifra[b])
              {
                if (b == a)
                {
                  aciertos++;
                }
                else
                {
                  coincidencias++;
                }
              }
            }
          }
          if (aciertos<cantidad)
          {
            System.out.println();
            System.out.println("Tienes "+aciertos+" aciertos y "+coincidencias+" coincidencias");
            System.out.println("PIENSA EN OTRA CIFRA");
            aciertos = 0;
            coincidencias = 0;
          }
          intentos++;
        }
        impresion(intentos,cifra);
    }

    //Se imprime el numero aleatorio y pregunta si se quiere volver a jugar
    public static void impresion(int attempt, int cifra[])
    {
      String opcion="";
      Scanner input = new Scanner(System.in);
      // Impresion del arreglo alaeatorio
      System.out.print("El numero aleatorio era: ");
      for (int x=0;x<cifra.length;x++)
      {
        System.out.print(cifra[x]);
      }
      System.out.println();

      System.out.println("ADIVINASTE!!!!!");
      System.out.println("Lo hiciste en "+attempt+" intentos");
      System.out.println("Escribe 'si' si deseas seguir jugando o 'no' si deseas salir");
      System.out.print("Quieres volver a jugar: ");
      opcion = input.next();
      while (!opcion.equals("si") && !opcion.equals("no"))
      {
        System.out.println("Escribe 'si' si deseas seguir jugando o 'no' si deseas salir");
        System.out.print("Quieres volver a jugar: ");
        opcion = input.next();
      }
      if (opcion.equals("si"))
      {
        dificultad();
      }
      else
      {
        System.out.println("GRACIAS POR JUGAR");
      }
    }
}
