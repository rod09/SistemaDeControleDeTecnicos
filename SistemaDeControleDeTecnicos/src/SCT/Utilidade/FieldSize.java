package SCT.Utilidade;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


public class FieldSize extends PlainDocument {

    private int size;

    public FieldSize(int maxlen) {
        super();
        size = maxlen;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

   

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (size <= 0) { // aceitara qualquer no. de caracteres
            super.insertString(offset, str, attr);
            return;
        }
        int tFinal = (getLength() + str.length());

        if (tFinal <= size) { // se o comprimento final for menor...
            super.insertString(offset, str, attr);   // ...aceita str
        } else {
            if (getLength() == size) {
                return; // nada a fazer
            }
          String newStr = str.substring(0, (size - getLength()));
          super.insertString(offset, newStr, attr);
        }
    }

 }