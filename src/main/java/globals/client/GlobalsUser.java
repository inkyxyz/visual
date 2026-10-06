package globals.client;


public final class GlobalsUser {
   private final String username;
   private final String password;
   private final String client;

   public GlobalsUser(String var1, String var2, String var3) {
      this.username = var1;
      this.password = var2;
      this.client = var3;
   }

   @Override
   public final String toString() {
      return "GlobalsUser[username=" + this.username() + ", password=" + this.password() + ", client=" + this.client() + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.username());
      result = 31 * result + java.util.Objects.hashCode(this.password());
      result = 31 * result + java.util.Objects.hashCode(this.client());
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      GlobalsUser other = (GlobalsUser) var1;
      return java.util.Objects.equals(this.username(), other.username())
         && java.util.Objects.equals(this.password(), other.password())
         && java.util.Objects.equals(this.client(), other.client());
   }

   public String username() {
      return this.username;
   }

   public String password() {
      return this.password;
   }

   public String client() {
      return this.client;
   }
}
