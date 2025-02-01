public class Artwork{

        private String title;
        private int year;
        private Artist artist;

        Artwork(String title,int year,Artist artist){
           this.title=title;
           this.year=year;
            this.artist=artist;

}
       Artwork(String title,int year){
          this.title=title;
           this.year=year;
         


}

 public void setTitle(String t){
        this.title=t;

}
public void setYear(int y){
          this.year=y;
}
public void setArtist(Artist a){
   this.artist=a;
}

public void displayInfo(){

       System.out.println("Title of Artwork :"+title);
        System.out.println("Year the Artwork created :"+year);
         System.out.println("Artist who created the Artwork :"+artist);
}
}