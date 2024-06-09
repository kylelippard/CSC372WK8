class Student {

    private String name;
    private String address;
    private double GPA;

    Student() {
        //Default constructor
    }
    //initialized constructor
    public  Student(String name, String address, double GPA){
        this.name = name;
        this.address = address;
        this.GPA = GPA;

    }

    public String getName() { return name; }
    public double getGPA() { return GPA;  }
    public String GetAddress() {return this.address; };

    public void setName(String name) { this.name = name;  }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }



    //toString method.
    @Override
    public String toString() {
        return this.name.toString()+"\n" +this.address.toString()+"\n" + this.GPA+"\n"+"\n";
    }

}
