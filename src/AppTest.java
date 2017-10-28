import java.util.ArrayList;

public class AppTest {

    public static void main(String[] args){
        Core c = new Core("casoteste01.txt");
        ArrayList<Account> sp = c.shortestPath();
        for(int i = sp.size()-1; i >= 0; i--){
            System.out.println("Resultado");
            System.out.println("Conta: "+sp.get(i).getAccountID()+"Nome1:"+sp.get(i).getAccHolder1()+" - Nome2:"+sp.get(i).getAccHolder1());
            System.out.println("Resultado");
        }
    }
}
