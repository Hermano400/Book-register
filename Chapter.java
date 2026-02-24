public class Chapter {
    private String tittle;
    private int totalPages;

//    public Chapter(String tittle, int totalPages) {
//        this.tittle = tittle;
//        this.totalPages = totalPages;
//    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }


    @Override
    public String toString() {
        return "Chapter {" +
                "tittle = '" + tittle + '\'' +
                ", totalPages = " + totalPages +
                '}';
    }
}
