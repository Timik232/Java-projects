package patterns;
public class TextDocument implements IDocument{
    @Override
    public String print() {
        return "Текстовый документ создан";
    }

}