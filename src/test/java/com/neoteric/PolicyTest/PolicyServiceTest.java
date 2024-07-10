package com.neoteric.PolicyTest;


import Model.PolicyHolder;
import Service.PolicyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class PolicyServiceTest {

    @Test
    public void testCreatePolicy() {
        // Arrange
        PolicyHolder policyHolder = new PolicyHolder();
        policyHolder.firstName = "John";
        policyHolder.lastName = "Doe";
        policyHolder.age = 30;

        com.neoteric.lic.model.Address address = new com.neoteric.lic.model.Address();
        address.flatNo = "101";
        address.area = "Downtown";
        address.street = "Main St";
        address.city = "Metropolis";
        address.pinCode = "12345";
        policyHolder.address=  address;

        PolicyService service = new PolicyService();

        // Act
        com.neoteric.lic.model.Policy policy = service.createPolicy("POL123", "Life", 5000.0);

        // Assert
        Assertions.assertNotNull(policy);
        Assertions.assertEquals("POL123", policy.policyNumber);
        Assertions.assertEquals("Life", policy.policyType);
        Assertions.assertEquals(5000.0, policy.premiumAmount);
//        Assertions.assertEquals(policyHolder, policy.policyHolder);
    }

    @Test
    public void testIsValidPolicy() {
        // Arrange
        PolicyHolder policyHolder = new PolicyHolder();
        policyHolder.firstName = "John";
        policyHolder.lastName = "Doe";
        policyHolder.age = 30;

        com.neoteric.lic.model.Address address = new com.neoteric.lic.model.Address();
        address.flatNo = "101";
        address.area = "Downtown";
        address.street = "Main St";
        address.city = "Metropolis";
        address.pinCode = "12345";
        policyHolder.address =  address;

        PolicyService service = new PolicyService();
        com.neoteric.lic.model.Policy policy = service.createPolicy("POL123", "Life", 5000.0);

        // Act & Assert
        Assertions.assertTrue(service.isValidPolicy(policy));
    }
}
