package walletServiceTests;

import dtos.CreateWalletDTO;
import entities.Wallet;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import repositoryInterfaces.IWalletRepository;
import services.WalletService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest()
class WalletServiceTests {
    private WalletService walletService;

    @Mock
    private IWalletRepository walletRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        walletService = new WalletService(walletRepository);
    }

    @Test
    void CreateWalletTestNoException() {
        CreateWalletDTO walletDTO = new CreateWalletDTO("1234567891234", "ime", "prezime", "123456789123456789", "BrankoBank", "1234");

        String password = walletService.Create(walletDTO);

        Optional<Wallet> createdWallet = walletRepository.findById("1234567891234");

        assertTrue(createdWallet.isPresent());
        assertNotNull(password);
        assertEquals(password.length(), 6);
        assertEquals(createdWallet.get().getJmbg(),"1234567891234") ;
        assertEquals(createdWallet.get().getFirstName(),"ime") ;
        assertEquals(createdWallet.get().getLastName(),"prezime") ;
        assertEquals(createdWallet.get().getBankAccount(),"123456789123456789") ;
        assertEquals(createdWallet.get().getBankType().toString(),"BrankoBank") ;
        assertEquals(createdWallet.get().getPIN(),"1234");
    }

}
