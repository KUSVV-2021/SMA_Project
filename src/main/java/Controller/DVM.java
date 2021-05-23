package Controller;

public class DVM {
    public static Precode pr;
    private static DVM dvm = null;

    private DVM(){
        pr = Precode.getInstance();     //선결제코드 초기화
    }

    public static DVM getInstance() {
        if(dvm == null) {
            dvm = new DVM();
        }
        return dvm;
    }
}
