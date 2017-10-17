import java.util.ArrayList;
import java.util.HashMap;

/**
 * <p>Classe responsável por conter as informações e operações referentes a estrutura de dados Grafo</p>
 * @author Guilherme Munaretto
 */
public class Graph {

    private Account[] depo;
    private int depoIndex;
    private int edges;
    private int vertices;
    private HashMap<Integer,ArrayList<Account>> adj;

    /**
     * <p>Método construtor da classe, responsável por inicializar as variáveis globais e chamar o método privado para
     * popular um grafo com as informações de um arquivo de texto.</p>
     * @param path o caminho para o arquivo de texto com as informações a serem populadas no grafo
     */
    public Graph(String path){
        edges = 0;
        depoIndex = 0;
        adj = new HashMap<>();
        //TODO Verificar a necessidade de inicializar o arraylist em cada chave do hashmap
        buildGraph(path);
    }

    /**
     * Método de acesso que retorna um inteiro com o número total de arestas do grafo
     * @return um número inteiro contendo o número total de arestas do grafo
     */
    public int getEdges(){return edges;}

    /**
     * Método de acesso que retorna um inteiro com o número total de vértices do grafo
     * @return um número inteiro contendo o número total de vértices do grafo
     */
    public int getVertices(){return vertices;}

    /**
     * Método de acesso que retorna uma referência para a "lista" de adjascência do grafo
     * @return uma referência do tipo "HashMap<Integer, ArrayList<Account>>" para a "lista" de adjascência do grafo
     */
    public HashMap<Integer, ArrayList<Account>> getAdj() {return adj;}

    /**
     * Método responsável por realizar a "ligação" entre dois vértices do grafo
     * @param acc1 um objeto do tipo Account a ser ligado com acc2
     * @param acc2 um objeto do tipo Account a ser ligado com acc1
     */
    public void addEdge(Account acc1, Account acc2){
        int idAcc1 = acc1.getAccountID();
        int idAcc2 = acc2.getAccountID();
        adj.get(idAcc1).add(acc2); // Ligando acc2 em acc1
        adj.get(idAcc2).add(acc1); // Ligando acc1 em acc2
        edges++;
    }

    /**
     * Método que, com base nos nomes dos correntistas de duas contas conjuntas, informa um booleano com o valor "true"
     * no caso de haver um correntista comum, e "false" caso contrário
     * @param acc1 um objeto do tipo Account correspondente a uma conta conjunta
     * @param acc2 outro objeto do tipo Account correspondente a uma conta conjunta
     * @return true caso haja ao menos um correntista comum em ambas as contas. False caso contrário.
     */
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

    /**
     * Método responsável por ler as informações do arquivo de texto e, com base nas mesmas, popular sua "lista" de
     * adjascência
     * @param filepath uma String contendo o caminho para o arquivo de texto com as informações dos correntistas
     */
    private void buildGraph(String filepath){

    }

}
