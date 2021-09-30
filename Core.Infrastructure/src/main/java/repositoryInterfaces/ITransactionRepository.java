package repositoryInterfaces;

import entities.Transaction;
import entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction, Integer> {
}
