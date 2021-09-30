package interfaces;

import dtos.CreateWalletDTO;
import entities.Wallet;

public interface IWalletService {
    public String Create(CreateWalletDTO walletDTO);
}
