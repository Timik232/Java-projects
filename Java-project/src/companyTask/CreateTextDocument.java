package companyTask;

public class CreateTextDocument implements ICreateDocument {

    @Override
    public TextDocument CreateNew() {
        return new TextDocument();
    }

    @Override
    public TextDocument CreateOpen() {
        return new TextDocument();
    }
}
