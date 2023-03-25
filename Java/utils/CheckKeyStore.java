package utils;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;

public class CheckKeyStore {
    static KeyStoreConfig keyStoreConfig;

    public static void main(String[] args) throws Exception {
        final String SHA_256 = "SHA-256";
        // KeyStoreConfig ktc = new
        // KeyStoreConfig("D:\\android\\TVEduVoice\\platform.release.ktc123.keystore",
        // "ktc123", "ktc123");
        KeyStoreConfig debug = new KeyStoreConfig("D:\\android\\TVEduVoice\\debug.keystore", "android",
                "androiddebugkey");
        keyStoreConfig = debug;
        FileInputStream fis = new FileInputStream(keyStoreConfig.keystorePath);
        KeyStore keystore = KeyStore.getInstance("JKS");
        keystore.load(Files.newInputStream(Paths.get(keyStoreConfig.keystorePath)),
                keyStoreConfig.keystorePassword.toCharArray());
        fis.close();

        // 现在您可以使用 keystore 对象进行各种操作，例如获取证书或密钥。
        printFinger(keystore, SHA_256);

    }

    // 计算证书指纹
    static void printFinger(KeyStore keyStore, String algorithm)
            throws NoSuchAlgorithmException, KeyStoreException, CertificateEncodingException {
        Certificate cert = keyStore.getCertificate(keyStoreConfig.alias);
        MessageDigest md = MessageDigest.getInstance(algorithm);
        byte[] fingerprint = md.digest(cert.getEncoded());

        // 将指纹转换为十六进制字符串
        StringBuilder sb = new StringBuilder();
        for (byte b : fingerprint) {
            sb.append(String.format("%02x", b)).append(":");
        }
        String fingerprintStr = sb.substring(0, sb.length() - 1).toUpperCase();
        System.out.println(algorithm + ": " + fingerprintStr);
    }

    public static class KeyStoreConfig {
        String keystorePath;
        String keystorePassword;
        String alias;

        public KeyStoreConfig(String keystorePath, String keystorePassword, String alias) {
            this.keystorePath = keystorePath;
            this.keystorePassword = keystorePassword;
            this.alias = alias;
        }
    }

}
