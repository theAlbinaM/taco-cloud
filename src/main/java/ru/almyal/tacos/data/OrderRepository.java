package ru.almyal.tacos.data;

import jakarta.persistence.criteria.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.almyal.tacos.Ingredient;
import ru.almyal.tacos.TacoOrder;
import ru.almyal.tacos.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    TacoOrder save(TacoOrder order);
    Iterable<TacoOrder> findAll();
    Optional<TacoOrder> findById(Long id);

//    List<TacoOrder> findByDeliveryZip(String deliveryZip);
//    List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
//
//    List<TacoOrder> findByDeliveryToAndDeliveryCityAllIgnoresCase(
//            String deliveryTo, String deliveryCity);

//    List<TacoOrder> findByDeliveryCityOrderByDeliveryTo(String city);

//    @Query("Order o where o.deliveryCity='Seattle'")
//    List<TacoOrder> readOrdersDeliveredInSeattle();

    List<Order> findByUserOrderByPlacedAtDesc (User user, Pageable pageable);
}
