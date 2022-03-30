package com.example.caysotudi.model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractDetailId;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "attachServiceId", referencedColumnName = "attachServiceId")
    private AttachService attachService;

    @ManyToOne
    @JoinColumn(name = "contractId", referencedColumnName = "contractId")
    private Contract contract;


    public ContractDetail() {
    }

    public ContractDetail(int contractDetailId, int quantity, String attachServiceUnit, AttachService attachService) {
        this.contractDetailId = contractDetailId;
        this.quantity = quantity;
        this.attachService = attachService;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}