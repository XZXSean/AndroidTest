package com.msi.studyonandroid.glide;

import android.os.Parcel;
import android.os.Parcelable;

public class SpacePhoto implements Parcelable {

    private String url;
    private String title;

    public SpacePhoto(String url, String title) {
        this.url = url;
        this.title = title;
    }

    protected SpacePhoto(Parcel in) {
        url = in.readString();
        title = in.readString();
    }

    public static final Creator<SpacePhoto> CREATOR = new Creator<SpacePhoto>() {
        @Override
        public SpacePhoto createFromParcel(Parcel in) {
            return new SpacePhoto(in);
        }

        @Override
        public SpacePhoto[] newArray(int size) {
            return new SpacePhoto[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static  SpacePhoto[] getSpacePhotos() {

        return new SpacePhoto[]{
                new SpacePhoto("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy"),
                new SpacePhoto("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle"),
                new SpacePhoto("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion"),
                new SpacePhoto("http://i.imgur.com/qpr5LR2.jpg", "Earth"),
                new SpacePhoto("http://i.imgur.com/pSHXfu5.jpg", "Astronaut"),
                new SpacePhoto("http://i.imgur.com/3wQcZeY.jpg", "Satellite"),
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(title);
    }
}
