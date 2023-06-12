package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence. createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
           /* Member member = new Member();
            member.setUsername("C");

            System.out.println("==============================");
            em.persist(member);
            System.out.println("#######  member.Id = " + member.getId() + " #######");
            System.out.println("==============================");

            tx.commit();*/

            Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("================================");

            em.persist(member1);
            em.persist(member2);
            em.persist(member3);

            System.out.println("memeber1 = " + member1.getId());
            System.out.println("memeber2 = " + member2.getId());
            System.out.println("memeber3 = " + member3.getId());
            System.out.println("================================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
