package com.project.sapbackend.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TokenRepository extends JpaRepository<JwtToken, Long> {

    @Query(
            """
                SELECT t from JwtToken t inner join User  u on t.user.userId = u.userId
                where u.userId = :userId and (t.expired = false or t.revoked = false )
            """
    )
    List<JwtToken> findAllValidTokensByUser(@Param("userId") Long userId);

//    Optional<JwtToken> findByToken(String token);

    @Query("select j from JwtToken j where j.token = ?1")
    Optional<JwtToken> findByToken(String token);

    @Query("select j from JwtToken j where j.expired = ?1 and j.revoked = ?2")
    Optional<List<JwtToken>> findByExpiredAndRevoked(boolean expired, boolean revoked);


}
