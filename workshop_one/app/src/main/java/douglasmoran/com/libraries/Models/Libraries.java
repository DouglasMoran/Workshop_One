package douglasmoran.com.libraries.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Libraries implements Parcelable {

    private int id;
    private String imgItem;
    private String imgDetail;
    private String country;
    private String numberpic;
    private String title;
    private String mainDescription;
    //DATA JSON ADD FOR ITEM INFORMATION
    private String history;
    private String construction;
    private String jewel;
    private String curiosity;
    private String desing;
    private String address;


    protected Libraries(Parcel in){

        id = in.readInt();
        imgItem = in.readString();
        imgDetail = in.readString();
        country = in.readString();
        numberpic = in.readString();
        title = in.readString();
        mainDescription = in.readString();

        history = in.readString();
        construction = in.readString();
        jewel = in.readString();
        curiosity = in.readString();
        desing = in.readString();
        address = in.readString();

    }


    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Libraries> CREATOR = new Creator<Libraries>() {
        @Override
        public Libraries createFromParcel(Parcel in) {
            return new Libraries(in);
        }

        @Override
        public Libraries[] newArray(int size) {
            return new Libraries[size];
        }
    };


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgItem() {
        return imgItem;
    }

    public void setImgItem(String imgItem) {
        this.imgItem = imgItem;
    }

    public String getImgDetail() {
        return imgDetail;
    }

    public void setImgDetail(String imgDetail) {
        this.imgDetail = imgDetail;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNumberpic() {
        return numberpic;
    }

    public void setNumberpic(String numberpic) {
        this.numberpic = numberpic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainDescription() {
        return mainDescription;
    }

    public void setMainDescription(String mainDescription) {
        this.mainDescription = mainDescription;
    }

    //get and set for item info


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
    public void writeToParcel(Parcel desc, int flags) {

        desc.writeInt(id);
        desc.writeString(imgItem);
        desc.writeString(imgDetail);
        desc.writeString(country);
        desc.writeString(numberpic);
        desc.writeString(title);
        desc.writeString(mainDescription);


        desc.writeString(history);
        desc.writeString(construction);
        desc.writeString(jewel);
        desc.writeString(curiosity);
        desc.writeString(desing);
        desc.writeString(address);

    }

    public Libraries(int id, String imgItem, String imgDetail, String country, String numberpic, String title, String mainDescription) {
        this.id = id;
        this.imgItem = imgItem;
        this.imgDetail = imgDetail;
        this.country = country;
        this.numberpic = numberpic;
        this.title = title;
        this.mainDescription = mainDescription;
    }

}
