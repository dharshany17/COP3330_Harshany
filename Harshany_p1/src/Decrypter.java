public class Decrypter {
    public static String decrypt(String dCode){

        char e=dCode.charAt(0);
        char f=dCode.charAt(1);
        char g=dCode.charAt(2);
        char h=dCode.charAt(3);

        int e2=Character.getNumericValue(e);
        int f2=Character.getNumericValue(f);
        int g2=Character.getNumericValue(g);
        int h2=Character.getNumericValue(h);

        int e3=((e2+10)-7)%10;
        int f3=((f2+10)-7)%10;
        int g3=((g2+10)-7)%10;
        int h3=((h2+10)-7)%10;

        int temp;
        temp = e3;
        e3 = g3;
        g3 = temp;

        int temp2;
        temp2 = f3;
        f3 = h3;
        h3 = temp2;

        String s1 = Integer.toString(e3);
        String s2 = Integer.toString(f3);
        String s3 = Integer.toString(g3);
        String s4 = Integer.toString(h3);

        String str1 = s1 + s2 + s3 +s4;
        System.out.printf("Decrypted code is %s", str1);


        return str1;
    }

}

