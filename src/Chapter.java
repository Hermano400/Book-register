public class Chapter {
    private final String title;
    private final int totalPages;

    public Chapter(String title, int totalPages) {
        this.title = title;
        this.totalPages = totalPages;
    }

    public String getTitle() {
        return title;
    }


    public int getTotalPages() {
        return totalPages;
    }


    @Override
    public String toString() {
//        return "Chapter {" +
//                "title = '" + title + '\'' +
//                ", totalPages = " + totalPages +
//                '}';
        return String.format("Chapter{title = '%s', totalPages = %d }", title,totalPages);
    }
}
