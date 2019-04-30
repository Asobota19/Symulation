package save;

import java.util.Date;

public class SaveDataObject {
    private AmethropyType amethropyType;
    private int visualImpairment;
    private int length;
    private Date date;

    public AmethropyType getAmethropyType() {
        return amethropyType;
    }

    public void setAmethropyType(AmethropyType amethropyType) {
        this.amethropyType = amethropyType;
    }

    public int getVisualImpairment() {
        return visualImpairment;
    }

    public void setVisualImpairment(int visualImpairment) {
        this.visualImpairment = visualImpairment;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
