public class CD {
  private String title;
  private String artist;
  private int year;
  private String genre;

  public CD (String title, String artist, int year, String genre) {
    this.title = title;
    this.artist = artist;
    this.year = year;
    this.genre = genre;
  }

  public String getInfo() {
    return title + ", by " + artist + "\nGenre: " + genre + ", " + year + "\n";
  }
}
