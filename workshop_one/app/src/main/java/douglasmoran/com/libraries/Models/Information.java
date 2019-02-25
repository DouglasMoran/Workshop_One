package douglasmoran.com.libraries.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Information implements Parcelable {

    //DATA JSON ADD FOR ITEM INFORMATION
    private int id;
    private String txtHistory;
    private String history;
    private String construction;
    private String jewel;
    private String curiosity;
    private String desing;
    private String address;

    protected Information(Parcel in) {
        id = in.readInt();
        txtHistory = in.readString();
        history = in.readString();
        construction = in.readString();
        jewel = in.readString();
        curiosity = in.readString();
        desing = in.readString();
        address = in.readString();
    }

    public static final Creator<Information> CREATOR = new Creator<Information>() {
        @Override
        public Information createFromParcel(Parcel in) {
            return new Information(in);
        }

        @Override
        public Information[] newArray(int size) {
            return new Information[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTxtHistory() {
        return txtHistory;
    }

    public void setTxtHistory(String txtHistory) {
        this.txtHistory = txtHistory;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public String getJewel() {
        return jewel;
    }

    public void setJewel(String jewel) {
        this.jewel = jewel;
    }

    public String getCuriosity() {
        return curiosity;
    }

    public void setCuriosity(String curiosity) {
        this.curiosity = curiosity;
    }

    public String getDesing() {
        return desing;
    }

    public void setDesing(String desing) {
        this.desing = desing;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(txtHistory);
        parcel.writeString(history);
        parcel.writeString(construction);
        parcel.writeString(jewel);
        parcel.writeString(curiosity);
        parcel.writeString(desing);
        parcel.writeString(address);
    }
}
