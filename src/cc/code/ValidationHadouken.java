package cc.code;

import java.util.ArrayList;
import java.util.List;

public class ValidationHadouken {

	Pessoa p = new Pessoa();
	
	public List<String> validaPessoa(Pessoa pessoa) {
		
		List<String> constraints = new ArrayList<String>();
		if (pessoa != null) {
			if (pessoa.cpf != null) {
				if (pessoa.name != null) {
					if (pessoa.telefonesFixos != null) {
						for (String telefone : pessoa.telefonesFixos) {
							if (telefone != null) {
								if (telefone.isEmpty()) {
									constraints.add("Erro - Telefone inválido");
									return constraints;
								} else {
									if(telefone.length() < 7){
										constraints.add("Erro - Telefone inválido");
										return constraints;
									}
								}
								
							} else {
								constraints.add("Erro - Telefone inválido");
								return constraints;
							}
						}
					}
					else constraints.add("Erro - deveria ter pelo menos um telefone");
				}
				else constraints.add("Erro - deveria ter nome definido");
			}
			else constraints.add("Erro - deveria ter cpf definido");
		}

		return constraints;
	}
	
	 class Pessoa {
		public List<String> telefonesFixos;
		public String name;
		public String cpf;
	}
	
	public static void main(String[] args) {
		ValidationHadouken vh = new ValidationHadouken();
		vh.p.cpf = "111";
		vh.p.name = "name";
		vh.p.telefonesFixos = null;
		
		List<String> retorno = vh.validaPessoa(vh.p);
		System.out.println(retorno.toString());
		
	}

}

