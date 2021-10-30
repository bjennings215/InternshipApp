public class Review {
    private String numberRating;
    private String writtenReview;

    public Review(String numberRating,String writtenReview){

    }
    public String getNumberRating(){
        return this.numberRating;
    }
    public String getWrittenReview(){
        return this.writtenReview;
    }
    public String toString(){
        return "Rating: "+numberRating+ "Review: "+writtenReview;
    }
}
