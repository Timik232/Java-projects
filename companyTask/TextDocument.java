package companyTask;

public class TextDocument extends Carcas {
    @Override
    public void mainWindow() {
        System.out.println("Window is active");
    }

    @Override
    public void instruments() {

    }
    TextDocument(IDocument document, ICreateDocument documentFactory){
        this.document = document;
        this.documentFactory = documentFactory;
    }
    TextDocument(){

    }
    public TextDocument Open(){
        return new TextDocument();
    }
    public TextDocument New(){
        return new TextDocument();
    }

}
