package com.webwallet.core.infrastructure.repositoryInterfaces;

import com.webwallet.core.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {
}
