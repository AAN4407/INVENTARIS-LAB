package Model;

import javafx.beans.property.*;

/**
 * @Aira Althafeliq Nurfirly
 */
public class DataModel {
    private final StringProperty field1;
    private final StringProperty field2;
    private final StringProperty field3;

    public DataModel(String field1, String field2, String field3) {
        this.field1 = new SimpleStringProperty(field1);
        this.field2 = new SimpleStringProperty(field2);
        this.field3 = new SimpleStringProperty(field3);
    }

    public String getField1() {

        return field1.get();
    }

    public void setField1(String field1) {

        this.field1.set(field1);
    }

    public StringProperty field1Property() {

        return field1;
    }

    public String getField2() {

        return field2.get();
    }

    public void setField2(String field2) {

        this.field2.set(field2);
    }

    public StringProperty field2Property() {

        return field2;
    }

    public String getField3() {

        return field3.get();
    }

    public void setField3(String field3) {

        this.field3.set(field3);
    }

    public StringProperty field3Property() {

        return field3;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "field1='" + field1.get() + '\'' +
                ", field2='" + field2.get() + '\'' +
                ", field3='" + field3.get() + '\'' +
                '}';
    }
}
