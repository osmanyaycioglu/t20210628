package com.training.java.prop;

import com.training.java.prop.with.anno.Prop;
import com.training.java.prop.with.anno.PropFile;

@PropFile("my2.properties")
public class MyAppConfig2 {

    @Prop(name = "app.port")
    private int    port;
    @Prop(name = "app.name")
    private String name;
    @Prop(name = "app.desc")
    private String desc;
    @Prop(name = "app.dest")
    private String dest;

    public int getPort() {
        return this.port;
    }

    public void setPort(final int portParam) {
        this.port = portParam;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(final String descParam) {
        this.desc = descParam;
    }


    @Override
    public String toString() {
        return "MyAppConfig [port="
               + this.port
               + ", name="
               + this.name
               + ", desc="
               + this.desc
               + ", dest="
               + this.dest
               + "]";
    }

    public String getDest() {
        return this.dest;
    }

    public void setDest(final String destParam) {
        this.dest = destParam;
    }


}
