public class Main {
    public static void main(String[] args) {
        Program p = new Program();
        p.setUserName(args[0]);
        BookRegister br = new BookRegister();
        br.books();
        p.setBookRegister(br);
        p.run();
    }
}