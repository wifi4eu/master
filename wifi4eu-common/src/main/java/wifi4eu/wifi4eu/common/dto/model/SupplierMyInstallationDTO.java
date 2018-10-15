package wifi4eu.wifi4eu.common.dto.model;

import java.util.List;

public class SupplierMyInstallationDTO {

    List<BeneficiaryMyInstallationDTO> beneficiaryMyInstallationDTOList;
    List<BankAccountDTO> bankAccountDTOList;

    public SupplierMyInstallationDTO() {
    }

    public SupplierMyInstallationDTO(List<BeneficiaryMyInstallationDTO> beneficiaryMyInstallationDTOList, List<BankAccountDTO> bankAccountDTOList) {
        this.beneficiaryMyInstallationDTOList = beneficiaryMyInstallationDTOList;
        this.bankAccountDTOList = bankAccountDTOList;
    }

    public List<BeneficiaryMyInstallationDTO> getBeneficiaryMyInstallationDTOList() {
        return beneficiaryMyInstallationDTOList;
    }

    public void setBeneficiaryMyInstallationDTOList(List<BeneficiaryMyInstallationDTO> beneficiaryMyInstallationDTOList) {
        this.beneficiaryMyInstallationDTOList = beneficiaryMyInstallationDTOList;
    }

    public List<BankAccountDTO> getBankAccountDTOList() {
        return bankAccountDTOList;
    }

    public void setBankAccountDTOList(List<BankAccountDTO> bankAccountDTOList) {
        this.bankAccountDTOList = bankAccountDTOList;
    }

}
