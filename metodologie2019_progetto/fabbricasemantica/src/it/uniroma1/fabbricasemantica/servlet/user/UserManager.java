package it.uniroma1.fabbricasemantica.servlet.user;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.json.JSONObject;

public class UserManager {

  public static boolean isSignedUp(InputStream s) throws Exception {
    return (!s.equals(null));
  }

  public static boolean verify(JSONObject userDetails, String pwd) {
    String secret = userDetails.getString("secret");
    String pwdEncoded = encode(pwd);
    return pwdEncoded.equals(secret);
  }

  public static void signUp(User user, File usersFile) {
    JSONObject userDetails = new JSONObject();
    userDetails.put("username", user.getUsername());
    String secret = encode(user.getPassword());
    userDetails.put("secret", secret);
    for (Language l : user.getNatLanguages()) {
      userDetails.put("nativeLanguage", l.toString());
    }
    for (Pair<Language, Level> p : user.getOtherLanguages()) {
      userDetails.put("otherLanguage", p.toString());
    }

    try (FileWriter file = new FileWriter(usersFile)) {
      file.write(userDetails.toString());
      file.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String encode(String pwd) {
    return pwd; // il metodo dovrebbe codificare la password, in modo da poterla salvare nel db criptata
  }
}