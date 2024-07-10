package Service;

import com.neoteric.lic.model.Claim;
import com.neoteric.lic.model.Policy;

import java.util.Date;

public class ClaimService {

    public Claim fileClaim(String claimNumber, double claimAmount, Policy policy) {
        if (!isValidPolicyForClaim(policy)) {
            return null;
        }

        Claim claim = new Claim();
        claim.claimNumber = claimNumber;
        claim.claimDate = new Date();
        claim.claimAmount = claimAmount;
        claim.status = "Filed";
        claim.policy = policy;
        return claim;
    }

    private boolean isValidPolicyForClaim(Policy policy) {
        return policy != null && policy.policyNumber != null && !policy.policyNumber.isEmpty();
    }
}
