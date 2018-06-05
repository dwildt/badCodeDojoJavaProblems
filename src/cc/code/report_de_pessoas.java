package cc.code;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Relatório de pessoas
 * @author Deus
 */
public class report_de_pessoas {
	/**
	 * a string para somar todos os nomes na lista 
	 */
	static String _s;
	
	public report_de_pessoas() {
		_s = null;
	}
	
	/**
	 * imprime a lista de pessoas
	 * @param paramL
	 */
	public static void print_e_vai(Vector paramL){
		
		for (int i = 0; i < paramL.size(); i++) {
			
			Pessoa p = (Pessoa) paramL.get(i);
			ValidaPessoa validador = new ValidaPessoa();
			List<String> erro = validador.valida(p);
			
			if(!erro.isEmpty())
				continue;
			
			concatenaPessoa(p);			
		}
		//remove first comma
		_s = _s.substring(6); 
		System.out.print(_s);
	}

	public static void concatenaPessoa(Pessoa p) {
			_s += ", " + p.name;
	}
	
	/**
	 * codigo principal
	 * @param args
	 */
	public static void main(String[] args) {
		Vector v = new Vector();
		
		Pessoa p = new Pessoa();
		p.name = "Guilherme";
		p.cpf = "0023334467";
		ArrayList<String> danielTelefonesFixos = new ArrayList<String>();
		danielTelefonesFixos.add("8765343");
		p.telefonesCelulares = danielTelefonesFixos;
		v.add(p);

		p = new Pessoa();
		p.name = "Daniel";
		p.cpf = "123456766";
		danielTelefonesFixos = new ArrayList<String>();
		danielTelefonesFixos.add("7654343");
		p.telefonesCelulares = danielTelefonesFixos;
		v.add(p);
		
		print_e_vai(v);
		
	}

}

 class Pessoa{
	String name;
	String cpf;
	int idade;
	List<String> telefonesFixos;
	List<String> telefonesCelulares;
}
 
class ValidaPessoa {

	public List<String> valida(Pessoa p) {
		List <String> lista = new ArrayList<String>();
		if(p.name == null) 
			lista.add("Nome deve ser preenchido");
		return lista;
	}
	
}