// package com.frostix.backend.configuration;

// public class JwtTokenConfig {
// public static String createToken(String id, String key, long expireTime) {
// return Jwts.builder()
// .setHeaderParam("typ", "JWT")
// .setHeaderParam("alg", "HS256")
// .setSubject("user")
// .setExpiration(new Date(System.currentTimeMillis() + expireTime))
// .claim("id", id)
// .signWith(SignatureAlgorithm.HS256, key)
// .compact();
// };
// }
