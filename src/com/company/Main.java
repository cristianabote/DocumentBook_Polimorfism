package com.company;

class Document{
    private String authors[];
    private  String dataDoc;

    public Document(){
        this.authors=null;
        this.dataDoc=null;
    }
    public Document( int nrOfAuthors, String dataDoc){
        this.authors=new String[nrOfAuthors];
        this.dataDoc=dataDoc;
    }
    public String[] getAuthors(){
        for(int i=0;i<this.authors.length;i++)
            if(this.authors[i]!=null)
                System.out.println("Autorul "+i+" se numeste "+this.authors[i]);
            else{
                break;}
        return this.authors;
    }
    public void addAuthor(String author){
        for(int i=0; i<this.authors.length;i++)
        {
            if(this.authors[i]!=null){
                continue;}
            else {
                this.authors[i]=author;
                System.out.println("A fost adaugat autorul "+this.authors[i]);
                break;
            }
        }
    }
    public String getDataDoc(){
        return this.dataDoc;
    }
    public void setDataDoc(String dataDoc){
        this.dataDoc=dataDoc;
    }
}

class Book extends Document{     //Mostenire prin keywordul extends
    private String title;
    private int nrPages;
    private String[] bookAuthors;

    public Book(){
        this.title=null;
        this.nrPages=0;
    }
    public Book(int nrOfAuthors, String dataDoc, String title, int nrPages){
        super(nrOfAuthors,dataDoc);    // folosirea mostenirii prin keywordul super
        this.title=title;
        this.nrPages=nrPages;
        this.bookAuthors=super.getAuthors();
        // super.getDataDoc();  //"super" din clasa careia se face mostenirea
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setNrPages(){

        this.nrPages=100; //nr implicit de pagini
    }
    public void setNrPages(int nrPages){

        this.nrPages=nrPages; //OVERLOADING fata de metoda precedenta
    }
    public String getTitle(){
        return this.title;
    }
    public int getNrPages(){
        return nrPages;
    }

    @Override
    public String[] getAuthors(){
        return this.bookAuthors; //OVERRIDE fata de clasa parinte
    }

    public String getAuthors(int nr){         //nr=nr de autori pe care vrem sa ii afisam
        if(nr<=this.bookAuthors.length){         //OVERLOADING  fara de metoda precedenta
            return this.bookAuthors[nr];
        }
        return null;
    }
}


public class Main {

    public static void main(String[] args) {

        int nrOfAuthors=3;
        Book bookJava=new Book(nrOfAuthors, "Oct 2020", "JAVA BOOK", 220);
        System.out.println(bookJava.getNrPages());
        System.out.println(bookJava.getTitle());

        //apelarea metodelor definite in clasa Document
        System.out.println(bookJava.getDataDoc());
        bookJava.addAuthor("Mihaela");
        bookJava.addAuthor("Andrei");
        bookJava.addAuthor("Ionut");

        for(int i=0;i<nrOfAuthors;i++){
            System.out.println(bookJava.getAuthors(i));}
        String[] authors=bookJava.getAuthors();
        for (int i=0;i<authors.length;i++)
        {
            System.out.println(authors[i]+ " e autorul nr "+(i+1));
        }
        bookJava.setNrPages();
        int pagini= bookJava.getNrPages();
        System.out.println("Cartea are un total de "+pagini+ " de pagini.");

        bookJava.setNrPages(128);
        pagini= bookJava.getNrPages();
        System.out.println("Cartea are un total de "+pagini+ " de pagini.");
    }
}
