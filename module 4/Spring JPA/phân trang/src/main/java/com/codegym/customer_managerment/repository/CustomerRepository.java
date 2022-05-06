package com.codegym.customer_managerment.repository;

import com.codegym.customer_managerment.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM customer WHERE name like concat('%', ?1 ,'%') ",
            countQuery = "SELECT count(*) FROM customer WHERE name like concat('%', ?1 ,'%')  ",
            nativeQuery = true)
    Page<Customer> searchByName(String name, Pageable pageable);

//    // Search co Int = null
//    @Query("select q from Question q where (:id is null or q.questionId = :id) and (q.questionTitle like %:title%)")
//    List<Question> findAllByIdAndTitle(Integer id, String title);
}