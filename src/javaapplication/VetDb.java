/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication;

import javaapplication.Database;

/**
 *
 * @author layalsaadeddine
 */
public class VetDb {
    public VetDb() {
Database database = new Database();
        String sql = "CREATE TABLE vet " +
                "(id INTEGER not NULL auto_increment, " +
                " name String(50), " +
                " email String(50), " +
                " phone Int, " +
                " username String, " +
                " password String, " +
                " PRIMARY KEY ( id ))";

        
        database.executeQuery(sql);

        String sql1 = "INSERT INTO vet (name, email, phone, username, password) VALUES " +
                "('Dr. Johnson','johnson@gmail.com','03222222','johnson','123')," +
                "('Dr. Lee','lee@gmail.com','81555555','lee','456')," +
                "('Dr. Patel','patel@gmail.com','71888888','patel','890')," +
                "('Dr. Brown','brown@gmail.com','71888888','brown','678'),";

                database.executeUpdate(sql1);

        String sql2 = "CREATE TABLE staff " +
                "(id INTEGER not NULL auto_increment, " +
                " username String, " +
                " password String, "+
                " PRIMARY KEY ( id ))";

        database.executeQuery(sql2);

        String sql3 = "INSERT INTO staff (username,password) VALUES" +
                "('staff1','1234'),"+
                "('staff2','5678')";

        database.executeUpdate(sql3);

        String sql4 = "CREATE TABLE owner " +
                "(id INTEGER not NULL auto_increment, " +
                " name String(50), " +
                " email String(30)," +
                " phone Int(8), " +
                " PRIMARY KEY ( id ))";

        database.executeQuery(sql4);

        String sql5 = "INSERT INTO owner(name,email,phone) VALUES "+
                "('Sarah Brown','sara@gmail.com','71333333'),"+
                "('John Smith','john@gmail.com','70666666'),"+
                "('Emily Davis','emily@gmail.com','81555555'),"+
                "('Micheal Chen','micheal@gmail.com','71444444'),"+
                "('Olivia Zhang','olivia@gmail.com','81565656'),"+
                "('David Lee','david@gmail.com','71434343')";

        database.executeUpdate(sql5);

        String sql6 = "CREATE TABLE pet " +
                "(id INTEGER not NULL auto_increment, " +
                " name String(50), " +
                " type String(40), " +
                " weight INTEGER, " +
                " age INTEGER, " +
                " gender CHAR, " +
                " owner INTEGER, " +
                " PRIMARY KEY ( id )," +
                " FOREIGN KEY ( owner ) REFERENCES owner ( id ) " + ")";

        database.executeQuery(sql6);

        String sql7 = "INSERT INTO pet (name,type,weight,age,gender,owner) VALUES" +
                "('Max','dog','10','3','male','1'),"+
                "('Luna','cat','9','5','female','2'),"+
                "('Bella','cat','3','1','female','3'),"+
                "('Simba','cat','3','1','male','4'),"+
                "('Charlie','dog','10','3','male','5'),"+
                "('Fluffy','dog','10','3','female','6')";

        database.executeUpdate(sql7);

        String sql8 = "CREATE TABLE appointment " +
                "(id INTEGER not NULL auto_increment, " +
                " date LocalDate, " +
                " time String, " +
                " owner INTEGER, " +
                " vet INTEGER, " +
                " service String" +
                " PRIMARY KEY ( id ), " +
                " FOREIGN KEY ( pet ) REFERENCES pet ( id ), " +
                " FOREIGN KEY ( vet ) REFERENCES vet ( id ) )";

        database.executeQuery(sql8);

        String sql9 = "INSERT INTO appointment(date,time,owner,vet,service) VALUES"+
                "('2023-05-01','10:00','1','1','vaccination')," +
                "('2023-05-02','14:30','2','2','grooming')," +
                "('2023-05-05','11:00','3','3','vaccination')," +
                "('2023-05-07','9:00','2','4','medication')," +
                "('2023-05-09','13:00','4','5','medication')," +
                "('2023-05-10','12:00','3','6','grooming')";

        database.executeUpdate(sql9);

        String sql11 = "CREATE TABLE medicalRecord " +
                "(id INTEGER not NULL auto_increment, " +
                " petid INTEGER, " +
                " PRIMARY KEY ( id )), " +
                " FOREIGN KEY ( petid ) REFERENCES pet ( id ), ";

        database.executeQuery(sql11);

        String sql12 = "INSERT INTO medicalRecord (petid) VALUES "+
                "('1'),('2'),('3'),('4'),('5'),('6')";

        database.executeUpdate(sql12);

        String sql13 = "CREATE TABLE vaccine " +
                "(id INTEGER not NULL auto_increment, " +
                " name String(50), " +
                " description String(100), " +
                " price Double, " +
                " PRIMARY KEY ( id )) ";

        database.executeQuery(sql13);

        String sql14 = "INSERT INTO vaccine (name,description,price) VALUES" +
                "('Rabies Vaccine','A vaccine that helps protect cats from the deadly Rabies virus','100$',)," +
                "('Feline Distemper Vaccine','A vaccine that helps protect cats from the highly contagious Feline Distemper virus','100$',)," +
                "('Feline Leukemia Vaccine','A vaccine that helps protect cats from the highly contagious & deadly Feline Leukemia virus','100$',)," +
                "('Feline Calicivirus Vaccine','A vaccine that helps protect cats from respiratory disease caused by Feline Calicivirus','100$',)," +
                "('Feline Herpevirus-1 Vaccine','A vaccine that helps protect cats from respiratory disease caused by Feline Herpevirus-1','100$',)," +
                "('Feline Immunodeficiency virus Vaccine','A vaccine that helps protect cats from the Feline Immunodeficiency virus which weakens their immune system','100$',)," +
                "('Rabies Vaccine','A vaccine that helps protect dogs from the deadly Rabies virus','100$',)," +
                "('Canine Distemper Vaccine','A vaccine that helps protect dogs from the highly contagious Canine Distemper virus','100$',)," +
                "('Canine Parovirus Vaccine','A vaccine that helps protect dogs from the highly contagious Canine Parovirus','100$',)," +
                "('Canine Adenovirus Vaccine','A vaccine that helps protect dogs from respiratory problems and infectious canine hepatitis','100$',)," +
                "('Bordetella Vaccine','A vaccine that helps protect dogs from the bacterial infection that causes kernel cough','100$',)," +
                "('Leptospirosis Vaccine','A vaccine that helps protect dogs from the bacterial disease that can cause liver and kidney damage','100$',)";

        database.executeUpdate(sql14);

        String sql15 = "CREATE TABLE vaccineRecord" +
                "(vid INTEGER, " +
                " mid INTEGER, " +
                " FOREIGN KEY ( mid ) REFERENCES medicalRecord ( id ), " +
        " FOREIGN KEY ( vid ) REFERENCES vaccine ( id ), ";

        database.executeQuery(sql15);

        String sql16 = "INSERT INTO vaccineRecord (vid,mid) VALUES "+
                "('1','7'),('1','9'),('1','10')," +
                "('2','1'),('2','3'),('2','4')," +
                "('3','2'),('3','4'),('3','6')," +
                "('4','5'),('4','2'),('4','1')," +
                "('5','7'),('5','9'),('5','11')," +
                "('6','8'),('6','11'),('6','12')";

        database.executeUpdate(sql16);

        String sql17 = "CREATE TABLE medication " +
                "(id INTEGER not NULL auto_increment, " +
                " name String(50), " +
                " description String(100), " +
                " price Double, " +
                " PRIMARY KEY ( id )), ";

        database.executeQuery(sql17);

        String sql18 = "INSERT INTO medication (name,description,price) VALUES " +
                "('Cerenia(maropitant)','A medication used to control vomiting in cats','100$')," +
                "('Metacom(meloxicam)','A nonsteroidal anti-inflammatory drug (NSAID) used to treat pain and inflamation associated with arthritis and other conditions in cats','100$')," +
                "('Revolution(selamectin)','A medication used to prevent heartworm disease, control fleas, ear mites, and some intestinal parasites in cats','100$')," +
                "('Methimazole','A medication used to treat bacterial infections in cats','100$')," +
                "('Amoxicillin','An antibiotic medication used to treat bacterial infections in cats','100$')," +
                "('Prednisolone','A steroid medication used to reduce inflammation and treat various conditions in cats','100$')," +
                "('Rimadyl(carprofen)','A nonsteroidal anti-inflammatory drug (NSAID) used to treat pain and inflammation associated with arthritis and other conditions in dogs','100$')," +
                "('Tramadol','A pain medication used to treat moderate to severe pain in dogs','100$')," +
                "('Apoquel(oclacitinib)','A medication used to control itching and inflammation associated with allergies in dogs','100$')," +
                "('Heartgard(ivermectin)','A medication used to protect heartworm disease in dogs','100$')," +
                "('Sentinel(melbemycin oxime)','A medication used to prevent heartworm disease and control flies in dogs','100$')," +
                "('Cephalexin','An antibiotic medication used to treat bacterial infections in dogs','100$')";

        database.executeUpdate(sql18);

        String sql19 = "CREATE TABLE medicationRecord" +
                "(mdid INTEGER, " +
                " mrid INTEGER, " +
                " FOREIGN KEY ( mrid ) REFERENCES medicalRecord ( id ), " +
        " FOREIGN KEY ( mdid ) REFERENCES medication ( id ), ";

        database.executeQuery(sql19);

        String sql20 = "INSERT INTO medicationRecord (mrid,mdid) VALUES "+
                "('1','7'),('1','9'),('1','10')," +
                "('2','1'),('2','3')," +
                "('3','2'),('3','4')," +
                "('4','5'),('4','2'),('4','1')," +
                "('5','7'),('5','9')," +
                "('6','8'),('6','11'),('6','12')";

        database.executeUpdate(sql20);
    }
}
