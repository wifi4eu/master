package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.BankAccount;

import java.util.List;

public interface BankAccountRepository extends CrudRepository<BankAccount,Integer> {

    List<BankAccount> findBySupplierId(int supplierId);

    BankAccount findByIdAndSupplierId(int id, int supplierId);
}
