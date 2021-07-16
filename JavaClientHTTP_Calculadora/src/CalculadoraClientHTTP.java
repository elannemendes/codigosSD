import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class CalculadoraClientHTTP {
	//variáveis globais
	public static int oper1, oper2, operacao;
	//criando função pra atribuir os valores de cada variável global
	public static void atribuindoValores(int a, int b, int c) {
		oper1 = a;
		oper2 = b;
		operacao = c;
	}
	public static void main(String[] args) {
		//chamando a função
		//exemplo de soma
		atribuindoValores(1,1,1);
		//exemplo de subtração
		atribuindoValores(35,25,2);
		//exemplo de multiplicação
		atribuindoValores(5,5,3);
		//exemplo de divisão
		atribuindoValores(20,5,4);
		
	String result="";
    try {

       URL url = new URL("https://double-nirvana-273602.appspot.com/?hl=pt-BR");
       HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setReadTimeout(10000);
        conn.setConnectTimeout(15000);
        conn.setRequestMethod("POST");
        conn.setDoInput(true);
        conn.setDoOutput(true) ;

        //ENVIO DOS PARAMETROS
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"));
        //Concatenação da escrita com as variáveis obtidas pela ultima chamada da função "atribuindoValores", no caso a divisão de 20 por 5 (resultado: 4).
        writer.write("oper1="+oper1+"&oper2="+oper2+"&operacao="+operacao); //1-somar 2-subtrair 3-multiplicar 4-dividir*
        writer.flush();
        writer.close();
        os.close();

        int responseCode=conn.getResponseCode();
        if (responseCode == HttpsURLConnection.HTTP_OK) {

            //RECBIMENTO DOS PARAMETROS


            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"));
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            result = response.toString();
            System.out.println("Resposta do Servidor PHP="+result);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
	}
}
