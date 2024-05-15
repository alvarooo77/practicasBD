package nuestroCRUD;

import java.util.List;

public class MyConstraint {
   // only two types: primary and foreign
   private String[] params;

   public MyConstraint(boolean isPrimary) {
      // [1]- name of constraint
      // [2]- name of affected column
      // [3]- name of referenced table if its foreign
      // [4]- name of column of referenced table if its foreign

      if (isPrimary){
         params = new String[2]; // name of constraint and name of column
      } else {
         params = new String[4]; // as up and name of referencedTable and its column
      }
   }

   public String[] getParams() {
      return params;
   }

   public void setParams(String[] params) {
      this.params = params;
   }

   

   
   
}
