public class Review {
    private double numberRating;
    private String writtenReview;

    public Review(double numberRating,String writtenReview){

    }
    public double getNumberRating(){
        return this.numberRating;
    }
    public String getWrittenReview(){
        return this.writtenReview;
    }
    public String toString(){
        return "Rating: "+numberRating+ "Review: "+writtenReview;
    }
}
