package globals.client.auth;


public final class Session {
   private final String access;
   private final String refresh;
   private final long expiresAt;
   private final String username;
   private final Integer uid;
   private final String role;

   public Session(String var1, String var2, long var3, String var5, Integer var6, String var7) {
      this.access = var1;
      this.refresh = var2;
      this.expiresAt = var3;
      this.username = var5;
      this.uid = var6;
      this.role = var7;
   }

   public boolean stale() {
      return System.currentTimeMillis() > this.expiresAt - 60000L;
   }

   @Override
   public final String toString() {
      return "Session[access=" + this.access() + ", refresh=" + this.refresh() + ", expiresAt=" + this.expiresAt() + ", username=" + this.username() + ", uid=" + this.uid() + ", role=" + this.role() + "]";
   }

   @Override
   public final int hashCode() {
      int result = 0;
      result = 31 * result + java.util.Objects.hashCode(this.access());
      result = 31 * result + java.util.Objects.hashCode(this.refresh());
      result = 31 * result + java.util.Objects.hashCode(this.expiresAt());
      result = 31 * result + java.util.Objects.hashCode(this.username());
      result = 31 * result + java.util.Objects.hashCode(this.uid());
      result = 31 * result + java.util.Objects.hashCode(this.role());
      return result;
   }

   @Override
   public final boolean equals(Object var1) {
      if (this == var1) return true;
      if (var1 == null || getClass() != var1.getClass()) return false;
      Session other = (Session) var1;
      return java.util.Objects.equals(this.access(), other.access())
         && java.util.Objects.equals(this.refresh(), other.refresh())
         && java.util.Objects.equals(this.expiresAt(), other.expiresAt())
         && java.util.Objects.equals(this.username(), other.username())
         && java.util.Objects.equals(this.uid(), other.uid())
         && java.util.Objects.equals(this.role(), other.role());
   }

   public String access() {
      return this.access;
   }

   public String refresh() {
      return this.refresh;
   }

   public long expiresAt() {
      return this.expiresAt;
   }

   public String username() {
      return this.username;
   }

   public Integer uid() {
      return this.uid;
   }

   public String role() {
      return this.role;
   }
}
