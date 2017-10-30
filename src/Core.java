import java.io.FileNotFoundException;
import java.util.*;

/**
 * <p>Classe responsável por comportar toda a lógica da aplicação, separando-a de seus componentes visuais e de dados.</p>
 * @author Guilherme de Oliveira Munaretto
 * @author Igor Sgorla Brehm
 */
public class Core {
    private Graph grafo;

    public Core(String filePath){
        try {
            this.grafo = new Graph(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo de origem não pode ser lido ou não existe. Erro interno: "+e.getMessage());
        }
    }

    /**
     * <p>Método responsável por retornar uma String com as informações sobre o software 'fsoc' e seu desenvolvimento</p>
     * @return Uma String com as informações sobre o software 'fsoc' e seu desenvolvimento
     */
    public String about(){
        return "";
    }

    /**
     * <p>Método responsável por realizar o processamento de informações do grafo e chamar outros métodos auxiliares
     * para descobrir o menor caminho possível entre um vértice inicial e outro vértice final</p>
     * @return Um ArrayList de contas contendo referências para objetos do tipo Account que formam o menor caminho
     * entre dois vértices previamente informados
     */
    public ArrayList<Account> shortestPath(){
        ArrayList<Account> resultPath = null;
        // Pega uma coleção com todas as chaves do HashMap de adjascência
        Set<Account> keys = this.grafo.getAdj().keySet();
        // Percorre, para cada conta no conjunto de chaves de adj
        for(Account start: keys){
            // Verifica se a conta possui a pessoa que vai realizar a transferência
            if(start.getAccHolder1().equals(grafo.getStartingHolder()) || start.getAccHolder2().equals(grafo.getStartingHolder())){
                // Realiza um bfs para cada conta, armazenano em uma instancia auxiliar de hashmap
                HashMap<Account,Account> aux = bfs(start);
                // Cria um conjunto de chaves para ese hashmap auxiliar
                Set<Account> keysAux = aux.keySet();
                // Percorre o conjunto de chaves
                for(Account goal : keysAux){
                    /*
                    * Seguindo o caminho de referencias do HashMap gerado por cada BFS a partir do ponto de partida
                    * da transação bancária. Esse ponto de decisão tem como objetivo realizar o caminhamento pelas
                    * referências somente para as contas que possuem o correntista final da transação.
                    */
                    if(goal.getAccHolder1().equals(grafo.getGoalHolder()) || goal.getAccHolder2().equals(grafo.getGoalHolder())){
                        // Realiza o processamento de cada hashmap, procurando o caminho mais curto
                        ArrayList<Account> current = comparePaths(aux,goal);
                        if(resultPath == null || current.size() < resultPath.size()){
                            resultPath = current;
                        }
                    }

                }
            }
        }
        return resultPath;
    }

    /**
     * <p>Método que realiza um caminhamento Breadth First Search em um grafo a partir de um vértice específicado por
     * parâmetro.</p>
     * @param s O vértice do grafo que deverá ser utilizado como ponto de partida para o caminhamento
     * @return Um HashMap de contas "Account" contendo um 'caminho' de cada vértice para uma outra.
     */

    private HashMap<Account,Account> bfs(Account s){
        Queue<Account> q = new LinkedList<>();
        HashMap<Account,Account> ref = new HashMap<>();
        HashMap<Account,Boolean> visited = new HashMap<>();
        // Adiciona o ponto de partida na fila
        q.offer(s);
        // Diz que s não parte de nenhum outro vértice, pois é a "fonte"
        ref.put(s,null);
        // Marca s como visitado
        visited.put(s,true);
        while (!q.isEmpty()){
            Account aux = q.remove();
            // Verifica para todos os vértices vizinhos de aux
            for(Account acc : this.grafo.getAdj().get(aux)){
                // Se o vizinho ainda não foi visitado...
                if(visited.get(acc) == null){
                    // Marca como visitado
                    visited.put(acc,true);
                    // Diz de onde ele veio
                    ref.put(acc,acc);
                    // Coloca o vizinho na fila
                    q.offer(acc);
                }
            }
        }
        return ref;
    }

    /**
     * <p>Método responsável por "caminhar" pelo HashMap gerado a partir do correntista inicial no método BFS, devolvendo
     * a quem o chamar um ArrayList contendo as contas do caminho entre o correntista final e o inicial.</p>
     * @param hm O HashMap de contas gerado pelo caminhamento da BFS
     * @param f Uma conta "Account" por onde o algorítmo deve iniciar o caminhamento.
     * @return Um ArrayList de contas contendo o caminho entre o correntista final e o inicial.
     */
    private ArrayList<Account> comparePaths(HashMap<Account,Account> hm, Account f){

        Queue<Account> queue = new LinkedList<>();
        ArrayList<Account> al = new ArrayList<>();

        queue.offer(f);
        while(!queue.isEmpty()){
            Account aux = queue.remove();
            al.add(aux);
            if(hm.get(aux) == null){
                return al;
            }
            queue.offer(hm.get(aux));
        }
        return al;


        /*
        Account newGoal = f;

        //Caso de parada da recursão. Retorna o arraylist com o caminho caso o newGoal seja o "ponto inicial" da bfs

            if(hm.get(newGoal) == null) return ar;
        // Adiciona o vértice atual ao arraylist com o caminho
        ar.add(newGoal);
        // Atualiza o valor do vértice atual, seguindo as ligações indicadas pelo hashmap gerado pela bfs
        newGoal = hm.get(newGoal);
        // Chama a recursão
        return comparePaths(hm,newGoal,ar);
         */

    }
}
