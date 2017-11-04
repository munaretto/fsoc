package src;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.util.ArrayList;

public class Interface extends JFrame{

    
	private static final long serialVersionUID = 1L;

	public Interface(Core c){
    	
    	//Título da janela
    	super("Contas Conjuntas - Solucionador FSOC");
		
		long tempo = System.currentTimeMillis();
		ArrayList<Account> sp = c.shortestPath();
		tempo = System.currentTimeMillis() - tempo;

        JFrame janela = new JFrame();

    	//Container que guarda todos os itens da interface
    	Container container = new JPanel();
    	janela.getContentPane().add(container);
    	Container containerEsquerda = new JPanel();
    	
    	//Tipo de layout de itens na tela
    	container.setLayout(new GridLayout(1,2));
    	containerEsquerda.setLayout(new GridLayout(10,1));
    	container.add(containerEsquerda);
    	//Espaço de texto
    	final String newLine = "\n";
    	JTextArea caixaTexto = new JTextArea(sp.size(), 20);
    	JScrollPane scrollPane = new JScrollPane(caixaTexto); 
    	caixaTexto.setEditable(false);
    	container.add(scrollPane);
    	caixaTexto.append(" - Tempo Total: " + tempo + newLine);
        for(int i = sp.size()-1; i >= 0; i--){
        	caixaTexto.append(" - Conta: "+sp.get(i).getAccountID() + newLine +
        			" - Nome1: "+sp.get(i).getAccHolder1()+ newLine +
        			" - Nome2: "+sp.get(i).getAccHolder2() + newLine);
        }
    	//Os botões
        JButton caso1 = new JButton("Caso 1");
        JButton caso2 = new JButton("Caso 2");
        JButton caso3 = new JButton("Caso 3");
        JButton caso4 = new JButton("Caso 4");
        JButton caso5 = new JButton("Caso 5");
        JButton caso6 = new JButton("Caso 6");
        JButton caso7 = new JButton("Caso 7");
        JButton caso8 = new JButton("Caso 8");
        JButton caso9 = new JButton("Caso 9");
        JButton caso10 = new JButton("Caso 10");
        containerEsquerda.add(caso1);
        containerEsquerda.add(caso2);
        containerEsquerda.add(caso3);
        containerEsquerda.add(caso4);
        containerEsquerda.add(caso5);
        containerEsquerda.add(caso6);
        containerEsquerda.add(caso7);
        containerEsquerda.add(caso8);
        containerEsquerda.add(caso9);
        containerEsquerda.add(caso10);
        
        
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(800, 480);
        janela.setVisible(true);
    }



    public static void main(String[] args) {
        Core c = new Core("/home/igor/fsoc/src/caso01.txt");
        //System.out.println(c.about());
        new Interface(c);
    }
}
