package v2.repository;


import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import v2.domain.Orders;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    List<Orders> findByTemplate(Boolean template);
//    List<Orders> findByIdOtv(Integer id);
//    List<Orders> findByIdProg(Integer id);
//    List<Orders> findByDateCreate(Date date);
//    List<Orders> findByDateCorr(Date date);
//    List<Orders> findByIdTehn(Integer id);
//    List<Orders> findByNumber(Integer num);
}