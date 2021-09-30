package com.webwallet.core.applicationServices.interfaces;

import com.webwallet.core.applicationServices.dtos.CreateWalletDTO;

public interface IWalletService {
    public String Create(CreateWalletDTO walletDTO);
}
