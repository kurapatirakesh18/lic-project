package com.neoteric.PolicyTest;

import Model.PolicyHolder;
import Service.ClaimService;
import Service.PolicyService;
import com.neoteric.lic.model.Address;
import com.neoteric.lic.model.Claim;
import com.neoteric.lic.model.Policy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClaimServiceTest {

    @Test
    public void testFileClaim() {
        // Arrange
        PolicyHolder policyHolder = new PolicyHolder();
        policyHolder.firstName = "Rakesh";
        policyHolder.lastName = "Rake";
        policyHolder.age = 21;

        Address address = new Address();
        address.flatNo = "202";
        address.area = "Uptown";
        address.street = "First Ave";
        address.city = "bayadere";
        address.pinCode = "500061";
        policyHolder.address=  address;

        PolicyService policyService = new PolicyService();
        Policy policy = policyService.createPolicy("POL456", "Health", 3000.0);

        ClaimService claimService = new ClaimService();

        // Act
        Claim claim = claimService.fileClaim("CLM789", 1500.0, policy);

        // Assert
        Assertions.assertNotNull(claim);
        Assertions.assertEquals("CLM789", claim.claimNumber);
        Assertions.assertEquals(1500.0, claim.claimAmount);
        Assertions.assertEquals("Filed", claim.status);
        Assertions.assertEquals(policy, claim.policy);
    }

    @Test
    public void testFileClaimWithInvalidPolicy() {
        // Arrange
        Policy policy = new Policy(); // Invalid policy with null policy number

        ClaimService claimService = new ClaimService();

        // Act
        Claim claim = claimService.fileClaim("CLM123", 1000.0, policy);

        // Assert
        Assertions.assertNull(claim, "Claim should be null for an invalid policy");
    }
}
