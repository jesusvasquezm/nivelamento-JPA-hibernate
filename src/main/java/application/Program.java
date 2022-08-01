package application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Program {

	public static void main(String[] args) {

		//Atribuir ID nulo pois o proprio banco de dados vai atribuir um ID para p1,p2,p3
		Pessoa p1 = new Pessoa(null, "Carlos da Silda", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "maria@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		//adicionando as pessoas na base de dados
		em.getTransaction().begin(); // Inicia um trasacção om o banco de dados
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit(); // Confirma as alterações feitas
		System.out.println("Pronto");
		
		em.close();
		emf.close();

	}

}
