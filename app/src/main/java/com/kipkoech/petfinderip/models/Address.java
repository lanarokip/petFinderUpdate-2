
package com.kipkoech.petfinderip.models;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
@Generated("jsonschema2pojo")
public class Address {

    @SerializedName("address1")
    @Expose
    private String address1;
    @SerializedName("address2")
    @Expose
    private String address2;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("postcode")
    @Expose
    private String postcode;
    @SerializedName("country")
    @Expose
    private String country;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Address() {
    }

    /**
     * 
     * @param country
     * @param address2
     * @param city
     * @param address1
     * @param postcode
     * @param state
     */
    public Address(String address1, String address2, String city, String state, String postcode, String country) {
        super();
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
        this.country = country;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
//
//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append(Address.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
//        sb.append("address1");
//        sb.append('=');
//        sb.append(((this.address1 == null)?"<null>":this.address1));
//        sb.append(',');
//        sb.append("address2");
//        sb.append('=');
//        sb.append(((this.address2 == null)?"<null>":this.address2));
//        sb.append(',');
//        sb.append("city");
//        sb.append('=');
//        sb.append(((this.city == null)?"<null>":this.city));
//        sb.append(',');
//        sb.append("state");
//        sb.append('=');
//        sb.append(((this.state == null)?"<null>":this.state));
//        sb.append(',');
//        sb.append("postcode");
//        sb.append('=');
//        sb.append(((this.postcode == null)?"<null>":this.postcode));
//        sb.append(',');
//        sb.append("country");
//        sb.append('=');
//        sb.append(((this.country == null)?"<null>":this.country));
//        sb.append(',');
//        if (sb.charAt((sb.length()- 1)) == ',') {
//            sb.setCharAt((sb.length()- 1), ']');
//        } else {
//            sb.append(']');
//        }
//        return sb.toString();
//    }

}
