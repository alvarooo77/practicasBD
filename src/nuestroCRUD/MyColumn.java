package nuestroCRUD;

public class MyColumn {
   private String ColName;
   private String ColType;
   private boolean nulleable;
   
   public MyColumn() {
      ColName = null;
      ColType = null;
      nulleable = false;
      }
   public String getColName() {
      return ColName;
   }
   public void setColName(String colName) {
      ColName = colName;
   }
   public String getColType() {
      return ColType;
   }
   public void setColType(String colType) {
      ColType = colType;
   }
   public boolean isNulleable() {
      return nulleable;
   }
   public void setNulleable(boolean nulleable) {
      this.nulleable = nulleable;
   }

   
}
