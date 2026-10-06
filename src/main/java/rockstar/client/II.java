package rockstar.client;

public class II {
    private String serverId;
    private String serverRuName;
    private String mineName;
    private String mineRarity;
    private String nextMineRarity;
    private long resetSecondsLeft;
    private long fetchTime;

    public String I_method_da8e5874() {
        return this.serverId;
    }

    public void I_method_1bfd4076(String string) {
        this.serverId = string;
    }

    public String i_method_6dad0894() {
        return this.serverRuName;
    }

    public void i_method_ecb49456(String string) {
        this.serverRuName = string;
    }

    public String II_method_7c96a20b() {
        return this.mineName;
    }

    public void II_method_bafe29bf(String string) {
        this.mineName = string;
    }

    public String Ii_method_fb5522b() {
        return this.mineRarity;
    }

    public void Ii_method_8bb57d9f(String string) {
        this.mineRarity = string;
    }

    public String iI_method_4d4df5eb() {
        return this.nextMineRarity;
    }

    public void iI_method_13151df(String string) {
        this.nextMineRarity = string;
    }

    public long I_method_b1b6a9a0() {
        return this.resetSecondsLeft;
    }

    public void I_method_851f0298(long l) {
        this.resetSecondsLeft = l;
    }

    public long i_method_b1c53580() {
        return this.fetchTime;
    }

    public void i_method_86e1f2b8(long l) {
        this.fetchTime = l;
    }

    public long II_method_852d8329() {
        long l = (System.currentTimeMillis() - this.fetchTime) / 1000L;
        return Math.max(0L, this.resetSecondsLeft - l);
    }

    public String toString() {
        return "FunTimeMine{serverId='" + this.serverId + "', serverRuName='" + this.serverRuName + "', mineName='" + this.mineName + "', mineRarity='" + this.mineRarity + "', nextMineRarity='" + this.nextMineRarity + "', secondsRemaining=" + this.II_method_852d8329() + "}";
    }
}

