package br.com.webtools.jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory = null;

	// QUANDO UMA REFERENCIA FOR FEITA A CLASS JPAUtil SE ELA N EXISTE O METODO SERA
	// CRIADA
	static {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("meuprimeiroprojetojsf02");
		}
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	//INDENTIFICA O ID OU CHAVE PRIMARIA SEJA ELA DE QUALQUE TIPO
	//DA MINHA ENDIDADE 
	public static Object getPrimaryKey(Object entidade) {
		return factory.getPersistenceUnitUtil().getIdentifier(entidade);
	}
	

}
