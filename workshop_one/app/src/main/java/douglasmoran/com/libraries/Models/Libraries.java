package douglasmoran.com.libraries.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class Libraries implements Parcelable {

    private int id;
    private String time;
    private String txttime;
    private String imgItem;
    private String imgDetail;
    private String country;
    private String numberpic;
    private String title;
    private String mainDescription;
    private float map_lat;
    private float map_long;

    protected Libraries(Parcel in) {
        id = in.readInt();
        time = in.readString();
        txttime = in.readString();
        imgItem = in.readString();
        imgDetail = in.readString();
        country = in.readString();
        numberpic = in.readString();
        title = in.readString();
        mainDescription = in.readString();
        map_lat = in.readFloat();
        map_long = in.readFloat();
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTxttime() {
        return txttime;
    }

    public void setTxttime(String txttime) {
        this.txttime = txttime;
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

    public float getMap_lat() {
        return map_lat;
    }

    public void setMap_lat(float map_lat) {
        this.map_lat = map_lat;
    }

    public float getMap_long() {
        return map_long;
    }

    public void setMap_long(float map_long) {
        this.map_long = map_long;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(time);
        parcel.writeString(txttime);
        parcel.writeString(imgItem);
        parcel.writeString(imgDetail);
        parcel.writeString(country);
        parcel.writeString(numberpic);
        parcel.writeString(title);
        parcel.writeString(mainDescription);
        parcel.writeFloat(map_lat);
        parcel.writeFloat(map_long);
    }
}
