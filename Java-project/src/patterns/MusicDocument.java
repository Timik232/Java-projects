package patterns;
public class MusicDocument implements IDocument{
    @Override
    public String print() {
        return "Audio file was created";
    }
}