package kr.or.ddit.utiles;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpSession;

public class CryptoGenerator {
   
   public static Map<String, String> getGeneratePairKey(HttpSession session) {
      KeyPairGenerator pairGenerator = null;
      KeyPair keyPair = null;
      PublicKey publicKey = null;
      PrivateKey privateKey = null;
      KeyFactory keyFactory = null;
      
      Map<String, String> publicKeyMap = new HashMap<String, String>();
      
      try {
         pairGenerator = KeyPairGenerator.getInstance("RSA");
         pairGenerator.initialize(2048);
         keyPair = pairGenerator.generateKeyPair();
         publicKey = keyPair.getPublic();
         privateKey = keyPair.getPrivate();
         
         session.setAttribute("privateKey", privateKey);
         
         keyFactory = KeyFactory.getInstance("RSA");
         RSAPublicKeySpec publicKeySpec = (RSAPublicKeySpec)keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);   
         
         String publicModulus = publicKeySpec.getModulus().toString(16);   
         String publicExponent = publicKeySpec.getPublicExponent().toString(16);
         
         publicKeyMap.put("publicModulus", publicModulus);
         publicKeyMap.put("publicExponent", publicExponent);
         
         
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
      } catch (InvalidKeySpecException e) {
         e.printStackTrace();
      }
      
      return publicKeyMap;
   }
   
   public static String decryptRSA(PrivateKey privateKey, String secureValue) {
      String returnValue = "";
      try {
         Cipher cipher = Cipher.getInstance("RSA");
         cipher.init(Cipher.DECRYPT_MODE, privateKey);
         
         byte[] targetByte = hexToByteArray(secureValue);
         
         byte[] beforeString = cipher.doFinal(targetByte);
         
         returnValue = new String(beforeString, "UTF-8");
         
      } catch (NoSuchAlgorithmException e) {
         e.printStackTrace();
      } catch (NoSuchPaddingException e) {
         e.printStackTrace();
      } catch (InvalidKeyException e) {
         e.printStackTrace();
      } catch (IllegalBlockSizeException e) {
         e.printStackTrace();
      } catch (BadPaddingException e) {
         e.printStackTrace();
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
      }
      
      return returnValue;
   }

   private static byte[] hexToByteArray(String secureValue) {
      if(secureValue == null || secureValue.length()%2 != 0 ) { 
         return new byte[]{};
      }
      
      byte[] bytes = new byte[secureValue.length()/2];
      
      for(int i = 0; i < secureValue.length(); i+=2) {
         byte value = (byte) Integer.parseInt(secureValue.substring(i, i+2), 16); 
         bytes[(int)Math.floor(i/2)] = value;
      }
      
      return bytes;
   }
   
}







