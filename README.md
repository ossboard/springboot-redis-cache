# Spring Boot, redis cache

스프링 환경에서 redis 를 이용해 캐시 구현 예제



### 개발환경
>- Intellij IDEA 환경
>- gradle 프로젝트 열기
>- lombok 라이브러리 사용 ex) @Data 
>- Proferences > Build, Excution, Depoloyment > Compiler > Annotation Processors > Enable annotation processing (체크)

### 빌드
```
$ gradle clean
$ gradle build -x test
$ ls ./build/libs/demo-0.1.war
  ./build/libs/demo-0.1.war
$
```

### 환경설정
application.yml 에서 아래부분 옵션이 현재 동작안함, 좀더 봐야함!
```
spring:
    cache:
        redis:
            cache-null-values: true # Allow caching null values.
            key-prefix: KONAN_PRE_
            time-to-live: 5 # Entry expiration. By default the entries never expire.
            use-key-prefix: true # Whether to use the key prefix when writing to Redis.
```

### 기타
```
- RedisConfiguration.java 에서 redisTemplate.setKeySerializer(stringRedisSerializer()); 등이, 
@EnableCaching 에서 동작안함 
- RedisConfiguration.java 를 추가하면, redis에서 키가 2개생김, 원인파악중...

1) "\xac\xed\x00\x05sr\x00/org.springframework.cache.interceptor.SimpleKeyL\nW\x03km\x93\xd8\x02\x00\x02I\x00\bhashCode[\x00\x06paramst\x00\x13[Ljava/lang/Object;xp\x00\x00\x00\x01ur\x00\x13[Ljava.lang.Object;\x90\xceX\x9f\x10s)l\x02\x00\x00xp\x00\x00\x00\x00"
=>
1) "\xac\xed\x00\x05sr\x00/org.springframework.cache.interceptor.SimpleKeyL\nW\x03km\x93\xd8\x02\x00\x02I\x00\bhashCode[\x00\x06paramst\x00\x13[Ljava/lang/Object;xp\x00\x00\x00\x01ur\x00\x13[Ljava.lang.Object;\x90\xceX\x9f\x10s)l\x02\x00\x00xp\x00\x00\x00\x00"
2) "post-top~keys"
```

