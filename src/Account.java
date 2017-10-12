/**
 * <p>Esta classe tem como objetivo armazenar as informações referentes às contas conjuntas, contendo o seu número
 * identificador e o nome dos correntistas.</p>
 *
 * @author Guilherme de Oliveira Munaretto
 *
 */
public class Account {
    private int accountID;
    private String accHolder1;
    private String accHolder2;

    /**
     * <p>Método construtor da classe, responsável por atribuir valor às variáveis globais conforme os parâmetros
     * recebidos</p>
     * @param id O número identificador da conta
     * @param firstAccHolder O nome do "primeiro" correntista
     * @param secondAccHolder O nome do "segundo" correntista
     */
    public Account(int id, String firstAccHolder, String secondAccHolder){
        this.accountID = id;
        this.accHolder1 = firstAccHolder;
        this.accHolder2 = secondAccHolder;
    }

    /**
     * <p>Retorna para quem o utilizar um inteiro com o número identificador da conta</p>
     * @return Um inteiro com o número identificador da conta
     */
    public int getAccountID(){return this.accountID;}

    /**
     * <p>Retorna para quem o utilizar uma cadeia de caracteres com o nome do "primeiro" correntista</p>
     * @return Uma String com o nome do "primeiro" correntista
     */
    public String getAccHolder1(){return this.accHolder1;}

    /**
     * <p>Retorna para quem o utilizar uma cadeia de caracteres com o nome do "segundo" correntista</p>
     * @return Uma String com o nome do "segundo" correntista
     */
    public String getAccHolder2(){return this.accHolder2;}
}
