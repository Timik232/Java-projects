package patterns;
public class TextFactory implements ICreateDocument{
    @Override
    public IDocument createNew() {
        return new TextDocument();
    }

    @Override
    public IDocument createOpen() {
        return new TextDocument();
    }
}