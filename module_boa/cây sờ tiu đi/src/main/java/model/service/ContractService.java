package service;

import model.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> selectAllContract();
    void save(Contract contract);
    Contract findContractById(int contractId);
    void update(int contractid, Contract contract);
    void delete(int contractId);
    List<Contract> findContract(String valueFind);
}