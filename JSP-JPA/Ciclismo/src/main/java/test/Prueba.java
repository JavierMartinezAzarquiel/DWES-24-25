package test;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Participante;
import model.ParticipantePK;

public class Prueba {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("CiclismoPU");
		
		EntityManager em = emf.createEntityManager();
		
		List<Participante> participantes = em.createNamedQuery("Participante.findAll",Participante.class).getResultList();

		for (Participante participante : participantes) {
			System.out.println(participante.getCiclista().getNombrec()+"\t"+participante.getEdicion().getAno());
		}
		
		ParticipantePK pk = new ParticipantePK();
		pk.setIdciclista(1);
		pk.setIdedicion(2);//edición de 2000
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(pk);
		tx.commit();
		
		em.close();
		emf.close();
		
	}

}
