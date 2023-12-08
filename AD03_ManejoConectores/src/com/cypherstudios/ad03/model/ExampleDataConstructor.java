package com.cypherstudios.ad03.model;

/**
 * Proporcionar datos de ejemplo predefinido
 *
 * @author Victor
 */
public class ExampleDataConstructor {

    /*
    Tengo que construir un objeto por vuelo incluido en el sql, y meterlo en el arraylist
     */
    protected static final FlightArrayList frl = new FlightArrayList();
    protected static FlightModel fly = null;

    protected static final PassengersArrayList prl = new PassengersArrayList();
    protected static PassengerModel pass = null;

    public static FlightArrayList constExampleDataFlights() {
        fly = new FlightModel("IB-SP-4567", "27/03/22-10:30", "PARIS", "MADRID", 100, 100, 160, 40);
        frl.attach(fly);
        fly = new FlightModel("IB-BA-46DC", "28/03/22-12:30", "ROMA", "MADRID", 90, 100, 160, 30);
        frl.attach(fly);
        fly = new FlightModel("FR-DC-4667", "28/03/22-13:30", "BRUSELAS", "SEVILLA", 90, 100, 160, 30);
        frl.attach(fly);
        fly = new FlightModel("AV-DC-347", "29/03/22-13:35", "VALENCIA", "ROMA", 100, 200, 210, 90);
        frl.attach(fly);
        fly = new FlightModel("SP-DC-438", "30/03/22-09:20", "MOSCU", "SEVILLA", 90, 100, 160, 30);
        frl.attach(fly);
        fly = new FlightModel("AI-D7-347", "30/03/22-13:35", "BILBAO", "MOSCU", 100, 200, 210, 90);
        frl.attach(fly);
        fly = new FlightModel("IB-D5-347", "01/04/22-13:35", "ZARAGOZA", "PARIS", 100, 200, 210, 90);
        frl.attach(fly);
        fly = new FlightModel("FR-DC7-247", "01/04/22-15:35", "CORDOBA", "COMPOSTELA", 100, 100, 100, 100);
        frl.attach(fly);
        fly = new FlightModel("AV-DC9-233", "01/04/22-17:35", "VALENCIA", "BRUSELAS", 100, 100, 100, 100);
        frl.attach(fly);
        fly = new FlightModel("FR-DC2-269", "01/04/22-19:00", "BILBAO", "BUENOS AIRES", 100, 100, 180, 20);
        frl.attach(fly);
        fly = new FlightModel("IB-98779", "02/04/22-08:00", "MADRID", "NEW YORK", 200, 100, 250, 50);
        frl.attach(fly);
        fly = new FlightModel("AV-DC2-269", "02/04/22-12:00", "MADRID", "LA HABANA", 100, 100, 180, 20);
        frl.attach(fly);
        fly = new FlightModel("AI-1289-9", "02/04/22-14:30", "BARCELONA", "MOSCU", 150, 100, 180, 70);
        frl.attach(fly);

        return frl;
    }

    public static PassengersArrayList constExampleDataPassengers() {
        pass = new PassengerModel(123, "IB-SP-4567", "TU", "SI");
        prl.attach(pass);
        pass = new PassengerModel(124, "IB-SP-4567", "PR", "SI");
        prl.attach(pass);
        pass = new PassengerModel(125, "IB-SP-4567", "PR", "NO");
        prl.attach(pass);
        pass = new PassengerModel(126, "IB-BA-46DC", "TU", "SI");
        prl.attach(pass);
        pass = new PassengerModel(127, "IB-BA-46DC", "PR", "SI");
        prl.attach(pass);
        pass = new PassengerModel(128, "FR-DC-4667", "TU", "NO");
        prl.attach(pass);
        pass = new PassengerModel(129, "FR-DC-4667", "TU", "SI");
        prl.attach(pass);

        pass = new PassengerModel(130, "AV-DC9-233", "TU", "SI");
        prl.attach(pass);
        pass = new PassengerModel(131, "AV-DC9-233", "TU", "NO");
        prl.attach(pass);
        pass = new PassengerModel(132, "AV-DC9-233", "PR", "SI");
        prl.attach(pass);
        pass = new PassengerModel(133, "IB-D5-347", "PR", "SI");
        prl.attach(pass);
        pass = new PassengerModel(134, "IB-D5-347", "PR", "SI");
        prl.attach(pass);
        pass = new PassengerModel(135, "IB-D5-347", "TU", "NO");
        prl.attach(pass);
        pass = new PassengerModel(136, "IB-D5-347", "TU", "SI");
        prl.attach(pass);

        pass = new PassengerModel(137, "FR-DC-4667", "TU", "SI");
        prl.attach(pass);
        pass = new PassengerModel(138, "FR-DC-4667", "TU", "NO");
        prl.attach(pass);
        pass = new PassengerModel(139, "FR-DC-4667", "PR", "SI");
        prl.attach(pass);
        pass = new PassengerModel(126, "FR-DC-4667", "PR", "SI");
        prl.attach(pass);

        pass = new PassengerModel(130, "AV-DC2-269", "TU", "SI");
        prl.attach(pass);
        pass = new PassengerModel(131, "AV-DC2-269", "TU", "NO");
        prl.attach(pass);
        pass = new PassengerModel(132, "AV-DC2-269", "PR", "SI");
        prl.attach(pass);
        pass = new PassengerModel(133, "AI-1289-9", "PR", "SI");
        prl.attach(pass);
        pass = new PassengerModel(134, "AI-1289-9", "PR", "SI");
        prl.attach(pass);
        pass = new PassengerModel(135, "AI-1289-9", "TU", "NO");
        prl.attach(pass);
        pass = new PassengerModel(136, "AI-1289-9", "TU", "SI");
        prl.attach(pass);

        pass = new PassengerModel(137, "SP-DC-438", "TU", "SI");
        prl.attach(pass);
        pass = new PassengerModel(138, "SP-DC-438", "TU", "NO");
        prl.attach(pass);
        pass = new PassengerModel(139, "SP-DC-438", "PR", "SI");
        prl.attach(pass);
        pass = new PassengerModel(140, "SP-DC-438", "PR", "SI");
        prl.attach(pass);
        pass = new PassengerModel(141, "FR-DC7-247", "PR", "SI");
        prl.attach(pass);
        pass = new PassengerModel(142, "FR-DC7-247", "TU", "NO");
        prl.attach(pass);
        pass = new PassengerModel(143, "FR-DC7-247", "TU", "SI");
        prl.attach(pass);

        return prl;
    }
}
