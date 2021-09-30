package org.webwallet.webclient;

import dtos.CreateWalletDTO;
import entities.Wallet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import repositoryInterfaces.IWalletRepository;
import services.WalletService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
@TestPropertySource(locations="classpath:test.properties")
@ContextConfiguration(classes = {
        IWalletRepository.class
})
class WalletServiceTests {
    private WalletService walletService;

    @Autowired
    private IWalletRepository walletRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        walletService = new WalletService(walletRepository);
    }

    @Test
    void CreateWalletTestNoException() {
        CreateWalletDTO walletDTO = new CreateWalletDTO("0605996781029", "ime", "prezime", "123456789123456789", "BrankoBank", "1234");

        String password = walletService.Create(walletDTO);

        Optional<Wallet> createdWallet = walletRepository.findById("0605996781029");
        var wallets = walletRepository.findAll();
        assertTrue(createdWallet.isPresent());
        assertNotNull(password);
        assertEquals(password.length(), 6);
        assertEquals(createdWallet.get().getJmbg(),"0605996781029") ;
        assertEquals(createdWallet.get().getFirstName(),"ime") ;
        assertEquals(createdWallet.get().getLastName(),"prezime") ;
        assertEquals(createdWallet.get().getBankAccount(),"123456789123456789") ;
        assertEquals(createdWallet.get().getBankType().toString(),"BrankoBank") ;
        assertEquals(createdWallet.get().getPIN(),"1234");
    }

}
