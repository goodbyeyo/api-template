package template.global.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class JasyptConfigTest {

    @Autowired
    JasyptConfig config;

    @Test
    public void jasyptTest_kakao_clientId() {
        String content = "722e99b7d8f989054a0bd9152d87d6bf";
        String encryptContent = config.jasyptStringEncryptor().encrypt(content);
        String decryptContent = config.jasyptStringEncryptor().decrypt(encryptContent);
        System.out.println("encryptContent = " + encryptContent);
        System.out.println("decryptContent = " + decryptContent);
    }

    @Test
    public void jasyptTest_kakao_serect() {
        String content = "e75mFITZWDJlwN230Ow0AANue6z1eGCR";
        String encryptContent = config.jasyptStringEncryptor().encrypt(content);
        String decryptContent = config.jasyptStringEncryptor().decrypt(encryptContent);
        System.out.println("encryptContent = " + encryptContent);
        System.out.println("decryptContent = " + decryptContent);
    }

    @Test
    public void jasyptTest_token_serect() {
        String content = "e75mFITZWDJlwN230Ow0A";
        String encryptContent = config.jasyptStringEncryptor().encrypt(content);
        String decryptContent = config.jasyptStringEncryptor().decrypt(encryptContent);
        System.out.println("encryptContent = " + encryptContent);
        System.out.println("decryptContent = " + decryptContent);
    }
}