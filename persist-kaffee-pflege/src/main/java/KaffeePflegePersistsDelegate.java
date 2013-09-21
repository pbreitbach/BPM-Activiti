import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * 
 */

/**
 * @author pbreitbach
 *
 */
public class KaffeePflegePersistsDelegate implements JavaDelegate, Serializable {

	/* (non-Javadoc)
	 * @see org.activiti.engine.delegate.JavaDelegate#execute(org.activiti.engine.delegate.DelegateExecution)
	 */
	public void execute(DelegateExecution execution) throws Exception {
		String name = (String)execution.getVariable("kaffeename");
		String preis = (String)execution.getVariable("kaffeepreis");
		String kommentar = (String)execution.getVariable("kaffeekommentar");
		
		Kaffee kaffee = new Kaffee();
		kaffee.setId(1);
		kaffee.setName(name);
		kaffee.setPreis(Float.parseFloat(preis));
		kaffee.setKommentar(kommentar);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persist-kaffee-pflege");
		EntityManager kaffeeem = emf.createEntityManager();
		kaffeeem.persist(kaffee);
	}

}
