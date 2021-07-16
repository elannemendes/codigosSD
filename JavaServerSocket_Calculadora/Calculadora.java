public class Calculadora {
    public String sayHello(String nome, String sobrenome) {
        return "Fala "+ nome + " " + sobrenome;
    }
    public double soma(double oper1, double oper2) {
        return oper1 + oper2;
    }
  //Operação de subtração
    public double subtrai(double oper1, double oper2) {
        return oper1 - oper2;
    }
    //Operação de multiplicação
    public double multiplica(double oper1, double oper2) {
        return oper1 * oper2;
    }
    //Operação de divisão
    //Caso o divisor for 0, a operaçãoretorna 0
    public double divide(double oper1, double oper2) {
    	if(oper2 != 0) {
        return oper1 / oper2;}
    	else {
    		return 0;
    	}
    }
}