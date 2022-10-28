package companyTask;

public class Carcas implements IDocument{
    IDocument document;
    ICreateDocument documentFactory;

    public IDocument New(){
        return documentFactory.CreateNew();
    }
    public IDocument Open(){
        return documentFactory.CreateOpen();
    }


    @Override
    public void mainWindow() {

    }

    @Override
    public void instruments() {

    }


    public void Save() {

    }

    public void Exit() {

    }
}
