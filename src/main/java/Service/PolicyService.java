package Service;

import com.neoteric.lic.model.Policy;

public class PolicyService {

    public Policy createPolicy(String policyNumber, String policyType, double premiumAmount) {
        Policy policy = new Policy();
        policy.policyNumber = policyNumber;
        policy.policyType = policyType;
        policy.premiumAmount = premiumAmount;
//        policy.policyHolder = policyHolder;
        return policy;
    }

    public boolean isValidPolicy(Policy policy) {
        // Example validation logic
        return policy != null && policy.policyNumber != null && !policy.policyNumber.isEmpty();
    }
}
