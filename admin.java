public class admin {
    String name;
    int id;
    controls adminControl = new controls();

    protected String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public void manageMember(){ 
        adminControl.manageMember();
    }
    
    public void viewReports(){
        adminControl.viewReports();
    }
}
