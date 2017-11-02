import java.util.ArrayList;

public class AppTest {

    public static void main(String[] args){
        Core c = new Core("caso01.txt");
        System.out.println(c.about());
        long tempoInicio = System.currentTimeMillis();
        ArrayList<Account> sp = c.shortestPath();
        System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));
        for(int i = sp.size()-1; i >= 0; i--){
            System.out.println("Conta: "+sp.get(i).getAccountID()+"Nome1:"+sp.get(i).getAccHolder1()+" - Nome2:"+sp.get(i).getAccHolder2());
        }
    }
}
