package model;

import java.util.List;

public class Folder implements File {
   public String name;
   public List<File> files;
   public boolean collapsed;

   public Folder(String name) {
      this.name = name;
   }

   @Override
   public String getName() {
      return name;
   }

   public void addFile(File f) {
      files.add(f);
   }

   @Override
   public String toString() {
      return "Folder{" +
              "name='" + name + '\'' +
              ", files=" + files +
              ", collapsed=" + collapsed +
              '}';
   }

   @Override
   public String toString(boolean last) {
      return this.toString();
   }
}
