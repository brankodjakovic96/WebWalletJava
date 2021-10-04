package com.webwallet.applications.webclient.controllers;

import com.webwallet.applications.webclient.viewmodels.CreateWalletPageVM;
import com.webwallet.core.applicationServices.dtos.CreateWalletDTO;
import com.webwallet.core.applicationServices.interfaces.IWalletService;
import com.webwallet.core.domain.enums.BankType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.webwallet.applications.webclient.viewmodels.CreateWalletVM;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;

@Controller
public class WalletController {

    private final IWalletService _walletService;

    @Autowired
    public WalletController(IWalletService walletService) {
        _walletService = walletService;
    }

    @GetMapping("wallet")
    public String wallet(@ModelAttribute("walletPage") CreateWalletPageVM createWalletPageVM){;
        createWalletPageVM.setBankTypes(Arrays.stream(BankType.values()).filter(bt -> bt != BankType.Undefined).map(bt -> bt.toString()).toList());
        return "wallet";
    }

    @GetMapping("walletPassword")
    public String walletPassword(){
        return "walletPassword";
    }

    @PostMapping("wallet")
    public String wallet(@Valid @ModelAttribute("walletPage") CreateWalletPageVM createWalletPageVM, BindingResult result, Map<String, Object> model) {
        if (result.hasErrors()) {
            return "redirect:/error?message=" + result.getAllErrors().toString();
        }


        var walletDTO = new CreateWalletDTO(
                createWalletPageVM.getCreateWalletVM().getJmbg(),
                createWalletPageVM.getCreateWalletVM().getFirstName(),
                createWalletPageVM.getCreateWalletVM().getLastName(),
                createWalletPageVM.getCreateWalletVM().getBankAccount(),
                createWalletPageVM.getCreateWalletVM().getBankType(),
                createWalletPageVM.getCreateWalletVM().getPIN());

        String password = _walletService.Create(walletDTO);
        model.put("password",password);

        return "walletPassword";
    }


}
