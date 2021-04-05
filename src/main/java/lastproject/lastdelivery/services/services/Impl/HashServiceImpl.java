package lastproject.lastdelivery.services.services.Impl;

import lastproject.lastdelivery.services.HashingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class HashServiceImpl implements HashingService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
@Autowired
    public HashServiceImpl(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public String hash(String str) {
        return bCryptPasswordEncoder.encode(str);
    }
}
