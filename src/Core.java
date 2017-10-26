import java.io.FileNotFoundException;
import java.util.*;

public class Core {
    private Graph grafo;

    public Core(String filePath){
        try {
            this.grafo = new Graph(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo de origem não pode ser lido ou não existe. Erro interno: "+e.getMessage());
        }
    }

    public String about(){
        return "";
    }

    public ArrayList<Account> shortestPath(){
        ArrayList<Account> resultPath = null;
        // Pega uma coleção com todas as chaves do HashMap de adjascência
        Set<Account> keys = this.grafo.getAdj().keySet();
        // Percorre, para cada conta no conjunto de chaves de adj
        for(Account start: keys){
            // Verifica se a conta possui a pessoa que vai realizar a transferência
            //TODO Implementar na classe Graph metodos para pegar os atores envolvidos nas transferências
            if(start.getAccHolder1().equals("graph.beggining()") || start.getAccHolder2().equals("graph.goal()")){
                // Realiza um bfs para cada conta, armazenano em uma instancia auxiliar de hashmap
                HashMap<Account,Account> aux = bfs(start);
                // Cria um conjunto de chaves para ese hashmap auxiliar
                Set<Account> keysAux = aux.keySet();
                // Percorre o conjunto de chaves
                for(Account goal : keysAux){
                    // Realiza o processamento de cada hashmap,
                    ArrayList<Account> current = comparePaths(aux,start,goal,new ArrayList<Account>());
                    if(resultPath == null || current.size() < resultPath.size()){
                        resultPath = current;
                    }
                }
            }
        }
        return resultPath;
    }

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

    private ArrayList<Account> comparePaths(HashMap<Account,Account> hm, Account s, Account f, ArrayList<Account> ar){
        Account newGoal = f;
        /*
        * Caso de parada da recursão. Retorna o arraylist com o caminho caso o newGoal seja o "ponto inicial" da bfs
        */
        if(hm.get(newGoal) == s) return ar;
        // Adiciona o vértice atual ao arraylist com o caminho
        ar.add(newGoal);
        // Atualiza o valor do vértice atual, seguindo as ligações indicadas pelo hashmap gerado pela bfs
        newGoal = hm.get(newGoal);
        // Chama a recursão
        return comparePaths(hm,s,newGoal,ar);
    }
}
