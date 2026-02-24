public class Chapter {
    private final String tittle;
    private final int totalPages;

    public Chapter(String tittle, int totalPages) {
        this.tittle = tittle;
        this.totalPages = totalPages;
    }

    public String getTittle() {
        return tittle;
    }


    public int getTotalPages() {
        return totalPages;
    }


    @Override
    public String toString() {
        return "Chapter {" +
                "tittle = '" + tittle + '\'' +
                ", totalPages = " + totalPages +
                '}';
    }
}
