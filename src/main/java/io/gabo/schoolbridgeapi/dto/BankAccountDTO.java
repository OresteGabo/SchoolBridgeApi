package io.gabo.schoolbridgeapi.dto;

public class BankAccountDTO{
    private Long id;
    private String bankName;
    private String schoolName;
    private String bankNumber;

    public BankAccountDTO(Long id, String bankName, String schoolName, String bankNumber) {
        this.id = id;
        this.bankName = bankName;
        this.schoolName = schoolName;
        this.bankNumber = bankNumber;
    }
}
