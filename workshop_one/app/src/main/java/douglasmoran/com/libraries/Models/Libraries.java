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

    private String time;
    private String txttime;

    private float map_lat;
    private float map_long;


    protected Libraries(Parcel in){

        id = in.readInt();
        imgItem = in.readString();
        imgDetail = in.readString();
        country = in.readString();
        numberpic = in.readString();
        title = in.readString();
        mainDescription = in.readString();

        time = in.readString();
        txttime = in.readString();

        map_lat = in.readFloat();
        map_long = in.readLong();

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getTxttime() {
        return txttime;
    }

    public void setTxttime(String txttime) {
        this.txttime = txttime;
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

        desc.writeString(time);
        desc.writeString(txttime);

        desc.writeFloat(map_lat);
        desc.writeFloat(map_long);


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
