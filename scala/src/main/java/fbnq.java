public class fbnq {
    public static void main(String[] args) {
        System.out.println(fbn(7));
    }

    private static int fbn(int i) {
        if(i == 1||i ==2 ){
            return 1;
        }
        return fbn(i-2)+fbn(i-1);
    }

}
