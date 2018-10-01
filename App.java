import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	
	private static Scanner reader;

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> pre = new ArrayList<String>();
		ArrayList<String> in = new ArrayList<String>();
		ArrayList<String> aux = new ArrayList<String>();
		BinaryTree t = new BinaryTree();
		reader = new Scanner(new FileInputStream("/home/pedro/eclipse-workspace/T1AlgoritmosII/src/casos_t1/" + args[0]));

		while(reader.hasNext()) {
			String temp = reader.next();
			aux.add(temp);
		}
		
		for(int i = (aux.size())/2; i < aux.size(); i++) {
			in.add(aux.get(i));
		}
		
		for(int i = 0; i < aux.size()/2; i++) {
			pre.add(aux.get(i));
		}
		
		t.root = t.createTree(in, pre, 0, pre.size()-1);
		System.out.println("Height: " + t.height());
		reader.close();
	}
}
