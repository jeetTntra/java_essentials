package Serialization;

import java.io.File;
import java.io.Serializable;

public class Serialization {
  public static void main(String[] args) {
    SerializedUser user = new SerializedUser("John", "Doe");
    System.out.println("Before serialization: " + user);
    SerializedUser.serializeToFile(user);
    SerializedUser deserializedUser = SerializedUser.deserializeFromFile();
    System.out.println("After deserialization: " + deserializedUser);

  }
}

class SerializedUser implements Serializable {
  private String name;
  private String password;

  public SerializedUser(String name, String password) {
    this.name = name;
    this.password = password;
  }

  static void serializeToFile(SerializedUser user) {
    try {
      File file = new File("/Users/jeetpatel/IdeaProjects/java_essentials/src/main/java/Serialization/user.ser");
      java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(new java.io.FileOutputStream(file));
      out.writeObject(user);
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static SerializedUser deserializeFromFile() {
    try {
      File file = new File("/Users/jeetpatel/IdeaProjects/java_essentials/src/main/java/Serialization/user.ser");
      java.io.ObjectInputStream in = new java.io.ObjectInputStream(new java.io.FileInputStream(file));
      SerializedUser user = (SerializedUser) in.readObject();
      in.close();
      return user;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}

class User {
  private String name;
  private String password;

  public User(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}