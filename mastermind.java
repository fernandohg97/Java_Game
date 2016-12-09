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
      Scanner input = new Scanner(System.in);
      int nivel;
      System.out.println("Nivel 1: 3 digitos");
      System.out.println("Nivel 2: 4 digitos");
      System.out.println("Nivel 3: 5 digitos\n");
      System.out.println("Que nivel deseas jugar: ");
      nivel = input.nextInt();
      while (nivel!=1 && nivel!=2 && nivel!=3)
      {
        System.out.println("No existe este nivel, ingresa un nivel correcto: ");
        nivel = input.nextInt();
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













    public static void comparacion(int cifra[],int cantidad)
    {
      int nuevaCifra[] = new int[cantidad],num;
      int aciertos=0,coincidencias=0,intentos=0;
      Scanner input = new Scanner(System.in);
      while (!Arrays.equals(cifra,nuevaCifra))
      {
          // Pedir los numeros al usuario
          for (int m=0;m<nuevaCifra.length;m++)
          {
            System.out.print("Ingresa un numero: ");
            num=input.nextInt();
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
        numAleatorio();
      }
      else
      {
        System.out.println("GRACIAS POR JUGAR");
      }
    }
}
