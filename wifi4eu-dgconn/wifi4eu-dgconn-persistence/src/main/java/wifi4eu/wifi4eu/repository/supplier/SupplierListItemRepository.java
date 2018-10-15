package wifi4eu.wifi4eu.repository.supplier;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.supplier.SupplierListItem;

import java.util.List;

public interface SupplierListItemRepository extends CrudRepository<SupplierListItem,Integer> {

    @Query(value = "select sup.id, sup.name, sup.website, sup.vat, sup._status as status, (select count(1) from suppliers where vat = sup.vat and _status != 1) as numberRegistrations from suppliers as sup WHERE sup.name like concat('%',?#{[0]},'%') ORDER BY name ASC OFFSET ?#{[1]} ROWS FETCH NEXT ?#{[2]} ROWS ONLY", nativeQuery = true)
    List<SupplierListItem> findSupplierListItemsOrderByNameAsc(String name, Integer offset, Integer count);

    @Query(value = "select sup.id, sup.name, sup.website, sup.vat, sup._status as status, (select count(1) from suppliers where vat = sup.vat and _status != 1) as numberRegistrations from suppliers as sup WHERE sup.name like concat('%',?#{[0]},'%') ORDER BY name DESC OFFSET ?#{[1]} ROWS FETCH NEXT ?#{[2]} ROWS ONLY", nativeQuery = true)
    List<SupplierListItem> findSupplierListItemsOrderByNameDesc(String name, Integer offset, Integer count);

    @Query(value = "select sup.id, sup.name, sup.website, sup.vat, sup._status as status, (select count(1) from suppliers where vat = sup.vat and _status != 1) as numberRegistrations from suppliers as sup WHERE sup.name like concat('%',?#{[0]},'%') ORDER BY website ASC OFFSET ?#{[1]} ROWS FETCH NEXT ?#{[2]} ROWS ONLY", nativeQuery = true)
    List<SupplierListItem> findSupplierListItemsOrderByWebsiteAsc(String name, Integer offset, Integer count);

    @Query(value = "select sup.id, sup.name, sup.website, sup.vat, sup._status as status, (select count(1) from suppliers where vat = sup.vat and _status != 1) as numberRegistrations from suppliers as sup WHERE sup.name like concat('%',?#{[0]},'%') ORDER BY website DESC OFFSET ?#{[1]} ROWS FETCH NEXT ?#{[2]} ROWS ONLY", nativeQuery = true)
    List<SupplierListItem> findSupplierListItemsOrderByWebsiteDesc(String name, Integer offset, Integer count);

    @Query(value = "select sup.id, sup.name, sup.website, sup.vat, sup._status as status, (select count(1) from suppliers where vat = sup.vat and _status != 1) as numberRegistrations from suppliers as sup WHERE sup.name like concat('%',?#{[0]},'%') ORDER BY vat ASC OFFSET ?#{[1]} ROWS FETCH NEXT ?#{[2]} ROWS ONLY", nativeQuery = true)
    List<SupplierListItem> findSupplierListItemsOrderByVatAsc(String name, Integer offset, Integer count);

    @Query(value = "select sup.id, sup.name, sup.website, sup.vat, sup._status as status, (select count(1) from suppliers where vat = sup.vat and _status != 1) as numberRegistrations from suppliers as sup WHERE sup.name like concat('%',?#{[0]},'%') ORDER BY vat DESC OFFSET ?#{[1]} ROWS FETCH NEXT ?#{[2]} ROWS ONLY", nativeQuery = true)
    List<SupplierListItem> findSupplierListItemsOrderByVatDesc(String name, Integer offset, Integer count);

    @Query(value = "select sup.id, sup.name, sup.website, sup.vat, sup._status as status, (select count(1) from suppliers where vat = sup.vat and _status != 1) as numberRegistrations from suppliers as sup WHERE sup.name like concat('%',?#{[0]},'%') ORDER BY status ASC OFFSET ?#{[1]} ROWS FETCH NEXT ?#{[2]} ROWS ONLY", nativeQuery = true)
    List<SupplierListItem> findSupplierListItemsOrderByStatusAsc(String name, Integer offset, Integer count);

    @Query(value = "select sup.id, sup.name, sup.website, sup.vat, sup._status as status, (select count(1) from suppliers where vat = sup.vat and _status != 1) as numberRegistrations from suppliers as sup WHERE sup.name like concat('%',?#{[0]},'%') ORDER BY status DESC OFFSET ?#{[1]} ROWS FETCH NEXT ?#{[2]} ROWS ONLY", nativeQuery = true)
    List<SupplierListItem> findSupplierListItemsOrderByStatusDesc(String name, Integer offset, Integer count);

    @Query(value = "select sup.id, sup.name, sup.website, sup.vat, sup._status as status, (select count(1) from suppliers where vat = sup.vat and _status != 1) as numberRegistrations from suppliers as sup WHERE sup.name like concat('%',?#{[0]},'%') ORDER BY numberRegistrations ASC OFFSET ?#{[1]} ROWS FETCH NEXT ?#{[2]} ROWS ONLY", nativeQuery = true)
    List<SupplierListItem> findSupplierListItemsOrderByNumberRegistrationsAsc(String name, Integer offset, Integer count);

    @Query(value = "select sup.id, sup.name, sup.website, sup.vat, sup._status as status, (select count(1) from suppliers where vat = sup.vat and _status != 1) as numberRegistrations from suppliers as sup WHERE sup.name like concat('%',?#{[0]},'%') ORDER BY numberRegistrations DESC OFFSET ?#{[1]} ROWS FETCH NEXT ?#{[2]} ROWS ONLY", nativeQuery = true)
    List<SupplierListItem> findSupplierListItemsOrderByNumberRegistrationsDesc(String name, Integer offset, Integer count);
}
