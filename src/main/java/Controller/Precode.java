package Controller;


public class Precode {
    private String code;
    private int dvmIndex;
    private static Precode precode = null;

    public Precode(int dvmIndex){
        this.code = "";
        this.dvmIndex = dvmIndex;
    }

    public static Precode getInstance() {
        if(precode == null) {
            precode = new Precode(-1);
        }
        return precode;
    }

    public String getCode() {
        return code;
    }

    public int getDvmIndex() {
        return dvmIndex;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDvmIndex(int dvmIndex) {
        this.dvmIndex = dvmIndex;
    }
}
