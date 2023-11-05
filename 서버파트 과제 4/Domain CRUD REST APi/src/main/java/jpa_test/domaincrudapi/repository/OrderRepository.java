package jpa_test.domaincrudapi.repository;

import jakarta.persistence.EntityManager;
import jpa_test.domaincrudapi.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    Optional<Order> findOrderById(Long id);

//    private final EntityManager em;
//
//    private void save(Order order){
//        em.persist(order);
//    }
//
//    private Order findOne(Long id){
//       return em.find(Order.class, id);
//    }
//
//    private List<Order> findAll(){
//        return em.createQuery("select O from Order o", Order.class)
//                .getResultList();
//    }
}
