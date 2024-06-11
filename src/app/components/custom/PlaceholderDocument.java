package app.components.custom;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class PlaceholderDocument extends PlainDocument {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String placeholder;

    public PlaceholderDocument(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    public void insertString(int offs, String str, javax.swing.text.AttributeSet a) throws BadLocationException {
        if (str == null || str.isEmpty()) {
            return;
        }

        super.insertString(offs, str, a);
    }

    @Override
    public void remove(int offs, int len) throws BadLocationException {
        super.remove(offs, len);

        if (getText(0, getLength()).isEmpty()) {
            super.insertString(0, placeholder, null);
        }
    }
}