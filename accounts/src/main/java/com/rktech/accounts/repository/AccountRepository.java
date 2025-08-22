package com.rktech.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rktech.accounts.entity.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts,Long>{

	Optional<Accounts> findByCustomerId(Long customerId);
}
