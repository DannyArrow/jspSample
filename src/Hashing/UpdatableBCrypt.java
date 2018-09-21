package Hashing;


import java.util.function.Function;


import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UpdatableBCrypt {

    private static final Logger log = LoggerFactory.getLogger(UpdatableBCrypt.class);
    private final int logRounds;

    public UpdatableBCrypt(int logRounds) {
        this.logRounds = logRounds;
    }

    public String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(logRounds));
    }

    public boolean verifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

    public boolean verifyAndUpdateHash(String password, String hash, Function<String, Boolean> updateFunc) {
        if (BCrypt.checkpw(password, hash)) {
            int rounds = getRounds(hash);
            // It might be smart to only allow increasing the rounds.
            // If someone makes a mistake the ability to undo it would be nice though.
            if (rounds != logRounds) {
                log.debug("Updating password from {} rounds to {}", rounds, logRounds);
                String newHash = hash(password);
                return updateFunc.apply(newHash);
            }
            return true;
        }
        return false;
    }

    private int getRounds(String salt) {
        char minor = (char)0;
        int off = 0;

        if (salt.charAt(0) != '$' || salt.charAt(1) != '2')
            throw new IllegalArgumentException ("Invalid salt version");
        if (salt.charAt(2) == '$')
            off = 3;
        else {
            minor = salt.charAt(2);
            if (minor != 'a' || salt.charAt(3) != '$')
                throw new IllegalArgumentException ("Invalid salt revision");
            off = 4;
        }

        // Extract number of rounds
        if (salt.charAt(off + 2) > '$')
            throw new IllegalArgumentException ("Missing salt rounds");
        return Integer.parseInt(salt.substring(off, off + 2));
    }

    public static void main(String[] args) {
        // {{start:bcryptMain}}
        // Mini function to test updates.
        String[] mutableHash = new String[1];
        Function<String, Boolean> update = hash -> { mutableHash[0] = hash; return true; };

        String hashPw1 = HashingPassword.hash("password");
        System.out.println(hashPw1);
        System.out.println(("verifying pw1: {} "+ HashingPassword.verifyAndUpdateHash("password", hashPw1, update)));
        System.out.println(("verifying pw1 fails: {} " + HashingPassword.verifyAndUpdateHash("password1", hashPw1, update)));
        System.out.println("verifying old hash " + HashingPassword.verifyAndUpdateHash("password", hashPw1, update));
        String hashPw2 = HashingPassword.hash("password");
        log.debug("hash of pw2: {}", hashPw2);
        log.debug("verifying pw2: {}", HashingPassword.verifyAndUpdateHash("password", hashPw2, update));
        log.debug("verifying pw2 fails: {}", HashingPassword.verifyAndUpdateHash("password2", hashPw2, update));

        UpdatableBCrypt oldHasher = new UpdatableBCrypt(7);
        String oldHash = oldHasher.hash("password");
        log.debug("hash of oldHash: {}", oldHash);
        log.debug("verifying oldHash: {}, hash upgraded to: {}",
               HashingPassword.verifyAndUpdateHash("password", oldHash, update),
                mutableHash[0]);
        // {{end:bcryptMain}}

    }
}