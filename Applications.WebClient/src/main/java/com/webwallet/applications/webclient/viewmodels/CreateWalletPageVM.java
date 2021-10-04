package com.webwallet.applications.webclient.viewmodels;

import java.util.List;

public class CreateWalletPageVM {
    private CreateWalletVM createWalletVM;
    private List<String> bankTypes;


    public CreateWalletVM getCreateWalletVM() {
        return createWalletVM;
    }

    public List<String> getBankTypes() {
        return bankTypes;
    }

    public void setCreateWalletVM(CreateWalletVM createWalletVM) {
        this.createWalletVM = createWalletVM;
    }

    public void setBankTypes(List<String> bankTypes) {
        this.bankTypes = bankTypes;
    }
}
