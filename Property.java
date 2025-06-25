

class Property {
    int price;
    String property_type;
    int plot_Area;
    String City;
    String location;
    String[] prop_type = {"Residential","Commercial","Industrial","Raw Land"};
    String[] Citylist = {"Ahmedabad","Anand","Bhavnagar","Gandhinagar","Jamnagar","Junagarh","Kutch","Rajkot","Surat","Vadodara"};


    Property(int price,int prop_Type,int Plot_area,int city,String loc){
        
        this.price=price;
        this.property_type=prop_type[prop_Type-1];
        this.plot_Area=Plot_area;
        this.City=Citylist[city-1];
        this.location=loc;
    }
    Property(){
        
    }
 }
