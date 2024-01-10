package org.qalegend.dataprovider;


public class DataProvider {

    public Object[][] userCredentialsData() {
        Object[][] data=new Object[3][2];
        data[0][0]="nanduvs@gmail.com";
        data[0][1]="123";

        data[1][0]="nanduvs@gmail.com";
        data[1][1]="123456";

        data[2][0]="nanduvs01@gmail.com";
        data[2][1]="123";
        return data;
    }

}
