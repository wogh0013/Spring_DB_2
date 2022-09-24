package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SpringDataJpaItemRepository extends JpaRepository<Item, Long> {

    //이름으로 검색
    List<Item> findByItemNameLike(String itemName);

    //가격으로 검색
    List<Item> findByPriceLessThanEqual(Integer price);

    //둘 모두로 검색
    //복잡해져서 직접 JPQL로 작성, 파라미터 바인딩 필수
    @Query("select i from Item i where i.itemName like :itemName and i.price <= :price")
    List<Item> findItems(@Param("itemName") String itemName, @Param("price") Integer price);
}
