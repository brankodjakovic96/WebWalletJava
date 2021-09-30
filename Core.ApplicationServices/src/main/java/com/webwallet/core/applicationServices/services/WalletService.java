package com.webwallet.core.applicationServices.services;

import com.webwallet.core.applicationServices.dtos.CreateWalletDTO;
import com.webwallet.core.domain.entities.Wallet;
import com.webwallet.core.domain.enums.BankType;
import com.webwallet.common.utils.generators.PasswordGenerator;
import com.webwallet.core.applicationServices.interfaces.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.webwallet.core.infrastructure.repositoryInterfaces.IWalletRepository;
import com.webwallet.core.domain.valueObjects.Jmbg;


import java.time.LocalDate;
import java.util.Optional;

@Service
public class WalletService implements IWalletService {

    private IWalletRepository _walletRepository;

    @Autowired
    public WalletService(IWalletRepository walletRepository) {
        _walletRepository = walletRepository;
    }

    @Override
    public String Create(CreateWalletDTO walletDTO) {
        ValidateWalletInput(walletDTO.getJmbg(), walletDTO.getBankType(), walletDTO.getPIN(), walletDTO.getBankAccount());


        String password = PasswordGenerator.GeneratePassword(6);
        var jmbg = new Jmbg(walletDTO.getJmbg());

        var wallet = new Wallet(jmbg, walletDTO.getFirstName(), walletDTO.getLastName(), walletDTO.getBankAccount(), walletDTO.getPIN(), BankType.valueOf(walletDTO.getBankType()), password, "RSD");
        _walletRepository.saveAndFlush(wallet);
        return password;
    }

    private void ValidateWalletInput(String jmbg, String bankType, String PIN, String bankAccount){
         if(PIN.length() != 4){
             throw new IllegalArgumentException("Pin has to be 4 digits long.");
         }
         if(PIN.chars().anyMatch(c -> !Character.isDigit(c))){
             throw new IllegalArgumentException("Pin has to be only made out of digits.");
         }
         if(jmbg.length() != 13){
             throw new IllegalArgumentException("Jmbg has to be 13 digits long.");
         }
         if(jmbg.chars().anyMatch(c -> !Character.isDigit(c))){
            throw new IllegalArgumentException("Jmbg has to be only made out of digits.");
         }
        if(bankAccount.length() != 18){
            throw new IllegalArgumentException("BankAccount has to be 13 digits long.");
        }
        if(bankAccount.chars().anyMatch(c -> !Character.isDigit(c))){
            throw new IllegalArgumentException("BankAccount has to be only made out of digits.");
        }

        String day = jmbg.substring(0,2);
        String month = jmbg.substring(2,4);
        Integer year = 0;
        try{
            year = Integer.valueOf(jmbg.substring(4,7));
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        };

        if(year > 900) {
            year += 1000;
        }
        else{
            year += 2000;
        }

        var dateOfBirth = LocalDate.parse(String.format("%s-%s-%s", year.toString(), month, day));
        Boolean isOldEnough = LocalDate.now().isAfter(dateOfBirth.plusYears(18));
        if (!isOldEnough)
        {
            throw new IllegalArgumentException("Need to be older than 18 to open a wallet.");
        }

        Integer region = 0;
        try{
            region = Integer.valueOf(jmbg.substring(7,9));
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        };

        if (region < 70)
        {
            throw new IllegalArgumentException("Need to be a citizen of Serbia to open a wallet.");
        }

        Optional<Wallet> wallet = _walletRepository.findById(jmbg);
        if(wallet.isPresent()){
            throw new IllegalArgumentException("Wallet for that jmbg already exists.");
        }

        try{
            var bankTypeEnum = BankType.valueOf(bankType);
            if(bankTypeEnum == BankType.Undefined){
                throw new IllegalArgumentException("BankType can't be undefined.");
            }
        }
        catch (Exception ex){
            throw new IllegalArgumentException("Given BankType doesn't exist.");
        };

        //TODO - BankRoutingService

    }
}
