package com.example.projectSupplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/query")
    public ResponseEntity<List<Supplier>> querySuppliers(@RequestBody SupplierQueryRequest request) {
        // Fetch all suppliers from the service
        List<Supplier> allSuppliers = supplierService.getAllSuppliers();

        // Filter suppliers based on the request criteria
        List<Supplier> matchingSuppliers = allSuppliers.stream()
                .filter(supplier ->
                        (request.getLocation() == null || supplier.getLocation().equalsIgnoreCase(request.getLocation())) &&
                                (request.getNatureOfBusiness() == null || supplier.getNatureOfBusiness().equalsIgnoreCase(request.getNatureOfBusiness())) &&
                                (request.getManufacturingProcesses() == null || supplier.getManufacturingProcesses().containsAll(supplier.getManufacturingProcesses()))
                )
                .collect(Collectors.toList());

        // Return the filtered list of suppliers
        return ResponseEntity.ok(matchingSuppliers);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addSupplier(@RequestBody Supplier supplier) {
        supplierService.addSupplier(supplier);
        return ResponseEntity.ok("Supplier added successfully!");
    }
}
