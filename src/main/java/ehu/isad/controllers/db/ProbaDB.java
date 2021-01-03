package ehu.isad.controllers.db;

import ehu.isad.model.Pertsona;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProbaDB{

    private static final ProbaDB instance = new ProbaDB();
    private static final DBController dbcontroller = DBController.getController();

    private ProbaDB() {}

    public static ProbaDB getInstance() {
        return instance;
    }


    public List<Pertsona> lortuPertsonak() throws SQLException {
        List<Pertsona> emaitza = new ArrayList<Pertsona>();
        String eskaera = "SELECT * FROM datuak";
        ResultSet rs = dbcontroller.execSQL(eskaera);
        while (rs.next()){
            String fn = rs.getString("firstname");
            String ln = rs.getString("lastname");
            String sport = rs.getString("sport");
            int year = rs.getInt("numyears");
            Boolean veg = rs.getBoolean("vegetarian");
            String argazkia = rs.getString("argazkia");

            Pertsona p = new Pertsona(fn,ln,sport,year,veg,argazkia);
            emaitza.add(p);
        }
        return emaitza;
    }

    public void sartuDBn(List<Pertsona> eskLista) {
        ezabatu();
        for (int i = 0; i<eskLista.size();i++){
            Pertsona p = eskLista.get(i);
            String firstName = p.getFirstName();
            String lastName = p.getLastName();
            String sport = p.getSport();
            int years = p.getYears();
            Boolean vegetarian = p.getVegetarian();
            String argazkia = p.getIrudiPath();
            String eskaera = "INSERT INTO datuak VALUES('"+firstName+"','"+lastName+"','"+sport+"',"+years+","+vegetarian+",'"+argazkia+"')";
            dbcontroller.execSQL(eskaera);
        }

    }

    private void ezabatu() {
        String eskaera = "DELETE FROM datuak ";
        dbcontroller.execSQL(eskaera);
    }
}
