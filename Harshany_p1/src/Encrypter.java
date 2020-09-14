public class Encrypter {

    public static String encrypt(String eCode){

        char a=eCode.charAt(0);
        char b=eCode.charAt(1);
        char c=eCode.charAt(2);
        char d=eCode.charAt(3);

        int a2=Character.getNumericValue(a);
        int b2=Character.getNumericValue(b);
        int c2=Character.getNumericValue(c);
        int d2=Character.getNumericValue(d);

        int a3=(a2+7)%10;
        int b3=(b2+7)%10;
        int c3=(c2+7)%10;
        int d3=(d2+7)%10;


        int temp;
        temp = a3;
        a3 = c3;
        c3 = temp;

        int temp2;
        temp2 = b3;
        b3 = d3;
        d3 = temp2;

        String s1 = Integer.toString(a3);
        String s2 = Integer.toString(b3);
        String s3 = Integer.toString(c3);
        String s4 = Integer.toString(d3);

        String str1 = s1 + s2 + s3 +s4;
        System.out.printf("Encrypted code is %s", str1);


        return str1;
    }


}
