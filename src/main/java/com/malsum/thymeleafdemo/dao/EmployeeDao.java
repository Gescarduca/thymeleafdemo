package com.malsum.thymeleafdemo.dao;


import com.malsum.thymeleafdemo.model.Employee;
import com.malsum.thymeleafdemo.model.EmployeeImp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeImp,Integer> {

    List<EmployeeImp> findAllByOrderByLastNameAsc();

    //    @Query("from Transaction where person_id= :id")
//    public List<Transaction> getTransactionRecords(@Param("id") int personId);
    //@Query("from EmployeeImp where lastName like %:keyword%")
    @Query("from EmployeeImp where concat(lastName,email,firstName) like %?1%")
    List<EmployeeImp> findAllByName(@Param("keyword") String keyword);
    //List<EmployeeImp> findEmployeeImpByLastNameContains(String lastName);

    Optional<EmployeeImp> findEmployeeImpByUsername(String username);

}
