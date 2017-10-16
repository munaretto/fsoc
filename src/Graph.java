import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private Account[] depo;
    private int depoIndex;
    private int edges;
    private int vertices;
    private HashMap<Integer,ArrayList<Account>> adj;

    public Graph(String path){
        edges = 0;
        depoIndex = 0;
        adj = new HashMap<>();
        //TODO Verificar a necessidade de inicializar o arraylist em cada chave do hashmap
        buildGraph(path);
    }

    public int getEdges(){return edges;}
    public int getVertices(){return vertices;}
    public HashMap<Integer, ArrayList<Account>> getAdj() {return adj;}

    public void addEdge(Account acc1, Account acc2){
        int idAcc1 = acc1.getAccountID();
        int idAcc2 = acc2.getAccountID();
        adj.get(idAcc1).add(acc2); // Ligando acc2 em acc1
        adj.get(idAcc2).add(acc1); // Ligando acc1 em acc2
    }

    private boolean hasMatch(Account acc1, Account acc2){

        if(acc1.getAccHolder1().equals(acc2.getAccHolder1())){
            return true;
        }
        else if(acc1.getAccHolder1().equals(acc2.getAccHolder2())){
           return true;
        }
        else if(acc1.getAccHolder2().equals(acc2.getAccHolder1())){
            return true;
        }
        else if(acc1.getAccHolder2().equals(acc2.getAccHolder2())){
            return true;
        }
        else{
            return false;
        }
    }

    private void buildGraph(String filepath){

    }

}
