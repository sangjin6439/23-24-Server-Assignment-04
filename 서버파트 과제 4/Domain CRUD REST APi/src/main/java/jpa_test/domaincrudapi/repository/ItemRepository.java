package jpa_test.domaincrudapi.repository;

import jakarta.persistence.EntityManager;
import jpa_test.domaincrudapi.domain.Item;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findItemById(Long id);



//
//    private final EntityManager em; //엔티티 매니저 생성
//
//    public void save(Item item){
//        em.persist(item);
//    }
//
//    public Item findOne(Long id){
//        return em.find(Item.class, id);
//    }
//
//    public List<Item> findAll(){
//       return em.createQuery("select i from Item i", Item.class)
//                .getResultList();
    }


