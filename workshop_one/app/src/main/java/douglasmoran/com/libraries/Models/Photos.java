package douglasmoran.com.libraries.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Photos implements Parcelable {

    private int id;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private String img5;
    private String img6;

    public Photos() {
    }

    protected Photos(Parcel in) {
        id = in.readInt();
        img1 = in.readString();
        img2 = in.readString();
        img3 = in.readString();
        img4 = in.readString();
        img5 = in.readString();
        img6 = in.readString();
    }

    public static final Creator<Photos> CREATOR = new Creator<Photos>() {
        @Override
        public Photos createFromParcel(Parcel in) {
            return new Photos(in);
        }

        @Override
        public Photos[] newArray(int size) {
            return new Photos[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public String getImg5() {
        return img5;
    }

    public void setImg5(String img5) {
        this.img5 = img5;
    }

    public String getImg6() {
        return img6;
    }

    public void setImg6(String img6) {
        this.img6 = img6;
    }

    public static Creator<Photos> getCREATOR() {
        return CREATOR;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(img1);
        parcel.writeString(img2);
        parcel.writeString(img3);
        parcel.writeString(img4);
        parcel.writeString(img5);
        parcel.writeString(img6);
    }
}
