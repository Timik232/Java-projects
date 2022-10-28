package companyTask;

public class TestDocument {
    public static void main(String[] args) {
    CreateTextDocument factory = new CreateTextDocument();
    TextDocument text = factory.CreateNew();
    text.mainWindow();
    TextDocument newText = text.Open();
    newText.mainWindow();
    }
}
