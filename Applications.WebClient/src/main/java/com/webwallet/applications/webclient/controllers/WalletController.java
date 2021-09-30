package com.webwallet.applications.webclient.controllers;

import com.webwallet.core.applicationServices.dtos.CreateWalletDTO;
import com.webwallet.core.applicationServices.interfaces.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.webwallet.applications.webclient.viewmodels.
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class WalletController {

    private final IWalletService _walletService;

    @Autowired
    public WalletController(IWalletService walletService) {
        _walletService = walletService;
    }

    @GetMapping("wallet")
    public String wallet(@ModelAttribute("password")String password){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("password", password);
        return "wallet";
    }

    @PostMapping("wallet")
    public String wallet(@Valid @ModelAttribute("wallet") CreateWalletVM createWalletVM, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/error?message=" + result.getAllErrors().toString();
        }

        var walletDTO = new CreateWalletDTO(
                createWalletVM.getJmbg(),
                createWalletVM.getFirstName(),
                createWalletVM.getLastName(),
                createWalletVM.getBankAccount(),
                createWalletVM.getBankType(),
                createWalletVM.getPIN());

        String password = _walletService.Create(walletDTO);
        model.addAttribute("password",password);

        return ""
    }


}
