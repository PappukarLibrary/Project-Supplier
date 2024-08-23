package com.example.projectSupplier;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SupplierRepository {
    private final List<Supplier> suppliers = new ArrayList<>();

    public List<Supplier> findAll() {
        return suppliers;
    }

    public void save(Supplier supplier) {
        suppliers.add(supplier);
    }

    public List<Supplier> findByCriteria(String location, String natureOfBusiness, String manufacturingProcess) {
        return suppliers.stream()
                .filter(supplier -> supplier.getLocation().equalsIgnoreCase(location))
                .filter(supplier -> supplier.getNatureOfBusiness().equalsIgnoreCase(natureOfBusiness))
                .filter(supplier -> supplier.getManufacturingProcesses().contains(manufacturingProcess))
                .collect(Collectors.toList());
    }
}
