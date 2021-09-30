package com.webwallet.core.infrastructure.repositoryInterfaces;

import com.webwallet.core.domain.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWalletRepository extends JpaRepository<Wallet, String> {
}
