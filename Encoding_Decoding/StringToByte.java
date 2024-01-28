package Encoding_Decoding;
import java .util.*;
public class StringToByte {
    public static void main(String args[])
    {
        byte[] binaryData = "Hello, World!".getBytes("UTF-8");
        String base64String = Base64.getEncoder().encodeToString(binaryData);
    }

    
}
