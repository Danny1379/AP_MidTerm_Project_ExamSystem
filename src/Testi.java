class Testi extends Question {
    String answere1;
    String answere2;
    String answere3;
    String answere4;
    int correct_answere;

    Testi(String question) {
        super(question);
    }

    public void setAnswere1(String answere1) {
        this.answere1 = answere1;
    }

    public void setAnswere2(String answere2) {
        this.answere2 = answere2;
    }

    public void setAnswere3(String answere3) {
        this.answere3 = answere3;
    }

    public void setAnswere4(String answere4) {
        this.answere4 = answere4;
    }

    public void setCorrect_answere(int correct_answere) {
        this.correct_answere = correct_answere;
    }
}
