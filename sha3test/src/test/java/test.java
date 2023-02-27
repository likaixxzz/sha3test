import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.util.encoders.Hex;

public class test {
    private int key = 11169;

    public static void main(String[] args) {
        int a = 123456;
        test test = new test();




    /*    int encryption = test.encryption(a);
        test.decrypt(encryption);
*/

    /*    System.out.println("明文 = " + a);
        System.out.println("加密 = " + test.likai(a));
        System.out.println("解密 = " + test.likai(test.likai(a)));
*/


     /*   System.out.println("李凯 = " + (a + "李凯").hashCode());
        System.out.println("张三 = " + (a + "张三").hashCode());
        System.out.println("李四 = " + (a + "李四").hashCode());
        System.out.println("王五 = " + (a + "王五").hashCode());
*/

       String salt1 = "李凯";
        String salt2 = "张三";
        String salt3 = "李四";
        String salt4 = "王五";
        String s1 = test.sha3224(a + salt1);
        String s2 = test.sha3224(a + salt2);
        String s3 = test.sha3224(a + salt3);
        String s4 = test.sha3224(a + salt4);
        System.out.println("李凯的密码 = " + s1);
        System.out.println("张三的密码 = " + s2);
        System.out.println("李四的密码 = " + s3);
        System.out.println("王五的密码 = " + s4);
        System.out.println("李凯登录中  " + (s1.equals(test.sha3224(123456 + salt1))?"登录成功":"登录失败"));



        
    }

    public int encryption(int a) {
        System.out.println("十进制明文 = " + a);
        String s = Integer.toBinaryString(a);
        StringBuilder s1 = new StringBuilder(Integer.toBinaryString(key));
        for (int i = 0; i < s.length() - s1.length(); ) {
            s1.insert(0, "0");
        }
        System.out.println("明文 = " + s);
        System.out.println("密钥 = " + s1);
        int c = a ^ key;
        StringBuilder s2 = new StringBuilder(Integer.toBinaryString(c));
        for (int i = 0; i < s.length() - s2.length();) {
            s2.insert(0, "0");
        }
        System.out.println("密文 = " + s2);
        System.out.println("十进制密文 = " + c);
        return c;
    }

    public int decrypt(int a) {
        StringBuilder s = new StringBuilder(Integer.toBinaryString(a));
        StringBuilder s1 = new StringBuilder(Integer.toBinaryString(key));
        if (s.length() > s1.length()) {
            for (int i = 0; i < s.length() - s1.length(); ) {
                s1.insert(0, "0");
            }
        } else {
            for (int i = 0; i < s1.length() - s.length(); ) {
                s.insert(0, "0");
            }
        }
        System.out.println("密文 = " + s);
        System.out.println("密钥 = " + s1);
        int c = a ^ key;
        StringBuilder s2 = new StringBuilder(Integer.toBinaryString(c));
        for (int i = 0; i < s.length() - s2.length(); i++) {
            s2.insert(0, "0");
        }
        System.out.println("明文 = " + s2);
        System.out.println("十进制明文 = " + c);
        return c;
    }

    public int likai(int a) {
        return a ^ key;
    }

    public int Irreversible(Object o) {
        return o.hashCode();
    }

    public String sha3224(String password) {
        byte[] bytes = password.getBytes();
        SHA3Digest digest = new SHA3Digest(224);
        digest.update(bytes, 0, bytes.length);
        byte[] rsData = new byte[digest.getDigestSize()];
        digest.doFinal(rsData, 0);
        return Hex.toHexString(rsData);

    }
}
