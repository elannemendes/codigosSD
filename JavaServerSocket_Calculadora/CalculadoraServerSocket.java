import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraServerSocket {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket welcomeSocket;
		DataOutputStream socketOutput;     	
	    DataInputStream socketInput;
	    BufferedReader socketEntrada;
	    Calculadora calc = new Calculadora();
		try {
			welcomeSocket = new ServerSocket(9090);
		  int i=0; //número de clientes
	  
	      System.out.println ("Servidor no ar");
	      while(true) { 
	  
	           Socket connectionSocket = welcomeSocket.accept(); 
	           i++;
	           System.out.println ("Nova conexão");
	           
	           //Interpretando dados do servidor
	           socketEntrada = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
               String operacao= socketEntrada.readLine();
               String oper1=socketEntrada.readLine();
               String oper2=socketEntrada.readLine();
               
               //Chamando a calculadora
               //iniciando string de resultado
               String result= "";
               //verificando operações
               if(operacao == "1") {
            	   result= ""+calc.soma(Double.parseDouble(oper1),Double.parseDouble(oper2));}
               else if(operacao == "2") {
            	   result= ""+calc.subtrai(Double.parseDouble(oper1),Double.parseDouble(oper2));}
               else if(operacao == "3") {
            	   result= ""+calc.multiplica(Double.parseDouble(oper1),Double.parseDouble(oper2));}
               else if(operacao == "4") {
            	   result= ""+calc.divide(Double.parseDouble(oper1),Double.parseDouble(oper2));}
               //Caso a operação selecionada seja invalida. Operação diferente de 1, 2, 3 ou 4
               else {
            	   result= "Nenhuma operação válida selecionada";
               }
               //Enviando dados para o servidor
               socketOutput= new DataOutputStream(connectionSocket.getOutputStream());
               socketOutput.writeBytes(result+ '\n');
               System.out.println (result);
               socketOutput.flush();
               socketOutput.close();


	                    
	      }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	}

}
