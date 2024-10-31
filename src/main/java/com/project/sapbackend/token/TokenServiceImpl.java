package com.project.sapbackend.token;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final TokenRepository tokenRepository;


//    @Scheduled(cron = "0 0 0 * *")
    @Override
    public void cleanUpTableFromTokens(){
        Optional<List<JwtToken>> tokenList = tokenRepository.findByExpiredAndRevoked(true, true);
        if (tokenList.isPresent()){
            List<JwtToken> jwtTokens = tokenList.get();
            jwtTokens.forEach(token -> {
                tokenRepository.deleteById(token.getTokenid());
            });
        }
    }

}
