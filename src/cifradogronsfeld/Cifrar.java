/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradogronsfeld;

/**
 *
 * @author usuario
 */
public class Cifrar {
    
    char[] mensaje;
	char[] clave;
	char[] resultado; //resultado cifrado
	char matriz[][];
        
     /*   private char[] generarAbecedario()
	{
		char[] abc = new char[26];
		for(int i= 65; i<= 90;i++)
		{
			abc[i-65]=(char)i;
		}
		return abc;
	}
        	private char[][] generarMatrizABC()
	{
		int contador;
		char abcTemp[] = this.generarAbecedario();
		char abc[] = new char[abcTemp.length*2];//52
                      
		for(int c=0;c<26;c++) {
			abc[c]=abcTemp[c];
			abc[c+26]=abcTemp[c];
		}
		char[][] matriz = new char[11][26];
                int numerosPrimos[]={0,2,3,5,7,11,13,17,19,23,2};
                System.out.println("/////////TABLA DE CIFRADO////////");
		for(int i=0;i<11;i++)
		{
                        int c = numerosPrimos[i];
                	contador=0;
                        
			for(int j=0;j<26;j++)
			{
                            matriz[i][j]=abc[contador+c];
                            //System.out.print(matriz[i][j]);
                            contador++;                            
                                
			}
                        //System.out.println();
                        
		}
		System.out.println("///////////////////////////////");
                return matriz;
	}*/
                
	public Cifrar(String msg,int clave)
	{
                String claveaux = Integer.toString(clave);
		this.mensaje = msg.toCharArray();
                char[] claveTemp = this.clave = claveaux.toCharArray();
                this.clave = new char[mensaje.length];
		int cont =0;
		for(int i=0;i<mensaje.length;i++)//
		{
			this.clave[i]=claveTemp[cont];
			cont++;
			if(cont==claveTemp.length)
				cont=0;
		}
                //System.out.println(this.clave);
                GenerarTabla tabla = new GenerarTabla();
                char matrizGenerada[][]= tabla.generarMatrizABC();
		this.matriz = matrizGenerada;//Generamos matriz del abecedario
		cifrar(); //ciframos el texto
	}

	public void cifrar() //Genera cifrado
	{
            char[] cifrado = new char[mensaje.length];
		int i;
		int j;
		for(int cont=0;cont<mensaje.length;cont++)
		{
			j=(int)this.mensaje[cont]-65; //restamos 97 para pasar de codigo ascii a un numero entero
                        i=((int)this.clave[cont]-48)+1;
			cifrado[cont]=this.matriz[i][j];
		}

		this.resultado = cifrado;
		//System.out.println(this.mensaje);
		//System.out.println(this.clave);
                System.out.print("El mensaje ha sido cifrado en: ");
		System.out.println(cifrado);
	}
    
}
