package ml.zarkmedia.heapptrial;

public class herb {
private String Name;
private String disease;
private int photo;

    public herb(String name) {
        Name=name;
    }

    public herb(String name, String disease, int photo) {
        Name = name;
        this.disease = disease;
        this.photo = photo;
    }

    //getter

    public String getName() {
        return Name;
    }

    public String getDisease() {
        return disease;
    }

    public int getPhoto() {
        return photo;
    }


    //setter

    public void setName(String name) {
        Name = name;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
