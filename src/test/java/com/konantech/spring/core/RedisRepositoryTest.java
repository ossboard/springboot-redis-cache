package com.konantech.spring.core;

        import org.junit.Assert;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisRepositoryTest {

    @Autowired
    private RedisRepository redisRepository;

    @Test
    public void setObject() {
        redisRepository.setObject("key1","hello", 10);
        Assert.assertEquals(redisRepository.getObject("key1"),"hello");

    }
}