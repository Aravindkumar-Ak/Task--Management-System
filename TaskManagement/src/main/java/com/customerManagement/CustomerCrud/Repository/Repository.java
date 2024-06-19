package com.customerManagement.CustomerCrud.Repository;

import com.customerManagement.CustomerCrud.Entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Challenge,Long> {

    Optional<Challenge> findByMonthIgnoreCase (String month);
}
